package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }
    @Override
    public int getCount() {
        return cities.size();
    }

    public void addCity(City city) {
        cities.add(city);
    }
    public void deleteCity(String name, String province) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getProvinceName().equals(province) && cities.get(i).getCityName().equals(name)) {
                cities.remove(i);
            }
        }
    }

    public boolean hasCity(String name, String province) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getProvinceName().equals(province) && cities.get(i).getCityName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public int countCity() {
        int size = getCount();
        int count = 0;
        String cityNames[] = new String[size];
        String cityProvinces[] = new String[size];

        for (int i = 0; i< cities.size(); i++) {
            String name = cities.get(i).getCityName();
            String province = cities.get(i).getProvinceName();

            if (!Arrays.asList(cityNames).contains(name) && !Arrays.asList(cityProvinces).contains(province)) {
                count++;
                cityNames[i] = name;
                cityProvinces[i] = province;
            }
        }
        return count;
    }
}

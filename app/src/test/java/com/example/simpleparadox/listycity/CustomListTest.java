package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @BeforeEach
    public void createList() {
        list = new CustomList(null, new ArrayList<>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(listSize + 1, list.getCount());
    }

    @Test
    public void deleteCityTest() {
        list.addCity(new City("Edmonton", "AB"));
        int listSize = list.getCount();
        list.deleteCity("Edmonton", "AB");
        assertEquals(listSize - 1, list.getCount());
    }
}

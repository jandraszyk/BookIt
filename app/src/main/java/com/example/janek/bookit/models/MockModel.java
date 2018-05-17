package com.example.janek.bookit.models;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Janek on 13.05.2018.
 */

public class MockModel {

    public final ArrayList<PlaceInfo> restaurantsList = new ArrayList<>();

    public MockModel() {
        PlaceInfo firstRestaurant = new PlaceInfo();
        firstRestaurant.setAddress("Aleje Marcinkowskiego 22, Poznan");
        firstRestaurant.setId("0");
        firstRestaurant.setLatLng(new LatLng(52.40750200000001,16.928556));
        firstRestaurant.setRating(4.1f);
        firstRestaurant.setName("Hotel Rzymski");

        restaurantsList.add(firstRestaurant);

        PlaceInfo secondRestaurant = new PlaceInfo();
        secondRestaurant.setAddress("plac Kolegiacki 5, Poznań");
        secondRestaurant.setId("1");
        secondRestaurant.setLatLng(new LatLng(52.40709289999999,16.935999));
        secondRestaurant.setRating(4.4f);
        secondRestaurant.setName("Hotel Kolegiacki");

        restaurantsList.add(secondRestaurant);

        PlaceInfo thirdRestaurant = new PlaceInfo();
        thirdRestaurant.setAddress("Stary Rynek 73, Poznań");
        thirdRestaurant.setId("2");
        thirdRestaurant.setLatLng(new LatLng(52.408034,16.9323671));
        thirdRestaurant.setRating(4.4f);
        thirdRestaurant.setName("Brovaria");

        restaurantsList.add(thirdRestaurant);
    }

    public ArrayList<PlaceInfo> getRestaurantsList() {
        return  restaurantsList;
    }

}

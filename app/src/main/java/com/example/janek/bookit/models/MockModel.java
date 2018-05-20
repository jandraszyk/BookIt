package com.example.janek.bookit.models;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Janek on 13.05.2018.
 */

public class MockModel {

    public final ArrayList<PlaceInfo> restaurantsList = new ArrayList<>();

    public MockModel() {

        addRestaurant("Hotel Rzymski","Aleje Marcinkowskiego 22", "0",4.1f,52.40750200000001,16.928556, "Italian");
        addRestaurant("Brovaria", "Stary Rynek 73", "1",4.4f,52.408034,16.9323671, "Beer");
        addRestaurant("BASILIUM beer spot","Woźna 21", "2", 4.5f,52.4079491,16.9356063, "Beer");
        addRestaurant("Bazar 1838", "Paderewskiego 8", "3", 4.6f,52.4077334,16.9299292, "French");
        addRestaurant("Restauracja Ratuszova", "Stary Rynek 55", "4",4.5f,52.4075595,16.934023, "Polish,Italian,French");
        addRestaurant("The Mexican","Kramarska 19", "5",4.4f,52.4092916,16.935914,"Mexican");
        addRestaurant("Pastela", "Porucznika Janiny Lewandowskiej 40", "6",4.1f,52.4094382,16.9323706,"Polish");
        addRestaurant("Violet Sushi & Yakitori", "Święty Marcin 9", "7", 4.5f,52.4057853,16.9295692,"Sushi");

    }

    public void addRestaurant(String name, String address, String id, float rating, double latitude, double longitude, String foodType) {
        PlaceInfo restaurant =  new PlaceInfo();
        restaurant.setAddress(address);
        restaurant.setId(id);
        restaurant.setLatLng(new LatLng(latitude,longitude));
        restaurant.setName(name);
        restaurant.setRating(rating);
        restaurant.setFoodType(foodType);

        restaurantsList.add(restaurant);
    }

    public ArrayList<PlaceInfo> getRestaurantsList() {
        return  restaurantsList;
    }

}

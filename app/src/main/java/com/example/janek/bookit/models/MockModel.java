package com.example.janek.bookit.models;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Janek on 13.05.2018.
 */

public class MockModel {
    public final ArrayList<PlaceInfo> restaurantsList = new ArrayList<>();
    DatabaseReference databaseRestaurants = FirebaseDatabase.getInstance().getReference("Restaurants");

    public final ArrayList<PlaceInfo_RestaurantsZones> zonesList = new ArrayList<>();
    DatabaseReference databaseZones = FirebaseDatabase.getInstance().getReference("Zones");

    public MockModel() { //TODO randomize a little bit zones mock data :)
        String temporaryRestaurantId;

        temporaryRestaurantId = databaseRestaurants.push().getKey();
        addRestaurant("Hotel Rzymski","Aleje Marcinkowskiego 22", temporaryRestaurantId ,4.1f,52.40750200000001,16.928556, "Italian");
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 1, 10, 6);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 2, 10, 4);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 3, 10, 0);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 4, 10, 10);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 5, 10, 2);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 6, 10, 4);

        temporaryRestaurantId = databaseRestaurants.push().getKey();
        addRestaurant("Brovaria", "Stary Rynek 73", temporaryRestaurantId,4.4f,52.408034,16.9323671, "Beer");
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 1, 10, 6);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 2, 10, 4);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 3, 10, 0);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 4, 10, 10);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 5, 10, 2);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 6, 10, 4);

        temporaryRestaurantId = databaseRestaurants.push().getKey();
        addRestaurant("BASILIUM beer spot","Woźna 21", temporaryRestaurantId, 4.5f,52.4079491,16.9356063, "Beer");
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 1, 10, 6);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 2, 10, 4);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 3, 10, 0);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 4, 10, 10);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 5, 10, 2);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 6, 10, 4);

        temporaryRestaurantId = databaseRestaurants.push().getKey();
        addRestaurant("Bazar 1838", "Paderewskiego 8", temporaryRestaurantId, 4.6f,52.4077334,16.9299292, "French");
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 1, 10, 6);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 2, 10, 4);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 3, 10, 0);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 4, 10, 10);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 5, 10, 2);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 6, 10, 4);

        temporaryRestaurantId = databaseRestaurants.push().getKey();
        addRestaurant("Restauracja Ratuszova", "Stary Rynek 55", temporaryRestaurantId,4.5f,52.4075595,16.934023, "Polish,Italian,French");
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 1, 10, 6);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 2, 10, 4);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 3, 10, 0);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 4, 10, 10);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 5, 10, 2);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 6, 10, 4);

        temporaryRestaurantId = databaseRestaurants.push().getKey();
        addRestaurant("The Mexican","Kramarska 19", temporaryRestaurantId,4.4f,52.4092916,16.935914,"Mexican");
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 1, 10, 6);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 2, 10, 4);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 3, 10, 0);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 4, 10, 10);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 5, 10, 2);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 6, 10, 4);

        temporaryRestaurantId = databaseRestaurants.push().getKey();
        addRestaurant("Pastela", "Porucznika Janiny Lewandowskiej 40", temporaryRestaurantId,4.1f,52.4094382,16.9323706,"Polish");
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 1, 10, 6);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 2, 10, 4);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 3, 10, 0);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 4, 10, 10);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 5, 10, 2);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 6, 10, 4);

        temporaryRestaurantId = databaseRestaurants.push().getKey();
        addRestaurant("Violet Sushi & Yakitori", "Święty Marcin 9", temporaryRestaurantId, 4.5f,52.4057853,16.9295692,"Sushi");
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 1, 10, 6);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 2, 10, 4);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 3, 10, 0);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 4, 10, 10);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 5, 10, 2);
        addZones(databaseZones.push().getKey(), temporaryRestaurantId, 6, 10, 4);
    }

    public void addRestaurant(String name, String address, String id, float rating, double latitude, double longitude, String foodType) {
        PlaceInfo restaurant =  new PlaceInfo();
        restaurant.setAddress(address);
        restaurant.setId(id);
        restaurant.setLatitude(latitude);
        restaurant.setLongitude(longitude);
        restaurant.setName(name);
        restaurant.setRating(rating);
        restaurant.setFoodType(foodType);

        databaseRestaurants.child(id).setValue(restaurant);
    }

    public void addZones(String id, String restaurantId, int zoneNumber, int numberOfAllPlaces, int numberOfAvailablePlaces) {
        PlaceInfo_RestaurantsZones zones =  new PlaceInfo_RestaurantsZones();
        zones.setId(id);
        zones.setRestaurantId(restaurantId);
        zones.setZoneNumber(zoneNumber);
        zones.setNumberOfAvailablePlaces(numberOfAvailablePlaces);

        databaseZones.child(id).setValue(zones);
    }

    public ArrayList<PlaceInfo> getRestaurantsList() {
        return  restaurantsList;
    }

    public ArrayList<PlaceInfo_RestaurantsZones> getZonesList() {
        return zonesList;
    }
}

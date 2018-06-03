package com.example.janek.bookit.models;

import android.net.Uri;

/**
 * Created by Janek on 04.05.2018.
 */

public class PlaceInfo_RestaurantsZones {
    private String id;
    private String restaurantId;
    private int zoneNumber;
    private int numberOfAllPlaces;
    private int numberOfAvailablePlaces;

    public PlaceInfo_RestaurantsZones(String id, String restaurantId, int zoneNumber, int numberOfAllPlaces, int numberOfAvailablePlaces) {
        this.id = id;
        this.restaurantId = restaurantId;
        this.zoneNumber = zoneNumber;
        this.numberOfAllPlaces = numberOfAllPlaces;
        this.numberOfAvailablePlaces = numberOfAvailablePlaces;
    }

    public PlaceInfo_RestaurantsZones() {}

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getZoneNumber() { return zoneNumber; }
    public void setZoneNumber(int zoneNumber) {
        this.zoneNumber = zoneNumber;
    }

    public int getNumberOfAllPlaces() {
        return numberOfAllPlaces;
    }
    public void setNumberOfAllPlaces(int numberOfAllPlaces) { this.numberOfAllPlaces = numberOfAllPlaces; }

    public int getNumberOfAvailablePlaces() {
        return numberOfAvailablePlaces;
    }
    public void setNumberOfAvailablePlaces(int numberOfAvailablePlaces) { this.numberOfAvailablePlaces = numberOfAvailablePlaces; }

    @Override
    public String toString() {
        return "PlaceInfo_RestaurantsZones{" +
                ", id='" + id + '\'' +
                ", restaurantId=" + restaurantId +
                ", zoneNumber=" + zoneNumber +
                ", numberOfAllPlaces='" + numberOfAllPlaces + '\'' +
                ", numberOfAvailablePlaces='" + numberOfAvailablePlaces + '\'' +
                '}';
    }
}

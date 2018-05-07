package com.example.janek.bookit.models;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by Janek on 07.05.2018.
 */

public class RestaurantModel {
    private String restaurantName;
    private float restaurantRating;
    private int restaurantReviews;
    private String restaurantCity;
    private String restaurantFood;
    private boolean selected;
    private Image restaurantImage;

    public RestaurantModel() {

    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public float getRestaurantRating() {
        return restaurantRating;
    }

    public void setRestaurantRating(float restaurantRating) {
        this.restaurantRating = restaurantRating;
    }

    public int getRestaurantReviews() {
        return restaurantReviews;
    }

    public void setRestaurantReviews(int restaurantReviews) {
        this.restaurantReviews = restaurantReviews;
    }

    public String getRestaurantCity() {
        return restaurantCity;
    }

    public void setRestaurantCity(String restaurantCity) {
        this.restaurantCity = restaurantCity;
    }

    public String getRestaurantFood() {
        return restaurantFood;
    }

    public void setRestaurantFood(String restaurantFood) {
        this.restaurantFood = restaurantFood;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Image getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(Image restaurantImage) {
        this.restaurantImage = restaurantImage;
    }

    public ArrayList<RestaurantModel> getRestaurantListModel() {
        ArrayList<RestaurantModel> restaurants = new ArrayList<>();
        return  restaurants;
    }
}

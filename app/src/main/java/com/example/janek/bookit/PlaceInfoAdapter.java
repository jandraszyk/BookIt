package com.example.janek.bookit;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.janek.bookit.models.PlaceInfo;

import java.util.ArrayList;

/**
 * Created by Janek on 18.05.2018.
 */

public class PlaceInfoAdapter extends ArrayAdapter<PlaceInfo> {

    private ArrayList<PlaceInfo> restaurants;
    private Activity context;

    public PlaceInfoAdapter(@NonNull Activity context, int textViewResourceId, @NonNull ArrayList<PlaceInfo> objects) {
        super(context, textViewResourceId, objects);
        this.restaurants = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            v = inflater.inflate(R.layout.list_element, null, true);
        }
        final PlaceInfo restaurant = restaurants.get(position);
        if(restaurant != null) {
            TextView restaurantName = v.findViewById(R.id.restaurantName);
            TextView restaurantAddress = v.findViewById(R.id.foodType);
            RatingBar ratingBar = v.findViewById(R.id.ratingBar);
            if(restaurantName != null) {
                restaurantName.setText(restaurant.getName());
            }
            if(restaurantAddress != null) {
                restaurantAddress.setText(restaurant.getFoodType());
            }
            if(ratingBar != null) {
                ratingBar.setRating(restaurant.getRating());
            }
        }


        return v;
    }

    @Override
    public int getViewTypeCount() {

        return 1;
    }

    @Override
    public int getItemViewType(int position) {

        return 0;
    }
}

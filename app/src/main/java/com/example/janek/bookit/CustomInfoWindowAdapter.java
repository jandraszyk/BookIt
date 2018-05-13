package com.example.janek.bookit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by Janek on 13.05.2018.
 */

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private final View mWindow;
    private Context mContext;

    public CustomInfoWindowAdapter(Context mContext) {
        this.mContext = mContext;
        mWindow = LayoutInflater.from(mContext).inflate(R.layout.list_element, null);
    }

    private void renderWindow(Marker marker, View view) {
        String title = marker.getTitle();
        String snippet = marker.getSnippet();
        TextView txtTtitle = view.findViewById(R.id.restaurantName);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);

        if(!title.equals("")) {
            txtTtitle.setText(title);
        }

        if(!snippet.equals("")) {
            ratingBar.setRating(Float.parseFloat(snippet));
            System.out.println(Float.parseFloat(snippet));
        }

    }

    @Override
    public View getInfoWindow(Marker marker) {
        renderWindow(marker, mWindow);
        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        renderWindow(marker, mWindow);
        return mWindow;
    }
}

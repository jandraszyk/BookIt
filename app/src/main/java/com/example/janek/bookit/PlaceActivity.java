package com.example.janek.bookit;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.janek.bookit.models.PlaceInfo_RestaurantsZones;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PlaceActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;

    private int requestedNumberOfPlaces;
    private ArrayList<PlaceInfo_RestaurantsZones> places = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        Intent previousIntent = getIntent();
        requestedNumberOfPlaces = previousIntent.getExtras().getInt("requestedNumberOfPlaces");
        String restaurantId = previousIntent.getExtras().getString("restaurantId");

        DatabaseReference databaseZones = FirebaseDatabase.getInstance().getReference("Zones");
        Query query = databaseZones.orderByChild("restaurantId").equalTo(restaurantId);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    int i = 0;
                    places.clear();
                    for (DataSnapshot issue : dataSnapshot.getChildren()) {
                        PlaceInfo_RestaurantsZones inf = issue.getValue(PlaceInfo_RestaurantsZones.class);
                        places.add(i++, inf);
                    }
                    loadLayout();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
    private void loadLayout(){
        button1 = findViewById(R.id.button1);
        button1.setBackgroundColor(places.get(0).getNumberOfAvailablePlaces() >= requestedNumberOfPlaces ? Color.GREEN : Color.RED);
        button2 = findViewById(R.id.button2);
        button2.setBackgroundColor(places.get(1).getNumberOfAvailablePlaces() >= requestedNumberOfPlaces ? Color.GREEN : Color.RED);
        button3 = findViewById(R.id.button3);
        button3.setBackgroundColor(places.get(2).getNumberOfAvailablePlaces() >= requestedNumberOfPlaces ? Color.GREEN : Color.RED);
        button4 = findViewById(R.id.button4);
        button4.setBackgroundColor(places.get(3).getNumberOfAvailablePlaces() >= requestedNumberOfPlaces ? Color.GREEN : Color.RED);
        button5 = findViewById(R.id.button5);
        button5.setBackgroundColor(places.get(4).getNumberOfAvailablePlaces() >= requestedNumberOfPlaces ? Color.GREEN : Color.RED);
        button6 = findViewById(R.id.button6);
        button6.setBackgroundColor(places.get(5).getNumberOfAvailablePlaces() >= requestedNumberOfPlaces ? Color.GREEN : Color.RED);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}

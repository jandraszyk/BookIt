package com.example.janek.bookit;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.*;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.janek.bookit.models.MockModel;
import com.example.janek.bookit.models.PlaceInfo;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int ERROR_DIALOG_REQUEST = 9001;
    private ListView restaurantList;
    private MockModel mockModel;
    private ArrayList<PlaceInfo> placeInfoList;
    private PlaceInfoAdapter placeInfoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btMap = findViewById(R.id.btFilter);
        restaurantList = findViewById(R.id.listView);
        mockModel = new MockModel();
        placeInfoList = mockModel.getRestaurantsList();
        placeInfoAdapter = new PlaceInfoAdapter(this, R.layout.list_element,placeInfoList);
        restaurantList.setAdapter(placeInfoAdapter);
        placeInfoAdapter.notifyDataSetChanged();
        System.out.println("!!!!!!!!" + placeInfoList.size());
        if(!isServicesOK()) {
            Log.d("onCreate", " Finishing app because Google Play Services aren't available");
            finish();
        }
        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                //startActivity(intent);
                Toast.makeText(MainActivity.this, "This will display filters for searching", Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton floatingActionButton = findViewById(R.id.btMap);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        restaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ActivityBook.class);
                startActivity(intent);
            }
        });

    }

    public boolean isServicesOK() {

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if(available == ConnectionResult.SUCCESS) {
            return true;
        } else if( GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            Dialog dialogRedirect = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialogRedirect.show();
        } else {
            Toast.makeText(this, "You can't make map request", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


}

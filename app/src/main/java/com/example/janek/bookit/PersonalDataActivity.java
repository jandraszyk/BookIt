package com.example.janek.bookit;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.janek.bookit.models.PlaceInfo;
import com.example.janek.bookit.models.PlaceInfo_RestaurantsZones;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class PersonalDataActivity extends AppCompatActivity {
    private EditText firstName, lastName, phoneNumber;
    private Button proceed;

    private DatabaseReference databaseZones;
    private PlaceInfo_RestaurantsZones updatedZone;

    private int numberOfRequestedPlaces;
    private int numberOfAvailablePlaces;
    private String placeId;

    private boolean[] isComponentSelected = {false, false, false};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);

        proceed = findViewById(R.id.proceed);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        phoneNumber = findViewById(R.id.phoneNumber);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!firstName.getText().toString().isEmpty() &&
                   !lastName.getText().toString().isEmpty() &&
                   !phoneNumber.getText().toString().isEmpty())
                {
                    updateDatabase();
                    /*Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            android.support.v7.app.AlertDialog alertDialog = new android.support.v7.app.AlertDialog.Builder(PersonalDataActivity.this).create();
                            alertDialog.setTitle("Reservation succeeded");
                            alertDialog.setMessage("Thanks for use our application");
                            alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                        }
                    }, 3000);*/

                    Intent intent = new Intent(PersonalDataActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(PersonalDataActivity.this, "Reservation is being checked", Toast.LENGTH_SHORT).show();

                } else {
                    android.support.v7.app.AlertDialog alertDialog = new android.support.v7.app.AlertDialog.Builder(PersonalDataActivity.this).create();
                    alertDialog.setTitle("Data is incomplete");
                    alertDialog.setMessage("Please fill all necessary data");
                    alertDialog.setButton(android.support.v7.app.AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });
    }
    private void updateDatabase(){
        Intent previousIntent = getIntent();
        placeId = previousIntent.getExtras().getString("placeId");
        numberOfRequestedPlaces = previousIntent.getExtras().getInt("requestedNumberOfPlaces");
        numberOfAvailablePlaces = previousIntent.getExtras().getInt("availablePlaces");
        System.out.println("ID" + placeId);

        databaseZones = FirebaseDatabase.getInstance().getReference("Zones");
        Query query = databaseZones.orderByChild("id").equalTo(placeId);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("Jestem");
                for (DataSnapshot issue : dataSnapshot.getChildren()) {
                    System.out.println("Jestem");
                    updatedZone = issue.getValue(PlaceInfo_RestaurantsZones.class);
                }
                updatedZone.setNumberOfAvailablePlaces(numberOfAvailablePlaces - numberOfRequestedPlaces);
                databaseZones.child(placeId).setValue(updatedZone);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

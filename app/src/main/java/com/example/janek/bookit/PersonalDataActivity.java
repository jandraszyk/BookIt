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

public class PersonalDataActivity extends AppCompatActivity {
    private EditText firstName, lastName, phoneNumber;
    private Button proceed;

    private boolean[] isComponentSelected = {false, false, false};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);

        proceed = findViewById(R.id.proceed);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        phoneNumber = findViewById(R.id.phoneNumber);

        firstName.addTextChangedListener(new InputValidator(0));
        lastName.addTextChangedListener(new InputValidator(1));
        phoneNumber.addTextChangedListener(new InputValidator(2));

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isComponentSelected[0] && isComponentSelected[1] && isComponentSelected[2]){Handler handler = new Handler();
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
                            Intent intent = new Intent(PersonalDataActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }, 3000);
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

    private class InputValidator implements TextWatcher {
        private  int index;

        public InputValidator(int index){
            this.index = index;
        }

        public void afterTextChanged(Editable s) {

        }
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {

        }
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            isComponentSelected[index] = true;
        }
    }
}

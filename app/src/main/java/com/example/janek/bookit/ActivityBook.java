package com.example.janek.bookit;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

public class ActivityBook extends AppCompatActivity {

    private TextView displayDate,displayTime;
    private Button btDate,btTime, btSubmit;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private TimePickerDialog.OnTimeSetListener timeSetListener;
    private EditText editText;
    private boolean[] isComponentSelected = {false, false, false};
    private int requestedNumberOfPlaces;

    Calendar calendar = Calendar.getInstance();
    int currYear = calendar.get(Calendar.YEAR);
    int currDay = calendar.get(Calendar.DAY_OF_MONTH);
    int currMonth = calendar.get(Calendar.MONTH);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        displayDate = findViewById(R.id.txtDay);
        displayTime = findViewById(R.id.txtTime);
        btTime = findViewById(R.id.btTime);
        btDate = findViewById(R.id.btDay);
        btSubmit = findViewById(R.id.btSubmit);
        editText = findViewById(R.id.numOfPeople);
        editText.addTextChangedListener(new InputValidator());

        btDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isComponentSelected[0] = true;
                DatePickerDialog dialog = new DatePickerDialog(ActivityBook.this, R.style.Theme_AppCompat_Light_Dialog_MinWidth, dateSetListener, currYear, currMonth, currDay);
                dialog.show();
            }
        });

        btTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isComponentSelected[1] = true;
                System.out.print("jeden0");
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog dialog = new TimePickerDialog(ActivityBook.this, R.style.Theme_AppCompat_Light_Dialog_MinWidth, timeSetListener, hour, minute, true);
                dialog.show();
            }
        });

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isComponentSelected[0] && isComponentSelected[1] && isComponentSelected[2]){
                    Intent previousIntent = getIntent();
                    String restaurantId = previousIntent.getExtras().getString("restaurantId");
                    Intent intent = new Intent(ActivityBook.this, PlaceActivity.class);
                    intent.putExtra("restaurantId", restaurantId).putExtra("requestedNumberOfPlaces", requestedNumberOfPlaces);
                    startActivity(intent);
                } else {
                    android.support.v7.app.AlertDialog alertDialog = new android.support.v7.app.AlertDialog.Builder(ActivityBook.this).create();
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

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                StringBuilder date = new StringBuilder(day + "/" + (month + 1) + "/" + year + " in ");
                int yearDiff = year - currYear;
                int monthDiff = month - currMonth;
                int dayDiff = day - currDay;
                if(yearDiff != 0) {
                    date.append(yearDiff + " years ");
                }
                if(monthDiff != 0) {
                    date.append(monthDiff + " months ");
                }
                if(dayDiff != 0) {
                    date.append(dayDiff + " days");
                }
                displayDate.setText(date);

            }
        };

        timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                String time = hour + ":" + minute;
                displayTime.setText(time);
            }
        };
    }
    private class InputValidator implements TextWatcher {

        public void afterTextChanged(Editable s) {

        }
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {

        }
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            isComponentSelected[2] = true;
            requestedNumberOfPlaces = Integer.parseInt(s.toString());

        }
    }

}




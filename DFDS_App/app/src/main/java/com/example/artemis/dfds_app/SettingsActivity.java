package com.example.artemis.dfds_app;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setUserName(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter your name");

        // Set up the input
        /*final EditText input = new EditText(this);
        input.setPadding(16,16,16,16);*/
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        /*input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);*/

        View dialog_view = LayoutInflater.from(this).inflate(R.layout.enter_name, null);
        final AppCompatEditText input = (AppCompatEditText) dialog_view.findViewById(R.id.editText);
        builder.setView(dialog_view);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = "John Doe";
                name = input.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void setDOB(View view) {

        final Calendar dateSelected = Calendar.getInstance();
        DatePickerDialog datePickerDialog;

        Calendar newCalendar = dateSelected;
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dateSelected.set(year, monthOfYear, dayOfMonth, 0, 0);
                //dateEditText.setText(dateFormatter.format(dateSelected.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        //dateEditText.setText(dateFormatter.format(dateSelected.getTime()));

        datePickerDialog.show();

    }

    public void setGender(View view) {

        final AlertDialog levelDialog;

        // Strings to Show In Dialog with Radio Buttons
        final CharSequence[] items = {" Male "," Female "};

        // Creating and Building the Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Set gender");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                switch(item)
                {
                    case 0:
                        // Your code when first option seletced
                        break;
                    case 1:
                        // Your code when 2nd  option seletced
                        break;
                }
                dialog.dismiss();
            }
        });

        levelDialog = builder.create();
        levelDialog.show();

    }

    public void setMessage(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Set alert message");

        View dialog_view = LayoutInflater.from(this).inflate(R.layout.enter_message, null);
        final AppCompatEditText input = (AppCompatEditText) dialog_view.findViewById(R.id.editText2);
        builder.setView(dialog_view);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = "";
                name = input.getText().toString();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

}

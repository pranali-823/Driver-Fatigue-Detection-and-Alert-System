package com.example.artemis.dfds_app;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNewActivity(View view)
    {
        int id = view.getId();

        switch(id)
        {
            case (R.id.card1):
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);
                break;
            case (R.id.card2):
                intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            case (R.id.card3):
                intent = new Intent(MainActivity.this, GuideActivity.class);
                startActivity(intent);
                break;
            case (R.id.card4):
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("About");
                builder.setIcon(R.drawable.ic_about);
                builder.setMessage(R.string.about_text);
                builder.setCancelable(true);
                builder.setPositiveButton("Okay", null);

                AlertDialog alert = builder.create();
                alert.show();

                break;
        }
    }
}

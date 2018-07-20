package com.example.artemis.dfds_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        TextView welcomeText = (TextView) findViewById(R.id.welcome_screen);

        welcomeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GuideActivity.this, GuideWelcomeActivity.class);
                startActivity(intent);
            }
        });
    }

}

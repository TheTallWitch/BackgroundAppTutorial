package com.developercat.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button changeColorBtn;
    RelativeLayout mainBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeColorBtn = findViewById(R.id.changeColorBtn);
        mainBackground = findViewById(R.id.mainBackground);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String hexColor = sharedPreferences.getString("BACKGROUND_COLOR", getString(R.string.default_color));

        mainBackground.setBackgroundColor(Color.parseColor("#" + hexColor));

        changeColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChangeColorActivity.class);
                intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
    }
}

package com.developercat.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangeColorActivity extends AppCompatActivity {

    EditText colorValue;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_color);

        colorValue = findViewById(R.id.colorValue);
        saveBtn = findViewById(R.id.saveBtn);

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String hexColor = sharedPreferences.getString("BACKGROUND_COLOR", getString(R.string.default_color));
        colorValue.setText(hexColor);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColor = String.valueOf(colorValue.getText());
                if (!newColor.equals("")) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("BACKGROUND_COLOR", newColor);
                    editor.apply();

                    startActivity(new Intent(ChangeColorActivity.this, MainActivity.class));
                    finish();
                }
            }
        });
    }
}

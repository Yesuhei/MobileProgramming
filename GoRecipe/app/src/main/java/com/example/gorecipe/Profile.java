package com.example.gorecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Profile extends AppCompatActivity {
    ImageButton favorite,logout,add,settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        favorite = findViewById(R.id.favorite);
        logout = findViewById(R.id.logout);
        add = findViewById(R.id.add);
        settings = findViewById(R.id.settings);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class info extends AppCompatActivity{

    private TextView fname,phone,address,gender,Sudlah1,Sudlah2,Sudlah3;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        String ner = getIntent().getStringExtra("ner");
        String utas = getIntent().getStringExtra("utas");
        String hayg = getIntent().getStringExtra("hayg");
        String huis = getIntent().getStringExtra("huis");
        String sudlah1 = getIntent().getStringExtra("sudlah1");
        String sudlah2 = getIntent().getStringExtra("sudlah2");
        String sudlah3 = getIntent().getStringExtra("sudlah3");

        fname = findViewById(R.id.fname);
        fname.setText(ner);

        phone = findViewById(R.id.phone);
        phone.setText(utas);

        address = findViewById(R.id.address);
        address.setText(hayg);

        gender = findViewById(R.id.gender);
        gender.setText(huis);

        Sudlah1 = findViewById(R.id.sudlah1);
        Sudlah1.setText(sudlah1);

        Sudlah2 = findViewById(R.id.sudlah2);
        Sudlah2.setText(sudlah2);

        Sudlah3 = findViewById(R.id.sudlah3);
        Sudlah3.setText(sudlah3);

        back = (Button) findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(info.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
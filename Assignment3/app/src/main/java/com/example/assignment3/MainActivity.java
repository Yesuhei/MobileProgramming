package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button submit;
    public String FullName,Phone,Address;
    private EditText fName,phone,address;
    private TextView fullname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        submit = (Button) findViewById(R.id.submitBtn);
        fName = (EditText) findViewById(R.id.eFname);
        phone = (EditText) findViewById(R.id.ePhone);
        address = (EditText) findViewById(R.id.eAddress);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showInfo();
            }
        });

    }

    public void showInfo(){
        FullName = fName.getText().toString();
        Phone = phone.getText().toString();
        Address = address.getText().toString();

        Intent intent = new Intent(this,Info.class);
        intent.putExtra("ner",FullName);
        intent.putExtra("utas",Phone);
        intent.putExtra("hayg",Address);
        startActivity(intent);
    }
}

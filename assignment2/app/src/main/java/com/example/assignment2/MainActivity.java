package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button submit;
    public String FullName,Phone,Address,Gender,Sudlah1,Sudlah2,Sudlah3;
    private EditText fName,phone,address;
    private RadioButton rbFemale,rbMale;
    private CheckBox chWeb,chPython,chJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        RadioButton
        rbMale = (RadioButton) findViewById(R.id.male);
        rbFemale = (RadioButton) findViewById(R.id.female);

        rbMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gender = "Male";
            }
        });
        rbFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gender = "Female";
            }
        });
//        CheckBox
        chWeb = (CheckBox) findViewById(R.id.chWeb);
        chJava = (CheckBox) findViewById(R.id.chJava);
        chPython = (CheckBox) findViewById(R.id.chPython);




//        EditText
        fName = (EditText) findViewById(R.id.eFname);
        phone = (EditText) findViewById(R.id.ePhone);
        address = (EditText) findViewById(R.id.eAddress);


//        Submit
        submit = (Button) findViewById(R.id.submitBtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showInfo();
            }
        });

    }

    public void showInfo(){

        if(chJava.isChecked()){
            Sudlah1="Java";
        }
        if(chWeb.isChecked()){
            Sudlah2="Web";
        }
        if(chPython.isChecked()){
            Sudlah3="Python";
        }
        FullName = fName.getText().toString();
        Phone = phone.getText().toString();
        Address = address.getText().toString();


        Intent intent = new Intent(this,info.class);
        intent.putExtra("ner",FullName);
        intent.putExtra("utas",Phone);
        intent.putExtra("hayg",Address);
        intent.putExtra("huis",Gender);
        intent.putExtra("sudlah1",Sudlah1);
        intent.putExtra("sudlah2",Sudlah2);
        intent.putExtra("sudlah3",Sudlah3);
        startActivity(intent);
    }
}

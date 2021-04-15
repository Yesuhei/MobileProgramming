package com.example.passimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private Spinner sp;
    private String[] user = {"User 1","User 2","User 3","User 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        sp = (Spinner) findViewById(R.id.sp);
        ArrayAdapter adapter = new ArrayAdapter(
                this, android.R.layout.simple_spinner_item, user
        );
        sp.setAdapter(adapter);
        btn.setOnClickListener(v -> {

            int pos = sp.getSelectedItemPosition();

            Intent i = new Intent(MainActivity.this,MainActivity2.class);
            i.putExtra("pic",pos);
            startActivity(i);

        });
    }
}
package com.example.spinnerlab;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner sp;
    private Button btn;
    private ImageView iv;
    private String[] user = {"User 1","User 2","User 3","User 4"};
    private int[] users = {R.drawable.user1,
                            R.drawable.user2,
                            R.drawable.user3,
                            R.drawable.user4};
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = (Spinner) findViewById(R.id.sp);
        btn = (Button) findViewById(R.id.btn);
        iv = (ImageView) findViewById(R.id.iv);
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,user);

        sp.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = sp.getSelectedItemPosition();
                iv.setImageResource(users[pos]);
            }
        });
    }
}
package com.example.lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                iv.setImageResource(R.drawable.user1);
                return true;
            case R.id.item2:
                iv.setImageResource(R.drawable.user2);
                return true;
            case R.id.item3:
                iv.setImageResource(R.drawable.user3);
                return true;
            case R.id.item4:
                iv.setImageResource(R.drawable.user4);
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }
    }
}
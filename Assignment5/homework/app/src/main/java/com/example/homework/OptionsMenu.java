package com.example.homework;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class OptionsMenu extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.profile){
            Intent i = new Intent(this,Profile.class);
            startActivity(i);
            return true;
        }else if(item.getItemId() == R.id.grades){
            Intent i = new Intent(this,Grades.class);
            startActivity(i);
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }


    }
}

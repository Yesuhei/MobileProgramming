package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn);
        registerForContextMenu(btn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item1){
            Toast.makeText(this, "item 1 ", Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId() == R.id.item2){
            Toast.makeText(this, "item 2 ", Toast.LENGTH_SHORT).show();
            return true;
        }else if(item.getItemId() == R.id.item3){
            Toast.makeText(this, "item 3 ", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            return super.onContextItemSelected(item);
        }


    }
}
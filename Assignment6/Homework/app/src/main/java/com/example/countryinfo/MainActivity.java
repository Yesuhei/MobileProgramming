package com.example.countryinfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String Title[] = {"China","France","Italy","Spain","USA"};
    String Descrtiption[] = {
            "Diversity is synonymous to China. Its rich culture is simply extraordinary...",
            "The largest country in Western Europe is hailed as one of the world's...",
            "Some of the most renowned cities in the world, such as Vatican City,Rome and...",
            "From immaculate-white Mediterranean villages to bustling and sophisticated...",
            "America may be the world's most influential country, but there is more to..."
    };
    int images[] = {
            R.drawable.china,
            R.drawable.france,
            R.drawable.italy,
            R.drawable.spain,
            R.drawable.usa

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       lv = findViewById(R.id.lv);

       MyAdapter adapter = new MyAdapter(this,Title,Descrtiption,images);
       lv.setAdapter(adapter);

       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if(position == 0){
                   //China
                   Intent i = new Intent(MainActivity.this,Info.class);
                   i.putExtra("int",position);
                   startActivity(i);
                   Toast.makeText(MainActivity.this, Title[position], Toast.LENGTH_SHORT).show();
               }else if(position == 1){
                   //France
                   Intent i = new Intent(MainActivity.this,Info.class);
                   i.putExtra("int",position);
                   startActivity(i);
                   Toast.makeText(MainActivity.this, Title[position], Toast.LENGTH_SHORT).show();
               }else if(position == 2){
                   //Italy
                   Intent i = new Intent(MainActivity.this,Info.class);
                   i.putExtra("int",position);
                   startActivity(i);
                   Toast.makeText(MainActivity.this, Title[position], Toast.LENGTH_SHORT).show();
               }else if(position == 3){
                   //Spain
                   Intent i = new Intent(MainActivity.this,Info.class);
                   i.putExtra("int",position);
                   startActivity(i);
                   Toast.makeText(MainActivity.this, Title[position], Toast.LENGTH_SHORT).show();
               }else if(position == 4){
                   //USA
                   Intent i = new Intent(MainActivity.this,Info.class);
                   i.putExtra("int",position);
                   startActivity(i);
                   Toast.makeText(MainActivity.this, Title[position], Toast.LENGTH_SHORT).show();
               }
           }
       });




    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String aTitle[];
        String aDescription[];
        int aImgs[];

        MyAdapter (Context c,String title[],String description[],int imgs[]){
            super(c,R.layout.source,R.id.title,title);
            this.context = c;
            this.aTitle = title;
            this.aDescription = description;
            this.aImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.source,parent,false);
            ImageView images = row.findViewById(R.id.img);
            TextView myTitle = row.findViewById(R.id.title);
            TextView myDescription = row.findViewById(R.id.desc);

            images.setImageResource(aImgs[position]);
            myTitle.setText(aTitle[position]);
            myDescription.setText(aDescription[position]);



            return row;
        }
    }
}
package com.example.gorecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    GridView gridView;
    ImageButton profile;
    String[] names = {"burger","pizza","sandwich","buddae-jigae","spaghetti",
            "burger","pizza","sandwich","buddae-jigae","spaghetti",
            "burger","pizza","sandwich","buddae-jigae","spaghetti"};
    int[] images = {R.drawable.burger,R.drawable.pizza,R.drawable.sandwich,
            R.drawable.buddaejiggae,R.drawable.spagheti,
            R.drawable.burger,R.drawable.pizza,R.drawable.sandwich,
            R.drawable.buddaejiggae,R.drawable.spagheti,
            R.drawable.burger,R.drawable.pizza,R.drawable.sandwich,
            R.drawable.buddaejiggae,R.drawable.spagheti

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profile = findViewById(R.id.profile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Profile.class);
                startActivity(intent);
            }
        });

        gridView = findViewById(R.id.gridView);

        CustomAdapter customAdapter = new CustomAdapter(names,images,this);
        gridView.setAdapter(customAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String selectedName = names[i];
                int selectedImage = images[i];

                startActivity(new Intent(Home.this,Recipe.class).putExtra("name",selectedName).putExtra("image",selectedImage));
            }
        });

    }

    public class CustomAdapter extends BaseAdapter{
        private String[] imageNames;
        private int[] imagesPhoto;
        private Context context;
        private LayoutInflater layoutInflater;


        public CustomAdapter(String[] imageNames, int[] imagesPhoto, Context context) {
            this.imageNames = imageNames;
            this.imagesPhoto = imagesPhoto;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imagesPhoto.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if(view == null){
                view = layoutInflater.inflate(R.layout.row_items, viewGroup, false);

            }
            TextView tvName = view.findViewById(R.id.tvName);
            ImageView imageView = view.findViewById(R.id.imageView);

            tvName.setText(imageNames[i]);
            imageView.setImageResource(imagesPhoto[i]);

            return view;
        }
    }
}
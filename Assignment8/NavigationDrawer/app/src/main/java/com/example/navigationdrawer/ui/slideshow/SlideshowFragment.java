package com.example.navigationdrawer.ui.slideshow;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationdrawer.CountryInfo;
import com.example.navigationdrawer.R;

public class SlideshowFragment extends Fragment {


    private SlideshowViewModel slideshowViewModel;

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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel = new ViewModelProvider(this).get(SlideshowViewModel.class);

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        lv = root.findViewById(R.id.lv);

        MyAdapter adapter = new MyAdapter(getActivity(),Title,Descrtiption,images);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    //China
                    Intent i = new Intent(getActivity(), CountryInfo.class);
                    i.putExtra("int",position);
                    startActivity(i);
                    Toast.makeText(getActivity(), Title[position], Toast.LENGTH_SHORT).show();
                }else if(position == 1){
                    //France
                    Intent i = new Intent(getActivity(), CountryInfo.class);
                    i.putExtra("int",position);
                    startActivity(i);
                    Toast.makeText(getActivity(), Title[position], Toast.LENGTH_SHORT).show();
                }else if(position == 2){
                    //Italy
                    Intent i = new Intent(getActivity(), CountryInfo.class);
                    i.putExtra("int",position);
                    startActivity(i);
                    Toast.makeText(getActivity(), Title[position], Toast.LENGTH_SHORT).show();
                }else if(position == 3){
                    //Spain
                    Intent i = new Intent(getActivity(), CountryInfo.class);
                    i.putExtra("int",position);
                    startActivity(i);
                    Toast.makeText(getActivity(), Title[position], Toast.LENGTH_SHORT).show();
                }else if(position == 4){
                    //USA
                    Intent i = new Intent(getActivity(), CountryInfo.class);
                    i.putExtra("int",position);
                    startActivity(i);
                    Toast.makeText(getActivity(), Title[position], Toast.LENGTH_SHORT).show();
                }
            }
        });



//        final TextView textView = root.findViewById(R.id.text_slideshow);


        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return root;
    }
    class MyAdapter extends ArrayAdapter<String> {
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
            LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
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
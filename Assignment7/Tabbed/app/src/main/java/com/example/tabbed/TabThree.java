package com.example.tabbed;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class TabThree extends Fragment {


    GridView gv;

    int img[] = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.elliot,
            R.drawable.e
    };

    public TabThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_tab_three, container, false);



        gv = view.findViewById(R.id.gv);
        gv.setAdapter(new imgadapter(getActivity()));
        return view;
    }

    class imgadapter extends BaseAdapter{
        private Context mContext;

        public imgadapter(Context context){
            mContext = context;
        }

        @Override
        public int getCount() {
            return img.length;
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
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imageView;

            if(convertView == null){
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(500,500));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(10,10,10,10);

            }else{
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(img[position]);
            return imageView;
        }
    }
}
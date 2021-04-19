package com.example.navigationdrawer.ui.gallery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationdrawer.CountryInfo;
import com.example.navigationdrawer.Full_Image;
import com.example.navigationdrawer.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    GridView gv;

    int img[] = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.elliot,
            R.drawable.e
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        gv = root.findViewById(R.id.gv);
        gv.setAdapter(new imgadapter(getActivity()));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for(int i = 0;i<=img.length;i++){
                    if(i == position){
                        Intent intent = new Intent(getActivity(), Full_Image.class);
                        intent.putExtra("int",position);
                        startActivity(intent);

                    }
                }
            }
        });



//        final TextView textView = root.findViewById(R.id.text_gallery);


        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return root;
    }
    class imgadapter extends BaseAdapter {
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
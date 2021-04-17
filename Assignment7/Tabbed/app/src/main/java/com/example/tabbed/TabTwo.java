package com.example.tabbed;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TabTwo extends Fragment {

    private ListView lv;
    private ArrayAdapter adapter;
    private String[] data = {
            "Maroon 5 - Beautiful Mistakes","Hyukoh - Comes And Goes","Lauv & LANY - Mean It",
            "Magnolian - Primadonna","Arctic Monkeys - Do I Wanna Know",
            "BIGBANG - LIES","Maroon 5 - This Love","Sash - Close To You",
            "HAARPER - We Only Go North","Seotaiji - Ultramania","Maroon 5 - Beautiful Mistakes","Hyukoh - Comes And Goes","Lauv & LANY - Mean It",
            "Magnolian - Primadonna","Arctic Monkeys - Do I Wanna Know",
            "BIGBANG - LIES","Maroon 5 - This Love","Sash - Close To You",
            "HAARPER - We Only Go North","Seotaiji - Ultramania"
    };


    public TabTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_tab_two, container, false);
        lv = (ListView) view.findViewById(R.id.lv);

        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,data);
        lv.setAdapter(adapter);


        return view;
    }
}
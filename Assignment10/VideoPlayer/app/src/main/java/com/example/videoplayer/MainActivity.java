package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<String> arrayList;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listView);
        videoView = (VideoView)findViewById(R.id.videoView);

        arrayList = new ArrayList<String>();
        mediaController = new MediaController(this);
        Field[] fields = R.raw.class.getFields();
        for(int i = 0;i<fields.length;i++){
            arrayList.add(fields[i].getName());
        }
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri uri = Uri.parse("android.resource://"+getPackageName()+"/raw"+arrayList.get(position));
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(uri);
                videoView.start();
            }
        });
    }
}
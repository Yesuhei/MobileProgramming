package com.example.passimage;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;
    private int[] img = {R.drawable.user1,R.drawable.user2,R.drawable.user3,R.drawable.user4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = (TextView) findViewById(R.id.tv);
        iv = (ImageView) findViewById(R.id.iv);
        Bundle bundle = getIntent().getExtras();
        int pos = bundle.getInt("pic");
        iv.setImageResource(img[pos]);
    }
}
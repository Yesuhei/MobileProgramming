package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private TextView result;
    private CheckBox chHtml,chJava,chWeb,chCss;
    ArrayList<String> lesson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        result = (TextView) findViewById(R.id.result);
        chHtml = (CheckBox) findViewById(R.id.chHtml);
        chJava = (CheckBox) findViewById(R.id.chJava);
        chWeb = (CheckBox) findViewById(R.id.chWeb);
        chCss = (CheckBox) findViewById(R.id.chCss);
        lesson = new ArrayList<String>();


        chHtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chHtml.isChecked()){
                    lesson.add("HTML");
                }else{
                    lesson.remove("HTML");
                }
            }
        });
        chJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chJava.isChecked()){
                    lesson.add("Java");
                }else{
                    lesson.remove("Java");
                }
            }
        });
        chWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chWeb.isChecked()){
                    lesson.add("Web");
                }else{
                    lesson.remove("Web");
                }
            }
        });
        chCss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chCss.isChecked()){
                    lesson.add("CSS");
                }else{
                    lesson.remove("CSS");
                }
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                for(String txt: lesson)
                    sb.append(txt).append(", ");
                result.setText("Your skills: " + sb.toString());
            }
        });

    }
}
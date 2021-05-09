package com.example.fileinternal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnWrite,btnRead;
    private EditText editText;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnWrite = (Button) findViewById(R.id.btnWrite);
        btnRead = (Button) findViewById(R.id.btnRead);
        editText = (EditText) findViewById(R.id.editText);
        result = (TextView) findViewById(R.id.result);

        btnWrite.setOnClickListener(this);
        btnRead.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnWrite){
            writeInternal();
        }if(v.getId() == R.id.btnRead){
            readInternal();
        }
    }

    private void writeInternal(){
        String message = editText.getText().toString();
        String filename = "internal_file.txt";
        try{
            FileOutputStream fos = openFileOutput(filename,MODE_PRIVATE);
            fos.write(message.getBytes());
            fos.close();
            Toast.makeText(this, "Message saved", Toast.LENGTH_SHORT).show();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void readInternal(){
        try{
            String message;
            FileInputStream fis = openFileInput("internal_file.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer stringBuffer = new StringBuffer();
            while((message = br.readLine()) != null){
                stringBuffer.append(message +"\n");
            }
            result.setText(stringBuffer);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
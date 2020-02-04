package com.example.filepersistencetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        String content = onLoad();
        if(!TextUtils.isEmpty(content)){
            editText.setText(content);
            editText.setSelection(content.length());
            Toast.makeText(this, "Restore content succeed", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        String data = editText.getText().toString();
        onSave(data);
    }


    public void onSave(String data){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if(writer != null)
                    writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public String onLoad(){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            if((line = reader.readLine()) != null)
                builder.append(line);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if(reader != null)
                    reader.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return builder.toString();
    }
}

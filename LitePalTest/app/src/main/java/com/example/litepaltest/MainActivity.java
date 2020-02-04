package com.example.litepaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.tablemanager.Connector;

public class MainActivity extends AppCompatActivity {

    private Button create_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create_database = findViewById(R.id.create_database);
        create_database.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Connector.getDatabase();
                Toast.makeText(v.getContext(), "Database created succeed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.example.databaseforprovidertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button create_databse = findViewById(R.id.create_database);
        create_databse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
            }
        });

        Button add_data = findViewById(R.id.add_data);
        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("Code");
                book.setAuthor("Tom");
                book.setPages(500);
                book.setPrice(49.9);
                book.save();
            }
        });

        Button update_data = findViewById(R.id.update_data);
        update_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("Symbol");
                book.setPrice(30.0);
                book.setPages(300);
                book.update(2);
                book.setName("Apple");
                book.setPrice(29.9);
                book.setAuthor("Jack");
                book.setPages(88);
                book.update(3);
                book.setName("Orange");
                book.setPages(99);
                book.update(4);
                book.setName("The last one");
                book.setAuthor("Peter");
                book.setPrice(59.9);
                book.setPages(1000);
                book.update(5);
            }
        });



    }
}

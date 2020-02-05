package com.example.litepaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.exceptions.DataSupportException;
import org.litepal.tablemanager.Connector;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button create_database;

    private Button add_data;

    private Button update_data;

    private Button delete_data;

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

        add_data = findViewById(R.id.add_data);
        add_data.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Book book = new Book();
                book.setName("Code");
                book.setAuthor("Tom");
                book.setPages(60);
                book.setPress("Unknown");
                book.setPrice(36.5);
                if(!book.save())
                    Log.d(TAG, "onClick: insert false");
                else
                    Toast.makeText(v.getContext(), "done", Toast.LENGTH_SHORT).show();
                Category category = new Category();
                category.setCategoryCode(1);
                category.setName("fuck");
                category.save();
            }
        });

        update_data = findViewById(R.id.update_data);
        update_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setPrice(14.95);
                book.setPress("Anchor");
                book.updateAll("id = ? and name = ? and author = ?", "7", "Code", "Tom");
            }
        });

        delete_data = findViewById(R.id.delete_data);
        delete_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(Book.class, "pages = ? and price < ?", "60", "20");
                LitePal.deleteAll(Category.class);
            }
        });
    }
}

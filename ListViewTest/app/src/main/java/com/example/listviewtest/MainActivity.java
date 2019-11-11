package com.example.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruit_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruit_list);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Fruit fruit = fruit_list.get(position);
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruit(){
        for(int i = 0; i < 2; ++i){
            Fruit apple = new Fruit("apple", R.drawable.apple);
            fruit_list.add(apple);
            Fruit grape = new Fruit("Grape", R.drawable.grape);
            fruit_list.add(grape);
            Fruit mango = new Fruit("mango", R.drawable.mango);
            fruit_list.add(mango);
            Fruit orange = new Fruit("orange", R.drawable.orange);
            fruit_list.add(orange);
            Fruit pear = new Fruit("pear", R.drawable.pear);
            fruit_list.add(pear);
            Fruit pineapple = new Fruit("pineapple", R.drawable.pineapple);
            fruit_list.add(pineapple);
            Fruit strawberry = new Fruit("strawberry", R.drawable.strawberry);
            fruit_list.add(strawberry);
            Fruit watermelon = new Fruit("watermelon", R.drawable.watermelon);
            fruit_list.add(watermelon);
        }
    }
}

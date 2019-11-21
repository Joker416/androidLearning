package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruit_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter fruitAdapter = new FruitAdapter(fruit_list);
        recyclerView.setAdapter(fruitAdapter);
    }

    private void initFruits(){
        for(int i = 0; i < 2; ++i){
            Fruit apple = new Fruit( getRandomLengthName("apple"), R.drawable.apple);
            fruit_list.add(apple);
            Fruit grape = new Fruit( getRandomLengthName("grape"), R.drawable.grape);
            fruit_list.add(grape);
            Fruit mango = new Fruit( getRandomLengthName("mango"), R.drawable.mango);
            fruit_list.add(mango);
            Fruit orange = new Fruit( getRandomLengthName("orange"), R.drawable.orange);
            fruit_list.add(orange);
            Fruit pear = new Fruit( getRandomLengthName("pear"), R.drawable.pear);
            fruit_list.add(pear);
            Fruit pineapple = new Fruit( getRandomLengthName("pineapple"), R.drawable.pineapple);
            fruit_list.add(pineapple);
            Fruit strawberry = new Fruit( getRandomLengthName("strawberry"), R.drawable.strawberry);
            fruit_list.add(strawberry);
            Fruit watermelon = new Fruit( getRandomLengthName("watermelon"), R.drawable.watermelon);
            fruit_list.add(watermelon);
        }
    }

    private String getRandomLengthName(String name){
        Random random = new Random();
        int nameLength = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < nameLength; ++i){
            builder.append(name);
        }
        return builder.toString();
    }
}

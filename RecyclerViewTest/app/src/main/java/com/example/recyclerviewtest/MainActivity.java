package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter fruitAdapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(fruitAdapter);
    }

    private void initFruits(){
        for(int i = 0; i < 2; ++i){
            Fruit apple = new Fruit("Apple", R.drawable.apple);
            fruitList.add(apple);
            Fruit grape = new Fruit("Grape", R.drawable.grape);
            fruitList.add(grape);
            Fruit mango = new Fruit("Mango", R.drawable.mango);
            fruitList.add(mango);
            Fruit orange = new Fruit("Orange", R.drawable.orange);
            fruitList.add(orange);
            Fruit pear = new Fruit("Pear", R.drawable.pear);
            fruitList.add(pear);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon);
            fruitList.add(watermelon);
        }
    }
}

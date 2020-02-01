package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        GridLayoutManager layoutManager = new GridLayoutManager(this,5);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter fruitAdapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(fruitAdapter);
    }

    private void initFruits(){
        for(int i = 0; i < 2; ++i){
            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.drawable.apple);
            fruitList.add(apple);
            Fruit grape = new Fruit(getRandomLengthName("Grape"), R.drawable.grape);
            fruitList.add(grape);
            Fruit mango = new Fruit(getRandomLengthName("Mango"), R.drawable.mango);
            fruitList.add(mango);
            Fruit orange = new Fruit(getRandomLengthName("Orange"), R.drawable.orange);
            fruitList.add(orange);
            Fruit pear = new Fruit(getRandomLengthName("Pear"), R.drawable.pear);
            fruitList.add(pear);
            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"), R.drawable.pineapple);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"), R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"), R.drawable.watermelon);
            fruitList.add(watermelon);
        }
    }

    private String getRandomLengthName(String name){
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < length; ++i)
            stringBuilder.append(name);
        return stringBuilder.toString();
    }
}

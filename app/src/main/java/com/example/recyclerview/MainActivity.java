package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        /*LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);//横向滚动*/
        recyclerView.setLayoutManager(manager);
        FruitAdapter adapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void initFruit() {
        Fruit apple = new Fruit("apple", R.drawable.ic_launcher_background);
        fruitList.add(apple);
        Fruit banana = new Fruit("banana", R.drawable.ic_launcher_foreground);
        fruitList.add(banana);
        for (int i = 0; i < 8; i++) {


            Fruit apple1 = new Fruit(getRandomName("apple"), R.drawable.ic_launcher_background);
            fruitList.add(apple1);
            Fruit banana1 = new Fruit(getRandomName("banana"), R.drawable.ic_launcher_foreground);
            fruitList.add(banana1);
        }
    }
    private String getRandomName(String name){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);

        }
        return builder.toString();
    }
}


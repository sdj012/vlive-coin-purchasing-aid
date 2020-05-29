package com.example.coinpurchaseaid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Options extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    ArrayList<Map<String,Double>> list_of_options = new ArrayList<Map<String,Double>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        System.out.println("Options: onCreate ");

        super.onCreate(savedInstanceState);
        System.out.println("Options:  super.onCreate(savedInstanceState);  ");

        setContentView(R.layout.activity_options);
        System.out.println("Options:  setContentView(R.layout.activity_options);");

        recyclerView = findViewById(R.id.recyclerView);

        System.out.println("Options: recyclerView = findViewById(R.id.recyclerView);  ");


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        System.out.println("Options: recyclerView.setLayoutManager(layoutManager); ");

        recyclerAdapter mAdapter = new recyclerAdapter(list_of_options);
        recyclerView.setAdapter(mAdapter);

        System.out.println("Options: recyclerView.setAdapter(mAdapter); ");

    }
}

package com.example.githubapiapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    //Declare RecyclerView, corresponding adapter and layout manager
    private RecyclerView recyclerView;
    private RecyclerView.Adapter rAdapter;
    private RecyclerView.LayoutManager rLayoutManager;

    //Test dataset to be displayed in the list initially
    private String[] dataSet = new String[]{"test","test2","test3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.commit_recycler_view);

        recyclerView.setHasFixedSize(true);

        rLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rLayoutManager);

        rAdapter = new ViewAdapter(dataSet);
        recyclerView.setAdapter(rAdapter);
    }
}

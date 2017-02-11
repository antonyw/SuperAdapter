package me.anthony.testlibrarymodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.anthony.superadapter.recyclerview.CommonRecyclerAdapter;
import me.anthony.superadapter.recyclerview.CommonRecyclerViewHolder;
import me.anthony.superadapter.recyclerview.OnConvert;

public class MainActivity extends AppCompatActivity {

    private int count = 10, max = 999999, min = 100000;

    private ArrayList<Integer> data;

    private RecyclerView recyclerView;

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setSubtitle("for RecyclerView");
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        btn = (Button) findViewById(R.id.btn);
        data = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int r = random.nextInt(max) % (max - min + 1) + min;
            data.add(r);
        }
        initView();
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        CommonRecyclerAdapter<Integer> adapter = new CommonRecyclerAdapter<>(MainActivity.this, data, R.layout.item, new OnConvert<Integer>() {
            @Override
            public void convert(CommonRecyclerViewHolder viewHolder, Integer integer) {
                viewHolder.setText(R.id.tv, integer.toString());
            }
        });
        recyclerView.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListAty.class);
                Bundle bundle = new Bundle();
                bundle.putIntegerArrayList("list", data);
                i.putExtra("bundle",bundle);
                startActivity(i);
            }
        });
    }
}

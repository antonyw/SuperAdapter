package me.anthony.testlibrarymodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import me.anthony.superadapter.listview.CommonListAdapter;
import me.anthony.superadapter.listview.CommonListViewHolder;
import me.anthony.superadapter.listview.OnConvert;

/**
 * Created by Anthony on 2017/2/11.
 */

public class ListAty extends AppCompatActivity {

    private ListView lv;

    private ArrayList<Integer> data = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_list);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setSubtitle("for ListView");
        actionBar.setDisplayHomeAsUpEnabled(true);
        lv = (ListView) findViewById(R.id.lv);
        Intent i = getIntent();
        Bundle bundle = i.getBundleExtra("bundle");
        data.addAll(bundle.getIntegerArrayList("list"));
        initView();
    }

    private void initView() {
        lv.setAdapter(new CommonListAdapter<>(ListAty.this, data, android.R.layout.simple_list_item_1, new OnConvert<Integer>() {
            @Override
            public void convert(CommonListViewHolder viewHolder, Integer integer) {
                viewHolder.setText(android.R.id.text1, integer.toString());
            }
        }));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            ListAty.this.finish();
        return super.onOptionsItemSelected(item);
    }
}

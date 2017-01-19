package com.devscious.menuorder;

/**
 * Created by Khang.Dong on 2017-01-17.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class ConfirmOrder extends AppCompatActivity {
    CustomList adpater;
    private List<Data> listData = new ArrayList<>();
    double total = 0;
    String[] title = {
            "Plain HomeBurger",
            "Chicken Satay Tosta",
            "Chicken Satay Tosta"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_order);

        adpater = new CustomList(ConfirmOrder.this, listData);
        RecyclerView rview = (RecyclerView) findViewById(R.id.list);
        rview.setItemAnimator(new DefaultItemAnimator());
        rview.setAdapter(adpater);
        addItem();
        rview.setLayoutManager(new LinearLayoutManager(ConfirmOrder.this));
        //Set Line for list.
        rview.addItemDecoration(new DividerItemDecoration(getApplicationContext()));
        rview.setAdapter(adpater);
        rview.setItemAnimator(new DefaultItemAnimator());
        rview.setLayoutManager(new LinearLayoutManager(ConfirmOrder.this));
        EventBus.getDefault().register(this);
        Toolbar actionToolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView txtTotal = (TextView) findViewById(R.id.txtTotal);
        setSupportActionBar(actionToolbar);
        actionToolbar.setLogo(R.drawable.logo);
        for (int i = 0; i< listData.size();i++){
            total = total + listData.get(i).getPrice() * listData.get(i).getQuality();
        }
        txtTotal.setText("Total: "+ total +" VND");
    }

    public void addItem(){
        Data dataToAdd = new Data("Plain HomeBurger", 140000, 1, R.drawable.food1);
        listData.add(dataToAdd);
        dataToAdd = new Data("Chicken Satay Tosta", 160000, 1, R.drawable.food2);
        listData.add(dataToAdd);
        dataToAdd = new Data("Plain HomeBurger", 140000, 2, R.drawable.food1);
        listData.add(dataToAdd);
        dataToAdd = new Data("Chicken Satay Tosta", 160000, 1, R.drawable.food2);
        listData.add(dataToAdd);
        dataToAdd = new Data("Chicken Satay Tosta", 160000, 1, R.drawable.food2);
        listData.add(dataToAdd);
        dataToAdd = new Data("Chicken Satay Tosta", 160000, 1, R.drawable.food2);
        listData.add(dataToAdd);
        adpater.notifyDataSetChanged();
    }
    @Subscribe
    public void onEvent(String pst){
        TextView txtTotal = (TextView) findViewById(R.id.txtTotal);
        total = total - listData.get(Integer.parseInt(pst)).getPrice() * listData.get(Integer.parseInt(pst)).getQuality();
        txtTotal.setText("Total: "+  total +" VND");
    }
}

package com.artix.pichart_lib.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import com.artix.pichart_lib.Adapter.ItemAdapter;
import com.artix.pichart_lib.PiData;
import com.artix.pichart_lib.PiView;
import com.artix.pichart_lib.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PiChart extends LinearLayout {
    RecyclerView recyclerView;
    PiView piview;

    List<PiData> piData  = new ArrayList<>();

    public PiChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View v  =  inflate(context, R.layout.pi_chart, this);
        recyclerView = v.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        piview = v.findViewById(R.id.piview);
      Init(v);
    }

    private void Init(View v) {

        piData.add(new PiData(1,"1",10,getResources().getColor(R.color.red)));
        piData.add(new PiData(2,"2",120,getResources().getColor(R.color.greeen)));
        piData.add(new PiData(3,"3",120,getResources().getColor(R.color.blue)));
        piData.add(new PiData(3,"4",10,getResources().getColor(R.color.purple)));
        piview.setPiData(piData);

        ItemAdapter adapter =new ItemAdapter(piData);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @SuppressLint("NotifyDataSetChanged")
    public void setPiData(List<PiData> piData) {

        for (int i  = 0; i<piData.size();i++){
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            piData.get(i).setColor(color);
        }
        this.piData = piData;
        piview.setPiData(piData);
        ItemAdapter adapter =new ItemAdapter(piData);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}

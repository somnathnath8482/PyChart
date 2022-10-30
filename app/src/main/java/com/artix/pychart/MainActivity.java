package com.artix.pychart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.artix.pichart_lib.PiData;
import com.artix.pichart_lib.View.PiChart;
import  com.artix.pychart.R;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
PiChart py_ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        py_ch = findViewById(R.id.py_ch);


        List<PiData> piData = new ArrayList<>();
        piData.add(new PiData(1,"1",13));
        piData.add(new PiData(2,"2",73));
        piData.add(new PiData(3,"3",13));
        piData.add(new PiData(4,"4",19));
        piData.add(new PiData(5,"5",11));
        piData.add(new PiData(6,"6",25));
        piData.add(new PiData(7,"7",12));
        piData.add(new PiData(1,"8",43));
        piData.add(new PiData(2,"9",22));
        piData.add(new PiData(3,"10",33));
        piData.add(new PiData(3,"11",77));
        piData.add(new PiData(3,"12",67));
        piData.add(new PiData(3,"13",56));
        piData.add(new PiData(3,"14",31));
        py_ch.setPiData(piData);
    }
}
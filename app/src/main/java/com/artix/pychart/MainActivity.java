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
        piData.add(new PiData(1,"Goa 1-40",13));
        piData.add(new PiData(2,"Kolkatah 80-40",73));
        piData.add(new PiData(3,"Koar - 60-40",13));
        piData.add(new PiData(4,"sanghai 70-40",19));
        piData.add(new PiData(5,"Trichi 40-46",11));
        piData.add(new PiData(6,"samon 55-40",25));
        piData.add(new PiData(7,"bisgur 55-65",12));
        piData.add(new PiData(1,"Ohio 44-12",43));
        piData.add(new PiData(2,"Tala 77-34",22));
        piData.add(new PiData(3,"Ertop 66-89",33));
        py_ch.setPiData(piData);
    }
}
package com.artix.pichart_lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PiView extends View {

    private  float textHeight;
    private  boolean mShowText = false;
    private Paint piePaint;
    private int w;
    private int h;
    private Paint textPaint;
    List<PiData> piData  = new ArrayList<>();
    public PiView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

       TypedArray a =  context.obtainStyledAttributes(attrs,R.styleable.PieChart);
        try {
            mShowText = a.getBoolean(R.styleable.PieChart_showDetails, false);
            textHeight  = a.getDimension(R.styleable.PieChart_TextSize, 25);

        } finally {
            a.recycle();
        }
        init();
    }

    public void setPiData(List<PiData> piData) {
        this.piData = piData;
        invalidate();
        requestLayout();
    }

    private void init() {







        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(getResources().getColor(R.color.white));
        ///textPaint.setTextAlign(Paint.Align.RIGHT);
        if (textHeight == 0) {
            textHeight = textPaint.getTextSize();
        } else {
            textPaint.setTextSize(textHeight);
        }

        piePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        piePaint.setStyle(Paint.Style.FILL);
        piePaint.setTextSize(textHeight);
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        piePaint.setColor(color);

    }

    private RectF calculateBounds() {
        int availableWidth  = getWidth() - getPaddingLeft() - getPaddingRight();
        int availableHeight = getHeight() - getPaddingTop() - getPaddingBottom();

        int sideLength = Math.min(availableWidth, availableHeight);

        float left = getPaddingLeft() + (availableWidth - sideLength) / 2f;
        float top = getPaddingTop() + (availableHeight - sideLength) / 2f;

        return new RectF(left, top, left + sideLength, top + sideLength);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);




       /* piData.add(new PiData(1,"1",120,getResources().getColor(R.color.red)));
        piData.add(new PiData(2,"2",120,getResources().getColor(R.color.greeen)));
        piData.add(new PiData(3,"3",120,getResources().getColor(R.color.blue)));
        piData.add(new PiData(3,"4",10,getResources().getColor(R.color.purple)));
        piData.add(new PiData(3,"4",10,getResources().getColor(R.color.purple)));
        piData.add(new PiData(3,"4",10,getResources().getColor(R.color.purple)));
        piData.add(new PiData(3,"4",10,getResources().getColor(R.color.purple)));
        piData.add(new PiData(1,"1",120,getResources().getColor(R.color.red)));
        piData.add(new PiData(2,"2",120,getResources().getColor(R.color.greeen)));
        piData.add(new PiData(3,"3",120,getResources().getColor(R.color.blue)));
        piData.add(new PiData(3,"4",10,getResources().getColor(R.color.purple)));
        piData.add(new PiData(3,"4",10,getResources().getColor(R.color.purple)));
        piData.add(new PiData(3,"4",10,getResources().getColor(R.color.purple)));
        piData.add(new PiData(3,"4",10,getResources().getColor(R.color.purple)));*/

        RectF cc = calculateBounds();

        int total  = 0;
        for (int i=0;i<piData.size();i++){
            PiData item = piData.get(i);
            total+=item.getPoint();
        }
        float previous_ang=0;
        for (int i=0;i<piData.size();i++){
            PiData item = piData.get(i);
            float toAnge = ((float)item.getPoint()/total)*360;
            //float toAnge = (float)item.getPoint();
            float current_ang = previous_ang + toAnge;
            Random rnd = new Random();

           // int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
           //item.setColor(color);
            piePaint.setColor(item.getColor());

            canvas.drawArc(cc,
                    previous_ang,
                    toAnge,
                    true, piePaint);
/*
            Path path = new Path();
            path.addArc(cc, previous_ang,
                    60);
            canvas.drawTextOnPath(item.getTitle(), path, 20, 20, textPaint);*/
            previous_ang = previous_ang+toAnge;
        }
    }

}

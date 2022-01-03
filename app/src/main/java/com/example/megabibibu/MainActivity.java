package com.example.megabibibu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends Activity {

    static ArrayList<Path> paths;
    static ArrayList<Paint> paints;
    static Paint p, ris;
    static Path path;
    static int size = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        path = new Path();
        paths = new ArrayList<>();
        paints = new ArrayList<>();
        p = new Paint();
        p.setColor(Color.BLACK);
        p.setStrokeWidth(size);
        p.setStyle(Paint.Style.STROKE);
    }

    public static class MyDraw extends View {

        public MyDraw(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);

        }
        public void inv(){
            invalidate();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            for (int i =0; i< paths.size(); i++){
                canvas.drawPath(paths.get(i), paints.get(i));

            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent motionEvent) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path = new Path();
                    ris = new Paint();
                    path.moveTo(x, y);
                    paths.add(path);
                    ris.setStyle(Paint.Style.STROKE);
                    ris.setColor(p.getColor());
                    ris.setStrokeWidth(p.getStrokeWidth());
                    paints.add(ris);
                    invalidate();
                    return true;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(x, y);
                    invalidate();
                    return true;
                default:
                    return false;
            }
        }
    }

    public void clear (View v){
        paths.clear();
        paints.clear();
    }
    public void minus(View v){
        if(size != 1){
            size--;
            p.setStrokeWidth(size);
        }
    }
    public void plus(View v){
        size++;
        p.setStrokeWidth(size);
    }
    public void black(View v){
        p.setColor(Color.BLACK);
    }
    public void white(View v){
        p.setColor(Color.WHITE);
    }
    public void red(View v){
        p.setColor(Color.RED);
    }
    public void blue(View v){
        p.setColor(Color.BLUE);
    }
    public void green(View v){
        p.setColor(Color.GREEN);
    }
    public void yellow(View v){
        p.setColor(Color.YELLOW);
    }

}
package com.example.insomnia.weather.source;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.example.insomnia.weather.R;

/**
 * Created by insomnia on 2015/11/7.
 */
public class DotImageView extends TextView {
    private Paint mPaint;
    public DotImageView(Context context,AttributeSet attrs) {
        super(context,attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(getResources().getColor(R.color.dot_not_active));

    }

    @Override
    protected void onDraw(Canvas canvas) {

        float height = getMeasuredHeight();
        float width = getMeasuredWidth();
        canvas.drawCircle(width/2,height/2,height/5,mPaint);
    }

    public void active(){
        mPaint.setColor(getResources().getColor(R.color.dot_active));
        invalidate();
    }

    public void unActive(){
        mPaint.setColor(getResources().getColor(R.color.dot_not_active));
        invalidate();
    }

}

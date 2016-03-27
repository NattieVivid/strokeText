package com.vivid.stroketext;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Администратор on 16.10.2015.
 */
public class StrokeText extends TextView {
    private int strokeColor= Color.TRANSPARENT;
    private int strokeWidth=2;
    public StrokeText(Context context)
    {
        super(context);
    }
    public StrokeText(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.StrokeText);
        strokeColor=a.getColor(R.styleable.StrokeText_textStrokeColor, strokeColor);
        strokeWidth=a.getDimensionPixelSize(R.styleable.StrokeText_textStrokeWidth, strokeWidth);
        a.recycle();
    }

    public void setStrokeColor(int color){
        strokeColor = color;
    }

    public void setStrokeWidth(int wi){
        strokeWidth = wi;
        setPadding(wi, wi, wi, wi);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        final ColorStateList textColor = getTextColors();

        TextPaint paint = this.getPaint();

        paint.setStyle(Style.STROKE);
        paint.setStrokeJoin(Join.ROUND);
        paint.setStrokeMiter(10);
        this.setTextColor(strokeColor);
        paint.setStrokeWidth(strokeWidth);

        super.onDraw(canvas);
        paint.setStyle(Style.FILL);

        setTextColor(textColor);
        super.onDraw(canvas);
    }
}

package com.liger.grace.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Liger on 2016/3/11 18:52.
 */

public class CustomView extends View {

    private Paint mPaint;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int widthMeasureSpec) { //widthMeasureSpec 32位,高2位为测量模式,低30位为给定的大小
        int result = 0;//测量的结果
        int specMode = MeasureSpec.getMode(widthMeasureSpec);//获得的测量模式
        int specSize = MeasureSpec.getSize(widthMeasureSpec);//获得的测量大小
        switch (specMode) {
            case MeasureSpec.EXACTLY:       //exactly(match_parent)模式时,使用给定的大小
                result = specSize;
                break;
            case MeasureSpec.AT_MOST:       //其他模式时,需指定一个默认大小 200px
                result = 200;
                result = Math.min(result, specSize);// 最大值模式(wrap_content),取默认大小与测量大小的最小值
                break;
            case MeasureSpec.UNSPECIFIED:
                result = 200;
                break;
        }
        return result;
    }

    private int measureHeight(int heightMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (specMode) {
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
            case MeasureSpec.AT_MOST:
                result = 200;
                result = Math.min(result, specSize);
                break;
            case MeasureSpec.UNSPECIFIED:
                result = 200;
                break;
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        super.onDraw(canvas);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
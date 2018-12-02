package com.bw.qgs.qgs2.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * date:2018/12/2    11:18
 * author:秦广帅(Lenovo)
 * fileName:StraightLine
 */
public class StraightLine extends View {

    private Paint paint;

    public StraightLine(Context context) {
        this(context,null);
    }

    public StraightLine(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public StraightLine(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(300,850,100,paint);
    }
}

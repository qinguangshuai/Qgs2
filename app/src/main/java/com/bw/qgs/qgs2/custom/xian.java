package com.bw.qgs.qgs2.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * date:2018/12/2    11:49
 * author:秦广帅(Lenovo)
 * fileName:xian
 */
public class xian extends View {

    private Paint paint;

    public xian(Context context) {
        this(context,null);
    }

    public xian(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public xian(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(10,100,100,100,paint);
    }
}

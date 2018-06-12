package com.example.wtl.ttms_hdd.SeatToBuy.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 绘制座位图
 * Created by WTL on 2018/6/11.
 */

public class SeatView extends View {

    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 可选的座位图片
     */
    private Bitmap optionalSeat;
    /**
     * 选中的座位图片
     */
    private Bitmap selectSeat;
    /**
     * 已售的座位图片
     */
    private Bitmap soldSeat;
    /**
    * 整个座位图的宽度
    * */
    private int seatBitmapWidth;
    /**
    * 整个座位图的高度
    * */
    private int seatBitmapHeight;

    public SeatView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SeatView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

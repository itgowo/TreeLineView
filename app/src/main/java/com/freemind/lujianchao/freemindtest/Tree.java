package com.freemind.lujianchao.freemindtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lu JianChao on 2016/8/10.
 */
public class Tree extends View {
    private List<TreeBean> mTrees = new ArrayList<>();
    private int lineheight;
    private Canvas mCanvas;
    private OnTreeViewClickListener mOnTreeViewClickListener;

    public Tree(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OnTreeViewClickListener getOnTreeViewClickListener() {
        return mOnTreeViewClickListener;
    }

    public void setOnTreeViewClickListener(OnTreeViewClickListener mOnTreeViewClickListener) {
        this.mOnTreeViewClickListener = mOnTreeViewClickListener;
    }

    public List<TreeBean> getTrees() {
        return mTrees;
    }

    public void setTrees(List<TreeBean> mTrees) {
        this.mTrees = mTrees;
       invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCanvas = canvas;
        Paint mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(4);
        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        lineheight = mBitmap.getHeight() + 120;


        /**
         * 循环遍历
         */
        for (int i = 0; i < mTrees.size(); i++) {
            TreeBean mTreeBean = mTrees.get(i);

            /**
             * 判断是否是根节点
             */
            if (TextUtils.isEmpty(mTreeBean.getRootid())) {
                mTreeBean.setY(0 * i + 100);
                mTreeBean.setX(getWidth() / 2 - mBitmap.getWidth() / 2);
            } else {
                mTreeBean.setX((float) (getWidth() / 2 - mBitmap.getWidth() * (i - 1.5)));
                mTreeBean.setY(lineheight * mTreeBean.getLine() + 100);
                canvas.drawLine(mTreeBean.getX() + mBitmap.getWidth() / 2, mTreeBean.getY(), mTreeBean.getX() + mBitmap.getWidth() / 2, +mTreeBean.getY() - 50, mPaint);
                if (mTreeBean.getCount() > 1) {
                    if (mTreeBean.getIndex() == 0) {
                        canvas.drawLine(mTreeBean.getX() + mBitmap.getWidth() / 2, mTreeBean.getY() - 50, mTreeBean.getX(), mTreeBean.getY() - 50, mPaint);

                    } else if (mTreeBean.getIndex() == mTreeBean.getCount() - 1) {
                        canvas.drawLine(mTreeBean.getX() + mBitmap.getWidth() / 2, mTreeBean.getY() - 50, mTreeBean.getX() + mBitmap.getWidth(), mTreeBean.getY() - 50, mPaint);

                    } else {
                        canvas.drawLine(mTreeBean.getX() + mBitmap.getWidth() / 2, mTreeBean.getY() - 50, mTreeBean.getX() + mBitmap.getWidth(), mTreeBean.getY() - 50, mPaint);
                        canvas.drawLine(mTreeBean.getX() + mBitmap.getWidth() / 2, +mTreeBean.getY() - 50, mTreeBean.getX(), mTreeBean.getY() - 50, mPaint);

                    }
                }
            }
            Rect mrect = new Rect((int) mTreeBean.getX(), (int) (mTreeBean.getY()), (int) (mTreeBean.getX() + mBitmap.getWidth()), (int) (mTreeBean.getY() + mBitmap.getHeight() + 80));
            mTreeBean.setRect(mrect);

            canvas.drawBitmap(mBitmap, mTreeBean.getX(), mTreeBean.getY(), null);
            canvas.drawText(mTreeBean.getTag1(), mTreeBean.getX() + (mBitmap.getWidth() - mPaint.measureText(mTreeBean.getTag1())) / 2, mTreeBean.getY() + mBitmap.getHeight() + 20, mPaint);
            canvas.drawText(mTreeBean.getTag2(), mTreeBean.getX() + (mBitmap.getWidth() - mPaint.measureText(mTreeBean.getTag2())) / 2, mTreeBean.getY() + mBitmap.getHeight() + 40, mPaint);
            canvas.drawText(mTreeBean.getTag3(), mTreeBean.getX() + (mBitmap.getWidth() - mPaint.measureText(mTreeBean.getTag3())) / 2, mTreeBean.getY() + mBitmap.getHeight() + 60, mPaint);


        }

    }

    long time = 0;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN  ) {
            time = System.currentTimeMillis();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_UP  ) {
            for (int i = 0; i < mTrees.size(); i++) {
                if (mTrees.get(i).getRect().contains((int) event.getX(), (int) event.getY())&&mOnTreeViewClickListener!=null) {
                    if (System.currentTimeMillis() - time > 400) {
                        mOnTreeViewClickListener.onLongClickListener(mTrees.get(i));
                    }else {
                        mOnTreeViewClickListener.onClickListener(mTrees.get(i));
                    }
                    time=0;
                    return true;
                }
            }

        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = widthMeasureSpec;
        int height = heightMeasureSpec;
        if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.AT_MOST) {
            width = 190 + MeasureSpec.AT_MOST;
        }
        if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.AT_MOST) {
            height = 190 + MeasureSpec.AT_MOST;
        }
        super.onMeasure(width, height);
    }

    public interface OnTreeViewClickListener {
        public void onClickListener(TreeBean mTreeBean);

        public void onLongClickListener(TreeBean mTreeBean);
    }
}

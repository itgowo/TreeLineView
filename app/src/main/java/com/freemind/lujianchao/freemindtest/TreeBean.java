package com.freemind.lujianchao.freemindtest;

import android.graphics.Rect;

/**
 * Created by Lu JianChao on 2016/8/10.
 */
public class TreeBean {
    private String id;
    private int index,line,count;
    private String rootid;
    private String data;
    private String tag1,tag2,tag3,tag4;
    private float x,y;
private Rect mRect;
    public int getIndex() {
        return index;
    }

    public void setIndex(int mIndex) {
        index = mIndex;
    }

    public float getX() {
        return x;

    }

    public Rect getRect() {
        return mRect;
    }

    public void setRect(Rect mRect) {
        this.mRect = mRect;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int mCount) {
        count = mCount;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int mLine) {
        line = mLine;
    }

    public TreeBean(String mId, int mIndex, int mLine, int mCount, String mRootid, String mData, String mTag1, String mTag2, String mTag3, String mTag4) {
        id = mId;
        index = mIndex;
        line = mLine;
        count = mCount;
        rootid = mRootid;
        data = mData;
        tag1 = mTag1;
        tag2 = mTag2;
        tag3 = mTag3;
        tag4 = mTag4;
    }

    public void setX(float mX) {
        x = mX;
    }

    public float getY() {
        return y;
    }

    public void setY(float mY) {
        y = mY;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String mTag1) {
        tag1 = mTag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String mTag2) {
        tag2 = mTag2;
    }

    public String getTag3() {
        return tag3;
    }

    public void setTag3(String mTag3) {
        tag3 = mTag3;
    }

    public String getTag4() {
        return tag4;
    }

    public void setTag4(String mTag4) {
        tag4 = mTag4;
    }

    public String getId() {
        return id;
    }

    public void setId(String mId) {
        id = mId;
    }

    public String getRootid() {
        return rootid;
    }

    public void setRootid(String mRootid) {
        rootid = mRootid;
    }

    public String getData() {
        return data;
    }

    public void setData(String mData) {
        data = mData;
    }

    @Override
    public String toString() {
        return "TreeBean{" +
                "id='" + id + '\'' +
                ", index=" + index +
                ", line=" + line +
                ", count=" + count +
                ", rootid='" + rootid + '\'' +
                ", data='" + data + '\'' +
                ", tag1='" + tag1 + '\'' +
                ", tag2='" + tag2 + '\'' +
                ", tag3='" + tag3 + '\'' +
                ", tag4='" + tag4 + '\'' +
                '}';
    }
}

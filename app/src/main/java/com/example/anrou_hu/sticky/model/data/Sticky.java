package com.example.anrou_hu.sticky.model.data;

import com.example.anrou_hu.sticky.model.data_type.StickyType;

/**
 * @author anrou_hu
 */

public abstract class Sticky {

    StickyType mType;
    String mTitle;
    String mContent;
    long mTime;


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }


    public StickyType getType() {
        return mType;
    }

    public void setType(StickyType type) {
        mType = type;
    }

}

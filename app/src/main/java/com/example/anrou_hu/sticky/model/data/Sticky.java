package com.example.anrou_hu.sticky.model.data;

import android.os.Parcelable;

import com.example.anrou_hu.sticky.model.data_type.StickyStatus;
import com.example.anrou_hu.sticky.model.data_type.StickyType;

import java.io.Serializable;

/**
 * @author anrou_hu
 */

public abstract class Sticky implements Serializable {

    private StickyType mType;
    private StickyStatus mStatus;
    private String mTitle;
    private long mTime;



    public StickyType getType() {
        return mType;
    }

    public void setType(StickyType type) {
        mType = type;
    }


    public StickyStatus getStatus() {
        return mStatus;
    }

    public void setStatus(StickyStatus status) {
        mStatus = status;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

}

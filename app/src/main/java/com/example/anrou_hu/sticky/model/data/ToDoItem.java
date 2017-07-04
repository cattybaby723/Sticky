package com.example.anrou_hu.sticky.model.data;

import com.example.anrou_hu.sticky.model.data_type.StickyStatus;

/**
 * @author anrou_hu
 */

public class ToDoItem {

    private StickyStatus mStatus;
    private String mDescription;

    public ToDoItem(){
        mStatus = StickyStatus.ACTIVATE;
    }

    public StickyStatus getStatus() {
        return mStatus;
    }

    public void setStatus(StickyStatus status) {
        mStatus = status;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}

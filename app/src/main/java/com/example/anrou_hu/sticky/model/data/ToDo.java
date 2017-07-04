package com.example.anrou_hu.sticky.model.data;


import com.example.anrou_hu.sticky.model.data_type.StickyStatus;
import com.example.anrou_hu.sticky.model.data_type.StickyType;

import java.util.ArrayList;

/**
 * @author anrou_hu
 */

public class ToDo extends Sticky {


    private ArrayList<ToDoItem> mToDoItemList = new ArrayList<>();

    public ToDo() {
        this.setType(StickyType.TO_DO);
        this.setStatus(StickyStatus.ACTIVATE);
    }

    public ArrayList<ToDoItem> getToDoItemList() {
        return mToDoItemList;
    }

    public void setToDoItemList(ArrayList<ToDoItem> toDoItemList) {
        mToDoItemList = toDoItemList;
    }
}

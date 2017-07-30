package com.example.anrou_hu.sticky.presenters;

import com.example.anrou_hu.sticky.contract.AddToDoContract;
import com.example.anrou_hu.sticky.model.data.ToDo;
import com.example.anrou_hu.sticky.model.data.ToDoItem;

import java.util.List;

/**
 * @author anrou_hu
 */

public class AddTodoPresenter implements AddToDoContract.Presenter {

    private AddToDoContract.View mAddToDoView;
    private List<ToDoItem> mToDoItems;

    public AddTodoPresenter(AddToDoContract.View addToDoView) {
        mAddToDoView = addToDoView;
        mAddToDoView.setPresenter(this);
    }


    @Override
    public void start() {

    }

    @Override
    public void writeIntoDb(ToDo note) {

    }

    @Override
    public ToDoItem getToDoItem(int position) {
        if (mToDoItems.size() < position) return null;
        return mToDoItems.get(position);
    }

    @Override
    public List<ToDoItem> getToDoItems() {
        return mToDoItems;
    }

    @Override
    public int getToDoItemsCount() {
        return mToDoItems.size();
    }


}

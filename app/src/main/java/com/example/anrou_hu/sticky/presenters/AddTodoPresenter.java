package com.example.anrou_hu.sticky.presenters;

import com.example.anrou_hu.sticky.AddToDoContract;
import com.example.anrou_hu.sticky.model.data.ToDo;

/**
 * @author anrou_hu
 */

public class AddTodoPresenter implements AddToDoContract.Presenter {

    private AddToDoContract.View mAddToDoView;


    public AddTodoPresenter (AddToDoContract.View addToDoView){
        mAddToDoView = addToDoView;
        mAddToDoView.setPresenter(this);
    }


    @Override
    public void start() {

    }

    @Override
    public void writeIntoDb(ToDo note) {

    }
}

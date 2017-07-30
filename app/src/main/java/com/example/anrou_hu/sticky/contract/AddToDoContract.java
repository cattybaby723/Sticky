package com.example.anrou_hu.sticky.contract;

import com.example.anrou_hu.sticky.model.data.ToDo;
import com.example.anrou_hu.sticky.model.data.ToDoItem;
import com.example.anrou_hu.sticky.presenters.BasePresenter;
import com.example.anrou_hu.sticky.views.BaseView;

import java.util.List;

/**
 * @author anrou_hu
 */

public interface AddToDoContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

        void writeIntoDb(ToDo note);

        ToDoItem getToDoItem(int position);

        List<ToDoItem> getToDoItems();

        int getToDoItemsCount();
    }

}

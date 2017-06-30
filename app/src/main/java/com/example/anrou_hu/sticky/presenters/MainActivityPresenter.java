package com.example.anrou_hu.sticky.presenters;

import android.support.annotation.NonNull;

import com.example.anrou_hu.sticky.MainContract;
import com.example.anrou_hu.sticky.model.data.Note;
import com.example.anrou_hu.sticky.model.data.Sticky;
import com.example.anrou_hu.sticky.model.data.ToDo;
import com.example.anrou_hu.sticky.utils.Preconditions;

import java.util.ArrayList;

/**
 * @author anrou_hu
 */

public class MainActivityPresenter implements MainContract.Presenter {

    private final MainContract.View mMainView;

    private ArrayList<Sticky> stickyList = new ArrayList<>();

    public MainActivityPresenter(@NonNull MainContract.View mainView) {
        mMainView = Preconditions.checkNotNull(mainView);
        mMainView.setPresenter(this);
        buildFakeList();
    }

    private void buildFakeList() {
        Sticky n1 = new Note();
        n1.setTitle("note 123");

        Sticky t1 = new ToDo();
        t1.setTitle("todo 123");

        stickyList.add(n1);
        stickyList.add(t1);
    }


    @Override
    public void start() {

    }


    @Override
    public void addSticky(Sticky sticky) {

    }

    @Override
    public ArrayList<Sticky> getStickList() {
        return stickyList;
    }
}

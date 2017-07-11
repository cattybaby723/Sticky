package com.example.anrou_hu.sticky.presenters;

import android.support.annotation.NonNull;

import com.example.anrou_hu.sticky.MainContract;
import com.example.anrou_hu.sticky.model.data.Sticky;
import com.example.anrou_hu.sticky.utils.Preconditions;

import java.util.ArrayList;

/**
 * @author anrou_hu
 */

public class MainActivityPresenter implements MainContract.Presenter {

    private final MainContract.View mMainView;

    private ArrayList<Sticky> mStickyList = new ArrayList<>();

    public MainActivityPresenter(@NonNull MainContract.View mainView) {
        mMainView = Preconditions.checkNotNull(mainView);
        mMainView.setPresenter(this);
    }



    @Override
    public void start() {

    }


    @Override
    public void addSticky(Sticky sticky) {
        if(sticky == null)return;
        mStickyList.add(sticky);
        mMainView.listIsModified();
    }

    @Override
    public ArrayList<Sticky> getStickList() {
        return mStickyList;
    }
}

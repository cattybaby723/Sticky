package com.example.anrou_hu.sticky.presenters;

import android.support.annotation.NonNull;

import com.example.anrou_hu.sticky.AddNoteContract;

/**
 * @author anrou_hu
 */

public class AddNotePresenter implements AddNoteContract.Presenter {


    private AddNoteContract.View mAddNoteView;


    public AddNotePresenter(@NonNull AddNoteContract.View addNoteView){
        mAddNoteView = addNoteView;
        mAddNoteView.setPresenter(this);
    }

    @Override
    public void start() {

    }


}

package com.example.anrou_hu.sticky.views;

import android.support.v7.app.AppCompatActivity;

import com.example.anrou_hu.sticky.AddToDoContract;
import com.example.anrou_hu.sticky.utils.Preconditions;

/**
 * @author anrou_hu
 */

public class AddToDoActivity extends AppCompatActivity implements AddToDoContract.View {

    private AddToDoContract.Presenter mPresenter;





    @Override
    public void setPresenter(AddToDoContract.Presenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
    }
}



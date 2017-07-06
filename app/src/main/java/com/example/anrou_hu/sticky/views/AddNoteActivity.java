package com.example.anrou_hu.sticky.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.anrou_hu.sticky.AddNoteContract;
import com.example.anrou_hu.sticky.R;
import com.example.anrou_hu.sticky.presenters.AddNotePresenter;
import com.example.anrou_hu.sticky.utils.Preconditions;
import com.example.anrou_hu.sticky.utils.RequestCode;

/**
 * @author anrou_hu
 */

public class AddNoteActivity extends AppCompatActivity implements AddNoteContract.View {

    private AddNoteContract.Presenter mPresenter;

    private Toolbar mToolbar;
    private EditText mTitle;
    private EditText mDescription;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        createPresenter();
        initViews();
    }


    private void createPresenter() {
        mPresenter = new AddNotePresenter(this);
    }


    private void initViews() {
        mTitle = (EditText) findViewById(R.id.title);
        mDescription = (EditText) findViewById(R.id.description);

        setupToolBar();
    }

    private void setupToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.new_note);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_sticky_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_complete:

                break;
        }

        return true;
    }

    @Override
    public void setPresenter(AddNoteContract.Presenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
    }


    public static void startForResult(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, AddNoteActivity.class);
        ((Activity) context).startActivityForResult(intent, RequestCode.ADD_NOTE);
    }


}

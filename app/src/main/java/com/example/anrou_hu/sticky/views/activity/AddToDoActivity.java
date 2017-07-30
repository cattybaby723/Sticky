package com.example.anrou_hu.sticky.views.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.anrou_hu.sticky.contract.AddToDoContract;
import com.example.anrou_hu.sticky.R;
import com.example.anrou_hu.sticky.utils.Preconditions;
import com.example.anrou_hu.sticky.utils.RequestCode;

/**
 * @author anrou_hu
 */

public class AddToDoActivity extends AppCompatActivity implements AddToDoContract.View {

    private AddToDoContract.Presenter mPresenter;

    private Toolbar mToolbar;
    private EditText mTitle;
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do_list);
        initViews();
    }

    private void initViews() {
        mTitle = (EditText) findViewById(R.id.title);

        setupToolBar();
        setupAddItemRecyclerView();
    }



    private void setupToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(R.string.new_to_do);
    }

    private void setupAddItemRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    @Override
    public void setPresenter(AddToDoContract.Presenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_sticky_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_complete:
                finish();
                break;

            case android.R.id.home:
                finish();
                break;
        }

        return true;
    }

    public static void startForResult(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, AddToDoActivity.class);
        ((Activity) context).startActivityForResult(intent, RequestCode.ADD_TO_DO);
    }
}



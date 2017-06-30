package com.example.anrou_hu.sticky.views;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.anrou_hu.sticky.MainContract;
import com.example.anrou_hu.sticky.R;
import com.example.anrou_hu.sticky.model.data.Sticky;
import com.example.anrou_hu.sticky.presenters.MainActivityPresenter;
import com.example.anrou_hu.sticky.utils.Preconditions;

public class MainActivity extends AppCompatActivity implements MainContract.View, IClickCallBack {

    private MainContract.Presenter mPresenter;
    private MainAdapter mAdapter;

    private Toolbar mToolbar;
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createPresenter();
        initViews();
    }

    private void createPresenter() {
        new MainActivityPresenter(this);
    }

    private void initViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new MainAdapter(mPresenter, this);
        initRecyclerView();

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void initRecyclerView() {
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider));
        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }


    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }


    @Override
    public void onNotifyItemClick(@IdRes int viewId, int position) {
        Sticky sticky = mPresenter.getStickList().get(position);

        switch (viewId) {
            case R.id.container:
                Toast.makeText(this, "Click container :" + sticky.getTitle(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.checkBox:
                Toast.makeText(this, "Click checkBox", Toast.LENGTH_SHORT).show();
                break;

            case R.id.expandBtn:
                Toast.makeText(this, "Click expandBtn", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

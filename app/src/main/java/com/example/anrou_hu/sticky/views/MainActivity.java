package com.example.anrou_hu.sticky.views;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.anrou_hu.sticky.MainContract;
import com.example.anrou_hu.sticky.R;
import com.example.anrou_hu.sticky.model.data.Sticky;
import com.example.anrou_hu.sticky.presenters.MainActivityPresenter;
import com.example.anrou_hu.sticky.utils.Preconditions;

public class MainActivity extends AppCompatActivity implements MainContract.View, PopupMenu.OnMenuItemClickListener, IClickCallBack {

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
        setupRecyclerView();
        setupToolBar();
    }

    private void setupRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new MainAdapter(mPresenter, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider));
        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }


    private void setupToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                showAddPopUpMenu();
                break;

            case R.id.menu_filter:
                break;
        }
        return true;
    }


    private void showAddPopUpMenu() {
        PopupMenu popup = new PopupMenu(this, findViewById(R.id.menu_add));
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.add_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(this);
        popup.show();
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add_note:
                startAddNote();
                break;

            case R.id.menu_add_to_do:
                startAddToDoList();
                break;
        }
        return true;
    }


    private void startAddNote() {
        AddNoteActivity.startForResult(this);
        Toast.makeText(this, "Click add note", Toast.LENGTH_SHORT).show();
    }


    private void startAddToDoList() {
        Toast.makeText(this, "Click add to-do list", Toast.LENGTH_SHORT).show();
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


    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }
}

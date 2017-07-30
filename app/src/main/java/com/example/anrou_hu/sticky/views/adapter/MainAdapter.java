package com.example.anrou_hu.sticky.views.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anrou_hu.sticky.contract.MainContract;
import com.example.anrou_hu.sticky.R;
import com.example.anrou_hu.sticky.model.data.Note;
import com.example.anrou_hu.sticky.model.data.Sticky;
import com.example.anrou_hu.sticky.model.data.ToDo;
import com.example.anrou_hu.sticky.model.data_type.StickyType;
import com.example.anrou_hu.sticky.views.IClickCallBack;
import com.example.anrou_hu.sticky.views.view_holder.NoteViewHolder;
import com.example.anrou_hu.sticky.views.view_holder.ToDoViewHolder;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * @author anrou_hu
 */

public class MainAdapter extends RecyclerView.Adapter {

    private WeakReference<MainContract.Presenter> mWeakPresenter;

    private IClickCallBack mIClickCallBack;


    public MainAdapter(MainContract.Presenter presenter, IClickCallBack iClickCallBack) {
        mWeakPresenter = new WeakReference<>(presenter);
        mIClickCallBack = iClickCallBack;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        switch (StickyType.values()[viewType]) {
            case NOTE:
                view = inflater.inflate(R.layout.list_item_note, parent, false);
                return new NoteViewHolder(view, mIClickCallBack);

            case TO_DO:
                view = inflater.inflate(R.layout.list_item_to_do, parent, false);
                return new ToDoViewHolder(view, mIClickCallBack);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MainContract.Presenter presenter = mWeakPresenter.get();
        if (presenter == null) return;

        Object data = presenter.getStickList().get(position);
        switch (StickyType.values()[getItemViewType(position)]) {
            case NOTE:
                ((NoteViewHolder) holder).bindViews((Note) data);
                break;

            case TO_DO:
                ((ToDoViewHolder) holder).bindViews((ToDo) data);
                break;
        }
    }


    @Override
    public int getItemViewType(int position) {
        MainContract.Presenter presenter = mWeakPresenter.get();
        if (presenter != null) {
            ArrayList<Sticky> stickyList = presenter.getStickList();
            if (position < stickyList.size()) {
                StickyType type = stickyList.get(position).getType();
                return type.ordinal();
            }
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        MainContract.Presenter presenter = mWeakPresenter.get();
        if (presenter != null) {
            return presenter.getStickList().size();
        }
        return 0;
    }
}

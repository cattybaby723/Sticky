package com.example.anrou_hu.sticky.views.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anrou_hu.sticky.R;
import com.example.anrou_hu.sticky.contract.AddToDoContract;
import com.example.anrou_hu.sticky.model.data.ToDoItem;
import com.example.anrou_hu.sticky.views.view_holder.AddToDoItemViewHolder;

import java.lang.ref.WeakReference;

/**
 * @author anrou_hu
 */

public class AddToDoItemAdapter extends RecyclerView.Adapter {

    private WeakReference<AddToDoContract.Presenter> mWeakPresenter;

    public AddToDoItemAdapter(AddToDoContract.Presenter mPresenter) {
        mWeakPresenter = new WeakReference<>(mPresenter);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_add_to_do_item, parent, false);
        return new AddToDoItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AddToDoContract.Presenter presenter = mWeakPresenter.get();
        if (presenter == null) return;

        ToDoItem toDoItem = presenter.getToDoItem(position);
        ((AddToDoItemViewHolder) holder).bindViews(toDoItem);
    }

    @Override
    public int getItemCount() {
        AddToDoContract.Presenter presenter = mWeakPresenter.get();
        return (presenter == null) ? 0 : presenter.getToDoItemsCount();
    }
}

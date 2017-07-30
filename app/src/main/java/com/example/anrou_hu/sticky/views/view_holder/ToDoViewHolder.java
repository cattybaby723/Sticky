package com.example.anrou_hu.sticky.views.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.anrou_hu.sticky.R;
import com.example.anrou_hu.sticky.model.data.ToDo;
import com.example.anrou_hu.sticky.views.IClickCallBack;

/**
 * @author anrou_hu
 */

public class ToDoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private IClickCallBack mClickCallBack;

    private ViewGroup mContainer;
    private ImageButton mCheckBox;
    private ImageButton mExpandBtn;
    private TextView mTitle;


    public ToDoViewHolder(View itemView, IClickCallBack clickCallBack) {
        super(itemView);

        mClickCallBack = clickCallBack;
        initViews();
    }

    private void initViews() {
        mContainer = (ViewGroup) itemView.findViewById(R.id.container);
        mCheckBox = (ImageButton) itemView.findViewById(R.id.checkBox);
        mExpandBtn = (ImageButton) itemView.findViewById(R.id.expandBtn);
        mTitle = (TextView) itemView.findViewById(R.id.title);

        mContainer.setOnClickListener(this);
        mCheckBox.setOnClickListener(this);
        mExpandBtn.setOnClickListener(this);
    }

    public void bindViews(ToDo toDo) {
        mTitle.setText(toDo.getTitle());
    }


    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        switch (v.getId()) {
            case R.id.container:
                mClickCallBack.onNotifyItemClick(R.id.container, position);
                break;

            case R.id.checkBox:
                toggleCheckBtn();
                mClickCallBack.onNotifyItemClick(R.id.checkBox, position);
                break;

            case R.id.expandBtn:
                mClickCallBack.onNotifyItemClick(R.id.expandBtn, position);
                break;
        }
    }

    private void toggleCheckBtn() {
        boolean wasSelected = mCheckBox.isSelected();
        mCheckBox.setSelected(!wasSelected);
    }
}

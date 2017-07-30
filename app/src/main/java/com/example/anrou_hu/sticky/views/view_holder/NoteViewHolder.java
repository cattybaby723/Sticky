package com.example.anrou_hu.sticky.views.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.anrou_hu.sticky.R;
import com.example.anrou_hu.sticky.model.data.Note;
import com.example.anrou_hu.sticky.views.IClickCallBack;

/**
 * @author anrou_hu
 */

public class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private IClickCallBack mIClickCallBack;

    private ViewGroup mContainer;
    private ImageButton mCheckBox;
    private TextView mTitle;


    public NoteViewHolder(View itemView, IClickCallBack iClickCallBack) {
        super(itemView);

        mIClickCallBack = iClickCallBack;
        initView(itemView);
    }


    private void initView(View itemView) {
        mContainer = (ViewGroup) itemView.findViewById(R.id.container);
        mCheckBox = (ImageButton) itemView.findViewById(R.id.checkbox);
        mTitle = (TextView) itemView.findViewById(R.id.title);

        mContainer.setOnClickListener(this);
        mCheckBox.setOnClickListener(this);
    }

    public void bindViews(Note note) {
        String title = note.getTitle().isEmpty() ? note.getDescription() : note.getTitle();
        mTitle.setText(title);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        switch (v.getId()) {
            case R.id.container:
                mIClickCallBack.onNotifyItemClick(R.id.container, position);
                break;

            case R.id.checkbox:
                toggleCheckBtn();
                mIClickCallBack.onNotifyItemClick(R.id.checkBox, position);
                break;
        }
    }


    private void toggleCheckBtn() {
        boolean wasSelected = mCheckBox.isSelected();
        mCheckBox.setSelected(!wasSelected);
    }
}

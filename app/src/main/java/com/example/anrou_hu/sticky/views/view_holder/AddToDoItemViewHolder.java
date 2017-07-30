package com.example.anrou_hu.sticky.views.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.anrou_hu.sticky.R;
import com.example.anrou_hu.sticky.model.data.ToDoItem;

/**
 * @author anrou_hu
 */

public class AddToDoItemViewHolder extends RecyclerView.ViewHolder {

    private ImageView mBulletPoint;
    private EditText mDescription;


    public AddToDoItemViewHolder(View itemView) {
        super(itemView);
        initViews();
    }

    private void initViews() {
        mBulletPoint = (ImageView) itemView.findViewById(R.id.bulletPoint);
        mDescription = (EditText) itemView.findViewById(R.id.description);
    }


    public void bindViews(ToDoItem toDoItem) {
        String description = toDoItem.getDescription();
        mDescription.setText(description);
    }
}

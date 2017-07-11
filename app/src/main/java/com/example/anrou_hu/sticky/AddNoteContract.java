package com.example.anrou_hu.sticky;

import com.example.anrou_hu.sticky.model.data.Note;
import com.example.anrou_hu.sticky.presenters.BasePresenter;
import com.example.anrou_hu.sticky.views.BaseView;

/**
 * @author anrou_hu
 */

public interface AddNoteContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

        void writeIntoDb(Note note);
    }
}

package com.example.machinery.activity.editor;

public interface MachineryView {

    void showProgress();
    void hideProgress();
    void onRequestSuccess(String message);
    void onRequestError(String message);

}

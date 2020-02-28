package com.example.machinery.activity.main;

import com.example.machinery.model.Department;

import java.util.List;

public interface MainView {
    void showLoading();
    void hideLoading();
    void onGetResult(List<Department> departments);
    void onErrorLoading(String message);
}

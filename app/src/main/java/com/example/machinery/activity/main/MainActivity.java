package com.example.machinery.activity.main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.machinery.helper.Utils;
import com.example.machinery.model.Department;
import com.example.retrofit.R;
import com.example.machinery.activity.editor.MachineryActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    private static final int INTENT_EDIT = 200;
    private static final int INTENT_ADD = 100;
    FloatingActionButton fab;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

    MainPresenter mainPresenter;
    MainAdapter mainAdapter;
    MainAdapter.ItemClickListener itemClickListener;
    List<Department> departmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        initView();

        fab.setOnClickListener(
                view -> startActivityForResult(new Intent( this, MachineryActivity.class ), INTENT_ADD));

        mainPresenter.getData();

        swipeRefreshLayout.setOnRefreshListener(
                () -> mainPresenter.getData()
        );

        itemClickListener = ((view, position) -> {
            String department_code = departmentList.get( position ).getDepartment_code();
            Intent intent = new Intent( this, MachineryActivity.class );
            intent.putExtra( "department_code", department_code );
            startActivityForResult( intent, INTENT_EDIT );
        });
    }

    private void initView() {
        setContentView( R.layout.activity_main );

        fab = findViewById( R.id.add );
        swipeRefreshLayout = findViewById( R.id.swipe_refresh );
        recyclerView = findViewById( R.id.recycler_view );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );

        mainPresenter = new MainPresenter( this );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

        if (requestCode == INTENT_ADD && resultCode == RESULT_OK) {
            mainPresenter.getData(); //reload data
        }
        else if (requestCode == INTENT_EDIT && resultCode == RESULT_OK) {
            mainPresenter.getData(); //reload data
        }
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setRefreshing( true );
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.setRefreshing( false );
    }

    @Override
    public void onGetResult(List<Department> departments) {
        mainAdapter = new MainAdapter( this, departments, itemClickListener );
        mainAdapter.notifyDataSetChanged();
        recyclerView.setAdapter( mainAdapter );

        departmentList = departments;
    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public boolean getNetworkAvailability() {
        return Utils.isNetworkAvailable(getApplicationContext());
    }
}

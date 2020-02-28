package com.example.machinery.activity.editor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.machinery.api.ApiInterface;
import com.example.retrofit.R;
import com.thebluealliance.spectrum.SpectrumPalette;

public class MachineryActivity extends AppCompatActivity implements MachineryView {

    EditText et_department_code;
    ProgressDialog progressDialog;
//    SpectrumPalette palette;

    ApiInterface apiInterface;

    MachineryPresenter presenter;

//    int color, id;
    String department_code;

    Menu actionMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_editor );

        et_department_code = findViewById(R.id.title);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        palette = findViewById( R.id.palette );

//        palette.setOnColorSelectedListener(
//                clr -> color = clr
//        );

        //Progress Dialog
        progressDialog = new ProgressDialog( this );
        progressDialog.setMessage("Please wait...");

        presenter = new MachineryPresenter( this );

        Intent intent = getIntent();
        department_code = intent.getStringExtra( "department_code" );

        setDataFromIntentExtra();
    }

    private void setDataFromIntentExtra() {
        et_department_code.setText( department_code );
        getSupportActionBar().setTitle("Danh sách phòng ban");
        readMode();
//        if (id != 0) {
//            et_department_code.setText( department_code );
//            getSupportActionBar().setTitle( "Update Note" );
//            readMode();
//        } else {
//            //Default Color Setup
//            palette.setSelectedColor( getResources().getColor( R.color.white ) );
//            color = getResources().getColor( R.color.white );
//            editMode();
//        }
    }

    private void editMode() {
        et_department_code.setFocusableInTouchMode( true );
//        palette.setEnabled( true );
    }

    private void readMode() {
        et_department_code.setFocusableInTouchMode( false );
//        palette.setEnabled( false );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_editor, menu );
        actionMenu = menu;

        actionMenu.findItem( R.id.edit ).setVisible( false );
        actionMenu.findItem( R.id.delete ).setVisible( false );
        actionMenu.findItem( R.id.save ).setVisible( false );
        actionMenu.findItem( R.id.update ).setVisible( false );

//        if (id != 0) {
//            actionMenu.findItem( R.id.edit ).setVisible( true );
//            actionMenu.findItem( R.id.delete ).setVisible( true );
//            actionMenu.findItem( R.id.save ).setVisible( false );
//            actionMenu.findItem( R.id.update ).setVisible( false );
//        } else {
//            actionMenu.findItem( R.id.edit ).setVisible( false );
//            actionMenu.findItem( R.id.delete ).setVisible( false );
//            actionMenu.findItem( R.id.save ).setVisible( true );
//            actionMenu.findItem( R.id.update ).setVisible( false );
//        }

        return super.onCreateOptionsMenu( menu );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String department_code = et_department_code.getText().toString().trim();
//        int color = this.color;

        switch (item.getItemId()) {
            case R.id.save:
//                //Save
//                if (department_code.isEmpty()) {
//                    et_department_code.setError( "Please enter a department code" );
//                } else {
//                    presenter.saveNote( title, note, color );
//                }
                return true;
            case R.id.edit:

//                editMode();
//                actionMenu.findItem( R.id.edit ).setVisible( false );
//                actionMenu.findItem( R.id.delete ).setVisible( false );
//                actionMenu.findItem( R.id.save ).setVisible( false );
//                actionMenu.findItem( R.id.update ).setVisible( true );

                return true;

            case R.id.update:
//                if (department_code.isEmpty()) {
//                    et_department_code.setError( "Please enter a title" );
//                } else {
//                    presenter.updateNote( id, title, note, color );
//                }

                return true;
            case R.id.delete:

//                AlertDialog.Builder alertDialog = new AlertDialog.Builder( this );
//                alertDialog.setTitle( "Confirm!" );
//                alertDialog.setMessage( "Are you sure?" );
//                alertDialog.setNegativeButton( "Yes",
//                    (dialog, which) -> {
//                        dialog.dismiss();
//                        presenter.deleteNote( id );
//                    });
//                alertDialog.setPositiveButton( "Cancel",
//                        ((dialog, which) -> dialog.dismiss()) );
//
//                alertDialog.show();

                return true;
            default:
                return super.onOptionsItemSelected( item );
        }
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public void onRequestSuccess(String message) {
        Toast.makeText( MachineryActivity.this, message,
                Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onRequestError(String message) {
        Toast.makeText( MachineryActivity.this, message,
                Toast.LENGTH_SHORT).show();
    }
}

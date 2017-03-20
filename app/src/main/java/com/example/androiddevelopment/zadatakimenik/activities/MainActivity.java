package com.example.androiddevelopment.zadatakimenik.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.androiddevelopment.zadatakimenik.R;
import com.example.androiddevelopment.zadatakimenik.dialogs.AboutDialog;

public class MainActivity extends AppCompatActivity {

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.action_settings:
                startActivity(new Intent(MainActivity.this,SettingActivity.class));
                break;

            case R.id.action_about:
                AlertDialog.Builder aboutdialog = new AlertDialog.Builder(MainActivity.this);
                aboutdialog.setIcon(R.drawable.ic_action_about);
                aboutdialog.setTitle("Autor aplikacije");
                aboutdialog.setMessage("Vlada Becelic");
                aboutdialog.setCancelable(false);

                aboutdialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                aboutdialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

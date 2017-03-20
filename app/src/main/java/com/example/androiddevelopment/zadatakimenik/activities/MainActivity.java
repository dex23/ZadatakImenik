package com.example.androiddevelopment.zadatakimenik.activities;

import android.app.Dialog;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androiddevelopment.zadatakimenik.R;
import com.example.androiddevelopment.zadatakimenik.db.ORMLightHelper;
import com.example.androiddevelopment.zadatakimenik.db.model.Kontakti;
import com.example.androiddevelopment.zadatakimenik.dialogs.AboutDialog;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import static com.example.androiddevelopment.zadatakimenik.R.xml.preferences;

public class MainActivity extends AppCompatActivity {

    private AlertDialog dialog;
    private ORMLightHelper databaseHelper;
    public static String TOAST = "notif_toast";
    public static String NOTIFICATION = "notif_status";

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
//    public void  showMessage(String message) {
//        boolean toast = preferences.getBoolean(TOAST, false);
//        boolean notification = preferences.getBoolean(NOTIFICATION, false);
//
//        if (toast) {
//            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
//        }
//        if (notification) {
//            statusMessage(message);
//        }
//    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
//            case R.id.action_add:
//                final Dialog dialog = new Dialog(MainActivity.this);
//                dialog.setTitle("Osnovni podaci o glumcu");
//                dialog.setContentView(R.layout.dialog_kontakti);
//                Button ok = (Button)dialog.findViewById(R.id.ok);
//
//                ok.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        EditText ime = (EditText) dialog.findViewById(R.id.et_ime);
//                        EditText adresa = (EditText) dialog.findViewById(R.id.et_address);
//                        EditText broj = (EditText) dialog.findViewById(R.id.et_number);
//
//                        Kontakti k = new Kontakti();
//                        k.settName(ime.getText().toString());
//
//                        if (k.gettName().equals("")) {
//                            k.settName("No name set");
//                            Toast.makeText(MainActivity.this, "Niste uneli ime kontakta", Toast.LENGTH_SHORT).show();
//                        }
//                        k.settAddress(adresa.getText().toString());
//                        k.settNumber(broj.getText().toString());
//
//                        try {
//                            getDatabaseHelper().getKontaktiDao().create(k);
//                            showMessage()
//                        }
//                    }
//                }


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

    public ORMLightHelper getDatabaseHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, ORMLightHelper.class);
        }
        return databaseHelper;
    }

}

package com.machczew.multiapps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //basic config
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        spinner = findViewById(R.id.spinner);
        findViewById(R.id.btnSalvar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inst = String.valueOf(spinner.getSelectedItem());
                if(inst.equals("APP 1")){
                    getPackageManager().setComponentEnabledSetting(new ComponentName("com.machczew.multiapps",
                            "com.machczew.multiapps.MainActivity_APP1"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                    getPackageManager().setComponentEnabledSetting(new ComponentName("com.machczew.multiapps",
                            "com.machczew.multiapps.MainActivity_Default"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

                    progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setTitle("Configurando..");
                    progressDialog.setMessage("");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();
                    progressDialog.setCancelable(true);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(5000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.machczew.multiapps");
                            if (launchIntent != null) {
                                launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(launchIntent);
                                finish();
                            }
                        }
                    }).start();


                }
                else if(inst.equals("APP 2")){
                    getPackageManager().setComponentEnabledSetting(new ComponentName("com.machczew.multiapps",
                            "com.machczew.multiapps.MainActivity_APP2"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                    getPackageManager().setComponentEnabledSetting(new ComponentName("com.machczew.multiapps",
                            "com.machczew.multiapps.MainActivity_Default"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

                    progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setTitle("Configurando..");
                    progressDialog.setMessage("");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();
                    progressDialog.setCancelable(true);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(5000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.machczew.multiapps");
                            if (launchIntent != null) {
                                launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(launchIntent);
                                finish();
                            }
                        }
                    }).start();

                }

            }
        });

    }
}
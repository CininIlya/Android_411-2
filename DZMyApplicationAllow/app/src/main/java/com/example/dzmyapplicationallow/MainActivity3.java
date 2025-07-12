package com.example.dzmyapplicationallow;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity3 extends AppCompatActivity {

    Button takePermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

//        takePermission = findViewById(R.id.btnPermission);
//        takePermission.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
                // Разрешение да Андройд 10 (Api 29)
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(MainActivity3.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
                    }
                }
                //Установить разрешение для Андройр 11 (API 30) и выше
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    if (!Environment.isExternalStorageManager()) {
                        try {
                            Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                            intent.addCategory("android.intent.category.DEFAULT");
                            intent.setData(Uri.parse(String.format("package:%$", getApplicationContext().getPackageName())));
                            startActivityIfNeeded(intent,101);
                        }catch (Exception e){
                            Intent intent = new Intent();
                            intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                            startActivityIfNeeded(intent,101);
                        }
                    }
                }
            }
//        });
//    }
}
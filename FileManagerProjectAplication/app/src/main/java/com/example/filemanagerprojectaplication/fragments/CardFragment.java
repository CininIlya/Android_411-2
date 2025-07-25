package com.example.filemanagerprojectaplication.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filemanagerprojectaplication.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class CardFragment extends Fragment {

    View view;

    private RecyclerView recyclerView;
    private List<File> fileList;
    private ImageView imgBackSD;
    private TextView tvPathHolder;
    File storage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_card, container, false);

        imgBackSD = view.findViewById(R.id.img_backSD);
        tvPathHolder = view.findViewById(R.id.tv_patg_holder);

        File[] externalDirs = ContextCompat.getExternalFilesDirs(getContext(), null);
        if (externalDirs.length > 1 && externalDirs !=null){
            storage = new File(externalDirs[1].getAbsolutePath());
            tvPathHolder.setText("Встроенная память:" + storage.getAbsolutePath());
            runtimePermission();
            
            
        }


            return view;


    }

    private void runtimePermission() {
        // Разрешение до Андройд 10 (API 29)
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED) {// работает если не предоставлено разрешение
                ActivityCompat.requestPermissions(getActivity(), new String[]
                        {Manifest.permission.READ_EXTERNAL_STORAGE}, 100); // -100 значит что нужно принять в работу и породолжить


            }
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_GRANTED) {// работает если не предоставлено разрешение
                displayFiles();
            }
            //// Разрешение до Андройд 11 и выше (API 30R)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (!Environment.isExternalStorageManager()) {
                    try {
                        Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
                        Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                        intent.setData(uri);
                        intent.addCategory("android.intent,category.DEFAULT");
                        intent.setData(Uri.parse(String.format("package:%s", getActivity().getPackageCodePath())));
                        getActivity().startActivityIfNeeded(intent, 101);// Метод позволяет запустить активность если требуется новый эжкземпляр 101 -
                    } catch (Exception e) {
                        Intent intent = new Intent();
                        intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                        getActivity().startActivityIfNeeded(intent, 101);

                    }
                }
                if (Environment.isExternalStorageManager()) {
                    displayFiles();

                }
            }
        }

    }

    public ArrayList<File> findFiles(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        File[] files = file.listFiles();

        for (File singleFile : files) {
            if (singleFile.isDirectory() && !singleFile.isHidden()) {
                arrayList.add(singleFile);

            }
        }
        for (File singleFile : files) {
            if (singleFile.getName().toLowerCase().endsWith(".jpeg") ||
                    singleFile.getName().toLowerCase().endsWith(".jpg") ||
                    singleFile.getName().toLowerCase().endsWith(".png") ||
                    singleFile.getName().toLowerCase().endsWith(".mp3") ||
                    singleFile.getName().toLowerCase().endsWith(".wav") ||
                    singleFile.getName().toLowerCase().endsWith(".mp4") ||
                    singleFile.getName().toLowerCase().endsWith(".pdf") ||
                    singleFile.getName().toLowerCase().endsWith(".doc") ||
                    singleFile.getName().toLowerCase().endsWith(".apk")){
                arrayList.add(singleFile);
            }
        }
        return arrayList;
    }

    private void displayFiles() {
        recyclerView = view.findViewById(R.id.recycler_internal);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        fileList = new ArrayList<>();
        fileList.addAll(findFiles(storage));
    }
}



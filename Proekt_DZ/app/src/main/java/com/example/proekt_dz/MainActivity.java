package com.example.proekt_dz;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    private int currentProgress =0;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup2 = findViewById(R.id.radioGroup2);
        TextView textView = findViewById(R.id.textIndicator);
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton2) {
                    textView.setTextColor(Color.parseColor("#009212"));
                } else if (checkedId == R.id.radioButton3) {
                    textView.setTextColor(Color.parseColor("#DCDCDC"));
                }
            }
        });

        Button chooseStart = findViewById(R.id.buttonStart);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    chooseStart.setBackgroundColor(Color.parseColor("#009212"));
                } else {
                    chooseStart.setBackgroundColor(Color.parseColor("#990000"));
                }
            }
        });
        Switch myswitch = findViewById(R.id.switch1);
        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    myswitch.setTextColor(Color.parseColor("#C27BA0"));
                } else {
                    myswitch.setTextColor(Color.parseColor("#3C78DB"));
                }
            }
        });
        ConstraintLayout constraintLayout = findViewById(R.id.main);
        SwitchMaterial switchMaterial = findViewById(R.id.switchMaterial);
        switchMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchMaterial.isChecked()) {
                    switchMaterial.setThumbDrawable(getDrawable(R.drawable.baseline_add));
                    switchMaterial.setText("Взять трубку");
                    switchMaterial.setThumbTintList(ColorStateList.valueOf(Color.GREEN));
                    switchMaterial.setTrackTintList(ColorStateList.valueOf(Color.parseColor("#B87676")));
                    constraintLayout.setBackgroundResource(R.color.yellow);
                } else {
                    switchMaterial.setThumbDrawable(getDrawable(R.drawable.baseline_add_ic_call));
                    switchMaterial.setText("Сбросить");
                    switchMaterial.setTrackTintList(ColorStateList.valueOf(Color.parseColor("#91CC92")));
                    constraintLayout.setBackgroundResource(R.color.green);
                }
            }
        });
        progressBar = findViewById(R.id.progressBarHorizoltal);
        Button startProgress = findViewById(R.id.buttonvolume);

        startProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentProgress = currentProgress +10;
                progressBar.setProgress(currentProgress);
                progressBar.setMax(100);
            }
        });
//        Button chooseStart = findViewById(R.id.buttonStart);
//        chooseStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                RadioGroup radioGroup2 = findViewById(R.id.radioGroup2);
//                int chekedButtonIndex = radioGroup2.getCheckedRadioButtonId();
//                TextView textView = findViewById(R.id.textIndicator);
//
//                if(chekedButtonIndex==R.id.radioButton2){
//                    textView.setTextColor(Color.parseColor("#009212"));
//                } else if (chekedButtonIndex == R.id.radioButton3) {
//                    textView.setTextColor(Color.parseColor("#808080"));
//
//                }
//            }
//        });
    }

}
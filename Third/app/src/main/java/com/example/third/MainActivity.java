package com.example.third;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        TextView textView = findViewById(R.id.textColor);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {  // измененния элементов цвета без нажатие на кнопку
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton1) {
                    textView.setTextColor(Color.parseColor("#009212"));
                } else if (checkedId == R.id.radioButton2) {
                    textView.setTextColor(Color.parseColor("#FF6F00"));
                }
            }
        });

        Button chooseColor = findViewById(R.id.changeColor);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) { //если нажата кнопка тогл изменение цвета кнопки Button
                    chooseColor.setBackgroundColor(Color.parseColor("#009212"));

                } else {
                    chooseColor.setBackgroundColor(Color.parseColor("#FF6F00"));
                }
            }
        });

        Switch muSwitch = findViewById(R.id.switch1); // переключатель подсветки
        muSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    muSwitch.setTextColor(Color.parseColor("#FF6F00"));
                } else {
                    muSwitch.setTextColor(Color.parseColor("#009212"));
                }
            }
        });
        ConstraintLayout constraintLayout = findViewById(R.id.main); //цвет фона всего телефона
        SwitchMaterial switchMaterial = findViewById(R.id.switchMaterial);
        switchMaterial.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (switchMaterial.isChecked()) {
                    switchMaterial.setThumbDrawable(getDrawable(R.drawable.baseline_ac_unit_24));// обращение к карьтнке
                    switchMaterial.setText("Turn on Night mode");//смена букв при нажаьтии
                    switchMaterial.setThumbTintList(ColorStateList.valueOf(Color.BLUE));// цвет бегунка со снежинкой
                    switchMaterial.setTrackTintList(ColorStateList.valueOf(Color.parseColor("#004CFF")));// цвет плоски ползунк\а
                    constraintLayout.setBackgroundResource(R.color.bg);//смена фона при нажатии на кнопку

                } else {
                    switchMaterial.setThumbDrawable(getDrawable(R.drawable.baseline_wb_sunny_24));
                    switchMaterial.setText("Turn on Light mome"); //обратное переключение бегунта ввиде солнца
                    switchMaterial.setTrackTintList(ColorStateList.valueOf(Color.parseColor("#FF6F00")));// цвет полоски бугунка при нажатии обратно
                    constraintLayout.setBackgroundResource(R.color.yellow); //изменение цвета фона при нажатии на бегунов назад
                }
            }
        });

        TextView sampleTextView = findViewById(R.id.sampleTextView);
        CheckBox boldCheckbox = findViewById(R.id.boldcheckBox);
        CheckBox italicCheckbox = findViewById(R.id.italiccheckBox2);// получение доступа к обьетам

        boldCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) { // изменение состояние кнопкт cheak
                if (isChecked) {
                    if (italicCheckbox.isChecked()) {
                        sampleTextView.setTypeface(null, Typeface.BOLD_ITALIC);// измениние сразу двеух настроек на текст TextViev (bold,italic)
                    } else {

                        sampleTextView.setTypeface(null, Typeface.BOLD);// измение вида надписи TEXTView-Sample Text
                    }

                } else {
                    if (italicCheckbox.isChecked()) {
                        sampleTextView.setTypeface(null, Typeface.ITALIC);//римение когда не отжался Italic при снятии checkbox Bold
                    }
                    sampleTextView.setTypeface(null, Typeface.NORMAL);// измение в изначальный  вида надписи TEXTView-Sample Text
                }
            }
        });

        italicCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (boldCheckbox.isChecked()) {
                        sampleTextView.setTypeface(null, Typeface.BOLD_ITALIC);// измение вида надписи TEXTView-Sample Text
                    } else {
                        sampleTextView.setTypeface(null, Typeface.ITALIC);// измение в изначальный  вида надписи TEXTView-Sample Text
                    }
                } else {
                    if (boldCheckbox.isChecked()) {
                        sampleTextView.setTypeface(null, Typeface.BOLD);
                    } else {
                        sampleTextView.setTypeface(null, Typeface.NORMAL);
                    }
                }
            }
    });

//        Button chooseColor =findViewById(R.id.changeColor);//смена цвета кнопки
//        chooseColor.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                RadioGroup radioGroup = findViewById(R.id.radioGroup); // получение доступа к радиогруппе
//                int chekedButtonIndex =radioGroup.getCheckedRadioButtonId();// получение радиокнопки по id и какая кнопка выбрана
//                TextView textView = findViewById(R.id.textColor);
//
//                if(chekedButtonIndex == R.id.radioButton1){
//                    textView.setTextColor(Color.parseColor("#009212"));
//                } else if (chekedButtonIndex == R.id.radioButton2){
//                    textView.setTextColor(Color.parseColor("#FF6F00"));
//
//                }
//            }
//        });

}
}
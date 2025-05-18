package com.example.third;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    private int currentProggress = 0;// переменная для отображение прогресса ползунка для подсчета прогресса
    private ProgressBar progressBar;// для получните досткпа к прогресс бару
    private EditText editTextKeyword;//переменная для доступ к текстовому полю \
    private ChipGroup chipGroup;//переменная для доступ к группе чипов


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

        Button buttonForProgress = findViewById(R.id.buttonForProgress);// доступ к виджету прогресс бар круглый
        buttonForProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBar pb = findViewById(R.id.progressBar);
                pb.setVisibility(View.VISIBLE);// отображение невидимого виджите который мы скрыли в разметке при нажатии кнопки Button

            }
        });
        progressBar = findViewById(R.id.progressBarHorizontal);
        Button startProgress = findViewById(R.id.StartProgress);

        startProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentProggress = currentProggress + 10;//увеличение прогресса через переменну при нажатия на кнопку старт прогресс
                progressBar.setProgress(currentProggress);//визуальное отображение га экране отображение при нажатии
                progressBar.setMax(100);//отображение до 100% как ограничение закращиваем в помощью созданной в drawable
                // custom_progress_bg -solid android color


            }
        });
        editTextKeyword = findViewById(R.id.editTextKeyWord);// доступ к элементам разметки
        chipGroup = findViewById(R.id.chipGroup);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonShow = findViewById(R.id.buttonShow);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewChip();
            }
        });

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelections();

            }
        });

//        Chip chip1 = findViewById(R.id.chip);
//        chip1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"Action Completed",Toast.LENGTH_LONG).show();//всплывающаяч подскаэка при нажатии на кнопку chip
//
//            }
//        });

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

    private void addNewChip() {//метод отвечает за добавление данных и преобразование этих данных в сhip
        String keyword = editTextKeyword.getText().toString();//переменноя для преобразование введенное в поле значени
        if (keyword.isEmpty()) {// проверка на пустое значение в текстовое поле
            Toast.makeText(this, "Please enter text keyword", Toast.LENGTH_SHORT).show();
            return;
        }
        LayoutInflater inflater = LayoutInflater.from(this);// для добавление элемента которого не существовало
        Chip newChip = (Chip) inflater.inflate(R.layout.layout_chip_entry, this.chipGroup, false);// добавлние ранне созданного в ресурсах layout chip
        newChip.setText(keyword);//значение ложим в chip и установит к нему тект
        chipGroup.addView(newChip);
        editTextKeyword.setText("");// очистка поля для слудуюшего ввого в поле текседит

        newChip.setOnCloseIconClickListener(new View.OnClickListener() { // удаление чипа chip по нажатию нга крестик иконки
            @Override
            public void onClick(View v) {
                handleChipCloseClicked((Chip) v);// вызов метод удаления

            }
        });
    }

    private void handleChipCloseClicked(Chip chip) {// метод для срабатывание крестика закрыти икоки chip
        ChipGroup parent = (ChipGroup) chip.getParent();//получение к родительскому элементу
        parent.removeView(chip);//удаление элемента
    }

    private void showSelections() {//провеерка помеченных элементов
        int count = chipGroup.getChildCount();//подсчет всех введенных элементов в текстовое поле через получениеколичество потомков
        String s = null;
        for (int i = 0; i < count; i++) {
            Chip child = (Chip) chipGroup.getChildAt(i);//получение по индексу сам chip
            if (!child.isChecked()) {//отброс не отмеченных элементов
                continue;
            }
            if (s == null) {
                s = child.getText().toString();
            }else {
                s+= "," + child.getText().toString(); // добавление элемента через запятую который нашел if
            }
        }
        Toast.makeText(this,s, Toast.LENGTH_SHORT).show();

    }
}
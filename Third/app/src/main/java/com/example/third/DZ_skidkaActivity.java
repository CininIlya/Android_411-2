package com.example.third;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;
import java.util.Locale;

public class DZ_skidkaActivity extends AppCompatActivity {



    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String Key_COST = "cost";
    SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz_skidka);
        preference = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        Button sellButton = findViewById(R.id.button_sell);
        Button saveButton = findViewById(R.id.button_save2);
        Button exitButton = findViewById(R.id.button_exit);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        EditText costofService = findViewById(R.id.cost_of_service2);
        TextView tipResult = findViewById(R.id.tip_resultate2);

        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText costService = findViewById(R.id.cost_of_service2);
                String keyword = costService.getText().toString();
                int cost = Integer.parseInt(keyword);

                double tip = 0;

                RadioGroup tipoptions = findViewById(R.id.tip_group);
                int selectedId = tipoptions.getCheckedRadioButtonId();
                if (selectedId == R.id.option_five_per && cost >= 1000) {
                    tip = cost * 0.05;
                } else if (selectedId == R.id.option_three_per && cost >= 500 && cost <= 999) {

                    tip = cost * 0.03;
                }

                String result = String.valueOf(tip);
                tipResult.setText(result);

//            }
//                    buttonSave.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            TextView resultViev = findViewById(R.id.tip_resultate2);
//                            String result2 = setting.getString(Key_Save, "нет значения");
//                            resultViev.setText(result2);
//
////                        SharedPreferences.Editor editor = sharedPreferences.edit();// Интерфейс использутся для записи  редактирования
////                        // в фаиле  sharedpreferance
////                        editor.putString(Key_Save, tip_resultate2.getText().toString());//Положит строковое значени в key name  и
////                        // преоброзовые в сроковое значение
////                        editor.clear();// очистка данные в документе mypref
////                        editor.apply();// сохранения новых данных
////                        finish();
//
//
                Locale uslocale = new Locale("ru", "RU");
                NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(uslocale);
                String currencyTip = usCurrencyFormat.format(tip);// перевод числовое значение в строково через locale
                tipResult.setText(currencyTip);
                String text = "Оставь на чай " + currencyTip;
                tipResult.setText(text);


            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preference.edit();
                editor.putString(Key_COST, costofService.getText().toString());
                Toast.makeText(DZ_skidkaActivity.this, "Сохранено", Toast.LENGTH_SHORT).show();
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preference.edit();
                finish();
                Toast.makeText(DZ_skidkaActivity.this, "Log out Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
















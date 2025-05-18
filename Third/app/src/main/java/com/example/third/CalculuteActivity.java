package com.example.third;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.text.NumberFormat;
import java.util.Locale;

public class CalculuteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculute);

        Button calculateButton = findViewById(R.id.calculate_Button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText costService = findViewById(R.id.cost_of_service);// доступ к таблу вывода
                String keybord = costService.getText().toString();// преобразуем введеные данные в табло в строковые значения
                int cost = Integer.parseInt(keybord);//переделывает значение в числовые  для вычисление в формуле

                double tip = 0;//сумма чаевых будим ее перезаписывать
                RadioGroup tipoptions = findViewById(R.id.tip_options);// получение доступа ко всем кнопкам через радиогруппу
                int selectedId = tipoptions.getCheckedRadioButtonId();// выбор отмеченного элемента в радиогруппе

                if (selectedId == R.id.options_ten_persen) {
                    ;
                    // если выбрана первая радиокнопка
                    tip = cost * 0.1;// расчет чаевых в 10 %

                } else if (selectedId == R.id.option_seven_persen) {
                    tip = cost * 0.7;
                } else if (selectedId == R.id.option_five_persen) {
                    tip = cost * 0.5;
                }

                SwitchMaterial roundSwitch = findViewById(R.id.round_switch);// получение доступа к переключателю
                boolean round = roundSwitch.isChecked();// проверка отмечен ли переключаль

                if (round) {
                    tip = Math.ceil(tip);// если истина окруление в большую сторону и передадим туда в чаевые
                }
                TextView tipResult = findViewById(R.id.tip_Result);// доступ к строчке сумма чаевых
//                String result = String.valueOf(tip); // преобразование значение tip число в строку
//                tipResult.setText(result);

                Locale uslocale = new Locale("ru", "RU");
                NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(uslocale);
                String currencyTip = usCurrencyFormat.format(tip);// перевод числовое значение в строково через locale
//                tipResult.setText(currencyTip);
                String text = "Оставь на чай " + currencyTip;
                tipResult.setText(text);
            }
        });
    }
}
package com.example.gamequizdz;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class Level1dz extends AppCompatActivity {

    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.universal);

        // Устанавливаем  номер уровня
        TextView textLevels = findViewById(R.id.textView);
        textLevels.setText(R.string.level_1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);// строка состояния скрывается сама после вытягивания

        //получение доступа к перечисленным элементам
        final ImageView imgLeft = findViewById(R.id.img_left);
        final ImageView imgRight = findViewById(R.id.img_rigth);

        //скругление углов

        imgLeft.setClipToOutline(true);
        imgRight.setClipToOutline(true);


        //вызов диалогово окно в начала игры

        dialog = new Dialog(this);// cjplftv lbfkjujt jtyj pltcm
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);// скрывает заголовок
        dialog.setContentView(R.layout.privioew_dialofdz);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалогового окна
        dialog.setCancelable(false);// не закрывать при кликам за пределами окна

        // кнопка назад
        TextView btnClose = dialog.findViewById(R.id.button_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level1dz.this, GameLevelsdz.class);
                startActivity(intent);
                dialog.dismiss();//закрытие диалогового окна

            }
        });

        // Кнопка продолжить
        Button btnContinue = dialog.findViewById(R.id.button_continue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); //звкрытие диалого окна
            }
        });

        dialog.show();//показать диалоговое окно


        // Кнопка Назад из окна с Уровнем

        Button btnBack = findViewById(R.id.button_back_level1);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Level1dz.this,GameLevelsdz.class);
                startActivity(intent);
            }
        });
    }
}
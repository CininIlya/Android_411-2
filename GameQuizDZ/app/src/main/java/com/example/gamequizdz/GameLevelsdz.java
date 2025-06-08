package com.example.gamequizdz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevelsdz extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_levelsdz);
        SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
        final int level = save.getInt("level",1);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);// строка состояния скрывается сама после вытягивания


        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {// нажатие на кнопку назад переход на начало игры
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GameLevelsdz.this, MainActivitydz.class);
                startActivity(intent);


            }
        });
//кнопка для перехода на 1 уровень
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level >= 1) {
                    Intent intent = new Intent(GameLevelsdz.this, Level1dz.class);
                    startActivity(intent);
                }
            }
        });

        // кнопка перехода на 2 уровень
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level >= 2) {

                    Intent intent = new Intent(GameLevelsdz.this, Level2dz.class);
                    startActivity(intent);
                }
            }
        });
        // кнопка перехода на 3 уровень
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (level >= 3) {
                    Intent intent = new Intent(GameLevelsdz.this, Level3dz.class);
                    startActivity(intent);
                }
            }
        });

        // кнопка перехода на 4 уровень
        TextView textView4 = findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (level >= 4) {
                    Intent intent = new Intent(GameLevelsdz.this, Level4dz.class);
                    startActivity(intent);
                }
            }
        });
        final int[ ] x = { // переделывает X в цифры
                R.id.textView1,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
        };
        for (int i = 0; i <level ; i++) {
            TextView tv =findViewById(x[i]);
            tv.setText(""+ (i+1));

        }
    }
}
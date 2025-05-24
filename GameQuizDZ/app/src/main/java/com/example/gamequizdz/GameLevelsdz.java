package com.example.gamequizdz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevelsdz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_levelsdz);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);// строка состояния скрывается сама после вытягивания


        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {// нажатие на кнопку назад переход на начало игры
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(GameLevelsdz.this, MainActivitydz.class);
                startActivity(intent);


            }
        });
//кнорка для перехода на 1 уровыень
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameLevelsdz.this, Level1dz.class);
                startActivity(intent);
            }
        });
    }
}
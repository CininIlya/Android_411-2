package com.example.third;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    TextView textViewName, textViewEmail;
    Button buttonLogout;

    SharedPreferences sharedPreferences;//переменноя в которой будут храница данные

    private static final String SHARED_PREF_NAME = "mypref";//бкз привязки к экземпляры и не измепняемвя константа
    private static final String Key_NAME = "name";//настройка для сохранеия имени
    private static final String Key_EMAIL = "email";//настройка для сохранеия email

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textViewName = findViewById(R.id.text_full_name);
        textViewEmail = findViewById(R.id.text_Email);
        buttonLogout = findViewById(R.id.button_logout);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE); //настройки для обьекта шаред и ложил в нее функцию режим по умочанию
        String name = sharedPreferences.getString(Key_NAME, null);
        String email = sharedPreferences.getString(Key_EMAIL, null);

        if (name != null || email != null) {
            textViewName.setText("Full Name -" + name);//если что то заполнено и перезаписаем значением в ковычках
            textViewEmail.setText("EMAIL -" + email);

        }
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();// редактирование документа которыф хранит структуру
                editor.clear();// очистка данные в документе mypref
                editor.apply();// сохранения новых данных
                finish();

                Toast.makeText(HomeActivity.this, "Log out Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
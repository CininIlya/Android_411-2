package com.example.third;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextName, editTextEmail;
    Button buttonSave;
    SharedPreferences sharedPreferences;//переменноя в которой будут храница данные

    private static final String SHARED_PREF_NAME = "mypref";//бкз привязки к экземпляры и не измепняемвя константа
    private static final String Key_NAME = "name";//настройка для сохранеия имени
    private static final String Key_EMAIL = "email";//настройка для сохранеия email


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextName = findViewById(R.id.edit_text_name);
        editTextEmail = findViewById(R.id.edit_Text_Email);
        buttonSave = findViewById(R.id.button_save);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE); //настройки для обьекта шаред и ложил в нее функцию режим по умочанию
        String name = sharedPreferences.getString(Key_NAME, null);

        if (name != null) {
            Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);// переход на другую страницу при условии ее заполнености
            startActivity(intent);


        }
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();// Интерфейс использутся для записи  редактирования
                // в фаиле  sharedpreferance
                editor.putString(Key_NAME, editTextName.getText().toString());//Положит строковое значени в key name  и
                // преоброзовые в сроковое значение
                editor.putString(Key_EMAIL, editTextEmail.getText().toString());
                editor.apply();// применение этого метода

                Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                startActivity(intent); // переход на новую страницу при нажатии кнопки save

                Toast.makeText(RegisterActivity.this, "Login success", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
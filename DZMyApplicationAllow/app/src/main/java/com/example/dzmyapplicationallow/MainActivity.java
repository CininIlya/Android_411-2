package com.example.dzmyapplicationallow;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final static String FILE_NAME ="content.txt"; // название фаила в который все ссохранияется

    Button saveText,openText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveText = findViewById(R.id.save_text);
        openText = findViewById(R.id.open_text);

        saveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FileOutputStream fos = null; // это переменная для записи из текста в фаил

                EditText textBox = findViewById(R.id.editor);
                String text =textBox.getText().toString();
                try {
                    fos = openFileOutput(FILE_NAME,MODE_PRIVATE); //  режим для перезаписи фаиала новыми данными
                    fos.write(text.getBytes()); // запись в фаил
                    Toast.makeText(MainActivity.this,"Фаил сохранен",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }finally {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show(); // вывлд ошибки если программа не может закрыть фаил

                    }
                }


            }
        });

        openText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileInputStream fis = null;// это переменная для считывание  из фаила
                TextView textView = findViewById(R.id.text);

                try {
                    fis = openFileInput(FILE_NAME);

                    byte[] bytes = new byte[fis.available()];
                    fis.read(bytes);
                    String text = new String(bytes);
                    textView.setText(text);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }finally {// Обязательное закрытие файла
                        try {
                            if (fis != null) {
                                fis.close();
                            }
                        } catch (IOException e) {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                }

        });


    }
}
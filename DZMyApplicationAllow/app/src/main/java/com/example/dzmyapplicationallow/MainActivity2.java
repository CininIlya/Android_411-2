package com.example.dzmyapplicationallow;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {

    private final static String FILE_NAME = "document.txt";

    Button saveText, openText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        saveText = findViewById(R.id.save_text);
        openText = findViewById(R.id.open_text);

        saveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try (FileOutputStream fos = new FileOutputStream(getExternalPath())) {
                    EditText textbox = findViewById(R.id.editor);
                    String  text = textbox.getText().toString();
                    fos.write(text.getBytes());
                    Toast.makeText(MainActivity2.this, "Фаил сохранен", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(MainActivity2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        openText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = findViewById(R.id.text);
                File file =getExternalPath();

                if (!file .exists()) {  // проверка если фаила не существует
                    return;
                }
                try (FileInputStream fis = new FileInputStream(file)){  // метод записи в фаил
                    byte [] bytes = new byte [fis.available()];
                    fis.read(bytes);
                    String  text = new String(bytes);
                    textView.setText(text);
                }catch (IOException e){
                    Toast.makeText(MainActivity2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private File getExternalPath() {
        return new File(getExternalFilesDir(null), FILE_NAME);
    }
}
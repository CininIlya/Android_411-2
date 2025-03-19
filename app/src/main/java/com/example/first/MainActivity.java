package com.example.first;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textSample;
    private TextView textSample2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.buttons);


        textSample = findViewById(R.id.textSample);
        textSample2 = findViewById(R.id.textSample2);



    }

    public void sayHello(View view){
        textSample.setText("Привет");
    }
    public void sayHello2(View view){
        textSample2.setText("Hello");


    }
}
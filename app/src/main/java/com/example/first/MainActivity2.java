package com.example.first;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView result;
    private EditText num1,num2;
    private Button button;
    private Button buttonMinus;
    private Button buttonMultiple;
    private Button buttonDivision;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        result = findViewById(R.id.result);
        num1 = findViewById(R.id.editNumber1);
        num2 = findViewById(R.id.editNumber2);
        button= findViewById(R.id.calc_Sum);
        buttonMinus =findViewById(R.id.calc_Minus);
        buttonMultiple =findViewById(R.id.calc_Mult);
        buttonDivision =findViewById(R.id.calc_division);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Integer number1 = Integer.parseInt(num1.getText().toString());
               Integer number2 = Integer.parseInt(num2.getText().toString());
               result.setText(String.valueOf(number1 + number2));


            }
        });
       buttonMinus.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Integer number1 = Integer.parseInt(num1.getText().toString());
               Integer number2 = Integer.parseInt(num2.getText().toString());
               result.setText(String.valueOf(number1 - number2));
           }
       });
        buttonMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer number1 = Integer.parseInt(num1.getText().toString());
                Integer number2 = Integer.parseInt(num2.getText().toString());
                result.setText(String.valueOf(number1 * number2));
            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer number1 = Integer.parseInt(num1.getText().toString());
                Integer number2 = Integer.parseInt(num2.getText().toString());
                result.setText(String.valueOf(number1 / number2));

            }
        });
    }
}
package com.example.third;

import android.os.Bundle;
import android.text.style.TtsSpan;
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

public class DZ_skidkaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz_skidka);

        Button sellButton = findViewById(R.id.button_sell);
        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText costService = findViewById(R.id.cost_of_service2);
                String keyword = costService.getText().toString();
                int cost = Integer.parseInt(keyword);

                double tip = 0;

                RadioGroup tipoptions = findViewById(R.id.tip_group);
                int selectedId = tipoptions.getCheckedRadioButtonId();
                if (selectedId == R.id.option_five_per && cost >= 1000) {
//                    if (cost >= 1000) {
                    tip = cost * 0.05;
//                    }
                } else if (selectedId == R.id.option_three_per && cost >= 500 && cost <= 999) {
//                        if (cost >= 500&& cost<=999) {
                    tip = cost * 0.03;


                }


                TextView tipResult = findViewById(R.id.tip_resultate2);
                String result = String.valueOf(tip);
                tipResult.setText(result);
            }
        });
    }
}
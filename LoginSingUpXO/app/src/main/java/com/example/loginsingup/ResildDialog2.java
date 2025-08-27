package com.example.gamexo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.loginsingup.R;

public class ResildDialog2 extends Dialog {


    private final String message;

    private final com.example.gamexo.PlayingField5x5 playingField5x5;

    public ResildDialog2(@NonNull Context context, String message, com.example.gamexo.PlayingField5x5 playingField5x5) {
        super(context);
        this.message = message;

        this.playingField5x5 = playingField5x5;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_resild_dialog);

        TextView messageText = findViewById(R.id.messageText);
        Button startAganeButton = findViewById(R.id.startAgainButton);

        messageText.setText(message);
        startAganeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                playingField5x5.restartMatch();
                dismiss();// закрытие окна
                
            }
        });

    }
}
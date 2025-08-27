package com.example.loginsingup;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.loginsingup.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayingField extends AppCompatActivity {

    private final List<int[]> combinationList = new ArrayList<>();

    private TextView playerOneName;
    private TextView playerTwoName;



    private int activePlayer = 1;

    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int totalSelectBoxes = 1;
    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;

    private int currentScoreOne = 0;
    private int currentScoreTwo = 0;//ПОСЧЕТ ОЧКОВ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_field);

        playerOneName = findViewById(R.id.playerOneName);
        playerTwoName = findViewById(R.id.playerTwoNANE);


        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);

        combinationList.add(new int[]{0, 1, 2});
        combinationList.add(new int[]{3, 4, 5});
        combinationList.add(new int[]{6, 7, 8});
        combinationList.add(new int[]{0, 3, 6});
        combinationList.add(new int[]{1, 4, 7});
        combinationList.add(new int[]{2, 5, 8});
        combinationList.add(new int[]{0, 4, 8});
        combinationList.add(new int[]{2, 4, 6});


        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        changePlayerTurn(1);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(0)) {
                    performAction((ImageView) v, 0);
                    hodPc();
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(1)) {
                    performAction((ImageView) v, 1);
                    hodPc();
                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(2)) {
                    performAction((ImageView) v, 2);
                    hodPc();
                }

            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(3)) {
                    performAction((ImageView) v, 3);
                    hodPc();
                }
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(4)) {
                    performAction((ImageView) v, 4);
                    hodPc();
                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(5)) {
                    performAction((ImageView) v, 5);
                    hodPc();
                }
            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(6)) {
                    performAction((ImageView) v, 6);
                    hodPc();
                }
            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(7)) {
                    performAction((ImageView) v, 7);
                    hodPc();
                }
            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(8)) {
                    performAction((ImageView) v, 8);
                    hodPc();
                }
            }
        });

    }

    private void performAction(ImageView imageView, int SelectedBoxPosition) {
        boxPositions[SelectedBoxPosition] = activePlayer;



        imageView.setBackgroundResource(R.drawable.white_box);
        imageView.setScaleType(ImageView.ScaleType.CENTER);

        playerOneName = findViewById(R.id.playerOneName);
        playerTwoName = findViewById(R.id.playerTwoNANE);

        TextView scorePlayerA = findViewById(R.id.scoreOne);
        TextView scorePlayerB = findViewById(R.id.scoreTwo);

        if (activePlayer == 1) {
            imageView.setImageResource(R.drawable.ximage);

            if (checkResults()) {
                com.example.gamexo.ResildDialog resildDialog = new com.example.gamexo.ResildDialog(PlayingField.this,
                        playerOneName.getText().toString() + "is a Winner", PlayingField.this);
                resildDialog.setCancelable(false);
                resildDialog.show();

                currentScoreOne++;
                scorePlayerA.setText(String.valueOf(currentScoreOne));//подсчет очков игрока 1


            } else if (totalSelectBoxes == 9) {

                com.example.gamexo.ResildDialog resildDialog = new com.example.gamexo.ResildDialog(PlayingField.this, "Match Draw", PlayingField.this);
                resildDialog.setCancelable(false);
                resildDialog.show();
            } else {


                changePlayerTurn(2);
                totalSelectBoxes++;
            }
//        } else {
//            imageView.setImageResource(R.drawable.oimage);
//
        }if (checkResults()) {
                com.example.gamexo.ResildDialog resildDialog = new com.example.gamexo.ResildDialog(PlayingField.this,
                        playerTwoName.getText().toString() + "is a Winner", PlayingField.this);
                resildDialog.setCancelable(false);
                resildDialog.show();


                currentScoreTwo++;
                scorePlayerB.setText(String.valueOf(currentScoreTwo));//подсчет очков игрока 2

        } else if (totalSelectBoxes == 9) {

            com.example.gamexo.ResildDialog resildDialog = new com.example.gamexo.ResildDialog(PlayingField.this, "Match Draw", PlayingField.this);
            resildDialog.setCancelable(false);
            resildDialog.show();
        } else {
            changePlayerTurn(1);
            totalSelectBoxes++;
        }
    }


    private boolean checkResults() {
        boolean response = false;
        for (int i = 0; i < combinationList.size(); i++) {
            final int[] combination = combinationList.get(i);

            if (boxPositions[combination[0]] == activePlayer && boxPositions[combination[1]] == activePlayer && boxPositions[combination[2]] == activePlayer) {
                response = true;
            }


        }
        return response;
    }

    private void changePlayerTurn(int currentPlayerTurn) {
        activePlayer = currentPlayerTurn;

        LinearLayout playerOneLayoutOuter = findViewById(R.id.playerOneLayoutOuter);
        LinearLayout playerTwoLayoutOuter = findViewById(R.id.playerTwoLayoutOuter);

        if (activePlayer == 1) {
            playerOneLayoutOuter.setBackgroundResource(R.drawable.black_baorder);
            playerTwoLayoutOuter.setBackgroundResource(R.drawable.white_box);

        } else {
            playerTwoLayoutOuter.setBackgroundResource(R.drawable.black_baorder);
            playerOneLayoutOuter.setBackgroundResource(R.drawable.white_box);
        }
    }

    private boolean isBoxSelectable(int boxPosition) {
        boolean response = false;
        if (boxPositions[boxPosition] == 0) {
            response = true;
        }
        return response;
    }

    public void restartMatch() {
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        activePlayer = 1;
        totalSelectBoxes = 1;

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        image1.setImageResource(R.drawable.white_box);
        image2.setImageResource(R.drawable.white_box);
        image3.setImageResource(R.drawable.white_box);
        image4.setImageResource(R.drawable.white_box);
        image5.setImageResource(R.drawable.white_box);
        image6.setImageResource(R.drawable.white_box);
        image7.setImageResource(R.drawable.white_box);
        image8.setImageResource(R.drawable.white_box);
        image9.setImageResource(R.drawable.white_box);



    }

    private void hodPc() {
        Random random = new Random();
        int imagePcClick = 1 + random.nextInt(9);
        switch (imagePcClick) {
            case (1): if (image1.getDrawable() != null){
                image1.setImageResource(R.drawable.oimage);
            }else{hodPc();}
           break;
            case (2):if (image2.getDrawable() != null){
                image2.setImageResource(R.drawable.oimage);
            }else{hodPc();}
                break;
            case (3):if (image3.getDrawable() != null){
                image3.setImageResource(R.drawable.oimage);
            }else{hodPc();}
                break;
            case (4):if (image4.getDrawable() != null){
                image4.setImageResource(R.drawable.oimage);
            }else{hodPc();}
                break;
            case (5):if (image5.getDrawable() != null){
                image5.setImageResource(R.drawable.oimage);
            }else{hodPc();}
                break;
            case (6):if (image6.getDrawable() != null){
                image6.setImageResource(R.drawable.oimage);
            }else{hodPc();}
                break;
            case (7):if (image7.getDrawable() != null){
                image7.setImageResource(R.drawable.oimage);
            }else{hodPc();}
                break;
            case (8):if (image8.getDrawable() != null){
                image8.setImageResource(R.drawable.oimage);
            }else{hodPc();}
                break;
            case (9):if (image9.getDrawable() != null){
                image9.setImageResource(R.drawable.oimage);
            }else{hodPc();}
                break;

        }
    }
}


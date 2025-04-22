package com.example.gamexo;

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

import java.util.ArrayList;
import java.util.List;

public class PlayingField5x5 extends AppCompatActivity {

    private final List<int[]> combinationList = new ArrayList<>();

    private TextView playerOneName;
    private TextView playerTwoName;

    private int activePlayer = 1;
    private int[] boxPositions = {0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0,
            0, 0, 0, 0, 0};
    private int totalSelectBoxes = 1;
    private ImageView image10, image11, image12, image13, image30,
            image31, image32, image33, image34, image35,
            image20, image21, image22, image23, image24,
            image25, image26, image27, image28, image14,
            image15, image16, image17, image18, image19;


    private int currentScoreOne = 0;
    private int currentScoreTwo = 0;//ПОСЧЕТ ОЧКОВ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playin5x5);

        playerOneName = findViewById(R.id.playerOneName);
        playerTwoName = findViewById(R.id.playerTwoName);

        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        playerOneName.setText(getPlayerOneName);
        playerTwoName.setText(getPlayerTwoName);

        combinationList.add(new int[]{0, 1, 2, 3, 4});
        combinationList.add(new int[]{5, 6, 7, 8, 9});
        combinationList.add(new int[]{10, 11, 12, 13, 14});
        combinationList.add(new int[]{15, 16, 17, 18, 19});
        combinationList.add(new int[]{20, 21, 22, 23, 24});
        combinationList.add(new int[]{0, 5, 10, 15, 20});
        combinationList.add(new int[]{1, 6, 11, 16, 21});
        combinationList.add(new int[]{2, 7, 12, 17, 22});
        combinationList.add(new int[]{3, 8, 13, 18, 23});
        combinationList.add(new int[]{4, 9, 14, 19, 24});
        combinationList.add(new int[]{0, 6, 12, 18, 24});
        combinationList.add(new int[]{4, 8, 12, 16, 20});


        image10 = findViewById(R.id.image10);
        image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12);
        image13 = findViewById(R.id.image13);
        image30 = findViewById(R.id.image30);
        image31 = findViewById(R.id.image31);
        image32 = findViewById(R.id.image32);
        image33 = findViewById(R.id.image33);
        image34 = findViewById(R.id.image34);
        image35 = findViewById(R.id.image35);

        image20 = findViewById(R.id.image20);
        image21 = findViewById(R.id.image21);
        image22 = findViewById(R.id.image22);
        image23 = findViewById(R.id.image23);
        image24 = findViewById(R.id.image24);

        image25 = findViewById(R.id.image25);
        image26 = findViewById(R.id.image26);
        image27 = findViewById(R.id.image27);
        image28 = findViewById(R.id.image28);
        image14 = findViewById(R.id.image14);

        image15 = findViewById(R.id.image15);
        image16 = findViewById(R.id.image16);
        image17 = findViewById(R.id.image17);
        image18 = findViewById(R.id.image18);
        image19 = findViewById(R.id.image19);


        changePlayerTurn1(1);

        image10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(0)) {
                    performAction((ImageView) v, 0);
                }
            }
        });
        image11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(1)) {
                    performAction((ImageView) v, 1);
                }
            }
        });
        image12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(2)) {
                    performAction((ImageView) v, 2);
                }
            }
        });
        image13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(3)) {
                    performAction((ImageView) v, 3);
                }
            }
        });
        image30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(4)) {
                    performAction((ImageView) v, 4);
                }
            }
        });
        image31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(5)) {
                    performAction((ImageView) v, 5);
                }
            }
        });
        image32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(6)) {
                    performAction((ImageView) v, 6);
                }
            }
        });
        image33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(7)) {
                    performAction((ImageView) v, 7);
                }
            }
        });
        image34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(8)) {
                    performAction((ImageView) v, 8);
                }
            }
        });

        image35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(9)) {
                    performAction((ImageView) v, 9);
                }
            }
        });
        image20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(10)) {
                    performAction((ImageView) v, 10);
                }
            }
        });
        image21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(11)) {
                    performAction((ImageView) v, 11);
                }
            }
        });
        image22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(12)) {
                    performAction((ImageView) v, 12);
                }
            }
        });
        image23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(13)) {
                    performAction((ImageView) v, 13);
                }
            }
        });
        image24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(14)) {
                    performAction((ImageView) v, 14);
                }
            }
        });
        image25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(15)) {
                    performAction((ImageView) v, 15);
                }
            }
        });
        image26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(16)) {
                    performAction((ImageView) v, 16);
                }
            }
        });
        image27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(17)) {
                    performAction((ImageView) v, 17);
                }
            }
        });
        image28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(18)) {
                    performAction((ImageView) v, 18);
                }
            }
        });
        image14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(19)) {
                    performAction((ImageView) v, 19);
                }
            }
        });
        image15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(20)) {
                    performAction((ImageView) v, 20);
                }
            }
        });
        image16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(21)) {
                    performAction((ImageView) v, 21);
                }
            }
        });
        image17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(22)) {
                    performAction((ImageView) v, 22);
                }
            }
        });
        image18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(23)) {
                    performAction((ImageView) v, 23);
                }
            }
        });
        image19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(24)) {
                    performAction((ImageView) v, 24);
                }
            }
        });
    }

    private void performAction(ImageView imageView, int SelectedBoxPosition) {
        boxPositions[SelectedBoxPosition] = activePlayer;
        imageView.setBackgroundResource(R.drawable.white_box5x5);
        imageView.setScaleType(ImageView.ScaleType.CENTER);

        playerOneName = findViewById(R.id.playerOneName);
        playerTwoName = findViewById(R.id.playerTwoName);

        TextView scorePlayerA = findViewById(R.id.scoreOne);
        TextView scorePlayerB = findViewById(R.id.scoreTwo);

        if (activePlayer == 1) {
            imageView.setImageResource(R.drawable.ximage1);

            if (checkResults()) {
                ResildDialog2 resildDialog2 = new ResildDialog2(PlayingField5x5.this,
                        playerOneName.getText().toString() + "is a Winner", PlayingField5x5.this);
                resildDialog2.setCancelable(false);
                resildDialog2.show();

                currentScoreOne++;
                scorePlayerA.setText(String.valueOf(currentScoreOne));//подсчет очков игрока 1


            } else if (totalSelectBoxes == 25) {

                ResildDialog2 resildDialog2 = new ResildDialog2(PlayingField5x5.this, "Match Draw", PlayingField5x5.this);
                resildDialog2.setCancelable(false);
                resildDialog2.show();
            } else {


                changePlayerTurn1(2);
                totalSelectBoxes++;
            }
        } else {
            imageView.setImageResource(R.drawable.oimage1);

            if (checkResults()) {
                ResildDialog2 resildDialog2 = new ResildDialog2(PlayingField5x5.this,
                        playerTwoName.getText().toString() + "is a Winner", PlayingField5x5.this);
                resildDialog2.setCancelable(false);
                resildDialog2.show();


                currentScoreTwo++;
                scorePlayerB.setText(String.valueOf(currentScoreTwo));//подсчет очков игрока 2

            } else if (totalSelectBoxes == 25) {

                ResildDialog2 resildDialog2 = new ResildDialog2(PlayingField5x5.this, "Match Draw", PlayingField5x5.this);
                resildDialog2.setCancelable(false);
                resildDialog2.show();
            } else {
                changePlayerTurn1(1);
                totalSelectBoxes++;
            }
        }
    }

    private boolean checkResults() {
        boolean response = false;
        for (int i = 0; i < combinationList.size(); i++) {
            final int[] combination = combinationList.get(i);

            if (boxPositions[combination[0]] == activePlayer && boxPositions[combination[1]] == activePlayer && boxPositions[combination[2]] == activePlayer
                    && boxPositions[combination[3]]==activePlayer&&boxPositions[combination[4]]==activePlayer) {
                response = true;
            }

        }
        return response;
    }

    private void changePlayerTurn1(int currentPlayerTurn) {
        activePlayer = currentPlayerTurn;

        LinearLayout playerOneLayoutOuter = findViewById(R.id.playerOneLayoutOuter);
        LinearLayout playerTwoLayoutOuter = findViewById(R.id.playerTwoLayoutOuter);

        if (activePlayer == 1) {
            playerOneLayoutOuter.setBackgroundResource(R.drawable.black_baorder);
            playerTwoLayoutOuter.setBackgroundResource(R.drawable.white_box5x5);

        } else {
            playerTwoLayoutOuter.setBackgroundResource(R.drawable.black_baorder);
            playerOneLayoutOuter.setBackgroundResource(R.drawable.white_box5x5);
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
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        activePlayer = 1;
        totalSelectBoxes = 1;

        image10 = findViewById(R.id.image10);
        image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12);
        image13 = findViewById(R.id.image13);
        image30 = findViewById(R.id.image30);

        image31 = findViewById(R.id.image31);
        image32 = findViewById(R.id.image32);
        image33 = findViewById(R.id.image33);
        image34 = findViewById(R.id.image34);
        image35 = findViewById(R.id.image35);

        image20 = findViewById(R.id.image20);
        image21 = findViewById(R.id.image21);
        image22 = findViewById(R.id.image22);
        image23 = findViewById(R.id.image23);
        image24 = findViewById(R.id.image24);

        image25 = findViewById(R.id.image25);
        image26 = findViewById(R.id.image26);
        image27 = findViewById(R.id.image27);
        image28 = findViewById(R.id.image28);
        image14 = findViewById(R.id.image14);

        image15 = findViewById(R.id.image15);
        image16 = findViewById(R.id.image16);
        image17 = findViewById(R.id.image17);
        image18 = findViewById(R.id.image18);
        image19 = findViewById(R.id.image19);

        image10.setImageResource(R.drawable.white_box5x5);
        image11.setImageResource(R.drawable.white_box5x5);
        image12.setImageResource(R.drawable.white_box5x5);
        image13.setImageResource(R.drawable.white_box5x5);
        image30.setImageResource(R.drawable.white_box5x5);
        image31.setImageResource(R.drawable.white_box5x5);
        image32.setImageResource(R.drawable.white_box5x5);
        image33.setImageResource(R.drawable.white_box5x5);
        image34.setImageResource(R.drawable.white_box5x5);
        image35.setImageResource(R.drawable.white_box5x5);
        image20.setImageResource(R.drawable.white_box5x5);
        image21.setImageResource(R.drawable.white_box5x5);
        image22.setImageResource(R.drawable.white_box5x5);
        image23.setImageResource(R.drawable.white_box5x5);
        image24.setImageResource(R.drawable.white_box5x5);
        image25.setImageResource(R.drawable.white_box5x5);
        image26.setImageResource(R.drawable.white_box5x5);
        image27.setImageResource(R.drawable.white_box5x5);
        image28.setImageResource(R.drawable.white_box5x5);
        image14.setImageResource(R.drawable.white_box5x5);
        image15.setImageResource(R.drawable.white_box5x5);
        image16.setImageResource(R.drawable.white_box5x5);
        image17.setImageResource(R.drawable.white_box5x5);
        image18.setImageResource(R.drawable.white_box5x5);
        image19.setImageResource(R.drawable.white_box5x5);
    }
}
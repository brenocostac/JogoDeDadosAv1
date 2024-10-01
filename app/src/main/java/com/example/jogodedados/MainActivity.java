package com.example.jogodedados;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewDice1, imageViewDice2;
    private TextView textViewWinner;
    private Random random;
    private int player1Wins = 0, player2Wins = 0, draws = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageViewDice1 = findViewById(R.id.imageViewDice1);
        imageViewDice2 = findViewById(R.id.imageViewDice2);
        textViewWinner = findViewById(R.id.textViewWinner);
        Button buttonRollDice = findViewById(R.id.buttonRollDice);
        Button buttonViewScore = findViewById(R.id.buttonViewScore);

        random = new Random();


        buttonRollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });


        buttonViewScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                intent.putExtra("player1Wins", player1Wins);
                intent.putExtra("player2Wins", player2Wins);
                intent.putExtra("draws", draws);
                startActivity(intent);
            }
        });
    }


    private void rollDice() {
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;

        setDiceImage(imageViewDice1, dice1);
        setDiceImage(imageViewDice2, dice2);

        if (dice1 > dice2) {
            textViewWinner.setText("VENCEDOR: Jogador 1");
            player1Wins++;
        } else if (dice2 > dice1) {
            textViewWinner.setText("VENCEDOR: Jogador 2");
            player2Wins++;
        } else {
            textViewWinner.setText("EMPATE");
            draws++;
        }
    }


    private void setDiceImage(ImageView imageView, int diceValue) {
        switch (diceValue) {
            case 1:
                imageView.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                imageView.setImageResource(R.drawable.dice_6);
                break;
        }
    }
}

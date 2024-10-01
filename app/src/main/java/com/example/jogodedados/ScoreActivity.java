package com.example.jogodedados;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    private TextView textViewPlayer1Score, textViewPlayer2Score, textViewDraws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


        textViewPlayer1Score = findViewById(R.id.textViewPlayer1Score);
        textViewPlayer2Score = findViewById(R.id.textViewPlayer2Score);
        textViewDraws = findViewById(R.id.textViewDraws);
        Button buttonReturn = findViewById(R.id.buttonReturn);


        Intent intent = getIntent();
        int player1Wins = intent.getIntExtra("player1Wins", 0);
        int player2Wins = intent.getIntExtra("player2Wins", 0);
        int draws = intent.getIntExtra("draws", 0);


        textViewPlayer1Score.setText("Jogador 1: " + player1Wins);
        textViewPlayer2Score.setText("Jogador 2: " + player2Wins);
        textViewDraws.setText("Empates: " + draws);


        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

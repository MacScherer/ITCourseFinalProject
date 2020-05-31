package com.example.trabson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.TextureView;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class EndActivity extends AppCompatActivity {
    TextView tv_ScoreFinal;
    TextView tv_Resultado;
    TextView tv_Nickname;
    TextView tv_Dificuldade;
    ImageView tv_Tier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        getSupportActionBar().hide();

        tv_Resultado = findViewById(R.id.resultadoFinal);
        tv_Nickname = findViewById(R.id.nickNameFinal);
        tv_ScoreFinal = findViewById(R.id.scoreTelaFinal);
        tv_Dificuldade = findViewById(R.id.dificuldadeFinal);
        tv_Tier = findViewById(R.id.Tier);

        int Correto = getIntent().getIntExtra("certo", 0);
        int Errado = getIntent().getIntExtra("errado", 0);
        int Score = getIntent().getIntExtra("score", 0);
        int Normal = getIntent().getIntExtra("normal", 0);
        int Dificil = getIntent().getIntExtra("dificil", 0);

        final String nickNameFinal = getIntent().getStringExtra("nome");

        tv_Resultado.setText("Respostas corretas: " + Correto + "\nRespostas erradas: " + Errado);
        tv_ScoreFinal.setText(String.valueOf(Score)); // SetText precisa converter String to Int
        tv_Nickname.setText(nickNameFinal);

        // Dificuldade escolhida
        if (Normal > Dificil){
            tv_Dificuldade.setText("NORMAL");
        }else{
            tv_Dificuldade.setText("DIFICIL");
        }

        // Ranking final
        if (Score >= 300){
            tv_Tier.setImageResource(R.drawable.bronze);
        }
        if (Score >= 500){
            tv_Tier.setImageResource(R.drawable.prata);
        }
        if (Score >= 800){
            tv_Tier.setImageResource(R.drawable.ouro);
        }
        if (Score >= 1100){
            tv_Tier.setImageResource(R.drawable.platina);
        }
        if (Score >= 1400){
            tv_Tier.setImageResource(R.drawable.diamante);
        }
        if (Score >= 1700){
            tv_Tier.setImageResource(R.drawable.mestre);
        }
        if (Score >= 2000){
            tv_Tier.setImageResource(R.drawable.challenger);
        }

        // Status do final de game
         if (Correto > Errado) {
            Toast.makeText(this, "VITORIA", Toast.LENGTH_LONG).show();
        }if (Correto == Errado) {
            Toast.makeText(this, "EMPATE", Toast.LENGTH_LONG).show();
        }if (Errado > Correto) {
            Toast.makeText(this, "DERROTA", Toast.LENGTH_LONG).show();
        }

    }
}

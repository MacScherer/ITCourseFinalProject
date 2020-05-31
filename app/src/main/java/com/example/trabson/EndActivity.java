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

        int valorCorreto = getIntent().getIntExtra("certo", 0);
        int valorErrado = getIntent().getIntExtra("errado", 0);
        int valorScore = getIntent().getIntExtra("score", 0);
        int dificuldadeNormal = getIntent().getIntExtra("normal", 0);
        int dificuldadeDificil = getIntent().getIntExtra("dificil", 0);

        final String nickNameFinal = getIntent().getStringExtra("nome");

        tv_Resultado.setText("Respostas corretas: " + valorCorreto + "\nRespostas erradas: " + valorErrado);
        tv_ScoreFinal.setText(String.valueOf(valorScore)); // SetText precisa converter String to Int
        tv_Nickname.setText(nickNameFinal);
        dificuldadeEscolhida(dificuldadeNormal, dificuldadeDificil);
        rankingFinal(valorScore);
        statusFinal(valorCorreto, valorErrado);

    }

    private void statusFinal(int valorCorreto, int valorErrado) {
        if (valorCorreto > valorErrado) {
           Toast.makeText(this, "VITORIA", Toast.LENGTH_LONG).show();
       }
        if (valorCorreto == valorErrado) {
            Toast.makeText(this, "EMPATE", Toast.LENGTH_LONG).show();
        }
        if (valorErrado > valorCorreto) {
            Toast.makeText(this, "DERROTA", Toast.LENGTH_LONG).show();
        }
    }

    private void rankingFinal(int valorScore) {
        if (valorScore >= 300){
            tv_Tier.setImageResource(R.drawable.bronze);
        }
        if (valorScore >= 500){
            tv_Tier.setImageResource(R.drawable.prata);
        }
        if (valorScore >= 800){
            tv_Tier.setImageResource(R.drawable.ouro);
        }
        if (valorScore >= 1100){
            tv_Tier.setImageResource(R.drawable.platina);
        }
        if (valorScore >= 1400){
            tv_Tier.setImageResource(R.drawable.diamante);
        }
        if (valorScore >= 1700){
            tv_Tier.setImageResource(R.drawable.mestre);
        }
        if (valorScore >= 2000){
            tv_Tier.setImageResource(R.drawable.challenger);
        }
    }

    private void dificuldadeEscolhida(int normal, int dificil) {
        if (normal > dificil){
            tv_Dificuldade.setText("NORMAL");
        }else{
            tv_Dificuldade.setText("DIFICIL");
        }
    }
}

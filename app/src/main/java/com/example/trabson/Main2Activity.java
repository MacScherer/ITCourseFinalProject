package com.example.trabson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main2Activity extends AppCompatActivity {
    TextView tv_nickname;
    TextView tv_score;
    TextView tv_questao;

    ImageView Tier;

    Button btnResposta1;
    Button btnResposta2;
    Button btnResposta3;
    Button btnResposta4;

    List<QuestionItem> questionItems; // Lista as Strings que recebem os botões

    int questaoAtual = 0;
    int valorScore = 0;
    int Certo = 0;
    int Errado = 0;
    int numNormal = 0;
    int numDificil = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide(); // Esconde barra de ações/voltar/menu
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final String paramNome = this.getIntent().getStringExtra("nomeInstanciado");
        final int dificuldadeNormal = getIntent().getIntExtra("Normal",0);
        final int dificuldadeDificil = getIntent().getIntExtra("Dificil",0);
        // Recebe os valores da tela passada

        tv_nickname = findViewById(R.id.txtNickname);
        tv_score = findViewById(R.id.txtScore);
        tv_questao = findViewById(R.id.txtPergunta);

        Tier = findViewById(R.id.imgTier); // Atribui o espaço para a imagem

        btnResposta1 = findViewById(R.id.btnOpcao1);
        btnResposta2 = findViewById(R.id.btnOpcao2);
        btnResposta3 = findViewById(R.id.btnOpcao3);
        btnResposta4 = findViewById(R.id.btnOpcao4);

        tv_nickname.setText(paramNome);
        tv_score.setText("Score " + valorScore);

        // Verificação de dificuldade escolhida
        if (dificuldadeNormal > dificuldadeDificil){
            numNormal++;
            questaoNormal();
        }else{
            questaoDificil();
            numDificil++;
        }


        Collections.shuffle(questionItems); //mexe nas questoes aleatoriamente

        setQuestaoTela(questaoAtual); //carrega primeira questao

        btnResposta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check se a questao ta certa
                if (questionItems.get(questaoAtual).getResposta1().equals(questionItems.get(questaoAtual).getCorreta())) {
                    //certo
                    Certo++;
                    valorScore += 100;
                    Toast.makeText(Main2Activity.this, "Resposta Certa!", Toast.LENGTH_SHORT).show();
                    tv_score.setText("Score " + valorScore);
                    if (valorScore == 300){
                        Tier.setImageResource(R.drawable.bronze);
                    }
                    if (valorScore == 500){
                        Tier.setImageResource(R.drawable.prata);
                    }
                    if (valorScore == 800){
                        Tier.setImageResource(R.drawable.ouro);
                    }
                    if (valorScore == 1100){
                        Tier.setImageResource(R.drawable.platina);
                    }
                    if (valorScore == 1400){
                        Tier.setImageResource(R.drawable.diamante);
                    }
                    if (valorScore == 1700){
                        Tier.setImageResource(R.drawable.mestre);
                    }
                    if (valorScore == 2000){
                        Tier.setImageResource(R.drawable.challenger);
                    }
                }else {
                    //errado
                    Errado++;
                    Toast.makeText(Main2Activity.this, "Resposta Errada! Resposta certa e " + questionItems.get(questaoAtual).getCorreta(), Toast.LENGTH_LONG).show();
                }

                //carrega proxima questao
                if (questaoAtual < questionItems.size()-1){
                    questaoAtual++;
                    setQuestaoTela(questaoAtual);
                }else {
                    //game over
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    intent.putExtra("certo", Certo);
                    intent.putExtra("errado", Errado);
                    intent.putExtra("score", valorScore);
                    intent.putExtra("nome", paramNome);
                    intent.putExtra("normal", numNormal);
                    intent.putExtra("dificil", numDificil);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnResposta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifica se a questão está certa
                if (questionItems.get(questaoAtual).getResposta2().equals(questionItems.get(questaoAtual).getCorreta())) {
                    //certo
                    Certo++;
                    Toast.makeText(Main2Activity.this, "Resposta Certa!", Toast.LENGTH_SHORT).show();
                    valorScore += 100;
                    tv_score.setText("Score " + valorScore);
                    if (valorScore == 300){
                        Tier.setImageResource(R.drawable.bronze);
                    }
                    if (valorScore == 500){
                        Tier.setImageResource(R.drawable.prata);
                    }
                    if (valorScore == 800){
                        Tier.setImageResource(R.drawable.ouro);
                    }
                    if (valorScore == 1100){
                        Tier.setImageResource(R.drawable.platina);
                    }
                    if (valorScore == 1400){
                        Tier.setImageResource(R.drawable.diamante);
                    }
                    if (valorScore == 1700){
                        Tier.setImageResource(R.drawable.mestre);
                    }
                    if (valorScore == 2000){
                        Tier.setImageResource(R.drawable.challenger);
                    }
                }else {
                    //errado
                    Errado++;
                    Toast.makeText(Main2Activity.this, "Resposta Errada! Resposta certa e " + questionItems.get(questaoAtual).getCorreta(), Toast.LENGTH_LONG).show();
                }

                //carrega proxima questao
                if (questaoAtual < questionItems.size()-1){
                    questaoAtual++;
                    setQuestaoTela(questaoAtual);
                }else {
                    //game over
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    intent.putExtra("certo", Certo);
                    intent.putExtra("errado", Errado);
                    intent.putExtra("score", valorScore);
                    intent.putExtra("nome", paramNome);
                    intent.putExtra("normal", numNormal);
                    intent.putExtra("dificil", numDificil);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnResposta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifica se a questão está certa
                if (questionItems.get(questaoAtual).getResposta3().equals(questionItems.get(questaoAtual).getCorreta())) {
                    //certo
                    Certo++;
                    Toast.makeText(Main2Activity.this, "Resposta Certa!", Toast.LENGTH_SHORT).show();
                    valorScore += 100;
                    tv_score.setText("Score " + valorScore);
                    if (valorScore == 300){
                        Tier.setImageResource(R.drawable.bronze);
                    }
                    if (valorScore == 500){
                        Tier.setImageResource(R.drawable.prata);
                    }
                    if (valorScore == 800){
                        Tier.setImageResource(R.drawable.ouro);
                    }
                    if (valorScore == 1100){
                        Tier.setImageResource(R.drawable.platina);
                    }
                    if (valorScore == 1400){
                        Tier.setImageResource(R.drawable.diamante);
                    }
                    if (valorScore == 1700){
                        Tier.setImageResource(R.drawable.mestre);
                    }
                    if (valorScore == 2000){
                        Tier.setImageResource(R.drawable.challenger);
                    }
                }else {
                    //errado
                    Errado++;
                    Toast.makeText(Main2Activity.this, "Resposta Errada! Resposta certa e " + questionItems.get(questaoAtual).getCorreta(), Toast.LENGTH_LONG).show();
                }

                //carrega proxima questao
                if (questaoAtual < questionItems.size()-1){
                    questaoAtual++;
                    setQuestaoTela(questaoAtual);
                }else {
                    //game over
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    intent.putExtra("certo", Certo);
                    intent.putExtra("errado", Errado);
                    intent.putExtra("score", valorScore);
                    intent.putExtra("nome", paramNome);
                    intent.putExtra("normal", numNormal);
                    intent.putExtra("dificil", numDificil);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnResposta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Verifica se a questão está certa
                if (questionItems.get(questaoAtual).getResposta4().equals(questionItems.get(questaoAtual).getCorreta())) {
                    //certo
                    Certo++;
                    Toast.makeText(Main2Activity.this, "Resposta Certa!", Toast.LENGTH_SHORT).show();
                    valorScore += 100;
                    tv_score.setText("Score " + valorScore);
                    if (valorScore == 300){
                        Tier.setImageResource(R.drawable.bronze);
                    }
                    if (valorScore == 500){
                        Tier.setImageResource(R.drawable.prata);
                    }
                    if (valorScore == 800){
                        Tier.setImageResource(R.drawable.ouro);
                    }
                    if (valorScore == 1100){
                        Tier.setImageResource(R.drawable.platina);
                    }
                    if (valorScore == 1400){
                        Tier.setImageResource(R.drawable.diamante);
                    }
                    if (valorScore == 1700){
                        Tier.setImageResource(R.drawable.mestre);
                    }
                    if (valorScore == 2000){
                        Tier.setImageResource(R.drawable.challenger);
                    }
                }else {
                    //errado
                    Errado++;
                    Toast.makeText(Main2Activity.this, "Resposta Errada! Resposta certa e " + questionItems.get(questaoAtual).getCorreta(), Toast.LENGTH_LONG).show();
                }

                //carrega proxima questao
                if (questaoAtual < questionItems.size()-1){
                    questaoAtual++;
                    setQuestaoTela(questaoAtual);
                }else {
                    //game over
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    intent.putExtra("certo", Certo);
                    intent.putExtra("errado", Errado);
                    intent.putExtra("score", valorScore);
                    intent.putExtra("nome", paramNome);
                    intent.putExtra("normal", numNormal);
                    intent.putExtra("dificil", numDificil);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    // Prepara as questoes pra tela
    private void setQuestaoTela(int number){
        tv_questao.setText(questionItems.get(number).getQuestao());
        btnResposta1.setText(questionItems.get(number).getResposta1());
        btnResposta2.setText(questionItems.get(number).getResposta2());
        btnResposta3.setText(questionItems.get(number).getResposta3());
        btnResposta4.setText(questionItems.get(number).getResposta4());
    }
    // Lista dificil
    private void questaoDificil(){
        questionItems = new ArrayList<>();
        //Carrega json na string

        String jsonStr = carregaJSONAsset("questoesDificil.json");
        //Carrega todos os dados na lista
        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray questoes = jsonObj.getJSONArray("questoes");
            for (int i = 0 ; i < questoes.length(); i++){
                JSONObject questao = questoes.getJSONObject(i);

                String questaoString = questao.getString("questao");
                String resposta1String = questao.getString("resposta1");
                String resposta2String = questao.getString("resposta2");
                String resposta3String = questao.getString("resposta3");
                String resposta4String = questao.getString("resposta4");
                String corretaString = questao.getString("correta");

                questionItems.add(new QuestionItem(
                        questaoString,
                        resposta1String,
                        resposta2String,
                        resposta3String,
                        resposta4String,
                        corretaString
                ));
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    // Lista normal
    private void questaoNormal(){
        questionItems = new ArrayList<>();
        //Carrega json na string

        String jsonStr = carregaJSONAsset("questoesNormal.json");
        //Carrega todos os dados na lista
        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray questoes = jsonObj.getJSONArray("questoes");
            for (int i = 0 ; i < questoes.length(); i++){ //Número de questões que aparecem na tela
                JSONObject questao = questoes.getJSONObject(i);

                String questaoString = questao.getString("questao");
                String resposta1String = questao.getString("resposta1");
                String resposta2String = questao.getString("resposta2");
                String resposta3String = questao.getString("resposta3");
                String resposta4String = questao.getString("resposta4");
                String corretaString = questao.getString("correta");

                questionItems.add(new QuestionItem(
                        questaoString,
                        resposta1String,
                        resposta2String,
                        resposta3String,
                        resposta4String,
                        corretaString
                ));
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    //Carrega JSON do Assets
    private String carregaJSONAsset(String file){
        String json = "";
        try {
            InputStream is = getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }
}

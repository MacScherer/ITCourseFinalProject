package com.example.trabson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   EditText campoNome;
   Button btnStart;
   Button btnNormal;
   Button btnDificil;
   int difNormal = 0; // Redundância para o valor ser 0 e não ocorrer bugs como valores aleatórios
   int difDificil = 0; // Booleano deu problemas
   // Declarações de variáveis e objetos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide(); // Esconde barra de ações
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Monta a tela atual

        btnStart = findViewById(R.id.botaoStart);
        btnNormal = findViewById(R.id.botaoNormal);
        btnDificil = findViewById(R.id.botaoDificil);
        // Construindo botao associado com objeto
        campoNome = findViewById(R.id.campoTextNome);
        // Construção de campo associado com objeto
    }

    public  void verificaInfo(View v) {
            if (!campoNome.getText().toString().equals("")) { // Se o campo for Preenchido  é verdadeiro
                if (difNormal > difDificil){ //  Var numérica INT
                    Intent intent = new Intent(this, Main2Activity.class); //Chama a tela
                    String paramNickname = campoNome.getText().toString();
                    intent.putExtra("Normal", difNormal); // Passa o valor numérico 0 ou 1 para a próxima tela
                    intent.putExtra("nomeInstanciado", paramNickname);
                    startActivity(intent); // Inicia a próxima tela
                }else {
                    Intent intent = new Intent(this, Main2Activity.class); //Chama a tela
                    String paramNickname = campoNome.getText().toString();
                    intent.putExtra("nomeInstanciado", paramNickname);
                    intent.putExtra("Dificil", difDificil);
                    startActivity(intent);
                }
            }else{ // Campo vazio
                Toast.makeText(this, "Campo vazio, insira seu nome", Toast.LENGTH_SHORT).show();
            }
    }

    public void setNormalDificulty (View v){
        btnDificil.setAlpha(0.5f); // Aparência de botão inativo, porém pode ser clicável
        btnNormal.setAlpha(0.8f);  // Aparência de botão ativo
        difNormal++; // Adição de valor na var
        difDificil *= 0; // Zera a variável
    }
    public void setHardDificulty (View v) {
        btnNormal.setAlpha(0.5f);
        btnDificil.setAlpha(0.8f);
        difDificil++;
        difNormal *= 0;
    }


}


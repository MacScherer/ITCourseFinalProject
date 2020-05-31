package com.example.trabson;

public class QuestionItem {

    private String questao, resposta1, resposta2, resposta3, resposta4, correta;

    public QuestionItem(String questao, String resposta1, String resposta2, String resposta3, String resposta4, String correta) {
        this.questao = questao;
        this.resposta1 = resposta1;
        this.resposta2 = resposta2;
        this.resposta3 = resposta3;
        this.resposta4 = resposta4;
        this.correta = correta;
    }

    public String getQuestao() {
        return questao;
    }

    public String getResposta1() {
        return resposta1;
    }

    public String getResposta2() {
        return resposta2;
    }

    public String getResposta3() {
        return resposta3;
    }

    public String getResposta4() {
        return resposta4;
    }

    public String getCorreta() {
        return correta;
    }
}

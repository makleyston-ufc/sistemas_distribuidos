package com.example.exemplomodelos_de_comunicacao;

import android.widget.TextView;

public class PrecisaCalcular {
    TextView tv;
    public PrecisaCalcular(TextView tv){
        this.tv=tv;
    }

    /* Seleção da operação matemática desejada com base no parâmetro "mathOperation".
    *  Pra cada operação é feita uma chamada específica para atender a solicitação.
    *  O resultado é armazenado em uma variável que é, posteriormente, apresentada no tv
    *  por meio do "showResult". */
    public void calculoLocal(int mathOperation, double value1, double value2){
        Calculadora calc = new Calculadora();
        String result = "";
        switch (mathOperation){
            case MathOperation.SUM:
                result = calc.soma(value1, value2)+"";
                break;
            case MathOperation.SUBTRACTION:
                result = calc.substracao(value1, value2)+"";
                break;
            case MathOperation.MULTIPLICATION:
                result = calc.multiplicacao(value1, value2)+"";
                break;
            case MathOperation.DIVISION:
                result = calc.divisao(value1, value2)+"";
                break;

        }
        this.showResult(result);
    }

    /* Seleção da operação matemática desejada com base no parâmetro "mathOperation".
     * a apresentação no TextView é feira pelo "posexecute" do "CalculadoraSocket". */
    public void calculoRemoto(int mathOperation, double value1, double value2){
        CalculadoraSocket shs = new CalculadoraSocket(this, mathOperation, value1+"", value2+"");
        shs.execute();

    }

    /* Seleção da operação matemática desejada com base no parâmetro "mathOperation".
     * a apresentação no TextView é feira pelo "posexecute" do "CalculadoraHttpPOST". */
    public void calculoRemotoHTTP(int mathOperation, double value1, double value2){
        CalculadoraHttpPOST shs = new CalculadoraHttpPOST(this, mathOperation, value1+"", value2+"");
        shs.execute();

    }
    public void showResult(String result){
        tv.setText(result);
    }

    /* Definição dos métodos implementados. */
    static class MathOperation{
        public final static int SUM = 0;
        public final static int SUBTRACTION = 1;
        public final static int DIVISION = 2;
        public final static int MULTIPLICATION = 3;
    }

}

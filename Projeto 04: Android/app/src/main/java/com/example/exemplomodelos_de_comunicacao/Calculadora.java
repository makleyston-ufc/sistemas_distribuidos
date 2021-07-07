package com.example.exemplomodelos_de_comunicacao;

public class Calculadora {
    public String sayHello(String nome, String sobrenome) {
        return "Fala "+ nome + " " + sobrenome;
    }
    public double soma(double oper1, double oper2) {
        return oper1 + oper2;
    }

    /* Os demais métodos da calculadora local foram implementados. */
    public double substracao(double oper1, double oper2) {
        return oper1 - oper2;
    }
    public double divisao(double oper1, double oper2) {
        return oper1 / oper2;
    }
    public double multiplicacao(double oper1, double oper2) {
        return oper1 * oper2;
    }
}

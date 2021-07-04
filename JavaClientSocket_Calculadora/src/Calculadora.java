public class Calculadora {
    public String sayHello(String nome, String sobrenome) {
        return "Fala "+ nome + " " + sobrenome;
    }
    public double soma(double oper1, double oper2) {
        return oper1 + oper2;
    }
    // Método de subtração da calculadora
    public double sub(double oper1, double oper2) {
        return oper1 - oper2;
    }
    // Método de divisão da calculadora
    public double div(double oper1, double oper2) {
        return oper1 / oper2;
    }
    // Método de multiplicação da calculadora
    public double mult(double oper1, double oper2) {
        return oper1 * oper2;
    }
}
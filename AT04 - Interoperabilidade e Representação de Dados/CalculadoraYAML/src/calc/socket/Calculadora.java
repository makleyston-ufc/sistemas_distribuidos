package calc.socket;

import calc.Expressao;

public class Calculadora {
    
    public double soma(double oper1, double oper2) {
        return oper1 + oper2;
    }
    
    public double sub(double oper1, double oper2) {
        return oper1 - oper2;
    }
    
    public double div(double oper1, double oper2) {
        return oper1 / oper2;
    }
    
    public double mult(double oper1, double oper2) {
        return oper1 * oper2;
    }
    
    private double mathOperator(Expressao exp){
//        System.out.println(exp.getMathOperator()+"<<");
        switch(exp.getMathOperator()){
            case "*":
                return mult(exp.getNumberLeft().getValue(), exp.getNumberRight().getValue());
            case "+":
                return soma(exp.getNumberLeft().getValue(), exp.getNumberRight().getValue());
            case "-":
                return sub(exp.getNumberLeft().getValue(), exp.getNumberRight().getValue());
            case "/":
                return div(exp.getNumberLeft().getValue(), exp.getNumberRight().getValue());
            default:
                return 0;
        }
    }
    
    public double calculate(Expressao exp) {
        if((exp.getNumberLeft() != null) && (exp.getNumberRight() != null))
            return mathOperator(exp);
        
        if (exp.getLeft() != null)
            exp.setNumberLeft(new calc.Number(calculate(exp.getLeft())));
        
        if(exp.getRight() != null)
            exp.setNumberRight(new calc.Number(calculate(exp.getRight()))); 
        
        return calculate(exp);   
    }
}

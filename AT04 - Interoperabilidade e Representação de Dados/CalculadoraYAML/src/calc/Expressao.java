/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

/**
 *
 * @author makleyston
 */
public class Expressao { //Ex.: ((5 × 9) + 9) ÷ (5 − 3)
    
    private Expressao left;
    private Expressao right;   
    private String mathOperator;
    private Number numberLeft;
    private Number numberRight;
    
    public String getMathOperator() {
        return mathOperator;
    }

    public void setMathOperator(String mathOperator) {
        this.mathOperator = mathOperator;
    }
    
    public Expressao getLeft() {
        return left;
    }

    public void setLeft(Expressao left) {
        this.left = left;
    }

    public Expressao getRight() {
        return right;
    }

    public void setRight(Expressao right) {
        this.right = right;
    }

    public Number getNumberLeft() {
        return numberLeft;
    }

    public void setNumberLeft(Number numberLeft) {
        this.numberLeft = numberLeft;
    }

    public Number getNumberRight() {
        return numberRight;
    }

    public void setNumberRight(Number numberRight) {
        this.numberRight = numberRight;
    }
    
    
    private void create(String s){
        Expressao exp = new Expressao();
        
    }
    
    public void getYAML(){
        
        
    }
}

package calc.socket;

import calc.Expressao;
import java.util.Stack;

public class TreeBuild {
    final String[] tokens;

    public TreeBuild(String expressao) {
        this.tokens = expressao.split(" ");
    }

    public Expressao build() {
        Stack<Expressao> pilha = new Stack<>();

        Expressao exp = new Expressao();
        pilha.push(exp);
        for (String token : tokens) {
//            System.out.println(token+"<<");
            switch (token) { //"( ( 5 * 9 ) + 9 ) / ( 5 - 3 )"
                case "(":
                    pilha.push(new Expressao());
                    break;
                case "+":
                    pilha.peek().setMathOperator(token);
                    break;
                case "-":
                    pilha.peek().setMathOperator(token);
                    break;
                case "*":
                    pilha.peek().setMathOperator(token);
                    break;
                case "/":
                    pilha.peek().setMathOperator(token);
                    break;
                case ")":
                    Expressao e = pilha.pop();
                    if(pilha.peek().getLeft() == null)
                        pilha.peek().setLeft(e);
                    else
                        pilha.peek().setRight(e);
//                    pilha.empty();
                    break;
                default:
//                    System.out.println(token+"***");
                    calc.Number number = new calc.Number(Double.parseDouble(token));
                    if((pilha.peek().getLeft() == null) && (pilha.peek().getNumberLeft() == null))
                        pilha.peek().setNumberLeft(number);
                    else
                        pilha.peek().setNumberRight(number);
                    break;
            }
        }

        return exp;
    }
}

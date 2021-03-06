import java.util.Stack;

public class TreeBuild {
    final String[] tokens;

    public TreeBuild(String expressao) {
        this.tokens = expressao.split(" ");
    }

    public ExpressaoOuterClass.Expressao build() {
        Stack<ExpressaoOuterClass.Expressao.Builder> pilha = new Stack<>();

        ExpressaoOuterClass.Expressao.Builder atual;
        for (String token : tokens) {
            switch (token) {
                case "(":
                    atual = ExpressaoOuterClass.Expressao.newBuilder();
                    pilha.push(atual);
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    pilha.peek().setOperacao(token);
                    break;
                case ")":
                    ExpressaoOuterClass.Expressao exp = pilha.pop().build();
                    if (pilha.empty()) {
                        return exp;
                    }
                    atual = pilha.peek();
                    if (atual.hasO1() || atual.hasLeft()) {
                    	atual.setRight(exp);
                    } else {
                    	atual.setLeft(exp);
                    }
                    break;
                default:
                    atual = pilha.peek();
                    if (atual.hasO1() || atual.hasLeft()) {
                    	atual.setO2(Double.parseDouble(token));
                    } else {
                    	atual.setO1(Double.parseDouble(token));
                    }
                    break;
            }
        }

        return null;
    }
}

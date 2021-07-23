import java.util.Stack;

public class TreeBuild {
    final String[] tokens;
    final int ponteiro;
    ExpressaoOuterClass.Expressao.Builder raiz;

    public TreeBuild(String expressao) {
        this.tokens = expressao.split(" ");
        this.ponteiro = 0;
    }

    public ExpressaoOuterClass.Expressao build() {
        raiz = ExpressaoOuterClass.Expressao.newBuilder();
        Stack<ExpressaoOuterClass.Expressao.Builder> pilha = new Stack<>();

        ExpressaoOuterClass.Expressao.Builder atual;
        for (String token : tokens) {
//            System.out.println(token);
            switch (token) {
                case "(":
                    atual = ExpressaoOuterClass.Expressao.newBuilder();
                    pilha.push(atual);
//                    System.out.println("pilha size: " + pilha.size());
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    pilha.peek().setOperacao(token);
                    break;
                case ")":
                    ExpressaoOuterClass.Expressao exp = pilha.pop().build();
//                    System.out.println("pilha size: " + pilha.size());
                    if (pilha.empty()) {
//                        System.out.println("Cheguei aqui");
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

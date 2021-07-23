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
    public double calculate(ExpressaoOuterClass.Expressao arvore) {
        double result;
        if(arvore.hasLeft()) {
            result = calculate(arvore.getLeft());
            arvore = arvore.toBuilder().clone().clearLeft().setO1(result).build();
        }
        if(arvore.hasRight()) {
            result = calculate(arvore.getRight());
            arvore = arvore.toBuilder().clone().clearRight().setO2(result).build();
        }
        switch (arvore.getOperacao()) {
            case "+":
                result = soma(arvore.getO1(), arvore.getO2());
                break;
            case "-":
                result = sub(arvore.getO1(), arvore.getO2());
                break;
            case "*":
                result = mult(arvore.getO1(), arvore.getO2());
                break;
            case "/":
                result = div(arvore.getO1(), arvore.getO2());
                break;
            default:
                result = -1;
        }
        return result;
    }
}

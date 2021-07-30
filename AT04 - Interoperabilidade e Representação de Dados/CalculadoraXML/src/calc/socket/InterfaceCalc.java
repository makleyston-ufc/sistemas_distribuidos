package calc.socket;

import javax.swing.*;

public class InterfaceCalc extends JFrame {

    final JButton btnNumero0;
    final JButton btnNumero1;
    final JButton btnNumero2;
    final JButton btnNumero3;
    final JButton btnNumero4;
    final JButton btnNumero5;
    final JButton btnNumero6;
    final JButton btnNumero7;
    final JButton btnNumero8;
    final JButton btnNumero9;
    final JButton btnPonto;
    final JButton btnDeletar;
    final JButton btnLimpar;
    final JButton btnParentesAbrindo;
    final JButton btnParentesFechando;

    public JButton btnIgual;
    public JButton btnSomar;
    public JButton btnDividir;
    public JButton btnSubtrair;
    public JButton btnMultiplicar;

    public JTextField display;

    public double leitura;
    public double operando;
    public double dot;
    public boolean isdot;

    public InterfaceCalc() {
        this.setTitle("Calculadora Remota");
        this.setBounds(200, 100, 295, 490); // x, y, width, height
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        this.dot = 0;
        this.leitura = 0;
        this.operando = 0;
        this.isdot = false;

        // Linha 0 ['0', '.', '=', '-']
        this.btnNumero0 = new JButton();
        this.btnNumero0.setText("0");
        this.btnNumero0.setBounds(10, 370, 65, 65);
        this.add(this.btnNumero0);

        this.btnPonto = new JButton();
        this.btnPonto.setText(".");
        this.btnPonto.setBounds(80, 370, 65, 65);
        this.add(this.btnPonto);

        this.btnIgual = new JButton();
        this.btnIgual.setText("=");
        this.btnIgual.setBounds(150, 370, 65, 65);
        this.add(this.btnIgual);

        this.btnSubtrair = new JButton();
        this.btnSubtrair.setText("-");
        this.btnSubtrair.setBounds(220, 370, 65, 65);
        this.add(this.btnSubtrair);

        // Linha 1 ['1', '2', '3', '+']
        this.btnNumero1 = new JButton();
        this.btnNumero1.setText("1");
        this.btnNumero1.setBounds(10, 300, 65, 65);
        this.add(this.btnNumero1);

        this.btnNumero2 = new JButton();
        this.btnNumero2.setText("2");
        this.btnNumero2.setBounds(80, 300, 65, 65);
        this.add(this.btnNumero2);

        this.btnNumero3 = new JButton();
        this.btnNumero3.setText("3");
        this.btnNumero3.setBounds(150, 300, 65, 65);
        this.add(this.btnNumero3);

        this.btnSomar = new JButton();
        this.btnSomar.setText("+");
        this.btnSomar.setBounds(220, 300, 65, 65);
        this.add(this.btnSomar);

        // Linha 2 ['4', '5', '6', '/']
        this.btnNumero4 = new JButton();
        this.btnNumero4.setText("4");
        this.btnNumero4.setBounds(10, 230, 65, 65);
        this.add(this.btnNumero4);

        this.btnNumero5 = new JButton();
        this.btnNumero5.setText("5");
        this.btnNumero5.setBounds(80, 230, 65, 65);
        this.add(this.btnNumero5);

        this.btnNumero6 = new JButton();
        this.btnNumero6.setText("6");
        this.btnNumero6.setBounds(150, 230, 65, 65);
        this.add(this.btnNumero6);

        this.btnDividir = new JButton();
        this.btnDividir.setText("/");
        this.btnDividir.setBounds(220, 230, 65, 65);
        this.add(this.btnDividir);

        // Linha 3 ['7', '8', '9', '*']
        this.btnNumero7 = new JButton();
        this.btnNumero7.setText("7");
        this.btnNumero7.setBounds(10, 160, 65, 65);
        this.add(this.btnNumero7);

        this.btnNumero8 = new JButton();
        this.btnNumero8.setText("8");
        this.btnNumero8.setBounds(80, 160, 65, 65);
        this.add(this.btnNumero8);

        this.btnNumero9 = new JButton();
        this.btnNumero9.setText("9");
        this.btnNumero9.setBounds(150, 160, 65, 65);
        this.add(this.btnNumero9);

        this.btnMultiplicar = new JButton();
        this.btnMultiplicar.setText("*");
        this.btnMultiplicar.setBounds(220, 160, 65, 65);
        this.add(this.btnMultiplicar);

        // Linha 4 ['(', ')', '<', 'C']
        this.btnParentesAbrindo = new JButton();
        this.btnParentesAbrindo.setText("(");
        this.btnParentesAbrindo.setBounds(10, 90, 65, 65);
        this.add(this.btnParentesAbrindo);

        this.btnParentesFechando = new JButton();
        this.btnParentesFechando.setText(")");
        this.btnParentesFechando.setBounds(80, 90, 65, 65);
        this.add(this.btnParentesFechando);

        this.btnDeletar = new JButton();
        this.btnDeletar.setText("<");
        this.btnDeletar.setBounds(150, 90, 65, 65);
        this.add(this.btnDeletar);

        this.btnLimpar = new JButton();
        this.btnLimpar.setText("C");
        this.btnLimpar.setBounds(220, 90, 65, 65);
        this.add(this.btnLimpar);

        // Linha 5 [TEXTO]
        this.display = new JTextField();
        this.display.setBounds(10, 20, 275, 65);
        this.add(this.display);

        this.btnNumero1.addActionListener((event) -> display.setText(display.getText() + "1"));
        this.btnNumero2.addActionListener((event) -> display.setText(display.getText() + "2"));
        this.btnNumero3.addActionListener((event) -> display.setText(display.getText() + "3"));
        this.btnNumero4.addActionListener((event) -> display.setText(display.getText() + "4"));
        this.btnNumero5.addActionListener((event) -> display.setText(display.getText() + "5"));
        this.btnNumero6.addActionListener((event) -> display.setText(display.getText() + "6"));
        this.btnNumero7.addActionListener((event) -> display.setText(display.getText() + "7"));
        this.btnNumero8.addActionListener((event) -> display.setText(display.getText() + "8"));
        this.btnNumero9.addActionListener((event) -> display.setText(display.getText() + "9"));
        this.btnNumero0.addActionListener((event) -> display.setText(display.getText() + "0"));

        this.btnParentesAbrindo.addActionListener((event) -> display.setText(display.getText() + "( "));
        this.btnParentesFechando.addActionListener((event) -> display.setText(display.getText() + " )"));

        this.btnPonto.addActionListener((event) -> display.setText(display.getText() + "."));
        this.btnLimpar.addActionListener((event) -> display.setText(""));
        this.btnDeletar.addActionListener((event) -> display.setText(display.getText().substring(0, display.getText().length()-1)));

        this.btnSomar.addActionListener((event) -> display.setText(display.getText() + " + "));
        this.btnSubtrair.addActionListener((event) -> display.setText(display.getText() + " - "));
        this.btnMultiplicar.addActionListener((event) -> display.setText(display.getText() + " * "));
        this.btnDividir.addActionListener((event) -> display.setText(display.getText() + " / "));
    }

    public void setDisplay(String txt) {
        this.display.setText(txt);
    }
}

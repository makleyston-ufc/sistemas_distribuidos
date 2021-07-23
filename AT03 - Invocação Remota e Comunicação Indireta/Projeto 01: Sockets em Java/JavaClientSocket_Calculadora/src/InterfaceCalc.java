import javax.swing.*;
import java.awt.event.*;

public class InterfaceCalc extends JFrame {

    private JButton numero0;
    private JButton numero1;
    private JButton numero2;
    private JButton numero3;
    private JButton numero4;
    private JButton numero5;
    private JButton numero6;
    private JButton numero7;
    private JButton numero8;
    private JButton numero9;
    private JButton numeroP;
    private JButton numeroD;

    public JButton igual;
    public JButton somar;
    public JButton dividir;
    public JButton subtrair;
    public JButton multiplicar;

    public JTextField display;

    public int operacao;
    public double leitura;
    public double operando;
    public double dot;
    public boolean isdot;

    public InterfaceCalc() {

        this.setTitle("Calculadora Remota");
        this.setBounds(500, 300, 295, 420); // x, y, width, height
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        this.dot = 0;
        this.leitura = 0;
        this.operando = 0;
        this.isdot = false;

        // Linha 0 ['0', '.', '=', '-']
        this.numero0 = new JButton();
        this.numero0.setText("0");
        this.numero0.setBounds(10, 300, 65, 65);
        this.add(this.numero0);

        this.numeroP = new JButton();
        this.numeroP.setText(".");
        this.numeroP.setBounds(80, 300, 65, 65);
        this.add(this.numeroP);

        this.igual = new JButton();
        this.igual.setText("=");
        this.igual.setBounds(150, 300, 65, 65);
        this.add(this.igual);

        this.subtrair = new JButton();
        this.subtrair.setText("-");
        this.subtrair.setBounds(220, 300, 65, 65);
        this.add(this.subtrair);

        // Linha 1 ['1', '2', '3', '+']
        this.numero1 = new JButton();
        this.numero1.setText("1");
        this.numero1.setBounds(10, 230, 65, 65);
        this.add(this.numero1);

        this.numero2 = new JButton();
        this.numero2.setText("2");
        this.numero2.setBounds(80, 230, 65, 65);
        this.add(this.numero2);

        this.numero3 = new JButton();
        this.numero3.setText("3");
        this.numero3.setBounds(150, 230, 65, 65);
        this.add(this.numero3);

        this.somar = new JButton();
        this.somar.setText("+");
        this.somar.setBounds(220, 230, 65, 65);
        this.add(this.somar);

        // Linha 2 ['4', '5', '6', '/']
        this.numero4 = new JButton();
        this.numero4.setText("4");
        this.numero4.setBounds(10, 160, 65, 65);
        this.add(this.numero4);

        this.numero5 = new JButton();
        this.numero5.setText("5");
        this.numero5.setBounds(80, 160, 65, 65);
        this.add(this.numero5);

        this.numero6 = new JButton();
        this.numero6.setText("6");
        this.numero6.setBounds(150, 160, 65, 65);
        this.add(this.numero6);

        this.dividir = new JButton();
        this.dividir.setText("/");
        this.dividir.setBounds(220, 160, 65, 65);
        this.add(this.dividir);

        // Linha 3 ['7', '8', '9', '*']
        this.numero7 = new JButton();
        this.numero7.setText("7");
        this.numero7.setBounds(10, 90, 65, 65);
        this.add(this.numero7);

        this.numero8 = new JButton();
        this.numero8.setText("8");
        this.numero8.setBounds(80, 90, 65, 65);
        this.add(this.numero8);

        this.numero9 = new JButton();
        this.numero9.setText("9");
        this.numero9.setBounds(150, 90, 65, 65);
        this.add(this.numero9);

        this.multiplicar = new JButton();
        this.multiplicar.setText("*");
        this.multiplicar.setBounds(220, 90, 65, 65);
        this.add(this.multiplicar);

        // Linha 4 ['AC']
        this.display = new JTextField();
        this.display.setBounds(10, 20, 205, 65);
        this.add(this.display);

        this.numeroD = new JButton();
        this.numeroD.setText("AC");
        this.numeroD.setBounds(220, 20, 65, 65);
        this.add(this.numeroD);

        this.numero1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                leitura *= 10;
                leitura += 1;
                display.setText(display.getText() + "1");
            }
        });

        this.numero2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                leitura *= 10;
                leitura += 2;
                display.setText(display.getText() + "2");
            }
        });

        this.numero3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                leitura *= 10;
                leitura += 3;
                display.setText(display.getText() + "3");
            }
        });

        this.numero4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                leitura *= 10;
                leitura += 4;
                display.setText(display.getText() + "4");
            }
        });

        this.numero5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                leitura *= 10;
                leitura += 5;
                display.setText(display.getText() + "5");
            }
        });

        this.numero6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                leitura *= 10;
                leitura += 6;
                display.setText(display.getText() + "6");
            }
        });

        this.numero7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                leitura *= 10;
                leitura += 7;
                display.setText(display.getText() + "7");
            }
        });

        this.numero8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                leitura *= 10;
                leitura += 8;
                display.setText(display.getText() + "8");
            }
        });

        this.numero9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                leitura *= 10;
                leitura += 9;
                display.setText(display.getText() + "9");
            }
        });

        this.numero0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                leitura *= 10;
                leitura += 0;
                display.setText(display.getText() + "0");
            }
        });

        this.numeroP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dot = leitura; leitura = 0; isdot = true;
                display.setText(display.getText() + ".");
            }
        });

        this.numeroD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                operando = 0; dot = 0; leitura = 0; isdot = false;
                display.setText("");
            }
        });

        this.somar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    leitura = Double.parseDouble(display.getText());
                    operacao = MathOperation.SUM;
                    operando = isdot ? dot + leitura / 10 : leitura;
                    dot = 0; leitura = 0; isdot = false;
                    display.setText(operando + " + ");
                } catch (Exception e) {
                    igual.doClick();
                }
            }
        });

        this.subtrair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    leitura = Double.parseDouble(display.getText());
                    operacao = MathOperation.SUBTRACTION;
                    operando = isdot ? dot + leitura / 10 : leitura;
                    dot = 0; leitura = 0; isdot = false;
                    display.setText(operando + " - ");
                } catch (Exception e) {
                    igual.doClick();
                }
            }
        });

        this.multiplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    leitura = Double.parseDouble(display.getText());
                    operacao = MathOperation.MULTIPLICATION;
                    operando = isdot ? dot + leitura / 10 : leitura;
                    dot = 0; leitura = 0; isdot = false;
                    display.setText(operando + " X ");
                } catch (Exception e) {
                    igual.doClick();
                }
            }
        });

        this.dividir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    leitura = Double.parseDouble(display.getText());
                    operacao = MathOperation.DIVISION;
                    operando = isdot ? dot + leitura / 10 : leitura;
                    dot = 0; leitura = 0; isdot = false;
                    display.setText(operando + " / ");
                } catch (Exception e) {
                    igual.doClick();
                }
            }
        });
    }

    public double getOper1() {
        return this.operando;
    }

    public double getOper2() {
        return this.isdot ? this.dot + this.leitura / 10 : this.leitura;
    }

    public int getOperacao() {
        return this.operacao;
    }

    public void setDisplay(String txt) {
        this.display.setText(txt);
    }

    public void resetVariaveis() {
        this.dot = 0;
        this.leitura = 0;
        this.isdot = false;
    }

    static class MathOperation{
        public final static int SUM = 1;
        public final static int SUBTRACTION = 2;
        public final static int MULTIPLICATION = 3;
        public final static int DIVISION = 4;
    }
}
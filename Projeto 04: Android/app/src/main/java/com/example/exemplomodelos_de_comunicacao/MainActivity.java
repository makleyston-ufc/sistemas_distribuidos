package com.example.exemplomodelos_de_comunicacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    RadioGroup radioGroup;

    Button numero0;
    Button numero1;
    Button numero2;
    Button numero3;
    Button numero4;
    Button numero5;
    Button numero6;
    Button numero7;
    Button numero8;
    Button numero9;
    Button numeroP;
    Button numeroD;

    Button btnSomar;
    Button btnSubtrair;
    Button btnMultiplicar;
    Button btnDividir;
    Button btnIgual;

    int mathOperation;
    double leitura;
    public double oper1;
    double dot;
    boolean isdot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero0 = (Button) findViewById(R.id.btnNumber0);
        numero1 = (Button) findViewById(R.id.btnNumber1);
        numero2 = (Button) findViewById(R.id.btnNumber2);
        numero3 = (Button) findViewById(R.id.btnNumber3);
        numero4 = (Button) findViewById(R.id.btnNumber4);
        numero5 = (Button) findViewById(R.id.btnNumber5);
        numero6 = (Button) findViewById(R.id.btnNumber6);
        numero7 = (Button) findViewById(R.id.btnNumber7);
        numero8 = (Button) findViewById(R.id.btnNumber8);
        numero9 = (Button) findViewById(R.id.btnNumber9);
        numeroP = (Button) findViewById(R.id.btnPonto);
        numeroD = (Button) findViewById(R.id.btnLimparVisor);

        radioGroup = (RadioGroup) findViewById(R.id.rgModo);

        btnSomar = (Button) findViewById(R.id.btnSomar);
        btnSubtrair = (Button) findViewById(R.id.btnSubtracao);
        btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnDividir = (Button) findViewById(R.id.btnDividir);
        btnIgual = (Button) findViewById(R.id.btnIgual);

        tv = (TextView) findViewById(R.id.textView);

        numero0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrecisaCalcular pc = new PrecisaCalcular(tv);
                leitura *= 10;
                leitura += 0;
                pc.showResult(pc.getText() + "0");
            }
        });

        numero1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrecisaCalcular pc = new PrecisaCalcular(tv);
                leitura *= 10;
                leitura += 1;
                pc.showResult(pc.getText() + "1");
            }
        });

        numero2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrecisaCalcular pc = new PrecisaCalcular(tv);
                leitura *= 10;
                leitura += 2;
                pc.showResult(pc.getText() + "2");
            }
        });

        numero3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrecisaCalcular pc = new PrecisaCalcular(tv);
                leitura *= 10;
                leitura += 3;
                pc.showResult(pc.getText() + "3");
            }
        });

        numero4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrecisaCalcular pc = new PrecisaCalcular(tv);
                leitura *= 10;
                leitura += 4;
                pc.showResult(pc.getText() + "4");
            }
        });

        numero5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrecisaCalcular pc = new PrecisaCalcular(tv);
                leitura *= 10;
                leitura += 5;
                pc.showResult(pc.getText() + "5");
            }
        });

        numero6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrecisaCalcular pc = new PrecisaCalcular(tv);
                leitura *= 10;
                leitura += 6;
                pc.showResult(pc.getText() + "6");
            }
        });

        numero7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrecisaCalcular pc = new PrecisaCalcular(tv);
                leitura *= 10;
                leitura += 7;
                pc.showResult(pc.getText() + "7");
            }
        });

        numero8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrecisaCalcular pc = new PrecisaCalcular(tv);
                leitura *= 10;
                leitura += 8;
                pc.showResult(pc.getText() + "8");
            }
        });

        numero9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrecisaCalcular pc = new PrecisaCalcular(tv);
                leitura *= 10;
                leitura += 9;
                pc.showResult(pc.getText() + "9");
            }
        });

        numeroP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrecisaCalcular pc = new PrecisaCalcular(tv);
                dot = leitura; leitura = 0; isdot = true;
                pc.showResult(pc.getText() + ".");
            }
        });

        numeroD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrecisaCalcular pc = new PrecisaCalcular(tv);
                oper1 = 0; dot = 0; leitura = 0; isdot = false;
                pc.showResult("");
            }
        });

        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    leitura = Double.parseDouble(tv.getText().toString());
                    PrecisaCalcular pc = new PrecisaCalcular(tv);
                    mathOperation = PrecisaCalcular.MathOperation.SUM;
                    oper1 = isdot ? dot + leitura / 10 : leitura;
                    dot = 0; leitura = 0; isdot = false;
                    pc.showResult(oper1 + " + ");
                } catch (Exception e) {
                    btnIgual.performClick();
                }
            }
        });

        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    leitura = Double.parseDouble(tv.getText().toString());
                    PrecisaCalcular pc = new PrecisaCalcular(tv);
                    mathOperation = PrecisaCalcular.MathOperation.SUBTRACTION;
                    oper1 = isdot ? dot + leitura / 10 : leitura;
                    dot = 0; leitura = 0; isdot = false;
                    pc.showResult(oper1 + " - ");
                } catch (Exception e) {
                    btnIgual.performClick();
                }
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    leitura = Double.parseDouble(tv.getText().toString());
                    PrecisaCalcular pc = new PrecisaCalcular(tv);
                    mathOperation = PrecisaCalcular.MathOperation.MULTIPLICATION;
                    oper1 = isdot ? dot + leitura / 10 : leitura;
                    dot = 0; leitura = 0; isdot = false;
                    pc.showResult(oper1 + " X ");
                } catch (Exception e) {
                    btnIgual.performClick();
                }
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    leitura = Double.parseDouble(tv.getText().toString());
                    PrecisaCalcular pc = new PrecisaCalcular(tv);
                    mathOperation = PrecisaCalcular.MathOperation.DIVISION;
                    oper1 = isdot ? dot + leitura / 10 : leitura;
                    dot = 0; leitura = 0; isdot = false;
                    pc.showResult(oper1 + " / ");
                } catch (Exception e) {
                    btnIgual.performClick();
                }
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(radioButtonID);
                int radioButtonIdx = radioGroup.indexOfChild(radioButton); //0:Local; 1:Socket; 2:HTTP
                PrecisaCalcular shc = new PrecisaCalcular(tv);

                double oper2 = isdot ? dot + leitura / 10 : leitura;

                switch (mathOperation) {
                    case PrecisaCalcular.MathOperation.SUM:
                        somar(shc, radioButtonIdx, oper1, oper2);
                        break;
                    case PrecisaCalcular.MathOperation.SUBTRACTION:
                        subtrair(shc, radioButtonIdx, oper1, oper2);
                        break;
                    case PrecisaCalcular.MathOperation.MULTIPLICATION:
                        multiplicar(shc, radioButtonIdx, oper1, oper2);
                        break;
                    case PrecisaCalcular.MathOperation.DIVISION:
                        dividir(shc, radioButtonIdx, oper1, oper2);
                        break;
                }
            }
        });
    }

    private void somar(PrecisaCalcular shc, int modo, double value1, double value2){
        if (modo == 0) //Local
            shc.calculoLocal(PrecisaCalcular.MathOperation.SUM, value1, value2);
        else if (modo == 1) // Socket'
            shc.calculoRemoto(PrecisaCalcular.MathOperation.SUM, value1, value2);
        else if(modo == 2) //HTTP
            shc.calculoRemotoHTTP(PrecisaCalcular.MathOperation.SUM, value1, value2);
    }

    private void subtrair(PrecisaCalcular shc, int modo, double value1, double value2){
        if (modo == 0) //Local
            shc.calculoLocal(PrecisaCalcular.MathOperation.SUBTRACTION, value1, value2);
        else if(modo == 1) // Socket
            shc.calculoRemoto(PrecisaCalcular.MathOperation.SUBTRACTION, value1, value2);
        else if(modo == 2) //HTTP
            shc.calculoRemotoHTTP(PrecisaCalcular.MathOperation.SUBTRACTION, value1, value2);
    }

    private void multiplicar(PrecisaCalcular shc, int modo, double value1, double value2){
        if (modo == 0) //Local
            shc.calculoLocal(PrecisaCalcular.MathOperation.MULTIPLICATION, value1, value2);
        else if(modo == 1) // Socket
            shc.calculoRemoto(PrecisaCalcular.MathOperation.MULTIPLICATION, value1, value2);
        else if(modo == 2) //HTTP
            shc.calculoRemotoHTTP(PrecisaCalcular.MathOperation.MULTIPLICATION, value1, value2);
    }

    private void dividir(PrecisaCalcular shc, int modo, double value1, double value2){
        if (modo == 0) //Local
            shc.calculoLocal(PrecisaCalcular.MathOperation.DIVISION, value1, value2);
        else if(modo == 1) // Socket
            shc.calculoRemoto(PrecisaCalcular.MathOperation.DIVISION, value1, value2);
        else if(modo == 2) //HTTP
            shc.calculoRemotoHTTP(PrecisaCalcular.MathOperation.DIVISION, value1, value2);
    }
}

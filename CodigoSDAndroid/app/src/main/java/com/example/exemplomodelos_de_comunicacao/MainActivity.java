package com.example.exemplomodelos_de_comunicacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    TextView tvMathOperation;
    Button btSomar;
    Button btSubtrair;
    Button btMultiplicar;
    Button btDividir;
    RadioGroup radioGroup;
    EditText etValue1;
    EditText etValue2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Associando os objetos aos recursos visuais - Botões das operações matemáticas*/
        btSomar = (Button) findViewById(R.id.btSomar);
        btSubtrair = (Button) findViewById(R.id.btSubtrair);
        btMultiplicar = (Button) findViewById(R.id.btMultiplicar);
        btDividir = (Button) findViewById(R.id.btDividir);

        tv= (TextView) findViewById(R.id.textView);
        tvMathOperation = (TextView) findViewById(R.id.tvMathOperation);
        radioGroup = (RadioGroup) findViewById(R.id.rgModo);
        etValue1 = (EditText) findViewById(R.id.etValor1);
        etValue2 = (EditText) findViewById(R.id.etValor2);

        btSomar.setOnClickListener(this);
        btMultiplicar.setOnClickListener(this);
        btDividir.setOnClickListener(this);
        btSubtrair.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(radioButtonID);
        int radioButtonIdx = radioGroup.indexOfChild(radioButton); //0:Local; 1:Socket; 2:HTTP
        PrecisaCalcular shc = new PrecisaCalcular(tv);

        double value1 = Double.parseDouble(etValue1.getText().toString().trim());
        double value2 = Double.parseDouble(etValue2.getText().toString().trim());

        switch (id){
            case R.id.btSomar:
                tvMathOperation.setText("+");
                somar(shc, radioButtonIdx, value1, value2);
                break;
            case R.id.btSubtrair:
                tvMathOperation.setText("-");
                subtrair(shc, radioButtonIdx, value1, value2);
                break;
            case R.id.btMultiplicar:
                tvMathOperation.setText("*");
                multiplicar(shc, radioButtonIdx, value1, value2);
                break;
            case R.id.btDividir:
                tvMathOperation.setText("/");
                dividir(shc, radioButtonIdx, value1, value2);
                break;
        }
    }

    private void somar(PrecisaCalcular shc, int modo, double value1, double value2){
        if (modo == 0)  //Local
            shc.calculoLocal(PrecisaCalcular.MathOperation.SUM, value1, value2);
        else if(modo == 1) // Socket'
            shc.calculoRemoto(PrecisaCalcular.MathOperation.SUM, value1, value2);
        else if(modo == 2) //HTTP
            shc.calculoRemotoHTTP(PrecisaCalcular.MathOperation.SUM, value1, value2);
    }

    private void subtrair(PrecisaCalcular shc, int modo, double value1, double value2){
        if (modo == 0)  //Local
            shc.calculoLocal(PrecisaCalcular.MathOperation.SUBTRACTION, value1, value2);
        else if(modo == 1) // Socket
            shc.calculoRemoto(PrecisaCalcular.MathOperation.SUBTRACTION, value1, value2);
        else if(modo == 2) //HTTP
            shc.calculoRemotoHTTP(PrecisaCalcular.MathOperation.SUBTRACTION, value1, value2);
    }

    private void multiplicar(PrecisaCalcular shc, int modo, double value1, double value2){
        if (modo == 0)  //Local
            shc.calculoLocal(PrecisaCalcular.MathOperation.MULTIPLICATION, value1, value2);
        else if(modo == 1) // Socket
            shc.calculoRemoto(PrecisaCalcular.MathOperation.MULTIPLICATION, value1, value2);
        else if(modo == 2) //HTTP
            shc.calculoRemotoHTTP(PrecisaCalcular.MathOperation.MULTIPLICATION, value1, value2);
    }

    private void dividir(PrecisaCalcular shc, int modo, double value1, double value2){
        if (modo == 0)  //Local
            shc.calculoLocal(PrecisaCalcular.MathOperation.DIVISION, value1, value2);
        else if(modo == 1) // Socket
            shc.calculoRemoto(PrecisaCalcular.MathOperation.DIVISION, value1, value2);
        else if(modo == 2) //HTTP
            shc.calculoRemotoHTTP(PrecisaCalcular.MathOperation.DIVISION, value1, value2);
    }
}

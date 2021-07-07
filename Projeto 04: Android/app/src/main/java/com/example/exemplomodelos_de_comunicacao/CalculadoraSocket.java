package com.example.exemplomodelos_de_comunicacao;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class CalculadoraSocket extends AsyncTask<Void, Void, String> {

    String oper1, oper2;
    PrecisaCalcular pc;

    /* Atributo utilizado para especificar a operação desejada. */
    int mathOperation;

    /*A extensão para as demais operações ocorre pela inclusão do parâmentro "mathOperation"
     * que define, com base em "PrecisaCalcular.MathOperation", qual é a operação a ser realizada.*/
    public CalculadoraSocket(PrecisaCalcular pc, int mathOperation, String oper1, String oper2){
        this.oper1 = oper1;
        this.oper2 = oper2;
        this.pc = pc;
        this.mathOperation = this.getMathOperationSocket(mathOperation);
    }

    @Override
    protected String doInBackground(Void... voids) {
        String result="";

        /* O valor da variável "operacao" é o resultado do mapeamento do "mathOperation" fornecido no
         * ato da chamada para a execução. */
        int operacao=mathOperation; //1-somar 2-subtrair 3-dividir 4-multiplicar

        try {
            //Conexão com o Servidor
            Socket clientSocket = new Socket("192.168.1.106", 9090);
            DataOutputStream socketSaidaServer = new DataOutputStream(clientSocket.getOutputStream());

            //Enviando os dados
            socketSaidaServer.writeBytes(operacao+"\n");
            socketSaidaServer.writeBytes(oper1+ "\n");
            socketSaidaServer.writeBytes(oper2+ "\n");
            socketSaidaServer.flush();

            //Recebendo a resposta
            BufferedReader messageFromServer = new BufferedReader
                    (new InputStreamReader(clientSocket.getInputStream()));
            result = messageFromServer.readLine();
            Log.d("RESULT: ", result);

            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
        //Codigo
    }


    @Override
    protected void onPreExecute() {
        //Codigo
    }

    @Override
    protected void onPostExecute(String result) {
        this.pc.showResult(result);
    }

    /* Mapeamento das operações presentes em "PrecisaCalcular.MathOperation" para os valores utilizados
     * no servidor SOCKET*/
    private int getMathOperationSocket(int op){
        int result = -1;
        if(op == PrecisaCalcular.MathOperation.SUM){
            result = 1;
        }else if(op == PrecisaCalcular.MathOperation.SUBTRACTION){
            result = 2;
        }else if(op == PrecisaCalcular.MathOperation.MULTIPLICATION) {
            result = 3;
        }else if(op == PrecisaCalcular.MathOperation.DIVISION) {
            result = 4;
        }
        return result;
    }

}

package com.example.exemplomodelos_de_comunicacao;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class CalculadoraHttpPOST extends AsyncTask<Void, Void, String> {

    String oper1,oper2;
    PrecisaCalcular pc;

    /* Atributo utilizado para especificar a operação desejada. */
    int mathOperation;

    /*A extensão para as demais operações ocorre pela inclusão do parâmentro "mathOperation"
    * que define, com base em "PrecisaCalcular.MathOperation", qual é a operação a ser realizada.*/
    public CalculadoraHttpPOST(PrecisaCalcular pc, int mathOperation, String oper1, String oper2){
        this.oper1=oper1;
        this.oper2=oper2;
        this.pc=pc;
        this.mathOperation = this.getMathOperationSocket(mathOperation);
    }

    @Override
    protected String doInBackground(Void... voids) {
        String result="";
        try {
           URL url = new URL("https://double-nirvana-273602.appspot.com/?hl=pt-BR");
           HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true) ;

            //ENVIO DOS PARAMETROS
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));

            /* O parâmetro "operação" do método POST foi alterado para o valor adequado diante
            * da operação desejada. */
            writer.write("oper1="+oper1+"&oper2="+oper2+"&operacao="+mathOperation);
            writer.flush();
            writer.close();
            os.close();

            int responseCode=conn.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK) {

                //RECBIMENTO DOS PARAMETROS


                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "utf-8"));
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                result = response.toString();
            }
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
        //Codigo
        this.pc.showResult(result);
    }

    /* Mapeamento das operações presentes em "PrecisaCalcular.MathOperation" para os valores utilizados
    * no servidor HTTP*/
    private int getMathOperationSocket(int op){
        int result = -1;
        if(op == PrecisaCalcular.MathOperation.SUM){
            result = 1;
        }else if(op == PrecisaCalcular.MathOperation.SUBTRACTION){
            result = 2;
        }else if(op == PrecisaCalcular.MathOperation.DIVISION) {
            result = 4;
        } else if(op == PrecisaCalcular.MathOperation.MULTIPLICATION) {
            result = 3;
        }
        return result;
    }

}


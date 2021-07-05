import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.awt.event.*;

import javax.net.ssl.HttpsURLConnection;

public class CalculadoraClientHTTP {

    public static String result;
    public static double oper1;
    public static double oper2;
    public static int operacao;

	public static void main(String[] args) {

        Calculadora calc = new Calculadora();
        calc.setVisible(true);
		
        calc.igual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                oper1 = calc.getOper1();
                oper2 = calc.getOper2();
                operacao = calc.getOperacao();

                calc.resetVariaveis();

                try {
                    URL url = new URL("https://double-nirvana-273602.appspot.com/?hl=pt-BR");
                    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                    conn.setReadTimeout(10000);
                    conn.setConnectTimeout(15000);
                    conn.setRequestMethod("POST");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);

                    //ENVIO DOS PARAMETROS
                    OutputStream os = conn.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));

                    //1-somar 2-subtrair 3-multiplicar 4-dividir
                    writer.write("oper1="+oper1+"&oper2="+oper2+"&operacao="+operacao);
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
                        System.out.println("Resposta do Servidor PHP="+result);

                        // Escreve o resultado na interface da calculadora.
                        calc.setDisplay(result);

                        // Atualiza o valor da leitura para o resultado da operação.
                        calc.setLeitura(Double.parseDouble(result));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
	}
}

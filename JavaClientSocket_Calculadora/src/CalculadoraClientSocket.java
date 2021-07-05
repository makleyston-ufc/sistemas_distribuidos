import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.awt.event.*;

public class CalculadoraClientSocket {

    public static double oper1;
    public static double oper2;
    public static int operacao;
    public static String result;

	public static void main(String[] args) throws IOException, InterruptedException {

        Calculadora calc = new Calculadora();
        calc.setVisible(true);

        // É criada uma Ação que dispara quando o usuário clica no botão de igual.
        // Capturando os valores digitados e enviando para o servidor.
        calc.igual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                oper1 = calc.getOper1();
                oper2 = calc.getOper2();
                operacao = calc.getOperacao(); //1-somar 2-subtrair 3-multiplicar 4-dividir

                calc.resetVariaveis();

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

                    // Escreve o resultado na interface da calculadora.
                    calc.setDisplay(result);

                    // Atualiza o valor da leitura para o resultado da operação.
                    calc.setLeitura(Double.parseDouble(result));

                    // Imprimindo o resultado
                    System.out.println("resultado = " + result + "\n");
                    clientSocket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
	}
}

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class CalculadoraClientSocket {

	public static void main(String[] args) throws IOException, InterruptedException {

        Scanner ler = new Scanner(System.in);

        int operacao;
        double oper1;
        double oper2;
        String result;

        while (true) {
            
            // TODO Auto-generated method stub
            // double oper1 = 10, oper2 = 20;
            // int operacao = 5; //1-somar 2-subtrair 3-dividir 4-multiplicar

            // Usando o Scanner para ler os valores do usuário.

            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Divisão");
            System.out.println("4 - Multiplicação");
            System.out.println("5 - Sair\n");

            System.out.println("Digite a Operação Desejada: ");
            operacao = ler.nextInt();

            if (operacao == 5) {
                break;
            }

            System.out.println("Digite o primeiro valor:");
            oper1 = ler.nextDouble();

            System.out.println("Digite o segundo valor:");
            oper2 = ler.nextDouble();

            try {

                //Conexão com o Servidor
                Socket clientSocket = new Socket("192.168.1.115", 9090);
                DataOutputStream socketSaidaServer = new DataOutputStream(clientSocket.getOutputStream());
                
                //Enviando os dados
                socketSaidaServer.writeBytes(operacao+"\n");
                socketSaidaServer.writeBytes(oper1+ "\n");
                socketSaidaServer.writeBytes( oper2+ "\n");
                socketSaidaServer.flush();

                //Recebendo a resposta
                BufferedReader messageFromServer = new BufferedReader
                        (new InputStreamReader(clientSocket.getInputStream()));
                result = messageFromServer.readLine();

                // "Limpando" o console
                clearScreen();
                
                // Imprimindo o resultado
                System.out.println("resultado = " + result + "\n");
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}

    // Método para "limpar" o console (imprime alguma linhas em branco).
    private static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
}

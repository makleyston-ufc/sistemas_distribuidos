import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CalculadoraClientSocket {
    public static String result;

    public static void main(String[] args) {

        InterfaceCalc calc = new InterfaceCalc();
        calc.setVisible(true);

        // É criada uma Ação que dispara quando o usuário clica no botão de igual.
        // Capturando os valores digitados e enviando para o servidor.
        calc.btnIgual.addActionListener((event) -> {
            String expressao = calc.display.getText();
            ExpressaoOuterClass.Expressao exp = new TreeBuild(expressao).build();

            try {
                //Conexão com o Servidor
                Socket clientSocket = new Socket("192.168.1.106", 9090);
                ObjectOutputStream socketSaidaServer =
                        (new ObjectOutputStream(clientSocket.getOutputStream()));

                //Enviando os dados
                socketSaidaServer.writeObject(exp);
                socketSaidaServer.flush();

                //Recebendo a resposta
                DataInputStream messageFromServer = new DataInputStream(clientSocket.getInputStream());
                result = messageFromServer.readUTF();

                // Imprimindo o resultado
                calc.setDisplay(result);
                System.out.println("resultado = " + result + "\n");
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

package calc.socket;

import calc.Expressao;
import com.thoughtworks.xstream.XStream;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraServer {
    public static void main(String[] args) {
        XStream xStream = new XStream();
        ServerSocket welcomeSocket;
        DataOutputStream socketOutput;
        ObjectInputStream socketEntrada;
        Calculadora calc = new Calculadora();
        try {
            welcomeSocket = new ServerSocket(9090);
            System.out.println ("Servidor no ar");

            while(true) {
                Socket connectionSocket = welcomeSocket.accept();
                System.out.println ("Nova conexão");

                //Interpretando dados do servidor
                socketEntrada = new ObjectInputStream(connectionSocket.getInputStream());
//                System.out.println("Aquii");
                String xml = (String) socketEntrada.readObject();
                System.out.println(xml);
                Expressao exp = (Expressao) xStream.fromXML(xml);

                //Chamando a calculadora passando a expressão em forma de árvore.
                String result = ""+calc.calculate(exp);
                System.out.println("Resultado: " + result);

                socketOutput = new DataOutputStream(connectionSocket.getOutputStream());
                socketOutput.writeUTF(result+ '\n');
                socketOutput.flush();
                socketOutput.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

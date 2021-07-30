/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import calc.socket.InterfaceCalc;
import calc.socket.TreeBuild;
import com.thoughtworks.xstream.XStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author makleyston
 */
public class Calc {

    /**
     * @param args the command line arguments
     */
    public static String result;
    public static void main(String[] args) {
        
        XStream xstream = new XStream();
        
        InterfaceCalc calc = new InterfaceCalc();
        calc.setVisible(true);
        
        calc.btnIgual.addActionListener((event) -> {
            String expressao = calc.display.getText();
//            String expressao = "( ( 5 * 9 ) + 9 ) / ( 5 - 3 )";
            TreeBuild treeBuild = new TreeBuild(expressao);
            Expressao exp = treeBuild.build();
            System.out.println(expressao);
            
            String xml = xstream.toXML(exp);
            System.out.println(xml);
                 
            try {
                //Conexão com o Servidor
                Socket clientSocket = new Socket("192.168.100.18", 9090);
                ObjectOutputStream socketSaidaServer =
                        (new ObjectOutputStream(clientSocket.getOutputStream()));

                //Enviando os dados
                socketSaidaServer.writeObject(xml);
                socketSaidaServer.flush();

                //Recebendo a resposta
                DataInputStream messageFromServer = new DataInputStream(clientSocket.getInputStream());
                result = messageFromServer.readUTF();

                // Imprimindo o resultado
                calc.setDisplay(result+"");
                System.out.println("resultado = " + result + "\n");
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            
        });
        
    }
    
}

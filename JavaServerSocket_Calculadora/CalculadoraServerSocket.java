import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraServerSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket welcomeSocket;
		DataOutputStream socketOutput;     	
	    DataInputStream socketInput;
	    BufferedReader socketEntrada;
	    Calculadora calc = new Calculadora();
		try {
			welcomeSocket = new ServerSocket(9090);
		  int i=0; //número de clientes
	  
	      System.out.println ("Servidor no ar");
	      while(true) { 
	  
	           Socket connectionSocket = welcomeSocket.accept(); 
	           i++;
	           System.out.println ("Nova conexão");
	           
	           //Interpretando dados do servidor
	           socketEntrada = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
               String operacao= socketEntrada.readLine();
               String oper1=socketEntrada.readLine();
               String oper2=socketEntrada.readLine();
               
               //Chamando a calculadora passando a operação desejada.
			   String result = "";
			   switch (Integer.parseInt(operacao)) {
				   case 1:
				   result += calc.soma(Double.parseDouble(oper1),Double.parseDouble(oper2));
				   break;
				   case 2:
				   result += calc.sub(Double.parseDouble(oper1),Double.parseDouble(oper2));
				   break;
				   case 3:
				   result += calc.div(Double.parseDouble(oper1),Double.parseDouble(oper2));
				   break;
				   case 4:
				   result += calc.mult(Double.parseDouble(oper1),Double.parseDouble(oper2));
				   break;
				   default:
				   result += "Invalid Operation!";
			   }
               
               //Enviando dados para o servidor
               socketOutput= new DataOutputStream(connectionSocket.getOutputStream());     	
	           socketOutput.writeBytes(result+ '\n');
	           System.out.println (result);	           
	           socketOutput.flush();
	           socketOutput.close();

	                    
	      }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	}

}

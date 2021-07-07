import java.net.MalformedURLException;
import java.rmi.*;
import java.awt.*;
import java.util.Arrays;
import java.awt.event.*;

public class CalculadoraCliente {

    public static double result;
    public static double oper1;
    public static double oper2;
    public static int operacao;

	public static ICalculadora calc = null;

	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());

		try {
			System.out.println(Arrays.toString(Naming.list("ServerJM")));

			/**
			 * O método lookup da classe Naming é usado para obter a referência
			 * do objeto Stub.
			 *
			 * O objeto Stub cria um bloco de informações e envia essas informações 
			 * ao servidor. O bloco consiste em:
			 * > Um identificador do objeto remoto a ser usado
			 * > Nome do método que deve ser invocado
			 * > Parâmetros para a JVM remoto
			 */
			calc = (ICalculadora) Naming.lookup("ServerJM");

			if(!calc.getStatus().equals("Ok")){
                System.out.println("Servidor não encontrado!");
                System.exit(0);
            }

			System.out.println("Servidor encontrado!");

			InterfaceCalc iCalc = new InterfaceCalc();
			iCalc.setVisible(true);

			iCalc.igual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					oper1 = iCalc.getOper1();
					oper2 = iCalc.getOper2();
					operacao = iCalc.getOperacao(); //1-somar 2-subtrair 3-multiplicar 4-dividir

					iCalc.resetVariaveis();

					try {
						result = calc.runOperation(oper1, oper2, operacao);
						System.out.println("resultado = " + result + "\n");

						iCalc.setDisplay(""+result);
					} catch (RemoteException e) {
						System.out.println("Server não encontrado");
					}
				}
			});
		} catch(MalformedURLException | NotBoundException | RemoteException e) {
			System.out.println("Server não encontrado");
		}
	}
}

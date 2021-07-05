import java.rmi.*;
import java.lang.Float;
import java.rmi.server.UnicastRemoteObject;

/**
 * Aqui fica a implementação dos métodos da interface remota.
 * Para implementar a interface remota, a classe deve se estender para a
 * classe UnicastRemoteObject do pacote java.rmi. Além disso, um construtor
 * padrão precisa ser criado para lançar o java.rmi.RemoteException de seu
 * construtor pai na classe.
 */
public class Calculadora extends UnicastRemoteObject implements ICalculadora {

	private static final long serialVersionUID = 1L;
	
	private static int chamadas = 0;

	public Calculadora() throws RemoteException{
        super();
    }

	/**
	 * Retorna "OK" se conseguiu conectar com o servidor.
	 */
	public String getStatus() throws RemoteException {
        return "Ok";
    }

	/**
	 * Método soma!
	 * Receber dois valores e retorna a soma deles!
	 */
	public double soma(double oper1, double oper2) throws RemoteException {
		System.out.println("Método soma chamado " + chamadas++);
		return oper1 + oper2;
	}

	/**
	 * Método subtração!
	 * Receber dois valores e retorna a subtração do primeiro menos o segundo!
	 */
	public double sub(double oper1, double oper2) throws RemoteException {
		System.out.println("Método subtração chamado " + chamadas++);
		return oper1 - oper2;
	}

	/**
	 * Método multiplicação!
	 * Recebe dois valores e retorna a multiplicação deles!
	 */
	public double mult(double oper1, double oper2) throws RemoteException {
		System.out.println("Método multiplicação chamado " + chamadas++);
		return oper1 * oper2;
	}

	/**
	 * Método divisão!
	 * Recebe dois valores e retorna a divisão do primeiro com o segundo!
	 */
	public double div(double oper1, double oper2) throws RemoteException {
		System.out.println("Método divisão chamado " + chamadas++);
		if (oper2 == 0) {
			System.out.println("Impossível dividir por zero!");
			return Float.NaN;
		}
		return oper1 / oper2;
	}

	/**
	 * Método Executa Operação
	 * Recebe dois valores e um identificador para a operação desejada.
	 * Então invoca o método desejado pelo usuário.	
	 */
	public double runOperation(double oper1, double oper2, int operacao) throws RemoteException {
		if (operacao == 1) {
			return this.soma(oper1, oper2);
		} else if (operacao == 2) {
			return this.sub(oper1, oper2);
		} else if (operacao == 3) {
			return this.mult(oper1, oper2);
		} else if (operacao == 4) {
			return this.div(oper1, oper2);
		} else {
			System.out.println("Invalid Operation!");
		}
		return -1;
	}
}

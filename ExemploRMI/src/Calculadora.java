import java.io.*;
import java.nio.channels.FileChannel;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calculadora extends UnicastRemoteObject implements ICalculadora {

	private static final long serialVersionUID = 1L;
	
	private static int chamadas = 0;

	public Calculadora() throws RemoteException{
        super();
    }

	public String getStatus() throws RemoteException {
        return "Ok";
    }

	public double soma(double oper1, double oper2) throws RemoteException {
		System.out.println("Método soma chamado " + chamadas++);
		return oper1 + oper2;
	}

	public double sub(double oper1, double oper2) throws RemoteException {
		System.out.println("Método subtração chamado " + chamadas++);
		return oper1 - oper2;
	}

	public double mult(double oper1, double oper2) throws RemoteException {
		System.out.println("Método multiplicação chamado " + chamadas++);
		return oper1 * oper2;
	}

	public double div(double oper1, double oper2) throws RemoteException {
		System.out.println("Método divisão chamado " + chamadas++);
		return oper1 / oper2;
	}

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

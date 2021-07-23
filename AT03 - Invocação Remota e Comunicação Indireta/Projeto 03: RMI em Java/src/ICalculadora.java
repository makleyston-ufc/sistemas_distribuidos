import java.io.File;
import java.rmi.*;
import java.util.ArrayList;

/**
 * Aqui é criada a interface que fornece a descrição dos métodos 
 * que podem ser chamados por clientes remotos.
 * Esta interface deve estender a interface Remote e o protótipo do
 * método dentro da interface deve lançar a RemoteException
 */
public interface ICalculadora extends Remote {

	public String getStatus() throws RemoteException;
	public double soma(double a, double b) throws RemoteException;
	public double sub(double a, double b) throws RemoteException;
	public double mult(double a, double b) throws RemoteException;
	public double div(double a, double b) throws RemoteException;
	public double runOperation(double a, double b, int op) throws RemoteException;
}

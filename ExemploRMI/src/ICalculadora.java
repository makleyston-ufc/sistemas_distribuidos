import java.io.File;
import java.rmi.*;
import java.util.ArrayList;

public interface ICalculadora extends Remote {

	public String getStatus() throws RemoteException;
	public double soma(double a, double b) throws RemoteException;
	public double sub(double a, double b) throws RemoteException;
	public double mult(double a, double b) throws RemoteException;
	public double div(double a, double b) throws RemoteException;
	public double runOperation(double a, double b, int op) throws RemoteException;
}

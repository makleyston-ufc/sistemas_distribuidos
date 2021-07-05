import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraServer {
    public static String nameService = "ServerJM";
    
    public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());
		
        try {
            int port = 8512;
            ICalculadora calc = new Calculadora();
            Registry reg = LocateRegistry.createRegistry(port);
            Naming.rebind(nameService, calc);
            System.out.println("Executando Sevidor...\nNome do Serviço:"+nameService);
		} catch (MalformedURLException | RemoteException e) {
			System.out.println(e.getMessage());
		}
	}
}
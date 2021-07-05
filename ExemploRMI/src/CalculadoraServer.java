import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.rmi.server.UnicastRemoteObject;

/**
 * O aplicação do servidor usa o método createRegistry da classe
 * LocateRegistry para criar rmiregistry na JVM do servidor com
 * o número da porta passado como argumento.
 *
 * O método rebind da classe Naming é usado para vincular o objeto
 * remoto ao novo nome.
 *
 * O objeto Skeleton passa a solicitação do objeto Stub para o objeto remoto
 */
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
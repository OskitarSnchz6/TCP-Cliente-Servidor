package MultihiloTCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMultihilo {
	public static void main(String argv[]) throws Exception{

		try {
			
			ServerSocket welcomeSocket = new ServerSocket(2021);
			System.out.printf("Creado socket de servidor en puerto %d. Esperando conexiones de clientes.\n", 2021);
			
		
		while(true) {
		// Wait, on welcoming socket for contact by client
			Socket socketNewClient = welcomeSocket.accept();
			System.out.println("Cliente conectado desde " + socketNewClient.getLocalAddress().getCanonicalHostName() + " : " + socketNewClient.getPort() + "." + "\n");	

			Thread hilo = new Thread(new NewThread());
			hilo.start();
		
				}
			}catch (IOException ex)	{
			System.out.println("Excepcion de E/S");
			ex.printStackTrace();
		}
	}
}
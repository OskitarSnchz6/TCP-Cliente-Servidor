package Cliente;

import java.io.*;
import java.net.*;

class TCPServer {
	public static void main(String argv[]) throws Exception{
	String clientSentence;
	String capitalizedSentence;
	// Create welcoming socket at port 2009
	ServerSocket welcomeSocket = new ServerSocket(2010);
	System.out.println("Conectado desde el puerto " + welcomeSocket.getLocalPort() + ". Esperando al cliente");
		while(true) {
	// Wait, on welcoming socket for contact by client
			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("Cliente conectado desde " + connectionSocket.getLocalAddress().getCanonicalHostName() + ":" + connectionSocket.getPort() + "." + "\n");		
			
		// Create input stream, attached to socket
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		
		// Create output stream, attached to socket
		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		
		// Read in line from socket
		clientSentence = inFromClient.readLine();
		System.out.println("Server clientSentence: " + clientSentence + '\n');
		capitalizedSentence = clientSentence.toUpperCase() + '\n';
		System.out.println("Server clientSentence: " + capitalizedSentence);
		// Write out line to socket
		outToClient.writeBytes(capitalizedSentence);
		// End of while loop, bloop back and
		// wait for another client connection
		}
	}
}
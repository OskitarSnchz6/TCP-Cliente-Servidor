package Cliente;

import java.io.*;
import java.net.Socket;

class TCPClient {
	public static void main(String argv[]) throws Exception	{
	String sentence;
	String modifiedSentence;
	
	
	// Create an input stream
	BufferedReader inFromUser =	new BufferedReader(new InputStreamReader(System.in));
	
	// Create a client socket, connect to server
	Socket clientSocket = new Socket("127.0.0.1", 2010);
	
	System.out.println("Cliente conectado desde el puerto " + clientSocket.getPort() + "\n");
	
	System.out.println("CLIENTE: texto a enviar al servidor: ");
	
	// Create an output stream attached to the socket
	DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	
	// Create an input stream attached to socket
	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	sentence = inFromUser.readLine();
	
	// Send a line to server
	outToServer.writeBytes(sentence + '\n');
	
	System.out.println("Palabra recogida por el teclado : " + sentence + '\n');
	
	// Read a line from server
	modifiedSentence = inFromServer.readLine();

	System.out.println("Palabra recibida por el servidor: " + modifiedSentence);
	clientSocket.close();
	}
}
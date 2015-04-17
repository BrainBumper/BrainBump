package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * A Simple Socket client that connects to our socket server
 *
 */
public class SocketClient {

	private String hostname, username;
	private int port;

	Socket socketClient;

	public SocketClient(String hostname, String username, int port){
		this.hostname = hostname;
		this.username = username;
		this.port = port;

		try {
			//trying to establish connection to the server
			connect();
			//asking server for time
			sendName();           
			//if successful, read response from server
			readResponse();

		} catch (UnknownHostException e) {
			System.err.println("Host unknown. Cannot establish connection");
		} catch (IOException e) {
			System.err.println("Cannot establish connection. Server may not be up."+e.getMessage());
		}
	}

	public void connect() throws UnknownHostException, IOException{
		System.out.println("Attempting to connect to "+hostname+":"+port);
		socketClient = new Socket(hostname,port);
		System.out.println("Connection Established");
	}

	public void readResponse() throws IOException{
		String serverInput;
		BufferedReader stdIn = new BufferedReader(
				new InputStreamReader(socketClient.getInputStream()));
		System.out.print("RESPONSE FROM SERVER:");
		while ((serverInput = stdIn.readLine()) != null) {
			System.out.println(serverInput);
		}
	}

	public void sendName() throws IOException{
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(socketClient.getOutputStream()));
		writer.write(username);
		writer.newLine();
		writer.flush();
	}

	public String getUsername(){
		return username;
	}

}

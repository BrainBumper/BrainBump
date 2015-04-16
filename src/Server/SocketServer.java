package server;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
* A simple socket server
*
*/
public class SocketServer {
    
    private ServerSocket serverSocket;
    private int port, maxClients, currentClients;
    private String name, password, hostname;
    
    public SocketServer(int port, int maxClients, String name, String password) {
        this.port = port;
        this.maxClients = maxClients;
        this.name = name;
        this.password = password;
        
        try {
			this.hostname = InetAddress.getLocalHost().getHostName();
			System.out.println(hostname);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        currentClients = 0;
        
        try {
			start();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void start() throws IOException {
        System.out.println("Starting the socket server at port:" + port +
        		"\n name: " + name +
        		"\n password: " + password +
        		"\n maxClients: " + maxClients);
        serverSocket = new ServerSocket(port);
        
        Socket client = null;
        
        while(true){
        	System.out.println("Waiting for clients...");
        	client = serverSocket.accept();
        	currentClients++;
        	System.out.println("The following client has connected:"
        			+client.getInetAddress().getCanonicalHostName());
            Thread thread = new Thread(new SocketClientHandler(client));
            thread.start();
        }     
    }
}

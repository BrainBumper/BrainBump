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
import java.util.concurrent.*;

import view.SessionCreateView;

/**
* A simple socket server
*
*/
public class SocketServer{
	
    private ServerSocket serverSocket;
    private int port, maxClients;
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
        
        try {
			start();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void start() throws IOException {
    	final ExecutorService clientProcessingPool = Executors.newFixedThreadPool(maxClients);
    	
        Runnable serverTask = new Runnable() {
            @SuppressWarnings("resource")
			@Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(port);
                    
                    System.out.println("Starting the socket server at port:" + port +
                    		"\n name: " + name +
                    		"\n password: " + password +
                    		"\n maxClients: " + maxClients);
                    
                    System.out.println("Waiting for clients to connect...");
                    while (true) {
                        Socket clientSocket = serverSocket.accept();
                        clientProcessingPool.submit(new ClientTask(clientSocket));
                    }
                } catch (IOException e) {
                    System.err.println("Unable to process client request");
                    e.printStackTrace();
                }
            }
        };
        Thread serverThread = new Thread(serverTask);
        serverThread.start();
    }
    
    private class ClientTask implements Runnable {
        private final Socket clientSocket;

        private ClientTask(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            System.out.println("Got a client !");

            // Do whatever required to process the client's request

            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

package com.firstproject.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.firstproject.chatapp.utils.ConfigReader;

public class Server {
	
		ServerSocket serverSocket;
		ArrayList<ServerWorker> workers = new ArrayList<>(); // Contains all the client sockets 
		
		public Server() throws IOException {
			int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
			serverSocket = new ServerSocket(PORT);
			System.out.println("\n Server started and waiting for the clients to join....");
			handleClientRequest();
		
		}
		//Multiple client handshaking
		public void handleClientRequest() throws IOException {
			while(true) {
				Socket clientSocket = serverSocket.accept();  //handshaking
		
				//per Client per thread
				ServerWorker serverWorker = new ServerWorker(clientSocket,this); //Creating a new worker / thread
				workers.add(serverWorker);
				serverWorker.start();
				}
			
		}
		
		
		
		
/* Sigle Client*/
		
		/*
		public Server() throws IOException {
			
			int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server started....");
			Socket socket = serverSocket.accept();  //handshaking
			System.out.println("Client joins the server");
			InputStream in = socket.getInputStream();  //Read data
			byte arr[] = in.readAllBytes();
			String str = new String(arr);
			System.out.println("Message recieved from client "+str);
			in.close();
			socket.close();
	}*/

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Server server = new Server();
		
	}

}

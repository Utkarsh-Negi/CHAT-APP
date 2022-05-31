package com.firstproject.chatapp.network;
//Thread == Worker
//Worker needs a job to perform
//For job U give Runnable
//Once the job is created through runnable so write the job logic inside a run function
//Assign the job to the Thread worker
//public class ServerWorker extends Thread{
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerWorker extends Thread {
	private Socket clientSocket;
	private InputStream in;
	private OutputStream out;
	private Server server;
	public ServerWorker(Socket clientSocket, Server server) throws IOException {
		
		this.server = server;
		this.clientSocket = clientSocket;
		in = clientSocket.getInputStream(); //Client data read
		out = clientSocket.getOutputStream(); // CLient data write
		System.out.println("\n New client comes");
		
		
		
		
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		
		//Read data from the client and broadcast the data to all
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		 String line;
		 try 
		 {
			 while(true)
			 {
				 
					line = br.readLine();// needs a \n
					System.out.println("Line is read...."+line);
					if(line.equalsIgnoreCase("quit")) {
						break; // Particular client chat will who will say quit
					}
					
					
					//out.write(line.getBytes()); //Data will be send to client
			  //Broadcast to all client
				for(ServerWorker serverWorker:server.workers) {
					line = line + "\n";
					serverWorker.out.write(line.getBytes());
					
				}
			 
			 
			 
			 
			 }
			 
		 
		 } 
		 
		 catch (IOException e) 
		 
		 {
				
				e.printStackTrace();
				
		 }
		 
		 finally 
		 {
			 try {
			 if(br!=null) {
				 br.close();
			 }
			 if(in!=null) {
				 in.close();
			 }
			 if(out!=null) {
				 out.close();
			 }
			 if(clientSocket!=null) {
				 clientSocket.close();
			 }
			 }
			 
			 catch(Exception ex) {
				 ex.printStackTrace();
			 }
		 }
		 
		
	}
	
}

 










































/*	
	@Override
	public void run() {
		//Job to Perform
		//Logic
		
		for(int i = 1;i<=5;i++) {
			System.out.println("Run I is "+i+" "+Thread.currentThread());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
//		ServerWorker job = new ServerWorker();
		ServerWorker worker = new ServerWorker();
		//Assign the job to worker/thread
//		Thread worker = new Thread (job);
		worker.start(); //Initially it will call the run()
		for(int j = 1;j<=5;j++) {
			System.out.println("Main "+j+" "+Thread.currentThread());
		}
	}
	

}
*/

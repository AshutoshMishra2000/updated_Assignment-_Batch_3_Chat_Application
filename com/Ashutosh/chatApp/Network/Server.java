package com.Ashutosh.chatApp.Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.Ashutosh.chatApp.utils.configReader;

public class Server {
ServerSocket serverSocket;
ArrayList<serverWorker> workers=new ArrayList<>();//we have taken this list just to store all our workers so that we may not loose them....
public Server() throws IOException {
	int port=Integer.parseInt(configReader.getValue("PORTNO"));
	serverSocket=new ServerSocket(port);
	handleMultipleClentRequests();
	

}

public void handleMultipleClentRequests() throws IOException {
	Socket clientSocket=serverSocket.accept();
	serverWorker worker=new serverWorker(clientSocket,this);
	workers.add(worker);
	worker.start();
	
}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Server server=new Server();

	}

}

/*
 * This is good for the single client not for the multiple clients so for multiple clients use upper logic
 * 	System.out.println("Server started and waiting for the client!");
	Socket socket=serverSocket.accept();//this is basically the hand shaking
	System.out.println("Client joins in!");
	InputStream in=socket.getInputStream();
	byte[] arr=in.readAllBytes();
	String str=new String(arr);
	System.out.println("the Message received is :"+str);
	socket.close();
	
	*/

package com.Ashutosh.chatApp.Network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import com.Ashutosh.chatApp.utils.configReader;

public class Client {
Socket socket;
InputStream in;
OutputStream out;
ClientWorker worker;
JTextArea textArea;
public Client(JTextArea textArea) throws UnknownHostException, IOException {
	int port=Integer.parseInt(configReader.getValue("PORTNO"));
	socket=new Socket(configReader.getValue("IP_ADDRESS"),port);
	out=socket.getOutputStream();
	in=socket.getInputStream();
	this.textArea=textArea;
	readMessages();
}

	/*
	 * System.out.println("Client joins the chat!");
	 * System.out.println("Enter the message you want to send to the server");
	 * Scanner sc=new Scanner(System.in); String message =sc.nextLine();
	 * OutputStream out=socket.getOutputStream(); out.write(message.getBytes());
	 * System.out.println("Message send to the server"); sc.close(); socket.close();
	 */
	
	public void sendMessages(String message) throws IOException {
		out.write(message.getBytes());
	}
	
	public void readMessages() {
		worker=new ClientWorker(in,textArea);//calling the read thread......
		worker.start();
	}

	/*
	 * public static void main(String[] args) throws UnknownHostException,
	 * IOException { Client cl=new Client(); }
	 */
}

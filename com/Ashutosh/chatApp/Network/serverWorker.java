package com.Ashutosh.chatApp.Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class serverWorker extends Thread {
	private Socket serverSocket;
	private OutputStream out;
	private InputStream in;
	private Server server;
	serverWorker(Socket serverSocket,Server server) throws IOException{
		this.serverSocket=serverSocket;
		this.server=server;
		in=serverSocket.getInputStream();
		out=serverSocket.getOutputStream();
	}
	


	public void run() {
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		
		String line;
		try {
		while(true) 
		{
		
			line=br.readLine();
			if(line.equalsIgnoreCase("Quit"))
			{
				break;
			}
			
			else 
			{
				//out.write(line.getBytes());//this is for te single client
				
				//for large number of clients we will have ....
				for(serverWorker serverworker:server.workers) {
					serverworker.out.write(line.getBytes());
				}
		    }
		}
		}
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		finally{
			try {
			if(in!=null) {
				in.close();
			}
			if(out!=null) {
				out.close();
			}
			
			if(serverSocket!=null) {
				serverSocket.close();
			}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		}
	}




/*
 *multithreading implementation using runnable interface.......
 * 
 * 
 * public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println("Hello :"+i+"  :  "+Thread.currentThread());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		serverWorker job =new serverWorker();
		Thread worker=new Thread(job);
		worker.start();
		for(int i=1;i<=5;i++) {
			System.out.println("Hello :"+i+"  :  "+Thread.currentThread());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}*/

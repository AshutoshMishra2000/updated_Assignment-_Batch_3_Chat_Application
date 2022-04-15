package com.Ashutosh.chatApp.Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JTextArea;

public class ClientWorker extends Thread{
	InputStream in;
	JTextArea textArea;
	public ClientWorker(InputStream in,JTextArea textArea) {
		this.in=in;
		this.textArea=textArea;
	}
	
	public void run() {
	BufferedReader br =new BufferedReader(new InputStreamReader(in));
	try {
		String line;
		while(true) {
		line=br.readLine();
		textArea.setText(textArea.getText()+line);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if(in!=null) {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}





}

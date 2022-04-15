package com.Ashutosh.chatApp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public interface Encryption {//as its object cannot be created.............
public static String passwordEncrypted(String plainPassword) throws NoSuchAlgorithmException {
	String encryptedPassword=null;
	MessageDigest messagedigest= MessageDigest.getInstance("MD5");
	messagedigest.update(plainPassword.getBytes());
	byte [] encrypt=messagedigest.digest();
	StringBuffer sb=new StringBuffer();
	for(byte b:encrypt) {
		sb.append(b);
	}
	encryptedPassword=sb.toString();
	
	
	return encryptedPassword;
}
//public static void main(String[] args) throws NoSuchAlgorithmException {
//	System.out.println("Encrypted Password"+passwordEncrypted("Ashutosh"));
//}
}

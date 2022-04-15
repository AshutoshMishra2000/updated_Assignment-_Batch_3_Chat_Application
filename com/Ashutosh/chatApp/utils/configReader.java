package com.Ashutosh.chatApp.utils;

import java.util.ResourceBundle;

public class configReader {
	configReader(){}  //so that no one will be able to make its object.....
	//this file is used to read the config file......
private static ResourceBundle rb=ResourceBundle.getBundle("config");
public static String getValue(String key) {
	return rb.getString(key);
	
}
}

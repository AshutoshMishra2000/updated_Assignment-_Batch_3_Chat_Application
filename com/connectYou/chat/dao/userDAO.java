package com.connectYou.chat.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Ashutosh.chatApp.utils.Encryption;
import com.connectYou.chat.DTO.userDTO;

//this basically use to CRUD operations on user...
public class userDAO {
	public boolean islogin(userDTO userDto) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		final String SQL="select userid from users where userid=? and password=?";
		try {
			connection=commonDAO.createConnection();
			pstmt =connection.prepareStatement(SQL);
			pstmt.setString(1, userDto.getUserId());
		String encryptedPassword=Encryption.passwordEncrypted(new String(userDto.getPassword()));
		pstmt.setString(2, encryptedPassword);
		rs=pstmt.executeQuery();
		return rs.next();
		}
		finally {
			if(rs!=null) {
				rs.close();
			}
			
			if(pstmt!=null) {
				pstmt.close();
			}
			
			if(connection!=null) {
				connection.close();
			}
		}
	
	}
	
public int add(userDTO userDto) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
	//System.out.println(userDto.getPassword()+"Data received  "+userDto.getUserId());
	Connection connection=null;//make the coonection
	Statement stmt=null;//to make query
	try {//gaurded region
	connection=commonDAO.createConnection();//step1: make connection
	//step 2: Make query
	stmt=connection.createStatement();
	// insert into users (userid,password) values ('Ahutosh','Palia@123');
	int record=stmt.executeUpdate("insert into users (userid ,password,email,phoneNumber,City) "
			+ "values ('"+userDto.getUserId()+"','"+Encryption.passwordEncrypted(new String(userDto.getPassword()))+"','"+userDto.getEmail()+"','"+userDto.getPhoneNumber()+"','"+userDto.getCity()+"')");
	return record;
	}
	//close first which is used last
	finally{//always use resource cleanup
		if(stmt!=null)
	stmt.close();
		if(connection!=null)
	connection.close();
	}
	
}
}

package com.connectYou.chat.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.connectYou.chat.DTO.userDTO;
import com.connectYou.chat.dao.userDAO;

public class userScreen extends JFrame {
	userDAO userdao=new userDAO();
	
	
public void isLogin() 
	{
		
		
		
		 String userId=userIdText.getText();
		//as the getText is depricated because of security reasons ....getText() prints original password i.e. bad practice
		char[] password=passwordField.getPassword();//this will give output in hexadecimal format
		
		userDTO userdto=new userDTO(userId,password);
		try {
			if(userdao.islogin(userdto)) {
				JOptionPane.showMessageDialog(this, "User logged in successfully "+userId);
			//	setVisible(false);
				//dispose();
				
				Dashboard db=new Dashboard(" \"User logged in successfully "+userId);
				db.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(this, "user login Fialed");
			}
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(HeadlessException e){
			e.printStackTrace();
		}
		catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		
	}
	public void register()  {
		String userId=userIdText.getText();
		//as the getText is depricated because of security reasons ....getText() prints original password i.e. bad practice
		char[] password=passwordField.getPassword();//this will give output in hexadecimal format
		String email=emailText.getText();
		//this is just for the email validation
		String originalEmail="";
		if(email.contains("@")&& email.endsWith(".com")||email.endsWith(".org")){
		     originalEmail=email;
		}
		
		else {
			JOptionPane.showMessageDialog(this, "Enter valid Email");
		}
		String phnNumber=phnText.getText();
		String city=cityText.getText();
		//userDAO userdao=new userDAO();
		userDTO userdto=new userDTO(userId,password,originalEmail,phnNumber,city);
		try {
		int result=userdao.add(userdto);
		if(result>0) {
			JOptionPane.showMessageDialog(this,"User registered Successfully");
		}
		if(result<0) {
			JOptionPane.showMessageDialog(this,"User registeration failed");
		}
		}
		catch(ClassNotFoundException|SQLException e) {
			System.out.println("DB ISsue");
			e.printStackTrace();
		}
		catch(Exception e) {//always write this in last as this is the parent of all exception classes so this will override all other classes exception will show parent exception
			System.out.println("Some other issue");
			e.printStackTrace();
		}
		System.out.println(userId+" "+password);//className@hashcodeHexadecimal   [C@54f9b76a   or password.toString() will
	//ive same output
	}
	
	private JTextField userIdText;
	private JPasswordField passwordField;
	private JTextField emailText;
	private JTextField phnText;
	private JTextField cityText;
	public userScreen() {
		getContentPane().setBackground(Color.CYAN);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(274, 10, 316, 129);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("UserName:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(193, 166, 145, 36);
		getContentPane().add(lblNewLabel_2);
		
		userIdText = new JTextField();
		userIdText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userIdText.setBounds(366, 166, 316, 46);
		getContentPane().add(userIdText);
		userIdText.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(193, 247, 129, 36);
		getContentPane().add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(366, 247, 316, 46);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//	LoginPage lp=new LoginPage();
			//	lp.setVisible(true);
				
					isLogin();
					
				
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(193, 683, 129, 46);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(543, 683, 139, 46);
		getContentPane().add(btnNewButton_1);
		
		JLabel email = new JLabel("Email:");
		email.setFont(new Font("Tahoma", Font.BOLD, 20));
		email.setBounds(193, 316, 110, 68);
		getContentPane().add(email);
		
		emailText = new JTextField();
		emailText.setBounds(366, 316, 316, 46);
		getContentPane().add(emailText);
		emailText.setColumns(10);
		
		JLabel phoneNumber = new JLabel("PhoneNumber:");
		phoneNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		phoneNumber.setBounds(193, 405, 157, 53);
		getContentPane().add(phoneNumber);
		
		phnText = new JTextField();
		phnText.setBounds(366, 405, 316, 48);
		getContentPane().add(phnText);
		phnText.setColumns(10);
		
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Tahoma", Font.BOLD, 20));
		city.setBounds(193, 496, 84, 36);
		getContentPane().add(city);
		
		cityText = new JTextField();
		cityText.setBounds(366, 492, 316, 46);
		getContentPane().add(cityText);
		cityText.setColumns(10);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userIdText.setText("");
				
				 passwordField.setText("");
				emailText.setText("");
				 phnText.setText("");
				cityText.setText("");
				
				
			}
		});
		resetButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		resetButton.setBounds(917, 685, 117, 46);
		getContentPane().add(resetButton);
		setTitle("Login/register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					userScreen window = new userScreen();
			
		window.setBounds(100, 50, 900, 900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
				
			}
}

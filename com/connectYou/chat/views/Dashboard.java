package com.connectYou.chat.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	
	
	private void logOut() {
		JOptionPane.showConfirmDialog(this,"Are you sure that you wanted to logout");
		setVisible(false);
		userScreen ur =new userScreen();
		ur.setVisible(true);
		JOptionPane.showMessageDialog(this,"User Logged out Successfully");
	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		
//					Dashboard frame = new Dashboard();
//					frame.setVisible(true);
//				
//		
//	}

	/**
	 * Create the frame.
	 */
	public Dashboard(String message) {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1550, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle(message);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/chit_chat1.png")));
		lblNewLabel.setBounds(414, 49, 733, 681);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(20, 20, 870, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("chat");
		mnNewMenu.setBounds(26, 18, 111, 24);
		contentPane.add(mnNewMenu);
		
		JButton btnNewButton = new JButton("Logout!");
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			logOut();
		
			
				
			}

		
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(108, 531, 130, 50);
		contentPane.add(btnNewButton);
	}
}

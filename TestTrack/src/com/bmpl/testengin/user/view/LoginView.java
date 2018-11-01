package com.bmpl.testengin.user.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import com.bmpl.testengin.user.userDAO.UserDAO;
import com.bmpl.testengin.user.userDTO.UserDTO;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField userName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	String message = "Invalid user and password";
	public String checkLogin()
	{
		String username = userName.getText();
		String password = new String(passwordField.getPassword());
		UserDAO userDAO = new UserDAO();
		
		
		try {
//			userDAO.doLogin(username, password);
			UserDTO userDTO = userDAO.doLogin(username, password);
		if(userDAO!=null)
		{
			message="Welcome "+username;
			System.out.println("Welcome "+username);
			DashBoard dashBoard = new DashBoard(userDTO);
			dashBoard.setExtendedState(dashBoard.MAXIMIZED_BOTH);
			dashBoard.setVisible(true);
			
		}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.shadow"));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(67, 78, 84), null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(23, 117, 99, 14);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(23, 142, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(UIManager.getColor("Button.focus"));
		passwordField.setBounds(132, 139, 239, 20);
		contentPane.add(passwordField);
		
		userName = new JTextField();
		userName.setBounds(132, 111, 239, 20);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("SignIn");
		lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(112, 25, 105, 36);
		contentPane.add(lblNewLabel_2);
		
		
		JButton btnNewButton = new JButton("SignIn\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});
		btnNewButton.setBounds(40, 199, 82, 23);
		contentPane.add(btnNewButton);
	
//		btnNewButton.setFocusable(true);
//		btnNewButton.requestFocus(true);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.setBounds(132, 199, 99, 23);
		contentPane.add(btnSignup);
	}
}

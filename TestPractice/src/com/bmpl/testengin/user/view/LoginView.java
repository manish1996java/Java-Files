package com.bmpl.testengin.user.view;

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
import javax.swing.border.EmptyBorder;

import com.bmpl.testengin.user.userDAO.UserDAO;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;

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

	
	public void checkLogin()
	{
		String userid = username.getText();
		String password = new String(passwordField.getPassword()); 
		
		UserDAO userDAO = new UserDAO();
		
		try {		
			userDAO.doLogin(userid, password);
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * Create the frame.
	 */
	public LoginView() {
		setTitle("LoginView");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton login = new JButton("Sign In");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});
		login.setBounds(21, 216, 89, 23);
		contentPane.add(login);
		
		JButton signup = new JButton("Sign Up");
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		signup.setBounds(134, 216, 89, 23);
		contentPane.add(signup);
		
		username = new JTextField();
		username.setBounds(123, 82, 243, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblUsername.setBounds(21, 85, 76, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblPassword.setBounds(21, 141, 76, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 138, 243, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("SignIn From");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setBounds(155, 11, 138, 23);
		contentPane.add(lblNewLabel);
	}
}

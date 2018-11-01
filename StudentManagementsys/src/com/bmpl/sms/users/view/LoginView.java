package com.bmpl.sms.users.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.bmpl.sms.test.DashBoard;
import com.bmpl.sms.users.UserDAO.UserDAO;
import com.bmpl.sms.users.UserDTO.UserDTO;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField usrid;
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
	
	

	private void checkLogin() {
		
//		boolean checkfirstlogin = false;
		String userid = usrid.getText();
		String password = new String(passwordField.getPassword());
		
		UserDAO userDAO = new UserDAO();
		try {
			
		UserDTO userdto = userDAO.doLogin(userid, password);
		
		
		if(userdto != null)
		{

			if(userdto.isChecklogin())
			{
				ChangePassword changepass = new ChangePassword();
				changepass.setVisible(true);
				System.out.println("change your password");
			}
			else {
			JOptionPane.showMessageDialog(this, "login Successfully", "login", JOptionPane.INFORMATION_MESSAGE);
			DashBoard dashboard = new DashBoard();
			dashboard.setVisible(true);
			}
		}
		else {
			JOptionPane.showMessageDialog(this, "login fail", "login", JOptionPane.INFORMATION_MESSAGE);
		}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setTitle("Login View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 526, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserLogin = new JLabel("User Login ");
		lblUserLogin.setFont(new Font("Arial", Font.BOLD, 23));
		lblUserLogin.setBounds(135, 11, 148, 29);
		contentPane.add(lblUserLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPassword.setBounds(28, 151, 97, 14);
		contentPane.add(lblPassword);
		
		usrid = new JTextField();
		usrid.setBounds(135, 96, 255, 20);
		contentPane.add(usrid);
		usrid.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});
		btnNewButton.setBounds(28, 315, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(135, 315, 89, 23);
		contentPane.add(btnReset);
		
		JLabel lblUserid = new JLabel("UserId");
		lblUserid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblUserid.setBounds(28, 102, 97, 14);
		contentPane.add(lblUserid);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(135, 145, 255, 20);
		contentPane.add(passwordField);
	}
}
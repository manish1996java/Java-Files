package com.bmpl.testengin.user.view;

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

import com.bmpl.testengin.user.dao.UserDAO;
import com.bmpl.testengin.user.dto.UserDTO;

public class Loginview extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginview frame = new Loginview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void checkLogin()
	{
		String userid=userName.getText();
		String password=new String(passwordField.getPassword());
		
		UserDAO userDAO = new UserDAO();
		
		try {
			UserDTO userDTO = userDAO.doLogin(userid, password);
			
		if(userDTO!=null)
		{
			DashBoard dashBoard =  new DashBoard(userDTO);
			dashBoard.setExtendedState(JFrame.MAXIMIZED_BOTH);
			dashBoard.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(this,"Invalid user or password","TestEngin",JOptionPane.WARNING_MESSAGE);
		}
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this,"Some connection","TestEngin",JOptionPane.WARNING_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,"Some DB Issue","TestEngin",JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	 * Create the frame.
	 */
	public Loginview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserID");
		lblNewLabel.setBounds(22, 89, 79, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(22, 134, 79, 20);
		contentPane.add(lblNewLabel_1);
		
		userName = new JTextField();
		userName.setBounds(141, 89, 253, 20);
		contentPane.add(userName);
		userName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(141, 134, 253, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});
		btnLogin.setBounds(22, 215, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("LoginPage");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_2.setBounds(111, 11, 209, 35);
		contentPane.add(lblNewLabel_2);
	}
}
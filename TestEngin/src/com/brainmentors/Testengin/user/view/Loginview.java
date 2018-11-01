package com.brainmentors.Testengin.user.view;

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

import com.brainmentors.Testengin.user.UserDAO.UserDAO;

public class Loginview extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField usertxt;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;

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

	/**
	 * Create the frame.
	 */
	private void checkLogin()
	{
		System.out.println("Check Login");
		String userid= usertxt.getText();
		String password= new String(passwordField.getPassword());
		
		UserDAO userdao= new UserDAO();
		try {
			System.out.println("Enter in a do login tryblock");
			String massage=userdao.doLogin(userid, password);
			
			if(massage.toLowerCase().startsWith("welcome")) {
				Dashboard dashboard = new Dashboard();
				dashboard.setExtendedState(JFrame.MAXIMIZED_BOTH);
				dashboard.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(this, massage, "TestEngin", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Some DB issue", "Test Engine", JOptionPane.WARNING_MESSAGE);
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(this, "SQLException","Test Engine",JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	
	
	public Loginview() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(25, 99, 79, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(25, 156, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(66, 100, 122, 0);
		contentPane.add(textField);
		textField.setColumns(10);
		
		usertxt = new JTextField();
		usertxt.setBounds(138, 100, 265, 20);
		contentPane.add(usertxt);
		usertxt.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(138, 153, 265, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});
		btnNewButton.setBounds(45, 213, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("TestEngine");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel_2.setBounds(109, 11, 200, 33);
		contentPane.add(lblNewLabel_2);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(150, 213, 89, 23);
		contentPane.add(btnReset);
	}
}

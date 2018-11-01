package com.bmpl.testengin.user.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegistrationView extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField password;
	private JPasswordField confpassword;
	private String role;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationView frame = new RegistrationView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	ButtonGroup bg = new ButtonGroup();     // for grouping two or more buttons
	
	
	
	
	/**
	 * Create the frame.
	 */
	public RegistrationView() {
		setTitle("RegistrationView");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserid = new JLabel("UserId");
		lblUserid.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblUserid.setBounds(30, 96, 88, 19);
		contentPane.add(lblUserid);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblPassword.setBounds(30, 152, 88, 19);
		contentPane.add(lblPassword);
		
		JLabel lblConfpassword = new JLabel("Conf-Password");
		lblConfpassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblConfpassword.setBounds(30, 203, 101, 19);
		contentPane.add(lblConfpassword);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblRole.setBounds(30, 250, 88, 19);
		contentPane.add(lblRole);
		
		JLabel lblSignupForm = new JLabel("SignUp Form");
		lblSignupForm.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblSignupForm.setBounds(172, 33, 117, 19);
		contentPane.add(lblSignupForm);
		
		JButton signup = new JButton("SignUp");
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		signup.setBounds(30, 419, 89, 23);
		contentPane.add(signup);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		login.setBounds(137, 419, 89, 23);
		contentPane.add(login);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		reset.setBounds(371, 419, 89, 23);
		contentPane.add(reset);
		
		userid = new JTextField();
		userid.setBounds(158, 96, 241, 20);
		contentPane.add(userid);
		userid.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(158, 153, 241, 20);
		contentPane.add(password);
		
		confpassword = new JPasswordField();
		confpassword.setBounds(158, 204, 241, 20);
		contentPane.add(confpassword);
		
		JRadioButton teacher = new JRadioButton("Teacher");
		bg.add(teacher);
		teacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				role = teacher.getText();
			}
		});
		teacher.setBounds(129, 250, 65, 23);
		contentPane.add(teacher);
		
		
		JRadioButton student = new JRadioButton("Student");
		bg.add(student);
		student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				role = student.getText(); 
			}
		});
		student.setBounds(205, 250, 65, 23);
		contentPane.add(student);
	}
}

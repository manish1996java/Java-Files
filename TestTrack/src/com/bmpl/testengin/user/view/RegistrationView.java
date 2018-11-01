package com.bmpl.testengin.user.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.bmpl.testengin.user.userDAO.UserDAO;
import com.bmpl.testengin.user.userDTO.UserDTO;

public class RegistrationView extends JFrame {

	private String role;
	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField pass;
	private JPasswordField pass2;
	private JTextField textField;

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
	
	
		

	/**
	 * Create the frame.
	 */
	
	private void checkSignup() {
		String userN = userName.getText();
		String text = textField.getText();
		String password = new String(pass.getPassword());
		String confPass = new String(pass2.getPassword());
		UserDAO userDAO = new UserDAO();
		
		try {
			UserDTO userDTO = userDAO.doRegistraion(userN, text, password, confPass, role);
			
			if(userDTO != null)
			{
				
				UploadTest uploadtest = new UploadTest();
				uploadtest.setExtendedState(uploadtest.MAXIMIZED_BOTH);
				uploadtest.setVisible(true);
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	public RegistrationView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setBounds(150, 11, 141, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(24, 62, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("UserId");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(24, 117, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setBounds(24, 174, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Conf-Password");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_4.setBounds(24, 225, 108, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Role");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_5.setBounds(24, 275, 89, 14);
		contentPane.add(lblNewLabel_5);
		
		userName = new JTextField();
		userName.setBounds(142, 59, 227, 22);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JRadioButton Teacher = new JRadioButton("Teacher");
		Teacher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Teacher.isSelected())
				{
					role = Teacher.getText();
					System.out.println(role);
				}	
			
			}
		});
		Teacher.setBounds(94, 273, 65, 23);
		contentPane.add(Teacher);
		
		
		JRadioButton Student = new JRadioButton("Student");
		Student.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(Student.isSelected())
				{
					role = Student.getText();
					System.out.println(role);
				}
				
			}
			
		});
		Student.setBounds(176, 273, 65, 23);
		contentPane.add(Student);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkSignup();
			}
		});
		btnSubmit.setBounds(24, 351, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(142, 351, 89, 23);
		contentPane.add(btnReset);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(Teacher);
		bg.add(Student);
		
		pass = new JPasswordField();
		pass.setBounds(142, 171, 227, 22);
		contentPane.add(pass);
		
		pass2 = new JPasswordField();
		pass2.setBounds(142, 224, 227, 22);
		contentPane.add(pass2);
		
		textField = new JTextField();
		textField.setBounds(145, 116, 224, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}

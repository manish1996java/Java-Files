package com.bmpl.sms.test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.border.EmptyBorder;

public class SplashScreen extends JWindow {

	private JPanel contentPane;

	JLabel loadingnum = new JLabel(" ");
	JProgressBar loadingbar = new JProgressBar();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
					for(int i=0;i<=100;i++) {
						Thread.sleep(40);
						frame.loadingnum.setText(Integer.toString(i)+"%");
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	JLabel wall = new JLabel("");
	JLabel lblNewLabel = new JLabel("");
	JLabel lblSplashScreenFor = new JLabel("");
	
	//to upload the background image on the splash screen.
	public void uploadImage() {
		ImagePicker ipicker = new ImagePicker();
		ImagePickerDTO ipdto = null;
		wall.setBounds(0, 0, 613, 411);
		
		try {
			ipdto = ipicker.pickImage();
			lblNewLabel.setText(ipdto.getDescription());
			lblSplashScreenFor.setText(ipdto.getConame());
			wall.setIcon(new ImageIcon(new ImageIcon(SplashScreen.class.getResource(ipdto.getImage())).getImage().getScaledInstance(wall.getWidth(), wall.getHeight(), Image.SCALE_SMOOTH)));
		
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
	public SplashScreen() {
		setAutoRequestFocus(false);
		setBounds(400,200, 613, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(65, 105, 225));
		panel.setBounds(0, 0, 613, 411);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 38));
		lblNewLabel.setBounds(49, 40, 509, 50);
		panel.add(lblNewLabel);
		
		
		lblSplashScreenFor.setForeground(Color.WHITE);
		lblSplashScreenFor.setFont(new Font("Arial", Font.PLAIN, 11));
		lblSplashScreenFor.setBounds(221, 114, 162, 14);
		panel.add(lblSplashScreenFor);
		
		uploadImage(); // calling the upload image method.
		
		loadingnum.setFont(new Font("Tahoma", Font.PLAIN, 32));
		loadingnum.setForeground(Color.WHITE);
		loadingnum.setBounds(266, 190, 82, 73);
		panel.add(loadingnum);
		
		
		loadingbar.setBounds(125, 274, 374, 23);
		panel.add(loadingbar);
		
		
		
		panel.add(wall);
		
		uploadImage();
		
	}
}

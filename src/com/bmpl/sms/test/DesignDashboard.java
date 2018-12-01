package com.bmpl.sms.test;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DesignDashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesignDashboard frame = new DesignDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void setColor(JPanel panel)
	{
		panel.setBackground(Color.WHITE);
	}
	
	public void resetColor(JPanel panel)
	{
		panel.setBackground(new Color(106, 124, 141));
	}
	/**
	 * Create the frame.
	 */
	public DesignDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane menu_bar_panel = new JLayeredPane();
		menu_bar_panel.setBounds(0, 0, 916, 64);
		contentPane.add(menu_bar_panel);
		
		JLayeredPane button_description_panel = new JLayeredPane();
		button_description_panel.setBounds(259, 65, 657, 236);
		contentPane.add(button_description_panel);
		
		JPanel dashboarpanel = new JPanel();
		dashboarpanel.setBounds(0, 0, 657, 237);
		button_description_panel.add(dashboarpanel);
		dashboarpanel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(25, 24, 37, 38);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		Image labelimage = new ImageIcon(DesignDashboard.class.getResource("/com/bmpl/sms/test/calendericon.png")).getImage();
		label.setIcon(new ImageIcon(labelimage.getScaledInstance(label.getWidth(),label.getHeight(), labelimage.SCALE_SMOOTH)));
		dashboarpanel.add(label);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(25, 104, 37, 38);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		Image label2image = new ImageIcon(DesignDashboard.class.getResource("/com/bmpl/sms/test/youtubeicon.png")).getImage();
		label_2.setIcon(new ImageIcon(label2image.getScaledInstance(label_2.getWidth(),label_2.getHeight(), label2image.SCALE_SMOOTH)));
		dashboarpanel.add(label_2);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(25, 182, 37, 28);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		Image label4image = new ImageIcon(DesignDashboard.class.getResource("/com/bmpl/sms/test/viewallicon.png")).getImage();
		label_4.setIcon(new ImageIcon(label4image.getScaledInstance(label_4.getWidth(),label_4.getHeight(), label4image.SCALE_SMOOTH)));
		dashboarpanel.add(label_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(126, 201, 235));
		panel.setBounds(84, 11, 249, 56);
		dashboarpanel.add(panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(224, 170, 222));
		panel_3.setBounds(84, 94, 249, 56);
		dashboarpanel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(170, 168, 170));
		panel_4.setBounds(84, 170, 249, 56);
		dashboarpanel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(94, 193, 171));
		panel_5.setBounds(385, 11, 249, 56);
		dashboarpanel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(173, 195, 221));
		panel_6.setBounds(385, 94, 249, 56);
		dashboarpanel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(189, 179, 103));
		panel_7.setBounds(385, 170, 249, 56);
		dashboarpanel.add(panel_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 657, 237);
		button_description_panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 657, 237);
		button_description_panel.add(panel_2);
		
		JLayeredPane leftside_panel = new JLayeredPane();
		leftside_panel.setBounds(0, 65, 259, 578);
		contentPane.add(leftside_panel);
		Image circleimage = new ImageIcon(DesignDashboard.class.getResource("/com/bmpl/sms/test/circle_yellow.png")).getImage();
		
		JLabel lblNewLabel = new JLabel("0");
		lblNewLabel.setBounds(332, 364, 27, 28);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		leftside_panel.setLayer(lblNewLabel, 1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(106, 124, 141));
		panel_8.setBounds(0, 0, 259, 579);
		leftside_panel.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_14 = new JPanel();
		JPanel panel_15 = new JPanel();
		JPanel panel_16 = new JPanel();
		JPanel panel_17 = new JPanel();
		JPanel panel_18 = new JPanel();
		
		JPanel panel_9 = new JPanel();
		panel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setColor(panel_14);
				resetColor(panel_15);
				resetColor(panel_16);
				resetColor(panel_17);
				resetColor(panel_18);
			}
		});
		panel_9.setBackground(new Color(106, 124, 141));
		panel_9.setBounds(0, 88, 259, 56);
		panel_8.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Dashboard");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 259, 56);
		panel_9.add(lblNewLabel_1);
		
		
		panel_14.setBounds(0, 0, 7, 56);
		panel_14.setBackground(new Color(106, 124, 141));
		panel_9.add(panel_14);
		
		JLabel dashbordicon = new JLabel("");
		dashbordicon.setBounds(46, 11, 32, 34);
		dashbordicon.setIcon(new ImageIcon(new ImageIcon(DesignDashboard.class.getResource("/com/bmpl/sms/test/Survey_48px.png")).getImage().getScaledInstance(dashbordicon.getWidth(), dashbordicon.getHeight(), Image.SCALE_SMOOTH)));
		panel_9.add(dashbordicon);
		
		JPanel panel_10 = new JPanel();
		panel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setColor(panel_15);
				resetColor(panel_14);
				resetColor(panel_16);
				resetColor(panel_17);
				resetColor(panel_18);
			}
		});
		panel_10.setBackground(new Color(106, 124, 141));
		panel_10.setBounds(0, 144, 259, 56);
		panel_8.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Purchases");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 259, 56);
		panel_10.add(lblNewLabel_2);
		
		
		panel_15.setBounds(0, 0, 7, 56);
		panel_15.setBackground(new Color(106, 124, 141));
		panel_10.add(panel_15);
		
		JLabel purchasesicon = new JLabel("");
		purchasesicon.setBounds(46, 11, 30, 34);
		purchasesicon.setIcon(new ImageIcon(new ImageIcon(DesignDashboard.class.getResource("/com/bmpl/sms/test/Buy_48px.png")).getImage().getScaledInstance(purchasesicon.getWidth(), purchasesicon.getHeight(), Image.SCALE_SMOOTH)));
		panel_10.add(purchasesicon);
		
		JPanel panel_11 = new JPanel();
		panel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setColor(panel_16);
				resetColor(panel_15);
				resetColor(panel_14);
				resetColor(panel_17);
				resetColor(panel_18);
			}
		});
		panel_11.setBackground(new Color(106, 124, 141));
		panel_11.setBounds(0, 199, 259, 56);
		panel_8.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Sales");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 259, 56);
		panel_11.add(lblNewLabel_3);
		
		
		panel_16.setBounds(0, 0, 7, 56);
		panel_16.setBackground(new Color(106, 124, 141));
		panel_11.add(panel_16);
		
		JLabel salesicon = new JLabel("");
		salesicon.setBounds(46, 11, 32, 34);
		salesicon.setIcon(new ImageIcon(new ImageIcon(DesignDashboard.class.getResource("/com/bmpl/sms/test/Pricing_48px.png")).getImage().getScaledInstance(salesicon.getWidth(), salesicon.getHeight(), Image.SCALE_SMOOTH)));
		panel_11.add(salesicon);
		
		JPanel panel_12 = new JPanel();
		panel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setColor(panel_17);
				resetColor(panel_15);
				resetColor(panel_16);
				resetColor(panel_14);
				resetColor(panel_18);
			}
		});
		panel_12.setBackground(new Color(106, 124, 141));
		panel_12.setBounds(0, 256, 259, 62);
		panel_8.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Accounts");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 0, 259, 62);
		panel_12.add(lblNewLabel_4);
		
		
		panel_17.setBounds(0, 0, 7, 62);
		panel_17.setBackground(new Color(106, 124, 141));
		panel_12.add(panel_17);
		
		JLabel accountsicon = new JLabel("");
		accountsicon.setBounds(42, 17, 37, 34);
		accountsicon.setIcon(new ImageIcon(new ImageIcon(DesignDashboard.class.getResource("/com/bmpl/sms/test/Accounting_48px.png")).getImage().getScaledInstance(accountsicon.getWidth(), accountsicon.getHeight(), Image.SCALE_SMOOTH)));
		panel_12.add(accountsicon);
		
		JPanel panel_13 = new JPanel();
		panel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setColor(panel_18);
				resetColor(panel_15);
				resetColor(panel_16);
				resetColor(panel_17);
				resetColor(panel_14);
			}
		});
		panel_13.setBackground(new Color(106, 124, 141));
		panel_13.setBounds(0, 316, 259, 56);
		panel_8.add(panel_13);
		panel_13.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Report");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 0, 259, 56);
		panel_13.add(lblNewLabel_5);
		
		
		panel_18.setBounds(0, 0, 7, 56);
		panel_18.setBackground(new Color(106, 124, 141));
		panel_13.add(panel_18);
		
		JLabel reporticon = new JLabel("");
		reporticon.setBounds(44, 11, 31, 34);
		reporticon.setIcon(new ImageIcon(new ImageIcon(DesignDashboard.class.getResource("/com/bmpl/sms/test/Combo Chart_48px.png")).getImage().getScaledInstance(reporticon.getWidth(), reporticon.getHeight(), Image.SCALE_SMOOTH)));
		panel_13.add(reporticon);
		
		JLabel lblUser = new JLabel("user");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUser.setForeground(Color.WHITE);
		lblUser.setBounds(105, 488, 46, 14);
		panel_8.add(lblUser);
		
		JLabel lblCredits = new JLabel("Credits");
		lblCredits.setForeground(Color.WHITE);
		lblCredits.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCredits.setBounds(90, 513, 79, 30);
		panel_8.add(lblCredits);
		
		JLabel lblAll = new JLabel(" All copyrights  \u00A9 bmpl software");
		lblAll.setForeground(Color.WHITE);
		lblAll.setBounds(54, 554, 205, 14);
		panel_8.add(lblAll);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel circle = new JLabel("");
		circle.setBounds(332, 354, 27, 38);
		contentPane.add(circle);
		circle.setHorizontalAlignment(SwingConstants.CENTER);
		circle.setIcon(new ImageIcon(circleimage.getScaledInstance(circle.getWidth(),circle.getHeight(), circleimage.SCALE_SMOOTH)));
		
		
	}
}

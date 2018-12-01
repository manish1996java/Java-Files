package com.bmpl.sms.users.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;


public class Recipt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recipt frame = new Recipt();
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
	public Recipt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel reciptpanel = new JPanel();
		reciptpanel.setBounds(10, 11, 736, 505);
		contentPane.add(reciptpanel);
		reciptpanel.setLayout(null);
		
		JLabel label = new JLabel("____________________________________________\r\n_______");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBounds(88, 62, 309, 14);
		reciptpanel.add(label);
		
		JLabel label_1 = new JLabel("Brain Mentors Pvt Ltd.");
		label_1.setFont(new Font("Monotype Corsiva", Font.PLAIN, 37));
		label_1.setBounds(78, 45, 319, 24);
		reciptpanel.add(label_1);
		
		JLabel lblHelpingMindsTo = new JLabel("Helping minds to perform in IT World.");
		lblHelpingMindsTo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
		lblHelpingMindsTo.setBounds(164, 77, 233, 24);
		reciptpanel.add(lblHelpingMindsTo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, -19, 78, 132);
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(Recipt.class.getResource("/images/brainlogo-ConvertImage.jpg")).getImage().getScaledInstance( lblNewLabel.getWidth(), lblNewLabel.getHeight(),Image.SCALE_SMOOTH)));
		reciptpanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Received with thanks from Mr./Ms.  ...................................................................................................................................................");
		lblNewLabel_1.setFont(new Font("Andalus", Font.ITALIC, 16));
		lblNewLabel_1.setBounds(24, 237, 686, 24);
		reciptpanel.add(lblNewLabel_1);
		
		JLabel lblAddress = new JLabel("Address  ...............................................................................................................................................................................................................");
		lblAddress.setFont(new Font("Andalus", Font.ITALIC, 16));
		lblAddress.setBounds(24, 272, 686, 24);
		reciptpanel.add(lblAddress);
		
		JLabel lblTheSumOf = new JLabel("the sum of Rupees  .......................................................................................................................................................................................");
		lblTheSumOf.setFont(new Font("Andalus", Font.ITALIC, 16));
		lblTheSumOf.setBounds(24, 307, 686, 24);
		reciptpanel.add(lblTheSumOf);
		
		JLabel lblByCashchequedraftNo = new JLabel("by Cash/Cheque*/Draft No.  ................................................Dated............................................Drawn on.....................................");
		lblByCashchequedraftNo.setFont(new Font("Andalus", Font.ITALIC, 16));
		lblByCashchequedraftNo.setBounds(24, 342, 686, 24);
		reciptpanel.add(lblByCashchequedraftNo);
		
		JLabel lblOnAccountOf = new JLabel("on account of Course  .............................................Balance Due........................................................................................................");
		lblOnAccountOf.setFont(new Font("Andalus", Font.ITALIC, 16));
		lblOnAccountOf.setBounds(24, 377, 686, 24);
		reciptpanel.add(lblOnAccountOf);
		
		JLabel lblAddressIst = new JLabel("Address: 23. Ist & 2nd Floor, Block-C, Pocket-9, Sector-7");
		lblAddressIst.setBounds(79, 114, 345, 14);
		reciptpanel.add(lblAddressIst);
		
		JLabel lblMob = new JLabel("Mob. : 7042434524,");
		lblMob.setBounds(82, 148, 110, 14);
		reciptpanel.add(lblMob);
		
		JLabel lblNewLabel_2 = new JLabel("(Opp. Metro Pillar No. :400) Rohini, Delhi - 110085");
		lblNewLabel_2.setBounds(78, 131, 258, 14);
		reciptpanel.add(lblNewLabel_2);
		
		JLabel lblEmailBrainmentorspvtltdgmailcom = new JLabel("E-mail : brainmentorspvtltd@gmail.com");
		lblEmailBrainmentorspvtltdgmailcom.setBounds(82, 165, 223, 14);
		reciptpanel.add(lblEmailBrainmentorspvtltdgmailcom);
		
		JLabel lblWebWwwbrainmentorscom = new JLabel("Web. : www.brain-mentors.com");
		lblWebWwwbrainmentorscom.setBounds(82, 185, 171, 14);
		reciptpanel.add(lblWebWwwbrainmentorscom);
		
		JLabel lblReceipt = new JLabel("RECEIPT");
		lblReceipt.setFont(new Font("Arial", Font.BOLD, 13));
		lblReceipt.setBackground(Color.BLACK);
		lblReceipt.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceipt.setBounds(353, 165, 110, 34);
		reciptpanel.add(lblReceipt);
		
		JLabel lblNewLabel_3 = new JLabel("Dated ..............................");
		lblNewLabel_3.setBounds(539, 109, 171, 24);
		reciptpanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NOTE : FEES IS NOT REFUNDABLE");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(44, 412, 195, 14);
		reciptpanel.add(lblNewLabel_4);
		
		JLabel lblchequesAreSubject = new JLabel("*Cheques are subject to realisation");
		lblchequesAreSubject.setBounds(44, 480, 195, 14);
		reciptpanel.add(lblchequesAreSubject);
		
		JLabel lblRs = new JLabel("Rs . _____________");
		lblRs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRs.setBounds(44, 437, 180, 32);
		reciptpanel.add(lblRs);
		
		JLabel label_2 = new JLabel("Brain Mentors Pvt Ltd.");
		label_2.setFont(new Font("Monotype Corsiva", Font.PLAIN, 30));
		label_2.setBounds(444, 424, 266, 24);
		reciptpanel.add(label_2);
		
		JLabel lblFor = new JLabel("For");
		lblFor.setFont(new Font("Arial", Font.BOLD, 13));
		lblFor.setBackground(Color.BLACK);
		lblFor.setBounds(419, 427, 31, 24);
		reciptpanel.add(lblFor);
	}
}

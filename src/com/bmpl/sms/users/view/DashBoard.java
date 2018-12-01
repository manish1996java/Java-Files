package com.bmpl.sms.users.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.bmpl.sms.users.DTO.RightDTO;
import com.bmpl.sms.users.DTO.UserDTO;

public class DashBoard extends JFrame {

	private JPanel contentPane;

	
	JMenu mnFile;
	JLabel lblNewLabel = new JLabel("");
	
	public void createMenu(String username,ArrayList<RightDTO> rightdto)
	{
		System.out.println(rightdto.toString());
		
		lblNewLabel.setText("Wellcome "+username);
		for(RightDTO rgtdto: rightdto) {
			
		JMenuItem jmenuitem = new JMenuItem(rgtdto.getRightname());
		jmenuitem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String screen = rgtdto.getScreen();
				System.out.println("kkkk");
				String packagename = "com.bmpl.sms.users.view.";
				String fullclassname = packagename+screen;
				System.out.println(fullclassname);
				loadScreen(fullclassname);

			}
			
		});
		mnFile.add(jmenuitem);
		}	
	}
	
	public void loadScreen(String screen)
	{
		try {
				Object object = Class.forName(screen).newInstance();
				Method method = object.getClass().getMethod("setVisible", boolean.class);
					method.invoke(object,true);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				} catch (IllegalAccessException e) {
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
	public DashBoard(UserDTO userdto) {
		setTitle("DashBoard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 477);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("file");
		menuBar.add(mnFile);
		
		createMenu(userdto.getUserid(),userdto.getRights());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(5, 5, 602, 67);
		contentPane.add(lblNewLabel);
	}

}

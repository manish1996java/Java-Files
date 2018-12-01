package com.bmpl.sms.users.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.bmpl.sms.users.DAO.StudentDAO;
import com.bmpl.sms.utils.CommonMethods;
import com.toedter.calendar.JDateChooser;

public class StudentEnquiry extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField fname;
	private JTextField address;
	private JTextField phoneno;
	private JTextField email;
	private JTextField intcourse;
	private JTextField batchtime;
	private JTextField clgName;
	private JTextField counselorName;
	private JDateChooser date; 
	private JDateChooser dob;
	private JCheckBox d1;
	private JCheckBox d2 ;
	private JRadioButton student ;
	private JRadioButton emp;
	private JRadioButton self;
	private JRadioButton other;
	private JRadioButton newspaper;
	private JRadioButton internet;
	private JRadioButton friend;
	private JRadioButton advertise;
	private JRadioButton oth;
	private ButtonGroup b1 = new ButtonGroup();
	private ButtonGroup b2 = new ButtonGroup();
	private JLabel label_6;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentEnquiry frame = new StudentEnquiry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void asktoclose()
	{
		CommonMethods.asktoClose(this);
	}
	public void setSystemDate()
	{
		Date inqdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String a = sdf.format(inqdate);
		try {
			date.setDate(sdf.parse(a));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void checkBlankFields()
	{
		if((name.getText() == null || name.getText().trim().isEmpty()) && 
				(address.getText() == null || address.getText().trim().isEmpty()) && 
				(phoneno.getText() == null || phoneno.getText().trim().isEmpty()) && 
				(intcourse.getText() == null || intcourse.getText().trim().isEmpty()) && 
				(counselorName.getText() == null || counselorName.getText().trim().isEmpty()) &&  
				(dob == null || ((JTextField)dob.getDateEditor().getUiComponent()).getText().trim().isEmpty())){
			
			JOptionPane.showMessageDialog(this,"please fill mandatory details..", "Student inquary" ,JOptionPane.WARNING_MESSAGE );
		}
		

		else {
//			checkData();
			JOptionPane.showMessageDialog(this , "you details has been updated", "enquiry form", JOptionPane.INFORMATION_MESSAGE);
			ReflectStudentDetails rsd = new ReflectStudentDetails();
			rsd.setVisible(true);
		}
		
	}

	public void checkData()
	{
		String sname = name.getText();
		String faname = fname.getText();
		String addr = address.getText();
		String phone = phoneno.getText();
		String emailid = email.getText();
		String intrcourse = intcourse.getText();
		String prebatchtime = batchtime.getText();
		String colgName = clgName.getText();
		String counsName = counselorName.getText();
		String idate = ((JTextField)date.getDateEditor().getUiComponent()).getText();
		String sdob = ((JTextField)dob.getDateEditor().getUiComponent()).getText();
		String dayPref =" ";
		String occupation = null;
		String aboutbmpl = null;
		if(d1.isSelected()) {
			dayPref += d1.getText() +" ";
		}
		if(d2.isSelected())
		{
			dayPref += d2.getText() +" ";
		}
		if(student.isSelected()) {
			occupation = student.getText();
		}
		else if (emp.isSelected()) {
			occupation = emp.getText();
		}
		else if(self.isSelected()) {
			occupation = self.getText();
		}
		else
		{
			occupation = other.getText();
		}
		if(newspaper.isSelected()) {
			aboutbmpl = newspaper.getText();
		}
		else if(internet.isSelected()) {
			aboutbmpl = internet.getText();
		}
		else if(friend.isSelected()) {
			aboutbmpl = friend.getText();
		}
		else if(advertise.isSelected()) {
			aboutbmpl = advertise.getText();
		}
		else
		{
			aboutbmpl = oth.getText();
		}
		//System.out.println(dayPref);
//		Date idate = date.getDate();
		//System.out.println(idate);
//		Date sdob = date.getDate();
		//System.out.println(sdob);
		StudentDAO stdao = new StudentDAO();
		try {
			stdao.updateStudInfo(sname,faname,addr,phone,
					emailid,intrcourse,prebatchtime,
					colgName,counsName,idate,sdob,dayPref,occupation,aboutbmpl );
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
//	public void dayPrefCheckbox(){
//		String result="";
//		for()
//		
//	}
//	
//	public void occupationCheckbox() {
//		
//	}
//	
//	public void bmplCheckbox()
//	{
//		
//	}
	
	
	/**
	 * Create the frame.
	 */
	public StudentEnquiry() {
		this.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e) {
				 asktoclose();
			 }
			
		});
		setTitle("StudentEnquiryView");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setResizable(false);
		setBounds(400, 10, 708, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(21, 90, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblFathersName = new JLabel("father's Name");
		lblFathersName.setBounds(21, 127, 109, 14);
		contentPane.add(lblFathersName);
		
		JLabel lblCourseInterested = new JLabel("Course Interested");
		lblCourseInterested.setBounds(21, 292, 128, 14);
		contentPane.add(lblCourseInterested);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(21, 158, 85, 14);
		contentPane.add(lblAddress);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(21, 193, 109, 14);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setBounds(21, 228, 85, 14);
		contentPane.add(lblPhoneNo);
		
		JLabel lblEmail = new JLabel("E-mail ID");
		lblEmail.setBounds(21, 259, 64, 14);
		contentPane.add(lblEmail);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(479, 90, 46, 14);
		contentPane.add(lblDate);
		
		name = new JTextField();
		name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
//				int code = e.getKeyCode()
//				System.out.println(e.getKeyChar());
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					fname.requestFocus();
				}
			}
		});
		name.setFocusable(true);
		name.setBounds(186, 86, 224, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		fname = new JTextField();
		fname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					address.requestFocus();
				}
			}
		});
		fname.setColumns(10);
		fname.setBounds(186, 123, 224, 20);
		contentPane.add(fname);
		
		address = new JTextField();
		address.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					phoneno.requestFocus();
				}
				
			}
		});
		address.setColumns(10);
		address.setBounds(186, 154, 339, 20);
		contentPane.add(address);
		
		phoneno = new JTextField();
		phoneno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					email.requestFocus();
				}
				
			}
		});
		phoneno.setColumns(10);
		phoneno.setBounds(186, 224, 224, 20);
		contentPane.add(phoneno);
		
		email = new JTextField();
		email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					intcourse.requestFocus();
				}
				
			}
		});
		email.setColumns(10);
		email.setBounds(186, 255, 224, 20);
		contentPane.add(email);
		
		JLabel lblBatchTimingsPreference = new JLabel("Batch Timings Preference");
		lblBatchTimingsPreference.setBounds(21, 327, 155, 14);
		contentPane.add(lblBatchTimingsPreference);
		
		intcourse = new JTextField();
		intcourse.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					batchtime.requestFocus();
				}
				
			}
		});
		intcourse.setColumns(10);
		intcourse.setBounds(186, 288, 224, 20);
		contentPane.add(intcourse);
		
		batchtime = new JTextField();
		batchtime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					clgName.requestFocus();
				}
			}
		});
		batchtime.setColumns(10);
		batchtime.setBounds(186, 323, 224, 20);
		contentPane.add(batchtime);
		
		clgName = new JTextField();
		clgName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					counselorName.requestFocus();
				}
			}
		});
		clgName.setColumns(10);
		clgName.setBounds(186, 439, 224, 20);
		contentPane.add(clgName);
		
		 d1 = new JCheckBox("WeekDays(Mon-Fri)");
		d1.setBounds(132, 364, 128, 23);
		contentPane.add(d1);
		
		d2 = new JCheckBox("Weekend(Sat-Sun)");
		d2.setBounds(262, 364, 128, 23);
		contentPane.add(d2);
		
//		if(chckbxNewCheckBox.isSelected())
//		{
//			dayPref += chckbxNewCheckBox.getText();
//			System.out.println(dayPref);
//		}
//		if(chckbxWeekendsatsun.isSelected())
//		{
//			dayPref += chckbxWeekendsatsun.getText();
//			System.out.println(dayPref);
//		}
		
		JLabel lblDaysPreference = new JLabel("Days Preference");
		lblDaysPreference.setBounds(21, 368, 128, 14);
		contentPane.add(lblDaysPreference);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setBounds(21, 406, 85, 14);
		contentPane.add(lblOccupation);
		
		JLabel lblCollegeCompany = new JLabel("College / Company Name");
		lblCollegeCompany.setBounds(21, 442, 148, 14);
		contentPane.add(lblCollegeCompany);
		
		JLabel lblHowDoYou = new JLabel("How Do You Know about Brain mentores");
		lblHowDoYou.setBounds(21, 479, 218, 14);
		contentPane.add(lblHowDoYou);
		
		JButton submitbutton = new JButton("Submit");
		submitbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBlankFields();
			}
		});
		
		submitbutton.setBounds(571, 643, 89, 23);
		contentPane.add(submitbutton);
		
		JLabel lblCounselorName = new JLabel("Counselor Name");
		lblCounselorName.setBounds(21, 563, 99, 14);
		contentPane.add(lblCounselorName);
		
		counselorName = new JTextField();
		counselorName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					getRootPane().setDefaultButton(submitbutton);
					submitbutton.requestFocus();
				}
				
			}
		});
		counselorName.setColumns(10);
		counselorName.setBounds(186, 560, 224, 20);
		contentPane.add(counselorName);
		
		date = new JDateChooser();
		date.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					phoneno.requestFocus();
				}
				
			}
		});
		date.setDateFormatString("yyyy/MM/dd");
		date.setBounds(535, 90, 128, 20);
		contentPane.add(date);
		
		dob = new JDateChooser();
		dob.setDateFormatString("yyyy/MM/dd");
		dob.setBounds(185, 187, 224, 20);
		contentPane.add(dob);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 11, 692, 38);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Student Enquiry");
		label.setBounds(274, 11, 141, 22);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(label);
		
		student = new JRadioButton("Student");
		student.setBounds(132, 402, 85, 23);
		contentPane.add(student);
		
		emp = new JRadioButton("Employee");
		emp.setBounds(219, 402, 85, 23);
		contentPane.add(emp);
		
		self = new JRadioButton("SelfEmployee");
		self.setBounds(306, 402, 109, 23);
		contentPane.add(self);
		
		other = new JRadioButton("Others");
		other.setBounds(416, 402, 109, 23);
		contentPane.add(other);
		b1.add(student);
		b1.add(emp);
		b1.add(self);
		b1.add(other);
		newspaper = new JRadioButton("NewsPaper");
		newspaper.setBounds(21, 516, 109, 23);
		contentPane.add(newspaper);
		
		internet = new JRadioButton("Internet");
		internet.setBounds(138, 516, 79, 23);
		contentPane.add(internet);
		
		friend = new JRadioButton("Friend");
		friend.setBounds(215, 516, 64, 23);
		contentPane.add(friend);
		
		advertise = new JRadioButton("Advertisement");
		advertise.setBounds(281, 516, 109, 23);
		contentPane.add(advertise);
		
		oth = new JRadioButton("Others");
		oth.setBounds(390, 516, 109, 23);
		contentPane.add(oth);
		b2.add(newspaper);
		b2.add(internet);
		b2.add(advertise);
		b2.add(friend);
		b2.add(oth);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(56, 86, 29, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(79, 228, 16, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(69, 152, 16, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(120, 288, 29, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(109, 560, 29, 14);
		contentPane.add(label_5);
		
		label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(90, 193, 16, 14);
		contentPane.add(label_6);
		
		
		setSystemDate();
		
	}
}

package com.bmpl.sms.users.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.bmpl.sms.users.DAO.DateDAO;
import com.bmpl.sms.users.DAO.StudentDAO;
import com.bmpl.sms.users.DTO.StudentDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ReflectStudentDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JDateChooser from;
	private JDateChooser to;
	ArrayList<StudentDTO> list;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReflectStudentDetails frame = new ReflectStudentDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void clearDateField()
	{
		from.setDate(null);
		to.setDate(null);
	}
	
	
	
	public void fiterByDate()
	{
		
		String fromdate = ((JTextField)from.getDateEditor().getUiComponent()).getText();
		String todate = ((JTextField)to.getDateEditor().getUiComponent()).getText();
		
		System.out.println(fromdate);
		System.out.println(todate);
		DateDAO datedao = new DateDAO();
		try {
			
			list = datedao.filterByDate(fromdate, todate);

			DefaultTableModel dtm = (DefaultTableModel)table.getModel();
			Object[] rowdata = new Object[15]; 
			
			for(int i=0;i<list.size();i++)
			{
				rowdata[0] = list.get(i).getName();
				rowdata[1] = list.get(i).getFatherName();
				rowdata[2] = list.get(i).getCourse();
				rowdata[3] = list.get(i).getPhoneno();
				rowdata[4] = list.get(i).getAddress();
				rowdata[5] = list.get(i).getEmail();
				rowdata[6] = list.get(i).getDob();
				rowdata[7] = list.get(i).getOccupation();
				rowdata[8] = list.get(i).getDaypreference();
				rowdata[9] = list.get(i).getDate();
				rowdata[10] = list.get(i).getPrefBatchTime();
				rowdata[11] = list.get(i).getCollageName();
				rowdata[12] = list.get(i).getCounselorName();
				rowdata[13] = list.get(i).getAboutbmpl();
				rowdata[14] = list.get(i).getStatus();
							 
				dtm.addRow(rowdata);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	private JTextField tsname;
	private JTextField tsfname;
	private JTextField tsdob;
	private JTextField tsaddress;
	private JTextField tscourse;
	private JTextField tsprefbatch;
	private JTextField tsphone;
	private JTextField tsoccupation;
	private JTextField tsaboutbmpl;
	private JTextField tscounselorn;
	private JTextField tsclg;
	JLabel tsprefday;
	JLabel tsinquirydate;
	private JTextField tsemail;
	
	
	public void browse() {
		String path = "";
		JFileChooser jchooser = new JFileChooser();
		jchooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int a = jchooser.showSaveDialog(this);
	
		
		if(a == JFileChooser.APPROVE_OPTION)
		{
			path = jchooser.getSelectedFile().getAbsolutePath() + "\\sms.pdf";
			System.out.println(path);
		}
		
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(path));
			document.open();
			
			Paragraph paragraph = new Paragraph("http://www.bmpl.com");
			document.add(paragraph);
			
			
			
			System.out.println("Finished");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//add 
		PdfPTable  pdftable = new PdfPTable(14);
		
		PdfPCell c1 = new PdfPCell(new Phrase(table.getColumnName(0)));
		pdftable.addCell(c1);
		c1 = new PdfPCell(new Phrase(table.getColumnName(1)));
		pdftable.addCell(c1);
		c1 = new PdfPCell(new Phrase(table.getColumnName(2)));
		pdftable.addCell(c1);
		c1 = new PdfPCell(new Phrase(table.getColumnName(3)));
		pdftable.addCell(c1);
		c1 = new PdfPCell(new Phrase(table.getColumnName(4)));
		pdftable.addCell(c1);
		c1 = new PdfPCell(new Phrase(table.getColumnName(5)));
		pdftable.addCell(c1);
		c1 = new PdfPCell(new Phrase(table.getColumnName(6)));
		pdftable.addCell(c1);
		c1 = new PdfPCell(new Phrase(table.getColumnName(7)));
		pdftable.addCell(c1);
		c1 = new PdfPCell(new Phrase(table.getColumnName(8)));
		pdftable.addCell(c1);
		c1 = new PdfPCell(new Phrase(table.getColumnName(9)));
		pdftable.addCell(c1);
		c1 = new PdfPCell(new Phrase(table.getColumnName(10)));
		pdftable.addCell(c1);
		c1 = new PdfPCell(new Phrase(table.getColumnName(11)));
		pdftable.addCell(c1);
		c1 = new PdfPCell(new Phrase(table.getColumnName(12)));
		pdftable.addCell(c1);
		c1 = new PdfPCell(new Phrase(table.getColumnName(13)));
		pdftable.addCell(c1);
		
		for(int i=0;i<table.getRowCount();i++) {
			String name = table.getValueAt(i,0).toString();
			pdftable.addCell(name);
			String fathername = table.getValueAt(i,1).toString();
			pdftable.addCell(fathername);
			String course = table.getValueAt(i,2).toString();
			pdftable.addCell(course);
			String phone = table.getValueAt(i,3).toString();
			pdftable.addCell(phone);
			String address = table.getValueAt(i,4).toString();
			pdftable.addCell(address);
			String email = table.getValueAt(i,5).toString();
			pdftable.addCell(email);
			String dob = table.getValueAt(i,6).toString();
			pdftable.addCell(dob);
			String occupation = table.getValueAt(i,7).toString();
			pdftable.addCell(occupation);
			String preferdate = table.getValueAt(i,8).toString();
			pdftable.addCell(preferdate);
			String inquirydate = table.getValueAt(i,9).toString();
			pdftable.addCell(inquirydate);
			String prfbatch = table.getValueAt(i,10).toString();
			pdftable.addCell(prfbatch);
			String clg = table.getValueAt(i,11).toString();
			pdftable.addCell(clg);
			String counslor = table.getValueAt(i,12).toString();
			pdftable.addCell(counslor);
			String aboutbmpl = table.getValueAt(i,13).toString();
			pdftable.addCell(aboutbmpl);
		}
		
		
		try {
			document.add(pdftable);
			document.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clearField()
	{
		tsname.setText("");
		tsfname.setText("");
		tsdob.setText("");
		tsaddress.setText("");
		tsaddress.setText("");
		tsprefbatch.setText("");
		tsphone.setText("");
		tsoccupation.setText("");
		tscounselorn.setText("");
		tsprefday.setText("");
		tsinquirydate.setText("");
		tsemail.setText("");
	}
	
	public void loadDetails() {
		StudentDAO stddao = new StudentDAO();
		try {
			list = stddao.getStudInfo();
			
			DefaultTableModel dtm = (DefaultTableModel)table.getModel();
			Object[] rowdata = new Object[15]; 
			
			for(int i=0;i<list.size();i++)
			{
				rowdata[0] = list.get(i).getName();
				rowdata[1] = list.get(i).getFatherName();
				rowdata[2] = list.get(i).getCourse();
				rowdata[3] = list.get(i).getPhoneno();
				rowdata[4] = list.get(i).getAddress();
				rowdata[5] = list.get(i).getEmail();
				rowdata[6] = list.get(i).getDob();
				rowdata[7] = list.get(i).getOccupation();
				rowdata[8] = list.get(i).getDaypreference();
				rowdata[9] = list.get(i).getDate();
				rowdata[10] = list.get(i).getPrefBatchTime();
				rowdata[11] = list.get(i).getCollageName();
				rowdata[12] = list.get(i).getCounselorName();
				rowdata[13] = list.get(i).getAboutbmpl();
				rowdata[14] = list.get(i).getStatus();
				
						
				dtm.addRow(rowdata);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void tableDataInTextbox()
	{
		int index = table.getSelectedRow();
		
		tsname.setText(table.getModel().getValueAt(index, 0).toString());
		tsfname.setText(table.getModel().getValueAt(index, 1).toString());
		tscourse.setText(table.getModel().getValueAt(index, 2).toString());
		tsphone.setText(table.getModel().getValueAt(index, 3).toString());
		tsaddress.setText(table.getModel().getValueAt(index, 4).toString());
		tsemail.setText(table.getModel().getValueAt(index, 5).toString());
		tsdob.setText(table.getModel().getValueAt(index, 6).toString());
		tsoccupation.setText(table.getModel().getValueAt(index, 7).toString());
		tsprefday.setText(table.getModel().getValueAt(index, 8).toString());
		tsinquirydate.setText(table.getModel().getValueAt(index, 9).toString());
		tsprefbatch.setText(table.getModel().getValueAt(index, 10).toString());
		tsclg.setText(table.getModel().getValueAt(index, 11).toString());
		tscounselorn.setText(table.getModel().getValueAt(index, 12).toString());
		tsaboutbmpl.setText(table.getModel().getValueAt(index, 13).toString());

	}
	/**
	 * Create the frame.
	 */
	public ReflectStudentDetails() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 799, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearField();
				tableDataInTextbox();

			}
		});
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Father Name", "Course", "Phoneno", "address", "Email", "DOB", "Occupation", "Preferenceday", "Inquiry Date", "Pref Batcht Time", "Collage/Comp Name", "Counselor", "KnowAboutBMPL", "Status"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(104);
		table.getColumnModel().getColumn(2).setPreferredWidth(96);
		table.getColumnModel().getColumn(3).setPreferredWidth(108);
		table.getColumnModel().getColumn(5).setPreferredWidth(202);
		table.getColumnModel().getColumn(6).setPreferredWidth(113);
		table.getColumnModel().getColumn(9).setPreferredWidth(110);
		table.getColumnModel().getColumn(10).setPreferredWidth(99);
		table.getColumnModel().getColumn(11).setPreferredWidth(123);
		table.getColumnModel().getColumn(12).setPreferredWidth(94);
		table.setBounds(10, 75, 612, 358);
		
		
		JScrollPane sclgname = new JScrollPane();
		sclgname.setBounds(0, 324, 779, 293);
		sclgname.setViewportView(table);
		contentPane.add(sclgname);
		
		from = new JDateChooser();
		from.setDateFormatString("yyyy/MM/dd");
		from.setBounds(115, 22, 148, 20);
		contentPane.add(from);
		
		to = new JDateChooser();
		to.setDateFormatString("yyyy/MM/dd");
		to.setBounds(115, 58, 148, 20);
		contentPane.add(to);
		
		JLabel lblNewLabel = new JLabel("From :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(21, 28, 76, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTo = new JLabel("To  :");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTo.setBounds(21, 64, 76, 14);
		contentPane.add(lblTo);
		
		JButton btnNewButton = new JButton("Fetch");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fiterByDate();
				clearDateField();
			}
		});
		btnNewButton.setBounds(21, 106, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnLoadAll = new JButton("Load All");
		btnLoadAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDetails();
			}
		});
		btnLoadAll.setBounds(21, 290, 89, 23);
		contentPane.add(btnLoadAll);
		
		JPanel selectedrowdetail = new JPanel();
		selectedrowdetail.setBounds(284, 11, 489, 302);
		contentPane.add(selectedrowdetail);
		selectedrowdetail.setLayout(null);
		

		JLabel sname;
		sname = new JLabel("Name");
		sname.setBounds(10, 11, 46, 22);
		selectedrowdetail.add(sname);
		
		JLabel sfname;
		sfname = new JLabel("Father Name");
		sfname.setBounds(10, 40, 82, 22);
		selectedrowdetail.add(sfname);
		
		JLabel scourse;
		scourse = new JLabel("Course");
		scourse.setBounds(10, 146, 46, 22);
		selectedrowdetail.add(scourse);
		
		JLabel sphone;
		sphone = new JLabel("Phone");
		sphone.setBounds(10, 212, 63, 22);
		selectedrowdetail.add(sphone);
		
		JLabel sdob;
		sdob = new JLabel("DOB");
		sdob.setBounds(16, 73, 40, 22);
		selectedrowdetail.add(sdob);
		
		JLabel sprefbatch;
		sprefbatch = new JLabel("Prefer-Batch");
		sprefbatch.setBounds(10, 179, 82, 22);
		selectedrowdetail.add(sprefbatch);
		
		JLabel sclg;
		sclg = new JLabel("College/compnay");
		sclg.setBounds(256, 174, 119, 22);
		selectedrowdetail.add(sclg);
		
		JLabel sinquirydate;
		sinquirydate = new JLabel("Student Enquiry Date");
		sinquirydate.setBounds(256, 11, 128, 22);
		selectedrowdetail.add(sinquirydate);
		
		JLabel counselorn;
		counselorn = new JLabel("Counselor Name");
		counselorn.setBounds(256, 141, 128, 22);
		selectedrowdetail.add(counselorn);
		
		JLabel saddress;
		saddress = new JLabel("Address");
		saddress.setBounds(10, 106, 55, 22);
		selectedrowdetail.add(saddress);
		
		JLabel sprefday;
		sprefday = new JLabel("Prefer Day");
		sprefday.setBounds(256, 44, 63, 18);
		selectedrowdetail.add(sprefday);
		
		JLabel occupation;
		occupation = new JLabel("Occupation");
		occupation.setBounds(256, 77, 73, 18);
		selectedrowdetail.add(occupation);
		
		JLabel aboutbmpl;
		aboutbmpl = new JLabel("know about bmpl");
		aboutbmpl.setBounds(256, 112, 137, 18);
		selectedrowdetail.add(aboutbmpl);
		
		tsname = new JTextField();
		tsname.setBounds(89, 12, 86, 20);
		selectedrowdetail.add(tsname);
		tsname.setColumns(10);
		
		tsfname = new JTextField();
		tsfname.setColumns(10);
		tsfname.setBounds(89, 41, 86, 20);
		selectedrowdetail.add(tsfname);
		
		tsdob = new JTextField();
		tsdob.setColumns(10);
		tsdob.setBounds(89, 74, 86, 20);
		selectedrowdetail.add(tsdob);
		
		tsaddress = new JTextField();
		tsaddress.setColumns(10);
		tsaddress.setBounds(89, 107, 137, 20);
		selectedrowdetail.add(tsaddress);
		
		tscourse = new JTextField();
		tscourse.setColumns(10);
		tscourse.setBounds(89, 147, 86, 20);
		selectedrowdetail.add(tscourse);
		
		tsprefbatch = new JTextField();
		tsprefbatch.setColumns(10);
		tsprefbatch.setBounds(89, 180, 86, 20);
		selectedrowdetail.add(tsprefbatch);
		
		tsphone = new JTextField();
		tsphone.setColumns(10);
		tsphone.setBounds(89, 213, 86, 20);
		selectedrowdetail.add(tsphone);
		
		tsoccupation = new JTextField();
		tsoccupation.setColumns(10);
		tsoccupation.setBounds(364, 74, 86, 20);
		selectedrowdetail.add(tsoccupation);
		
		tsaboutbmpl = new JTextField();
		tsaboutbmpl.setColumns(10);
		tsaboutbmpl.setBounds(364, 107, 86, 20);
		selectedrowdetail.add(tsaboutbmpl);
		
		tscounselorn = new JTextField();
		tscounselorn.setColumns(10);
		tscounselorn.setBounds(364, 142, 86, 20);
		selectedrowdetail.add(tscounselorn);
		
		tsclg = new JTextField();
		tsclg.setColumns(10);
		tsclg.setBounds(364, 175, 86, 20);
		selectedrowdetail.add(tsclg);
		
		JButton btnNewButton_1 = new JButton("Update Changes");
		btnNewButton_1.setBounds(343, 268, 128, 23);
		selectedrowdetail.add(btnNewButton_1);
		
		tsinquirydate = new JLabel("");
		tsinquirydate.setBounds(382, 11, 97, 14);
		selectedrowdetail.add(tsinquirydate);
		
		tsprefday = new JLabel("");
		tsprefday.setBounds(364, 44, 97, 14);
		selectedrowdetail.add(tsprefday);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 256, 46, 14);
		selectedrowdetail.add(lblEmail);
		
		tsemail = new JTextField();
		tsemail.setBounds(89, 253, 166, 20);
		selectedrowdetail.add(tsemail);
		tsemail.setColumns(10);
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				browse();
			}
		});
		btnImport.setBounds(151, 290, 89, 23);
		contentPane.add(btnImport);


	}
}

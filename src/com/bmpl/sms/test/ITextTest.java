package com.bmpl.sms.test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ITextTest extends JFrame {

	JLabel lblNewLabel;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ITextTest frame = new ITextTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void browse() {
		String path = "";
		JFileChooser jchooser = new JFileChooser();
		jchooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int a = jchooser.showSaveDialog(this);
		lblNewLabel.setText(jchooser.getSelectedFile().getPath());
		
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
		PdfPTable  pdftable = new PdfPTable(3);
		
		PdfPCell c1 = new PdfPCell(new Phrase());
		pdftable.addCell(c1);
		c1 = new PdfPCell(new Phrase("Heading2"));
		pdftable.addCell(c1);
		c1 = new PdfPCell(new Phrase("Heading3"));
		pdftable.addCell(c1);
		
		
		pdftable.addCell("1");
		pdftable.addCell("2");
		pdftable.addCell("3");
		pdftable.addCell("4");
		pdftable.addCell("5");
		pdftable.addCell("6");
		pdftable.addCell("7");
		pdftable.addCell("8");
		pdftable.addCell("9");
		pdftable.addCell("10");
		pdftable.addCell("11");
		pdftable.addCell("12");
		pdftable.addCell("13");
		pdftable.addCell("14");
		pdftable.addCell("15");
		
		try {
			document.add(pdftable);
			document.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public ITextTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 98, 216, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnBrowse = new JButton("browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				browse();
			}
		});
		btnBrowse.setBounds(270, 89, 89, 23);
		contentPane.add(btnBrowse);
	}
}

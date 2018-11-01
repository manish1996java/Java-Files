package com.bmpl.testengin.question.questionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bmpl.testengin.question.questionDTO.QuestionDTO;
import com.bmpl.testengin.user.utils.CommonDAO;
import com.bmpl.testengin.user.utils.SQLConstants;

public class QuestionDAO {
	
public boolean isUpload(ArrayList<QuestionDTO> questions) throws ClassNotFoundException, SQLException
{
	Connection con = null;
	PreparedStatement ps = null;
	boolean isUpload = false;
	
	try {
		if(questions!=null && questions.size()>0) {
	con = CommonDAO.getConnection();
	ps = con.prepareStatement(SQLConstants.QUESTION_UPLOAD_SQL);
	
	for(QuestionDTO question : questions)
	{
		ps.setInt(1, question.getSerialId());
		ps.setString(2, question.getQuesName());
		
		int position=3;
		for(String option : question.getOption())
		{
			ps.setString(position, option);
			position++;
		}
		ps.setString(7, question.getRightAns());
		ps.setInt(8, question.getScore());
		ps.addBatch();
	}
	
	int result[] = ps.executeBatch();
	boolean fail = false;
	for(int r : result)
	{
		if(r<1)
		{
			 fail= true;
			 break;
		}
	}
	if(fail)
	{
		con.rollback();
	}
	else {
		con.commit();
		return true;
	}
	}
}finally {
		if(ps!=null)
		{
			ps.close();
		}
		if(con!=null)
		{
			con.close();
		}
	}
	return isUpload;
}

}

package com.app.main;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IStudent {
		public int insertStudentData(String sname,int sage,String saddress) throws IOException, SQLException;
		public ResultSet selectStudentsData(int sid) throws IOException, SQLException ;
		public int updateStudentData();
		public int deletStudentData();
		
}

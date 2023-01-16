package com.app.main;

import java.io.*;
import java.sql.*;

public interface IStudent {
	
	public int insertStudentData(String sname,int sage,String saddress) throws IOException, SQLException;
	public ResultSet selectStudentsData(int sid) throws IOException, SQLException ;
	public int updateStudentData(int sid,String sname,int sage,String saddress) throws IOException, SQLException;
	public int deletStudentData(int sid) throws IOException, SQLException;
}

package com.app.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.app.utils.JDBCUtils;

public class StudentImpl implements IStudent {
	
	Connection connection=null;
	Scanner sc = null;
	
	@Override
	public int insertStudentData(String sname,int sage,String saddress) throws IOException, SQLException {
		int rowCount=0;
		PreparedStatement pstmt1 = null;
		connection = JDBCUtils.getJdbcConnection();
		if (connection != null) {
			String sqlInsertQuery = "insert into Students(`sname`,`sage`,`saddress`) values (?,?,?)";
			pstmt1 = connection.prepareStatement(sqlInsertQuery);
			if (pstmt1 != null) {
				rowCount = pstmt1.executeUpdate();
			}
		}
		JDBCUtils.cleapUp(connection,pstmt1, null);
		if (rowCount == 1) {
			return rowCount;
		}else {
			return 0;
		}
	}

	@Override
	public ResultSet selectStudentsData(int sid) throws IOException, SQLException {
		
		ResultSet resultSet = null;
		PreparedStatement pstmt2 = null;
		connection = JDBCUtils.getJdbcConnection();
		if (connection != null) {
			String sqlSelectQuery = "select sid,sname,sage,saddress from Students where sid=?";
			pstmt2 = connection.prepareStatement(sqlSelectQuery);
			if (pstmt2 != null) {
				resultSet=pstmt2.executeQuery();
			}
		}
		if (resultSet != null) {
			return resultSet;
		}else {
			return null;
		}
	}

	@Override
	public int updateStudentData() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletStudentData() {
		// TODO Auto-generated method stub
		return 0;
	}

}

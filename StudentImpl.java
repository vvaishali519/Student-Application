package com.app.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.app.utils.JDBCUtils;

public class StudentImpl implements IStudent{
		
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
				pstmt1.setString(1, sname);
				pstmt1.setInt(2, sage);
				pstmt1.setString(3, saddress);
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
				pstmt2.setInt(1,sid);
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
	public int updateStudentData(int sid,String sname,int sage,String saddress) throws IOException, SQLException {
		int rowCount = 0;
		PreparedStatement pstmt3 = null;
		connection = JDBCUtils.getJdbcConnection();
		if (connection != null) {
			String sqlUpdateQuery = "update Students set sname=?,sage=?,saddress=? where sid=?";
			pstmt3 = connection.prepareStatement(sqlUpdateQuery);
			if (pstmt3 != null) {
				pstmt3.setString(1, sname);
				pstmt3.setInt(2, sage);
				pstmt3.setString(3,saddress);
				pstmt3.setInt(4, sid);
				rowCount = pstmt3.executeUpdate();
			}
		}
		if (rowCount == 1) {
			return rowCount;
		}else {
			return 0;
		}
	}

	@Override
	public int deletStudentData(int sid) throws IOException, SQLException {
		int rowCount = 0;
		PreparedStatement pstmt4 = null;
		connection = JDBCUtils.getJdbcConnection();
		if (connection != null) {
			String sqlDeleteQuery = "delete from Students where sid=?";
			pstmt4 = connection.prepareStatement(sqlDeleteQuery);
			if (pstmt4 != null) {
				pstmt4.setInt(1, sid);
				rowCount = pstmt4.executeUpdate();
			}
		}
		if (rowCount == 1) {
			return rowCount;
		}else {
			return 0;
		}
	}
}

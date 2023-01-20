package com.app.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.dto.Student;
import com.app.utils.JDBCUtils;

//JDBC logic
public class StudentDaoImpl implements IStudentDao {
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	Student std = null;
	ResultSet resultSet = null;
	
	@Override
	public String insertStudentData(String sname, Integer sage, String saddress){
		
		try {
			int rowCount = 0;
			String sqlInsertQuery = "insert into Students(`sname`,`sage`,`saddress`) values (?,?,?)";
			connection = JDBCUtils.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
				if (pstmt != null) {
					pstmt.setString(1, sname);
					pstmt.setInt(2, sage);
					pstmt.setString(3, saddress);
					
					rowCount = pstmt.executeUpdate();
					if (rowCount == 1) {
						return "success";
					}
				}
			}
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public Student selectStudentsData(Integer sid){
		
		try {
			String sqlSelectQuery = "select sname,sage,saddress from Students where sid = ?";
			connection = JDBCUtils.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
				if (pstmt != null) {
					pstmt.setInt(1, sid);
				
					resultSet = pstmt.executeQuery();
					if (resultSet.next()) {
						std.setSname(resultSet.getString(1));
						std.setSage(resultSet.getInt(2));
						std.setSaddress(resultSet.getString(3));
					}
					if (std != null) {
						System.out.println(std);
						return std;
					}
				}
			}
			}catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public String updateStudentData(Integer sid, String sname, Integer sage, String saddress){
		
		return null;
	}

	@Override
	public String deletStudentData(Integer sid){
		
		return null;
	}

}

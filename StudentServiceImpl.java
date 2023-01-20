package com.app.service;

import com.app.daoFactory.StudentDaoFactory;
import com.app.dto.Student;
import com.app.persistence.IStudentDao;

public class StudentServiceImpl implements IStudentService {
	
	IStudentDao studentDao = null;

	@Override
	public String insertStudentData(String sname, Integer sage, String saddress){
		studentDao = StudentDaoFactory.getStudentDao();
		String result = studentDao.insertStudentData(sname, sage, saddress);
		return result;
	}

	@Override
	public Student selectStudentsData(Integer sid){
		studentDao = StudentDaoFactory.getStudentDao();
		Student std = studentDao.selectStudentsData(sid);
		return std;
	}

	@Override
	public String updateStudentData(Integer sid, String sname, Integer sage, String saddress) {

		return null;
	}

	@Override
	public String deletStudentData(Integer sid){

		return null;
	}

}

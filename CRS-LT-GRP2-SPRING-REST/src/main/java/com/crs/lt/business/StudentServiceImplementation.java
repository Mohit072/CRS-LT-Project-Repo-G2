package com.crs.lt.business;

import com.crs.lt.model.Course;
import com.crs.lt.model.Grade;
import com.crs.lt.dao.StudentDao;
import com.crs.lt.dao.StudentDaoImplementation;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService {
	/*
	 * This is Student service implementation
	 *
	 */

	StudentDao studentDao = new StudentDaoImplementation();

	@Override
	public boolean addCourse(String courseCode, int studentId) throws SQLException {
		Boolean courseStatus = studentDao.addCourse(courseCode, studentId);
		return courseStatus;
	}

	@Override
	public boolean dropCourse(String courseCode, int studentId) throws SQLException {
		Boolean courseStatus = studentDao.dropCourse(courseCode, studentId);
		return courseStatus;
	}

	@Override
	public List<Course> viewCourses(int studentId) throws SQLException {
		return studentDao.viewCourses(studentId);
	}

	@Override
	public List<Course> viewRegisteredCourses(int studentId) throws SQLException {
		return studentDao.viewRegisteredCourses(studentId);
	}

	@Override
	public List<Grade> viewGradeCard(int studentId) throws SQLException {
		return studentDao.viewGradeCard(studentId);
	}

	@Override
	public boolean makePayment(int studentId) throws SQLException {
		return studentDao.makePayment(studentId);
	}

}

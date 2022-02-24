/**
 * 
 */
package com.crs.lt.business;

import com.crs.lt.model.Course;
import com.crs.lt.model.Grade;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
	public boolean addCourse(String courseCode, int studentId) throws SQLException;

	public boolean dropCourse(String courseCode, int studentId) throws SQLException;

	public List<Course> viewCourses(int studentId) throws SQLException;

	public List<Course> viewRegisteredCourses(int studentId) throws SQLException;

	public List<Grade> viewGradeCard(int studentId) throws SQLException;

	public boolean makePayment(int studentId) throws SQLException;
}

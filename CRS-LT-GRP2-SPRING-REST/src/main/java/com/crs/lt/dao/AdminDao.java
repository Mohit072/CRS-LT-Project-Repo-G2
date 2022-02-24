package com.crs.lt.dao;

import com.crs.lt.model.Course;
import com.crs.lt.model.Professor;
import java.sql.SQLException;
import java.util.List;

public interface AdminDao {
	public List<Course> viewCoursesByCatalogId() throws SQLException;

	public void addCourse(Course course) throws SQLException;

	public void addProfessor(Professor professor) throws SQLException;

	public void approveStudent(int studentId) throws SQLException;

	public void assignCourse(String courseCode, String professorId) throws SQLException;

	public void deleteCourse(String courseCode) throws SQLException;

}

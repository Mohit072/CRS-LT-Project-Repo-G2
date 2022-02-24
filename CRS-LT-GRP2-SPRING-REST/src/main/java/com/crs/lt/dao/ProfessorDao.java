package com.crs.lt.dao;

import com.crs.lt.model.Course;
import com.crs.lt.model.EnrolledStudent;

import java.util.List;
import java.sql.SQLException;

public interface ProfessorDao {

	public List<Course> getCoursesByProfessorId(int userId) throws SQLException;

	public List<EnrolledStudent> getEnrolledStudents(int profId) throws SQLException;

	public Boolean addGrade(int studentId, String courseCode, String grade) throws SQLException;

}

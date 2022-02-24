/**
 *
 */
package com.crs.lt.business;

import com.crs.lt.model.Course;
import com.crs.lt.model.EnrolledStudent;

import java.sql.SQLException;
import java.util.List;

/**
 * @author user208
 *
 */
public interface ProfessorService {
	public Boolean addGrade(int studentId, String courseCode, String grade) throws SQLException;

	public List<Course> getCourses(int profId) throws SQLException;

	public List<EnrolledStudent> viewEnrolledStudents(int profId) throws SQLException;

}

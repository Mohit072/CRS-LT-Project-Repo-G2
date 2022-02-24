/**
 *
 */
package com.crs.lt.business;

import com.crs.lt.model.Course;
import com.crs.lt.model.Professor;

import java.sql.SQLException;

public interface AdminService {

	public void addCourse(Course course);

	public void addProfessor(Professor professor);

	public void approveStudent(int studentId);

	public void assignCourse(String courseCode, int professorId);

	public void deleteCourse(String courseCode);

	public void viewCoursesByCatalogId() throws SQLException;
}

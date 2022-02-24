package com.crs.lt.dao;

import com.crs.lt.CRSApplication.ConfigurationJDBC;
import com.crs.lt.model.Course;
import com.crs.lt.model.EnrolledStudent;

import com.crs.lt.constant.SQLQueriesConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static org.apache.logging.log4j.LogManager.getLogger;

@Repository
public class ProfessorDaoImplementation implements ProfessorDao {
	private static final Logger LOGGER = getLogger(ProfessorDaoImplementation.class);
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/crs";

	@Autowired
	ConfigurationJDBC configurationJDBC;

	static final String USER = "root";
	static final String PASS = "password";



	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet rs = null;

	@Override
	public List<Course> getCoursesByProfessorId(int profId) throws SQLException {
		List<Course> professorCourses = new ArrayList<Course>();
		try {

//			Class.forName(JDBC_DRIVER);
//			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			connection = configurationJDBC.dataSource().getConnection();
			statement = connection.prepareStatement(SQLQueriesConstants.VIEW_PROFESSOR_COURSES);
			statement.setInt(1, profId);
			rs = statement.executeQuery();

			while (rs.next()) {
				Course c1 = new Course();
				// c1.setInstructorId(rs.getString("instructorId"));
				c1.setCourseCode(rs.getString("courseCode"));
				c1.setName(rs.getString("courseName"));
				professorCourses.add(c1);
			}
		} catch (Exception e) {
			LOGGER.error("No Course Available");
		} finally {
			statement.close();
			connection.close();
		}
		return professorCourses;
	}

	@Override
	public List<EnrolledStudent> getEnrolledStudents(int profId) throws SQLException {
		List<EnrolledStudent> enrolledStudents = new ArrayList<EnrolledStudent>();

		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(SQLQueriesConstants.VIEW_ENROLLED_STUDENTS);
			statement.setInt(1, profId);
			rs = statement.executeQuery();

			while (rs.next()) {
				EnrolledStudent c1 = new EnrolledStudent();
				c1.setStudentId(rs.getInt("registeredcourse.studentId"));
				c1.setCourseCode(rs.getString("course.courseCode"));
				c1.setCourseName(rs.getString("course.courseName"));
				enrolledStudents.add(c1);
			}

		} catch (Exception e1) {
			LOGGER.error("No Student have enrolled to your Course");
		} finally {
			statement.close();
			connection.close();
		}

		return enrolledStudents;
	}

	@Override
	public Boolean addGrade(int studentId, String courseCode, String grade) throws SQLException {
		Boolean updated = false;

		try {
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.prepareStatement(SQLQueriesConstants.ADD_GRADE);
			statement.setString(1, grade);
			statement.setString(2, courseCode);
			statement.setInt(3, studentId);
			statement.executeUpdate();
			updated = true;
		} catch (Exception e1) {
			LOGGER.error("Unable to add Grade");
		} finally {
			statement.close();
			connection.close();
		}
		return updated;
	}

}

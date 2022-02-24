package com.crs.lt.dao;

import com.crs.lt.CRSApplication.ConfigurationJDBC;
import com.crs.lt.model.Course;
import com.crs.lt.model.Professor;
import com.crs.lt.constant.SQLQueriesConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.logging.log4j.Logger;

import static org.apache.logging.log4j.LogManager.getLogger;


@Repository
public class AdminDaoImplementation implements AdminDao {
	private static final Logger LOGGER = getLogger(AdminDaoImplementation.class);

//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/crs";

	static final String USER = "root";
	static final String PASS = "password";


	@Autowired
	private ConfigurationJDBC configurationJDBC;

	private Connection connection = null;
	private  PreparedStatement statement = null;
	private ResultSet rs = null;

	/**
	 * @return List of Courses
	 * @throws SQLException
	 */
	@Override
	public List<Course> viewCoursesByCatalogId() throws SQLException {
		LOGGER.info("Entered Dao impl" );

		List<Course> uniqueCoursesList1 = new ArrayList<Course>();
		try {
			connection = configurationJDBC.dataSource().getConnection();
			statement = connection.prepareStatement(SQLQueriesConstants.VIEW_COURSES_ADMIN);
			rs = statement.executeQuery();

			while (rs.next()) {
				Course c1 = new Course();
				c1.setCourseCode(rs.getString("courseCode"));
				c1.setName(rs.getString("courseName"));
				c1.setSeats(rs.getInt("seats"));
				c1.setInstructorId(rs.getInt("instructorId"));
				c1.setFees(rs.getInt("fee"));
				c1.setIsOffered(rs.getBoolean("isOffered"));
				uniqueCoursesList1.add(c1);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
			LOGGER.error("No Course is present");
		} finally {
			statement.close();
			connection.close();
		}
		LOGGER.info("Unique courses list is ", uniqueCoursesList1.toString());
		return uniqueCoursesList1;
	}

	/**
	 * @throws SQLException
	 * @param course Object
	 */
	@Override
	public void addCourse(Course course) throws SQLException {
		try {
			connection = configurationJDBC.dataSource().getConnection();

			statement = connection.prepareStatement(SQLQueriesConstants.ASSIGN_COURSES_ADMIN);
			statement.setString(1, course.getCourseCode());
			statement.setString(2, course.getName());
			statement.setInt(3, course.getInstructorId());
			statement.setInt(4, course.getSeats());
			statement.setInt(5, course.getFees());
			statement.setBoolean(6, course.getIsOffered());
			statement.execute();
		} catch (Exception e1) {
			LOGGER.error("Unable to add Course");
		} finally {
			statement.close();
			connection.close();
		}
	}

	@Override
	public void addProfessor(Professor professor) throws SQLException {
		try {
			connection = configurationJDBC.dataSource().getConnection();

			statement = connection.prepareStatement(SQLQueriesConstants.ADD_USER);
			statement.setInt(1, professor.getUserId());
			statement.setString(2, professor.getName());
			statement.setString(3, professor.getRole());
			statement.setString(4, professor.getPassword());
			statement.execute();
			statement = connection.prepareStatement(SQLQueriesConstants.ADD_PROFESSOR);
			statement.setInt(1, professor.getUserId());
			statement.setString(2, professor.getDepartment());
			statement.setString(3, professor.getDesignation());
			statement.setString(4, professor.getDate());
			statement.execute();
		} catch (Exception e1) {
			LOGGER.error("Unable to add Professor");
		} finally {
			statement.close();
			connection.close();
		}
	}

	@Override
	public void approveStudent(int studentId) throws SQLException {
		try {
//			Class.forName(JDBC_DRIVER);
//			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			connection = configurationJDBC.dataSource().getConnection();

			statement = connection.prepareStatement(SQLQueriesConstants.APPROVE_STUDENT_ADMIN);
			statement.setInt(1, 1);
			statement.setInt(2, studentId);
			statement.executeUpdate();
		} catch (Exception e1) {
			LOGGER.error("Unable to approve Student");
		} finally {
			statement.close();
			connection.close();
		}
	}

	@Override
	public void assignCourse(String courseCode, int professorId) throws SQLException {
		try {
//			Class.forName(JDBC_DRIVER);
//			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			connection = configurationJDBC.dataSource().getConnection();

			statement = connection.prepareStatement(SQLQueriesConstants.ADD_PROFESSOR_TO_COURSE_ADMIN);
			statement.setInt(1, Integer.valueOf(professorId));
			statement.setString(2, courseCode);
			statement.executeUpdate();
		} catch (Exception e1) {
			LOGGER.error("Unable to assign Course");
		} finally {
			statement.close();
			connection.close();
		}

	}

	@Override
	public void deleteCourse(String courseCode) throws SQLException {
		try {
//			Class.forName(JDBC_DRIVER);
//			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			connection = configurationJDBC.dataSource().getConnection();

			statement = connection.prepareStatement(SQLQueriesConstants.DELETE_COURSE_ADMIN);
			statement.setString(1, courseCode);
			statement.execute();
			System.out.println("DELETE");
		} catch (Exception e1) {
			LOGGER.error(" Unable to Delete Course");
		} finally {
			statement.close();
			connection.close();
		}
	}

}

package com.crs.lt.business;

import com.crs.lt.model.Course;
import com.crs.lt.model.Professor;
import com.crs.lt.dao.AdminDao;
import com.crs.lt.dao.AdminDaoImplementation;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;


@Service
public class AdminServiceImplementation implements AdminService {
	/*
	 * This is Admin service implementation
	 *
	 */

	private static final Logger LOGGER = getLogger(AdminServiceImplementation.class);
	AdminDao adminDao = new AdminDaoImplementation();

	@Override
	public void addCourse(Course course) {
		try {
			adminDao.addCourse(course);
			System.out.println("Course Successfully added");
		} catch (Exception e) {
			LOGGER.error("Unable to add Course");
		}
	}

	@Override
	public void addProfessor(Professor professor) {
		try {
			adminDao.addProfessor(professor);
			System.out.println("Professor Successfully added");
		} catch (Exception e) {
			LOGGER.error("Unable to add professor");

		}
	}

	@Override
	public void approveStudent(int studentId) {
		try {
			adminDao.approveStudent(studentId);
			System.out.println("Student is Successfully approved");
		} catch (Exception e) {
			LOGGER.error("Student is not approved");
		}
	}

	@Override
	public void assignCourse(String courseCode, String professorId) {
		try {
			adminDao.assignCourse(courseCode, professorId);
			System.out.println("Course Successfully Assigned");
		} catch (Exception e) {
			LOGGER.error("Professor can't be assigned to given course");
		}
	}

	@Override
	public void deleteCourse(String courseCode) {
		try {
			adminDao.deleteCourse(courseCode);
			System.out.println("Course Successfully deleted");
		} catch (Exception e) {
			LOGGER.error("Unable to delete Course ");
		}
	}

	@Override
	public void viewCoursesByCatalogId() throws SQLException {
		List<Course> allCourses = adminDao.viewCoursesByCatalogId();
		System.out.println("-------------------------");
		System.out.printf("|%10s|%10s|", "Course Code", "Course Name");
		System.out.println();
		System.out.println("-------------------------");
		for (Course course : allCourses) {
			System.out.format("|%11s|%11s|", course.getCourseCode(), course.getName()); 
			System.out.println(); 
		}
		System.out.println("-------------------------");
	}

}

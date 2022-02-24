package com.crs.lt.business;

import com.crs.lt.dao.ProfessorDao;
import com.crs.lt.dao.ProfessorDaoImplementation;
import com.crs.lt.model.Course;
import com.crs.lt.model.EnrolledStudent;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.List;

@Service
public class ProfessorServiceImplementation implements ProfessorService {
	/*
	 * This is professor service implementation
	 *
	 */
	ProfessorDao professorDao = new ProfessorDaoImplementation();

	@Override
	public Boolean addGrade(int studentId, String courseCode, String grade) throws SQLException {
		return professorDao.addGrade(studentId, courseCode, grade);
	}

	@Override
	public List<Course> getCourses(int profId) throws SQLException {
		List<Course> professorCourses = professorDao.getCoursesByProfessorId(profId);
		return professorCourses;
	}

	@Override
	public List<EnrolledStudent> viewEnrolledStudents(int profId) throws SQLException {
		return professorDao.getEnrolledStudents(profId);
	}

}

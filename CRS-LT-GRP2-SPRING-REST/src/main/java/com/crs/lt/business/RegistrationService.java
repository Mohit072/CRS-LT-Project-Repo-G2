package com.crs.lt.business;

import java.sql.SQLException;

import com.crs.lt.model.Student;
import com.crs.lt.model.User;

public interface RegistrationService {
	public void addUser(User user);
	public void addStudent(Student student);
	public boolean updatePassword(int userId,String password) throws SQLException;
	public User getUserDetails(int userId) throws SQLException;

}

package com.crs.lt.dao;

import java.sql.SQLException;

import com.crs.lt.model.Student;
import com.crs.lt.model.User;

public interface RegistrationDao {
	public void addUser(User user) throws SQLException;
	public void addStudent(Student student) throws SQLException;
	public boolean updatePassword(int userId,String password) throws SQLException;
	public User getUserDetails(int userId) throws SQLException;
}

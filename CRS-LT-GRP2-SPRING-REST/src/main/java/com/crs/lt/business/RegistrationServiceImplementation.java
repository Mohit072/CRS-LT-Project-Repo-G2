package com.crs.lt.business;

import java.sql.SQLException;


import com.crs.lt.model.Student;
import com.crs.lt.model.User;
import com.crs.lt.dao.RegistrationDao;
import com.crs.lt.dao.RegistrationDaoImplementation;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import static org.apache.logging.log4j.LogManager.getLogger;

@Service
public class RegistrationServiceImplementation implements RegistrationService {
	private static final Logger LOGGER = getLogger(RegistrationServiceImplementation.class);
	RegistrationDao registrationDao=new RegistrationDaoImplementation();

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		try {
			registrationDao.addUser(user);
		} catch (Exception e) {
			LOGGER.error("User can't be added");

		}
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			registrationDao.addStudent(student);
		} catch (Exception e) {
			LOGGER.error("User can't be added");

		}
		}

	@Override
	public boolean updatePassword(int userId, String password) throws SQLException {
		// TODO Auto-generated method stub
		return registrationDao.updatePassword(userId, password);
	}

	@Override
	public User getUserDetails(int userId) throws SQLException {
		// TODO Auto-generated method stub
		return registrationDao.getUserDetails(userId);
	}

	
		
	}

	


		
	



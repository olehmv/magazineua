package service;

import java.sql.Blob;
import java.util.List;
import dao.*;
import user.User;

public class UserServiceImpl implements UserService{
	UserDao userDao=new UserDaoImpl();
	

	public User getUserByEmailFromDb(String mail) {
		return userDao.getUserByEmail(mail);
	}

	@Override
	public Blob getIMageDb(String email, String file) {
		return userDao.getIMage(email, file);
	}

	@Override
	public void addPersonImageDb(String email, String file) {
			userDao.addPersonImage(email, file);
	}

	@Override
	public void addDescriptionFromFile(String email, String file) {
		userDao.addDescriptionFromFile(email, file);
	}

	@Override
	public String writeDescriptionToFile(String email, String file) {
		return userDao.writeDescriptionToFile(email, file);
	}

	@Override
	public List getAllusers() {
		return userDao.getAllusers();
	}

	@Override
	public User getUserByEmail(String mail) {
		return userDao.getUserByEmail(mail);
	}

}

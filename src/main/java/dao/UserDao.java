package dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import user.User;

public interface UserDao {
	public Blob getIMage(String email,String file);
	
	public void addPersonImage(String email,String file);
	
	public void addDescriptionFromFile(String email,String file);
	public String writeDescriptionToFile(String email,String file) ;
	
	void insertUser(User user);
	List getAllusers();
	
	User getUserByEmail(String mail);

}


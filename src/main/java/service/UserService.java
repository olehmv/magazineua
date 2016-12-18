package service;

import java.sql.Blob;
import java.util.List;

import user.User;

public interface UserService {
	public Blob getIMageDb(String email,String file);
	public void addPersonImageDb(String email,String file);
	public void addDescriptionFromFile(String email,String file);
	public String writeDescriptionToFile(String email,String file) ;
	List getAllusers();
	User getUserByEmail(String mail);
}

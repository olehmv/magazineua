package user;

import java.sql.Blob;
import java.sql.Clob;

public class User {
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	Clob desciption;
	
	public Clob getDesciption() {
		return desciption;
	}
	public void setDesciption(Clob desciption) {
		this.desciption = desciption;
	}
	String firstName;
	String email;
	String password;
	Blob blob;
	String sity;
	public String getSity() {
		return sity;
	}
	public void setSity(String sity) {
		this.sity = sity;
	}
	public Blob getImage(){
		return blob;
	}
	public void setImage(Blob blob){
		this.blob=blob;
	}
	public User(String firstName) {
		super();
		this.firstName = firstName;
	}
	public User() {
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	


}

package user;

import java.sql.Blob;
import java.sql.Clob;

public class User {
private	int id;
private	String firstName;
private String email;
private String password;
private Blob blob;
private String sity;
private String magazine;
private Clob desciption;
private double invoice;
public User() {
}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Clob getDesciption() {
		return desciption;
	}
	public void setDesciption(Clob desciption) {
		this.desciption = desciption;
	}
	public String getSity() {
		return sity;
	}
	public void setSity(String sity) {
		this.sity = sity;
	}
	
	public Blob getBlob() {
		return blob;
	}
	public void setBlob(Blob blob) {
		this.blob = blob;
	}
	public String getMagazine() {
		return magazine;
	}
	public void setMagazine(String magazine) {
		this.magazine = magazine;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	public double getInvoice() {
		return invoice;
	}
	public void setInvoice(double invoice) {
		this.invoice = invoice;
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

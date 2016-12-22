package user;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

import com.mysql.jdbc.Connection;

public class User implements HttpSessionBindingListener,HttpSessionActivationListener,Serializable{
private static final String FIND_PERSON_BY_EMAIL = "select * from CLIENTS where C_EMAIL=? and C_PASS=? ";
private	int id;
private	String firstName;
private String email;
private String password;
private Blob blob;
private String city;
private String magazine;
private Clob desciption;
private double invoice;
private Connection con;
private User user;

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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
//		this.user=(User) event.getSession().getAttribute("login");
//		 con=(Connection)event.getSession().getServletContext().getAttribute("connection");
//			HttpSession session=event.getSession();
//			ResultSet rs = null;
//			PreparedStatement stm=null;
//			 try {
//			 stm=con.prepareStatement(FIND_PERSON_BY_EMAIL);
//				stm.setString(1, (String) session.getAttribute("email"));
//			 stm.setString(2, (String) session.getAttribute("pass"));
//			  rs=stm.executeQuery();
//			  user=new User();
//				while(rs.next()){
//					user.setId(rs.getInt("C_ID"));
//					user.setFirstName(rs.getString("C_NAME"));
//					user.setDesciption(rs.getClob("C_DESCRIPTION"));
//					user.setEmail(rs.getString("C_EMAIL"));
//					user.setPassword(rs.getString("C_PASS"));
//					user.setImage(rs.getBlob("C_IMAGE"));
//					user.setCity(rs.getString("C_CITY"));
//			}
//			session.setAttribute("login",user);
//			 } catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
//			try {
//				con.close();
//				user=null;
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
	}
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}
	
//	 <jsp-config>
//	  <jsp-property-group>
//	  <url-pattern>*.jsp</url-pattern>
//	  <scripting-invalid>true</scripting-invalid>
//	  </jsp-property-group>  
//	  </jsp-config>


}

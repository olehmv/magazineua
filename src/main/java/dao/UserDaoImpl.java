package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.dbcp2.BasicDataSource;

import connection.JDBCUtils;
import user.Magazine;
import user.User;

public class UserDaoImpl implements UserDao {
	static List<User>list;
//	static ResultSet rs;
//	static User user;
	private Connection conn;
	public UserDaoImpl(){
		conn=JDBCUtils.getConnection1();
	}

	private static final String ADD_PERSON = "insert into CLIENTS (`C_NAME`,`C_EMAIL`,`C_PASS`,`C_CITY`) values (?,?,?,?)";
	private static final String FIND_PERSON_BY_EMAIL = "select * from CLIENTS where C_EMAIL=? ";
	private static final String FIND_ALL_PERSON = "select * from CLIENTS";
	private static final String LOG_IN = "select * from CLIENTS where C_ID=?";
	private static final String UPDATE_MAGAZINE_TO_USER="UPDATE clients SET C_MAGAZINE ='B' WHERE C_ID = 3";

	
	public void addMagazineToUser(User user,Magazine mag){
		try {
			PreparedStatement stm=conn.prepareStatement(UPDATE_MAGAZINE_TO_USER);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}	
	public User getUserByEmail(String mail) {
		ResultSet rs = null;
		User user = null;
		PreparedStatement stm=null;
		conn=JDBCUtils.getConnection1();
		try{
			 stm=conn.prepareStatement(FIND_PERSON_BY_EMAIL);
			 stm.setString(1, mail);
			  rs=stm.executeQuery();
			  user=new User();
			while(rs.next()){
				user.setId(rs.getInt("C_ID"));
				user.setFirstName(rs.getString("C_NAME"));
				user.setDesciption(rs.getClob("C_DESCRIPTION"));
				user.setEmail(rs.getString("C_EMAIL"));
				user.setPassword(rs.getString("C_PASS"));
				user.setImage(rs.getBlob("C_IMAGE"));
				user.setCity(rs.getString("C_CITY"));
			}
			  
			} catch (SQLException e) {
			e.printStackTrace();
			}
		return user;
	
}
	public void addUser(User user) {
		PreparedStatement stm = null;
		ResultSet rs = null;
	//	User user = null;
		try{
			stm=conn.prepareStatement(ADD_PERSON,PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setString(1,user.getFirstName());
			stm.setString(2, user.getEmail());
			stm.setString(3, user.getPassword());
			stm.setString(4, user.getCity());

			
			stm.executeUpdate();
			ResultSet reslt=stm.getGeneratedKeys();
			if(reslt.next()){
				int genId=reslt.getInt(1);
				user.setId(genId);
			}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
		
	}
	public List getAllusers() {
			list=new ArrayList<User>();
			ResultSet rs = null;
			User user = null;
			try{
				Connection conn=JDBCUtils.getConnection1();

				Statement stm=conn.createStatement();
				
				//stm=conn.prepareStatement(FIND_ALL_PERSON);
				rs=stm.executeQuery(FIND_ALL_PERSON);
				while(rs.next()){
					user=new User();
					user.setId(rs.getInt("C_ID"));
					user.setFirstName(rs.getString("C_NAME"));
					user.setEmail(rs.getString("C_EMAIL"));
					user.setPassword(rs.getString("C_PASS"));
					list.add(user);
				}
				rs.close();
				stm.close();
			}catch (SQLException e) {
				e.printStackTrace();
			
			}
			return list;
		}
	@Override
	public Blob getIMage(String email, String file) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addPersonImage(String email, String file) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addDescriptionFromFile(String email, String file) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String writeDescriptionToFile(String email, String file) {
		// TODO Auto-generated method stub
		return null;
	}
}


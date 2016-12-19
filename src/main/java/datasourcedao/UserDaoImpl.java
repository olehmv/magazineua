package datasourcedao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import org.apache.commons.dbcp2.BasicDataSource;

import connection.JDBCUtils;
import user.Magazine;
import user.User;

public class UserDaoImpl implements UserDao {
	static List<User>list;
//	static ResultSet rs;
//	static User user;
	private Connection con;
	private DataSource conn;
	public UserDaoImpl(){
		conn=JDBCUtils.getConnection();
	}

	private static final String ADD_PERSON = "insert into CLIENTS (`C_NAME`,`C_EMAIL`,`C_PASS`) values (?,?,?)";
	private static final String FIND_PERSON_BY_EMAIL = "select * from CLIENTS where C_EMAIL=? ";
	private static final String FIND_ALL_PERSON = "select * from CLIENTS";
	private static final String LOG_IN = "select * from CLIENTS where C_ID=?";
	private static final String UPDATE_MAGAZINE_TO_USER="UPDATE clients SET C_MAGAZINE =? WHERE C_ID = ?";

	
	public void addMagazineToUser(User user,Magazine mag){
		try {
			 con=conn.getConnection();
			PreparedStatement stm=con.prepareStatement(UPDATE_MAGAZINE_TO_USER);
			 stm.setString(1, mag.getName());
			 stm.setInt(2, user.getId());
			 
			} catch (SQLException e) {
			e.printStackTrace();
			}
	}	
	public User getUserByEmail(String mail) {
		ResultSet rs = null;
		User user = null;
		PreparedStatement stm=null;
		conn=JDBCUtils.getConnection();
		try{
			 con=conn.getConnection();
			 stm=con.prepareStatement(FIND_PERSON_BY_EMAIL);
			 stm.setString(1, mail);
			  rs=stm.executeQuery();
			  if(rs!=null){
				user=new User();
			while(rs.next()){
				user.setId(rs.getInt("C_ID"));
				user.setFirstName(rs.getString("C_NAME"));
				user.setDesciption(rs.getClob("C_DESCRIPTION"));
				user.setEmail(rs.getString("C_EMAIL"));
				user.setPassword(rs.getString("C_PASS"));
				user.setImage(rs.getBlob("IMAGE"));
				user.setSity(rs.getString("C_CITY"));
			}
			  }
			} catch (SQLException e) {
			e.printStackTrace();
			}
		return user;
	
}
	public void insertUser(User user) {
		PreparedStatement stm = null;
		ResultSet rs = null;
	//	User user = null;
		try{
			 con=conn.getConnection();
			stm=con.prepareStatement(ADD_PERSON,PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setString(1,user.getFirstName());
			stm.setString(2, user.getEmail());
			stm.setString(3, user.getPassword());
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
				 conn=JDBCUtils.getConnection();
				 con=conn.getConnection();
				Statement stm=con.createStatement();
				rs=stm.executeQuery(FIND_ALL_PERSON);
				while(rs.next()){
					user=new User();
					user.setId(rs.getInt("C_ID"));
					user.setSity(rs.getString("C_CITY"));
					user.setFirstName(rs.getString("C_NAME"));
					user.setEmail(rs.getString("C_EMAIL"));
					user.setPassword(rs.getString("C_PASS"));
					user.setDesciption(rs.getClob("C_DESCRIPTION"));
					user.setInvoice(rs.getDouble("C_INVOICE"));
					user.setMagazine(rs.getString("C_Magazine"));
					user.setImage(rs.getBlob("C_IMAGE"));
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


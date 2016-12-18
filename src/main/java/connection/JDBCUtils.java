package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.ConnectionPoolDataSource;


public class JDBCUtils {

	private static final String dbURL = "jdbc:mysql://localhost:3306/magazine";
	private static final String dbURL1 = "jdbc:mysql://localhost:3306/magazine?autoReconnect=true&amp;allowMultiQueries=true";
    private   String user="root";
	private static final String user1 = "root";
	private   String password="oleg";
	private static final String password1 = "oleg";
	private static BasicDataSource dataSource;
	private static ConnectionPoolDataSource connectionPool;
	private static Connection myConn;


	 public JDBCUtils(String user,String password) throws NamingException {
		this.user=user;
		this.password=password;
		dataSource=new BasicDataSource();
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		dataSource.setUrl("jdbc:mysql://localhost:3306/magazine");
		Context ctx = new InitialContext();
		ctx.bind("jdbc/magazine", dataSource);
	}
	 public JDBCUtils() {
	}
	 
	public static Connection getConnection1() {
			if (myConn == null) {
				try {
					

					Class.forName("com.mysql.jdbc.Driver");
					myConn = DriverManager.getConnection(dbURL, user1, password1);
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}

			return myConn;
	}
	public static BasicDataSource getConnection(){
		return dataSource;
	}
	public DataSource lookUpConnection(String url) throws NamingException{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup(url);
		return ds;
		
	}
	
}

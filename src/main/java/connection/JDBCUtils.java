package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class JDBCUtils {

	private static final String dbURL = "jdbc:mysql://localhost:3306/magazine";
    private static  String user="root";
	private  static String password="oleg";
	private static BasicDataSource dataSource;
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
					myConn = DriverManager.getConnection(dbURL, user, password);
				} catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}

			return myConn;
	}
	public static DataSource getConnection(){
		
			Properties props = new Properties();
			FileInputStream fis = null;
			MysqlDataSource mysqlDS = null;
			try {
				fis = new FileInputStream("src\\main\\resources\\db.properties");
				props.load(fis);
				mysqlDS = new MysqlDataSource();
				//Class.forName("com.mysql.jdbc.Driver");
				//mysqlDS.setServerName(props.getProperty("MYSQL_DB_DRIVER_CLASS"));
				//mysqlDS.setLogger(props.getProperty("MYSQL_DB_DRIVER_CLASS"));
				mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
				mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
				mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return mysqlDS;
		}
		
		
		
	
	public DataSource lookUpConnection(String url) throws NamingException{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup(url);
		return ds;
		
	}
	
}

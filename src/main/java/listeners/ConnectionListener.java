package listeners;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ConnectionListener implements ServletContextListener {
	private static final String dbURL = "jdbc:mysql://localhost:3306/magazine";


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc=sce.getServletContext();
		 String user=sc.getInitParameter("user");
		 String pass=sc.getInitParameter("password");
		Connection myConn=null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					 myConn = DriverManager.getConnection(dbURL, user, pass);
					sc.setAttribute("connection", myConn);
				} catch (SQLException | ClassNotFoundException  e) {
					e.printStackTrace();
				}
			
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	

}

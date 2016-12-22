package servlets;


import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.JDBCUtils;
import dao.UserDao;
import dao.UserDaoImpl;
import user.User;

/**
 * Servlet implementation class LoginSerlet
 */
public class LoginSerlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String FIND_PERSON_BY_EMAIL = "select * from CLIENTS where C_EMAIL=? and C_PASS=? ";
	User user;
	/**
     * Default constructor. 
     */
    public LoginSerlet() {
    	
    	
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			Connection con=null;
			 con=(Connection)getServletContext().getAttribute("connection");
				ResultSet rs = null;
				User user = null;
				PreparedStatement stm=null;
				 try {
					stm=con.prepareStatement(FIND_PERSON_BY_EMAIL);
				 stm.setString(1, request.getParameter("email"));
				 stm.setString(2, request.getParameter("pass"));
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
					synchronized(getServletContext()){
						HttpSession session=request.getSession();
						System.out.println(session.isNew());
						if(session.isNew()){session=request.getSession(true);};
						synchronized(session){
							System.out.println(session.getId());
							session.setAttribute("user",user);
						RequestDispatcher view=request.getRequestDispatcher("magazineua.jsp");
						response.encodeURL("magazineua.jsp");
						view.forward(request, response);
						}
				}	
				} catch (SQLException e) {
					e.printStackTrace();
				}	
				
	} 
	
			

}	
	

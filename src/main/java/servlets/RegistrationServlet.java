package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.UserDaoImpl;
import user.User;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ADD_PERSON = "insert into CLIENTS (`C_NAME`,`C_EMAIL`,`C_PASS`,`C_CITY`) values (?,?,?,?)";

    /**
     * @see HttpServlet#HttpServlet()
     */
   
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
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String [] str=request.getParameterValues("parram name");//return all param,only with same parram name
		User user=new User();
		Connection con=(Connection)getServletContext().getAttribute("connection");
		 String name =request.getParameter("username");
		 String email=request.getParameter("email");
		 String pass=request.getParameter("pass");
		 String city=request.getParameter("city");
		user.setFirstName(name);
		user.setEmail(email);
		user.setPassword(pass);
		user.setCity(city);
		PreparedStatement stm = null;
		try{
			stm=con.prepareStatement(ADD_PERSON,PreparedStatement.RETURN_GENERATED_KEYS);
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
		
		synchronized(getServletContext()){
			HttpSession session=request.getSession();
			System.out.println(session.isNew());
			if(session.isNew()){session=request.getSession(true);};
			synchronized(session){
				System.out.println(session.getId());
				session.setAttribute("login",user);
			RequestDispatcher view=request.getRequestDispatcher("magazineua.jsp");
			view.forward(request,response);
			}
		}
		
		
	}

}

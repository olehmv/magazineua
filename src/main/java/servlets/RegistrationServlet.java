package servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import user.User;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     User user;
     UserDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		user=new User();
		dao=new UserDaoImpl();
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
		//String [] str=request.getParameterValues("parram name");//return all param,only with same parram name
		 String name =request.getParameter("username");
		 String email=request.getParameter("email");
		 String pass=request.getParameter("pass");
		 String city=request.getParameter("city");


		user.setFirstName(name);
		user.setEmail(email);
		user.setPassword(pass);
		user.setCity(city);
		dao.addUser(user);
		request.setAttribute("registration", user);
		RequestDispatcher view=request.getRequestDispatcher("registration.jsp");
		view.forward(request, response);
		
	}

}

package servlets;


import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class LoginSerlet
 */
public class LoginSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao dao;
	User user;
	String desc;
	Blob blob;
	List <User> list;
    /**
     * Default constructor. 
     */
    public LoginSerlet() {
    	
    	
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		dao=new UserDaoImpl();
		user=new User();
		list=new ArrayList<>();
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
		
			user=dao.getUserByEmail(request.getParameter("email"));
			//response.setContentType("image/jpeg");
			request.setAttribute("user", user);
			RequestDispatcher view=request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
	}

}

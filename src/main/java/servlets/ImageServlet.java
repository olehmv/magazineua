package servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import service.UserService;
import service.UserServiceImpl;

/**
 * Servlet implementation class ImageServlet
 */
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	UserService user;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		user=new UserServiceImpl();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Blob blob=user.getIMageDb("o@gmail.com","cat.jpg");
		request.getParameter("id");
		response.setContentType("image/jpg" );
		ServletOutputStream out=response.getOutputStream();
		try {
			out.write(blob.getBytes(1,(int) blob.length()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("image", out);
		RequestDispatcher view=request.getRequestDispatcher("login.jsp");
		view.forward(request, response);
	}

}

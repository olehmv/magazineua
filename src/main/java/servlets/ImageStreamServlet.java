package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;

/**
 * Servlet implementation class ImageStreamServlet
 */
public class ImageStreamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageStreamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		dao=new UserDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("image/jpeg");
		Blob blob=dao.getIMage(request.getParameter("email"), "image.jpg");
		ServletContext ctx=getServletContext();
		InputStream in=ctx.getResourceAsStream("\\resources\\image.jpg");
		int read=0;
		byte [] bytes=new byte[1024];
		OutputStream out=response.getOutputStream();
		while((read=in.read(bytes))!=-1){
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();
//		ServletOutputStream output=response.getOutputStream();
//		output.write(b);
//		PrintWriter wr=response.getWriter();
//		wr.println(x);
//		response.setHeader(arg0, arg1);
//		response.addHeader(arg0, arg1);
	}

}



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import mypack.HibernateUtil;
import mypack.Student;
import mypack.StudentBO;
import mypack.StudentDAODatabaseImpl;

/**
 * Servlet implementation class ViewServ
 */
@WebServlet("/ViewServ")
public class ViewServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Session session;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			PrintWriter pw = response.getWriter();
			Student s1 = new Student();
			
			StudentBO sb = new StudentBO(new StudentDAODatabaseImpl());
			List<Student> studentList = sb.getStudent();
			pw.println("Retived all records from Database");
			
			request.setAttribute("Mylist", studentList);
			RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
			rd.forward(request, response);
		}
		catch(Exception ee)
		{
			System.out.println("in service  "+ee);
		}
	}

}

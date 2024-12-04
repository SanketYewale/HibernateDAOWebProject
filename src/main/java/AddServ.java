
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypack.Student;
import mypack.StudentBO;
import mypack.StudentDAODatabaseImpl;

/**
 * Servlet implementation class AddServ
 */
@WebServlet("/AddServ")
public class AddServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String ps = request.getParameter("mydropdown_persist");

		Student s1 = new Student();
		s1.setName(name);
		s1.setAddress(address);

		if (ps.equals("Database")) {
			StudentBO sb = new StudentBO(new StudentDAODatabaseImpl());
			sb.addStudent(s1);
			pw.println("Records added into Database");
		}
		
		pw.println("<br>");
		pw.println("<br>");
		pw.println("<A HREF=\"Home.jsp\">Go to Home page</A>");	// link to go to Home page

	}

}



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterInsert")
public class RegisterInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterInsert() {
        super();
    
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		
		RegisterBean sb=new RegisterBean();
		sb.setUsername(username);
		sb.setEmail(email);
		sb.setPassword(password);
		sb.setCpassword(cpassword);
		
		  //PrintWriter pw=response.getWriter();
		  //pw.print(username);
		RegisterDAO dao=new RegisterDAO();
		try {
			int i=dao.RegisterInsert(sb);
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("rsuccess.html");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("error.html");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginInsert")
public class LoginInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginInsert() {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		LoginBean sb=new LoginBean();
		sb.setUsername(username);
		sb.setPassword(password);
		
		//PrintWriter pw=response.getWriter();
		//pw.print(username+"  "+password);
		LoginDAO dao=new LoginDAO();
		try {
			int i=dao.LoginInsert(sb);
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("select.html");
				rd.include(request, response);
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

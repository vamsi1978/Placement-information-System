import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	public int LoginInsert(LoginBean sb) throws ClassNotFoundException ,SQLException
	{

		Connection con=DBConn.DBConnecction();
		String sql="select * from register where username=? and password=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,sb.getUsername());
		ps.setString(2,sb.getPassword());
		ResultSet rs=ps.executeQuery();  
		int i=0;
		if(rs.next())
		{
			i++;
		}
		return i;
	}
	

}

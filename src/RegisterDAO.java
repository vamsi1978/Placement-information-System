import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	public int RegisterInsert(RegisterBean sb) throws ClassNotFoundException ,SQLException
	{
		Connection con=DBConn.DBConnecction();
		String sql="insert into register values(?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,sb.getUsername());
		ps.setString(2,sb.getEmail());
		ps.setString(3,sb.getPassword());
		ps.setString(4, sb.getCpassword());
		int i=ps.executeUpdate();
		return i;
		
	}
}

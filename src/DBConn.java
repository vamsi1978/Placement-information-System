import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	public static Connection DBConnecction() throws  ClassNotFoundException ,SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	 	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","HR","hr");
		
		return con;
	}
}

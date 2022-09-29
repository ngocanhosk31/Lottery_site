package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	
public static Connection connect() throws SQLException, ClassNotFoundException {
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=do_an;user=sa;password=Abc_12345;encrypt=false;trustServerCertificate=false;");
	return conn;
}
}

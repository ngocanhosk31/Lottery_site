package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import context.DBContext;
import entity.Account;

public class LoginDAO {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	}
public static Account login(String email, String password) throws ClassNotFoundException, SQLException {
	String query = "select * from tai_khoan \n"
			+ "where email = ?\n"
			+ "and mat_khau = ?";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, email);
	ps.setString(2, password);
	rs = ps.executeQuery();
	while(rs.next()) {
		if(rs.getInt(5) == 0) {
			return new Account(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), false, true);
		}else {
			return new Account(rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), true, false);
		}
	}
	return null;
}

}

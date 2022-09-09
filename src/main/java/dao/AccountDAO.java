package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import context.DBContext;
import entity.Account;
import entity.MD5Library;

public class AccountDAO {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		int length = 10;
//        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        Random random = new Random();
//        char[] randomPass = new char[length];
//        for (int i = 0; i < length; i++) {
//        	randomPass[i] = characters.charAt(random.nextInt(characters.length()));
//        }
//        System.out.print(randomPass);
		changePass("12345", "ngocanhoskj@gmail.com");
		System.out.print("ok");
	}
public static List<Account> getListAccount(int index) throws ClassNotFoundException, SQLException{
	String query = "with x as (select row_number() over(order by id) as row, *\n"
			+ "from tai_khoan)\n"
			+ "select * from x where row between ?*5-4 and ?*5";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ps = conn.prepareStatement(query);
	ps.setInt(1, index);
	ps.setInt(2, index);
	rs = ps.executeQuery();
	List<Account> listAccount = new ArrayList<>();
	while(rs.next()) {
		if(rs.getInt(6) == 0) {
			Account account = new Account(rs.getInt(2), rs.getString(3),
					rs.getString(4), rs.getString(5), false, true);
			listAccount.add(account);
		}else {
			Account account = new Account(rs.getInt(2), rs.getString(3),
					rs.getString(4), rs.getString(5), true, false);
			listAccount.add(account);
		}
	}
	conn.close();
	return listAccount;
}
public static int count() throws ClassNotFoundException, SQLException {
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query = "select count(*) from tai_khoan";
	ps = conn.prepareStatement(query);
	rs = ps.executeQuery();
	while(rs.next()) {
		return rs.getInt(1);
	}
	conn.close();
	return 0;
}
public static void deleteAccount(String s) {
	String query = "delete from tai_khoan where id=?";
	try {
		Connection conn = DBContext.connect();
		PreparedStatement ps = null;
		
		ps = conn.prepareStatement(query);
		
			ps.setString(1, s);
			ps.executeUpdate();
		
			conn.close();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public static boolean checkAccount(String email) throws ClassNotFoundException, SQLException {
	String query = "select * from tai_khoan where email = ?";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, email);
	rs = ps.executeQuery();
	while(rs.next()) {
		return false;
	}
	conn.close();
	return true;
}
public static void addAccount(String hoTen, String email, String matKhau, int vaiTro) throws ClassNotFoundException, SQLException {
	String query = "insert into tai_khoan values (?, ?, ?, ?)";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, hoTen);
	ps.setString(2, email);
	ps.setString(3, matKhau);
	ps.setInt(4, vaiTro);
	ps.executeUpdate();
	conn.close();

}
public static int countMatchName(String s) throws ClassNotFoundException, SQLException {
	String query = "select count(*) from tai_khoan where ho_ten like concat('%', ?, '%')";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, s);
	rs = ps.executeQuery();
	while(rs.next()) {
		return rs.getInt(1);
	}
	conn.close();
	return 0;
}
public static int countMatchEmail(String s) throws ClassNotFoundException, SQLException {
	String query = "select count(*) from tai_khoan where email like concat('%', ?, '%')";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, s);
	rs = ps.executeQuery();
	while(rs.next()) {
		return rs.getInt(1);
	}
	conn.close();
	return 0;
}
public static int countMatchAccount(String s1, String s2) throws ClassNotFoundException, SQLException {
	String query = "select count(*) from tai_khoan where ho_ten like concat('%', ?, '%')"
			+ "and email like concat('%', ?, '%')";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, s1);
	ps.setString(2, s2);
	rs = ps.executeQuery();
	while(rs.next()) {
		return rs.getInt(1);
	}
	conn.close();
	return 0;
}
public static List<Account> getMatchName(int index, String s) throws ClassNotFoundException, SQLException{
	String query = "with x as (select row_number() over(order by id) as row, *\n"
			+ "from tai_khoan where ho_ten like concat('%', ?, '%'))\n"
			+ "select * from x where row between ?*5-4 and ?*5";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, s);
	ps.setInt(2, index);
	ps.setInt(3, index);
	rs = ps.executeQuery();
	List<Account> listAccount = new ArrayList<>();
	while(rs.next()) {
		if(rs.getInt(6) == 0) {
			Account account = new Account(rs.getInt(2), rs.getString(3),
					rs.getString(4), rs.getString(5), false, true);
			listAccount.add(account);
		}else {
			Account account = new Account(rs.getInt(2), rs.getString(3),
					rs.getString(4), rs.getString(5), true, false);
			listAccount.add(account);
		}
	}
	conn.close();
	return listAccount;
}
public static List<Account> getMatchEmail(int index, String s) throws ClassNotFoundException, SQLException{
	String query = "with x as (select row_number() over(order by id) as row, *\n"
			+ "from tai_khoan where email like concat('%', ?, '%'))\n"
			+ "select * from x where row between ?*5-4 and ?*5";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, s);
	ps.setInt(2, index);
	ps.setInt(3, index);
	rs = ps.executeQuery();
	List<Account> listAccount = new ArrayList<>();
	while(rs.next()) {
		if(rs.getInt(6) == 0) {
			Account account = new Account(rs.getInt(2), rs.getString(3),
					rs.getString(4), rs.getString(5), false, true);
			listAccount.add(account);
		}else {
			Account account = new Account(rs.getInt(2), rs.getString(3),
					rs.getString(4), rs.getString(5), true, false);
			listAccount.add(account);
		}
	}
	conn.close();
	return listAccount;
}
public static List<Account> getMatchAccount(int index, String s1, String s2) throws ClassNotFoundException, SQLException{
	String query = "with x as (select row_number() over(order by id) as row, *\n"
			+ "from tai_khoan where ho_ten like concat('%', ?, '%')\n"
			+ "and email like concat('%', ?, '%'))\n"
			+ "select * from x where row between ?*5-4 and ?*5";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, s1);
	ps.setString(2, s2);
	ps.setInt(3, index);
	ps.setInt(4, index);
	rs = ps.executeQuery();
	List<Account> listAccount = new ArrayList<>();
	while(rs.next()) {
		if(rs.getInt(6) == 0) {
			Account account = new Account(rs.getInt(2), rs.getString(3),
					rs.getString(4), rs.getString(5), false, true);
			listAccount.add(account);
		}else {
			Account account = new Account(rs.getInt(2), rs.getString(3),
					rs.getString(4), rs.getString(5), true, false);
			listAccount.add(account);
		}
	}
	conn.close();
	return listAccount;
}
public static void addPass(String s1, String s2) throws ClassNotFoundException, SQLException {
	String query = "insert into quan_ly_tk VALUES(?, ?);";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	
	ps = conn.prepareStatement(query);
	ps.setString(1, s1);
	ps.setString(2, s2);
	ps.executeUpdate();
	conn.close();
}
public static boolean checkPass(String s1, String s2) throws ClassNotFoundException, SQLException {
	String query = "select * from quan_ly_tk where email = ? and mat_khau = ?";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, s1);
	ps.setString(2, s2);
	rs = ps.executeQuery();
	while(rs.next()) {
		return true;
	}
	conn.close();
	return false;
}
public static void changePass(String s1, String s2) throws ClassNotFoundException, SQLException {
	String query = "update tai_khoan set mat_khau = ? where email = ?";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ps = conn.prepareStatement(query);
	String encryptPass = MD5Library.md5(s1);
	ps.setString(1, encryptPass);
	ps.setString(2, s2);
	ps.executeUpdate();
	conn.close();
}
public static String getName(String s) throws ClassNotFoundException, SQLException {
	String query = "select ho_ten from tai_khoan where email = ?";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, s);
	rs = ps.executeQuery();
	String name = null;
	while(rs.next()) {
		name = rs.getString(1);
		return name;
	}
	return name;
}
public static void changeRole(String s) throws ClassNotFoundException, SQLException {
	String query = "update tai_khoan set vai_tro = 0 where id = ?";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, s);
	ps.executeUpdate();
	conn.close();
}
public static void editName(String name ,String email) throws ClassNotFoundException, SQLException {
	String query = "update tai_khoan set ho_ten = ? where email = ?";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, name);
	ps.setString(2, email);
	ps.executeUpdate();
	conn.close();
}
}


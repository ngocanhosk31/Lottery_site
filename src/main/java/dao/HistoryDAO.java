package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.History;
import entity.Lottery;

public class HistoryDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static List<History> getHistory(int index, String email) throws ClassNotFoundException, SQLException {
	String query = "with x as (select row_number() over(order by id) as row, *\n"
			+ "from lich_su_do where email = ?)\n"
			+ "select * from x where row between ?*5-4 and ?*5";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, email);
	ps.setInt(2, index);
	ps.setInt(3, index);
	rs = ps.executeQuery();
	List<History> listHistory = new ArrayList<>();
	while(rs.next()) {
		History h = new History(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
				rs.getString(6), rs.getString(7), rs.getString(8));
		listHistory.add(h);
	}
	conn.close();
	return listHistory;
}
public static int count(String email) throws ClassNotFoundException, SQLException {
	String query = "select count(*) from lich_su_do where email = ?";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, email);
	rs = ps.executeQuery();
	while(rs.next()) {
		return rs.getInt(1);
	}
	conn.close();
	return 0;
}
public static void deleteHistory(String id) throws ClassNotFoundException, SQLException {
	String query = "delete from lich_su_do where id = ?";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, id);
	ps.executeUpdate();
	conn.close();
}
public static int countSearch(String s1, String s2) throws ClassNotFoundException, SQLException {
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query = "select count(*) from lich_su_do where thoiGian like concat('%',?,'%')"
			+ "and tinh like concat('%',?,'%')";
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
public static int countSearchTime(String s) throws ClassNotFoundException, SQLException {
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query = "select count(*) from lich_su_do where thoiGian like concat('%',?,'%')";
	ps = conn.prepareStatement(query);
	ps.setString(1, s);
	rs = ps.executeQuery();
	while(rs.next()) {
		return rs.getInt(1);
	}
	conn.close();
	return 0;
}
public static int countSearchCity(String s) throws ClassNotFoundException, SQLException {
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query = "select count(*) from lich_su_do where tinh like concat('%',?,'%')";
	ps = conn.prepareStatement(query);
	ps.setString(1, s);
	rs = ps.executeQuery();
	while(rs.next()) {
		return rs.getInt(1);
	}
	conn.close();
	return 0;
}
public static List<History> getMatchHistory(int index, String s1, String s2) throws ClassNotFoundException, SQLException{
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query =  " with x as (select row_number() over(order by id) as row,* from\n"
			+ "(select * from lich_su_do \n"
			+ "where thoiGian like concat('%',?,'%')\n"
			+ "and tinh like concat('%',?,'%')) as s )\n"
			+ "select * from x where row between ?*5-4 and ?*5";
	ps = conn.prepareStatement(query);
	ps.setInt(3, index);
	ps.setInt(4, index);
	ps.setString(1, s1);
	ps.setString(2, s2);
	rs = ps.executeQuery();
	List<History> listHistory = new ArrayList<>();
	while(rs.next()) {
		History history = new History(rs.getInt(2), rs.getString(3), rs.getString(4),
				rs.getString(5), rs.getString(6), rs.getString(7),
				 rs.getString(8));
		listHistory.add(history);
	}
	conn.close();
	return listHistory;
}
public static List<History> getMatchTimeHistory(int index, String s) throws ClassNotFoundException, SQLException{
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query =  " with x as (select row_number() over(order by id) as row,* from\n"
			+ "(select * from lich_su_do \n"
			+ "where thoiGian like concat('%',?,'%')\n"
			+ "select * from x where row between ?*5-4 and ?*5";
	ps = conn.prepareStatement(query);
	ps.setInt(2, index);
	ps.setInt(3, index);
	ps.setString(1, s);
	rs = ps.executeQuery();
	List<History> listHistory = new ArrayList<>();
	while(rs.next()) {
		History history = new History(rs.getInt(2), rs.getString(3), rs.getString(4),
				rs.getString(5), rs.getString(6), rs.getString(7),
				 rs.getString(8));
		listHistory.add(history);
	}
	conn.close();
	return listHistory;
}
public static List<History> getMatchCityHistory(int index, String s) throws ClassNotFoundException, SQLException{
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query =  " with x as (select row_number() over(order by id) as row,* from\n"
			+ "(select * from lich_su_do \n"
			+ "and tinh like concat('%',?,'%')) as s )\n"
			+ "select * from x where row between ?*5-4 and ?*5";
	ps = conn.prepareStatement(query);
	ps.setInt(2, index);
	ps.setInt(3, index);
	ps.setString(1, s);
	rs = ps.executeQuery();
	List<History> listHistory = new ArrayList<>();
	while(rs.next()) {
		History history = new History(rs.getInt(2), rs.getString(3), rs.getString(4),
				rs.getString(5), rs.getString(6), rs.getString(7),
				 rs.getString(8));
		listHistory.add(history);
	}
	conn.close();
	return listHistory;
}

}

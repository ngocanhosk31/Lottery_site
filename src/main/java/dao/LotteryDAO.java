package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Lottery;

public class LotteryDAO {
	
	public static List<Lottery> getListLottery(int index) throws ClassNotFoundException, SQLException{
		Connection conn = DBContext.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "with x as (select row_number() over(order by id) as row, *\n"
				+ "from ve_so)\n"
				+ "select * from x where row between ?*5-4 and ?*5";
		ps = conn.prepareStatement(query);
		ps.setInt(1, index);
		ps.setInt(2, index);
		rs = ps.executeQuery();
		List<Lottery> listLottery = new ArrayList<>();
		while(rs.next()) {
			Lottery lottery = new Lottery(rs.getInt(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7),
					 rs.getString(8), rs.getString(9), rs.getString(10),
					 rs.getString(11), rs.getString(12), rs.getString(13)
					);
			listLottery.add(lottery);
		}
		conn.close();
		return listLottery;
	}
	
	public static List<Lottery> getMatchLottery(int index, String s1, String s2) throws ClassNotFoundException, SQLException{
		Connection conn = DBContext.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query =  " with x as (select row_number() over(order by id) as row,* from\n"
				+ "(select * from ve_so \n"
				+ "where thoi_gian like concat('%',?,'%')\n"
				+ "and tinh like concat('%',?,'%')) as s )\n"
				+ "select * from x where row between ?*5-4 and ?*5";
		ps = conn.prepareStatement(query);
		ps.setInt(3, index);
		ps.setInt(4, index);
		ps.setString(1, s1);
		ps.setString(2, s2);
		rs = ps.executeQuery();
		List<Lottery> listLottery = new ArrayList<>();
		while(rs.next()) {
			Lottery lottery = new Lottery(rs.getInt(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7),
					 rs.getString(8), rs.getString(9), rs.getString(10),
					 rs.getString(11), rs.getString(12), rs.getString(13)
					);
			listLottery.add(lottery);
			//System.out.println(listLottery.size());
		}
		conn.close();
		return listLottery;
	}
	public static List<Lottery> getMatchTimeLottery(int index, String s) throws ClassNotFoundException, SQLException{
		Connection conn = DBContext.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query =  " with x as (select row_number() over(order by id) as row,* from\n"
				+ "(select * from ve_so \n"
				+ "where thoi_gian like concat('%',?,'%')\n"
				+ "select * from x where row between ?*5-4 and ?*5";
		ps = conn.prepareStatement(query);
		ps.setInt(3, index);
		ps.setInt(4, index);
		ps.setString(1, s);
		
		rs = ps.executeQuery();
		List<Lottery> listLottery = new ArrayList<>();
		while(rs.next()) {
			Lottery lottery = new Lottery(rs.getInt(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7),
					 rs.getString(8), rs.getString(9), rs.getString(10),
					 rs.getString(11), rs.getString(12), rs.getString(13)
					);
			listLottery.add(lottery);
			//System.out.println(listLottery.size());
		}
		conn.close();
		return listLottery;
	}
	public static List<Lottery> getMatchCityLottery(int index, String s) throws ClassNotFoundException, SQLException{
		Connection conn = DBContext.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query =  " with x as (select row_number() over(order by id) as row,* from\n"
				+ "(select * from ve_so \n"
				+ "where tinh like concat('%',?,'%')\n"
				
				+ "select * from x where row between ?*5-4 and ?*5";
		ps = conn.prepareStatement(query);
		ps.setInt(3, index);
		ps.setInt(4, index);
		ps.setString(1, s);
		
		rs = ps.executeQuery();
		List<Lottery> listLottery = new ArrayList<>();
		while(rs.next()) {
			Lottery lottery = new Lottery(rs.getInt(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7),
					 rs.getString(8), rs.getString(9), rs.getString(10),
					 rs.getString(11), rs.getString(12), rs.getString(13)
					);
			listLottery.add(lottery);
			//System.out.println(listLottery.size());
		}
		conn.close();
		return listLottery;
	}
	public static int count() throws ClassNotFoundException, SQLException {
		Connection conn = DBContext.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select count(*) from ve_so";
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
			return rs.getInt(1);
		}
		conn.close();
		return 0;
		
	}
	
	public static int countSearch(String s1, String s2) throws ClassNotFoundException, SQLException {
		Connection conn = DBContext.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "select count(*) from ve_so where thoi_gian like concat('%',?,'%')"
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
		String query = "select count(*) from ve_so where thoi_gian like concat('%',?,'%')";
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
		String query = "select count(*) from ve_so where tinh like concat('%',?,'%')";
		ps = conn.prepareStatement(query);
		ps.setString(1, s);
		
		rs = ps.executeQuery();
		while(rs.next()) {
			return rs.getInt(1);
		}
		conn.close();
		return 0;
		
	}
	public static void deleteLottery(String s) {
		String query = "delete from ve_so where id=?";
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
	
	public static boolean checkLottery(String tinh, String thoiGian) throws ClassNotFoundException, SQLException {
		String query = "select * from ve_so where tinh = ? and thoi_gian = ?";
		Connection conn = DBContext.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(query);
		ps.setString(1, tinh);
		ps.setString(2, thoiGian);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			return false;
		}
		conn.close();
			return true;
		
	}
	
	public static void addLottery(String tinh, String thoiGian, String giaiDacBiet, String giaiNhat,
			String giaiNhi, String giaiBa, String giaiTu, String giaiNam, String giaiSau, 
			String giaiBay, String giaiTam) {
		String query = "insert into ve_so \n"
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection conn = DBContext.connect();
			PreparedStatement ps = null;
			ps = conn.prepareStatement(query);
			
				ps.setString(1, tinh);
				ps.setString(2, thoiGian);
				ps.setString(3, giaiDacBiet);
				ps.setString(4, giaiNhat);
				ps.setString(5, giaiNhi);
				ps.setString(6, giaiBa);
				ps.setString(7, giaiTu);
				ps.setString(8, giaiNam);
				ps.setString(9, giaiSau);
				ps.setString(10, giaiBay);
				ps.setString(11, giaiTam);
				ps.executeUpdate();
				conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static List<String> getListCity() throws ClassNotFoundException, SQLException{
		String query = "select * from tinh";
		Connection conn = DBContext.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		List<String> listCity = new ArrayList<>();
		while(rs.next()) {
			listCity.add(rs.getString(1));
		}
		conn.close();
		return listCity;
	}

	public static Lottery getDetailLottery(String id) throws ClassNotFoundException, SQLException {
		String query = "select * from ve_so where id = ?";
		Connection conn = DBContext.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = conn.prepareStatement(query);
		ps.setString(1, id);
		rs = ps.executeQuery();
		while(rs.next()) {
			return new Lottery(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6),
					 rs.getString(7), rs.getString(8), rs.getString(9),
					 rs.getString(10), rs.getString(11), rs.getString(12));
		}
		conn.close();
		return null;
	}
	
	public static void editLottery(String id, String tinh, String thoiGian, String giaiDacBiet,
			String giaiNhat,String giaiNhi, String giaiBa, String giaiTu, String giaiNam,
			String giaiSau, String giaiBay,
			String giaiTam) throws ClassNotFoundException, SQLException {
		String query = "update ve_so\n"
				+ "set tinh = ?, thoi_gian = ?, giai_dac_biet = ?, giai_nhat = ?, giai_nhi = ?, \n"
				+ "giai_ba = ?, giai_tu = ?, giai_nam = ?, giai_sau = ?, giai_bay = ?, giai_tam = ?\n"
				+ "where id = ?";
		Connection conn = DBContext.connect();
		PreparedStatement ps = null;
		
		ps = conn.prepareStatement(query);
		ps.setString(1, tinh);
		ps.setString(2, thoiGian);
		ps.setString(3, giaiDacBiet);
		ps.setString(4, giaiNhat);
		ps.setString(5, giaiNhi);
		ps.setString(6, giaiBa);
		ps.setString(7, giaiTu);
		ps.setString(8, giaiNam);
		ps.setString(9, giaiSau);
		ps.setString(10, giaiBay);
		ps.setString(11, giaiTam);
		ps.setString(12, id);
		ps.executeUpdate();
		conn.close();
	}
	
	

}

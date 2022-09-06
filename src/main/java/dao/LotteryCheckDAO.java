package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import context.DBContext;
import entity.Award;

public class LotteryCheckDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static Award checkLottery(String city, String time) throws ClassNotFoundException, SQLException {
	String query = "select giai_dac_biet, giai_nhat, giai_nhi, giai_ba,\n"
			+ " giai_tu, giai_nam, giai_sau, giai_bay, giai_tam \n"
			+ " from ve_so\n"
			+ " where tinh = ? and thoi_gian = ?";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, city);
	ps.setString(2, time);
	rs = ps.executeQuery();
	Award award = null;
	
	while(rs.next()) {
		award = new Award(rs.getString(1).split("\\s*,\\s*"), rs.getString(2).split("\\s*,\\s*"),
				rs.getString(3).split("\\s*,\\s*"), rs.getString(4).split("\\s*,\\s*"), rs.getString(5).split("\\s*,\\s*"),
				rs.getString(6).split("\\s*,\\s*"), rs.getString(7).split("\\s*,\\s*"), rs.getString(8).split("\\s*,\\s*"),
				rs.getString(9).split("\\s*,\\s*"));
	}
	return award;
}
public static void addHistory(String tinh, String thoiGian, String hoTen, String email, String veSo, String giaiThuong)
		throws ClassNotFoundException, SQLException {
	String query = "insert into lich_su_do values(?,?,?,?,?,?)";
	Connection conn = DBContext.connect();
	PreparedStatement ps = null;
	ps = conn.prepareStatement(query);
	ps.setString(1, tinh);
	ps.setString(2, thoiGian);
	ps.setString(3, hoTen);
	ps.setString(4, email);
	ps.setString(5, veSo);
	ps.setString(6, giaiThuong);
	ps.executeUpdate();
	conn.close();
}
}

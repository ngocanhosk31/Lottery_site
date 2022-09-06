package entity;

public class History {
private int id;
private String tinh;
private String thoiGian;
private String hoTen;
private String email;
private String veSo;
private String giaiThuong;
public History(int id, String tinh, String thoiGian, String hoTen, String email, String veSo, String giaiThuong) {
	super();
	this.id = id;
	this.tinh = tinh;
	this.thoiGian = thoiGian;
	this.hoTen = hoTen;
	this.email = email;
	this.veSo = veSo;
	this.giaiThuong = giaiThuong;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTinh() {
	return tinh;
}
public void setTinh(String tinh) {
	this.tinh = tinh;
}
public String getThoiGian() {
	return thoiGian;
}
public void setThoiGian(String thoiGian) {
	this.thoiGian = thoiGian;
}
public String getHoTen() {
	return hoTen;
}
public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getVeSo() {
	return veSo;
}
public void setVeSo(String veSo) {
	this.veSo = veSo;
}
public String getGiaiThuong() {
	return giaiThuong;
}
public void setGiaiThuong(String giaiThuong) {
	this.giaiThuong = giaiThuong;
}

}

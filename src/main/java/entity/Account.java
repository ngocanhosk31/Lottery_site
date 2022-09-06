package entity;

public class Account {
private int id;
private String hoTen;
private String email;
private String matKhau;
private boolean user;
private boolean admin;

public Account(int id, String hoTen, String email, String matKhau, boolean user, boolean admin) {
	super();
	this.id = id;
	this.hoTen = hoTen;
	this.email = email;
	this.matKhau = matKhau;
	this.user = user;
	this.admin = admin;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getMatKhau() {
	return matKhau;
}
public void setMatKhau(String matKhau) {
	this.matKhau = matKhau;
}
public boolean isUser() {
	return user;
}
public void setUser(boolean user) {
	this.user = user;
}
public boolean isAdmin() {
	return admin;
}
public void setAdmin(boolean admin) {
	this.admin = admin;
}

}

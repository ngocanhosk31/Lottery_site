package entity;

import java.util.Arrays;

public class Award {

	private String[] giaiDacBiet;
	private String[] giaiNhat;
	private String[] giaiNhi;
	private String[] giaiBa;
	private String[] giaiTu;
	private String[] giaiNam;
	private String[] giaiSau;
	private String[] giaiBay;
	private String[] giaiTam;
	public Award(String[] giaiDacBiet, String[] giaiNhat, String[] giaiNhi, String[] giaiBa, String[] giaiTu,
			String[] giaiNam, String[] giaiSau, String[] giaiBay, String[] giaiTam) {
		super();
		this.giaiDacBiet = giaiDacBiet;
		this.giaiNhat = giaiNhat;
		this.giaiNhi = giaiNhi;
		this.giaiBa = giaiBa;
		this.giaiTu = giaiTu;
		this.giaiNam = giaiNam;
		this.giaiSau = giaiSau;
		this.giaiBay = giaiBay;
		this.giaiTam = giaiTam;
	}
	public String[] getGiaiDacBiet() {
		return giaiDacBiet;
	}
	public void setGiaiDacBiet(String[] giaiDacBiet) {
		this.giaiDacBiet = giaiDacBiet;
	}
	public String[] getGiaiNhat() {
		return giaiNhat;
	}
	public void setGiaiNhat(String[] giaiNhat) {
		this.giaiNhat = giaiNhat;
	}
	public String[] getGiaiNhi() {
		return giaiNhi;
	}
	public void setGiaiNhi(String[] giaiNhi) {
		this.giaiNhi = giaiNhi;
	}
	public String[] getGiaiBa() {
		return giaiBa;
	}
	public void setGiaiBa(String[] giaiBa) {
		this.giaiBa = giaiBa;
	}
	public String[] getGiaiTu() {
		return giaiTu;
	}
	public void setGiaiTu(String[] giaiTu) {
		this.giaiTu = giaiTu;
	}
	public String[] getGiaiNam() {
		return giaiNam;
	}
	public void setGiaiNam(String[] giaiNam) {
		this.giaiNam = giaiNam;
	}
	public String[] getGiaiSau() {
		return giaiSau;
	}
	public void setGiaiSau(String[] giaiSau) {
		this.giaiSau = giaiSau;
	}
	public String[] getGiaiBay() {
		return giaiBay;
	}
	public void setGiaiBay(String[] giaiBay) {
		this.giaiBay = giaiBay;
	}
	public String[] getGiaiTam() {
		return giaiTam;
	}
	public void setGiaiTam(String[] giaiTam) {
		this.giaiTam = giaiTam;
	}
	@Override
	public String toString() {
		return "Award [giaiDacBiet=" + Arrays.toString(giaiDacBiet) + ", giaiNhat=" + Arrays.toString(giaiNhat)
				+ ", giaiNhi=" + Arrays.toString(giaiNhi) + ", giaiBa=" + Arrays.toString(giaiBa) + ", giaiTu="
				+ Arrays.toString(giaiTu) + ", giaiNam=" + Arrays.toString(giaiNam) + ", giaiSau="
				+ Arrays.toString(giaiSau) + ", giaiBay=" + Arrays.toString(giaiBay) + ", giaiTam="
				+ Arrays.toString(giaiTam) + "]";
	}
	
}



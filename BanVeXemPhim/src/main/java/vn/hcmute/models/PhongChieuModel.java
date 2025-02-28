package vn.hcmute.models;

public class PhongChieuModel {
	private int maPhong;

	private String tenPhong;

	private int sucChua;

	private int tinhTrang;
	

	public PhongChieuModel() {
		super();
	}

	public PhongChieuModel(int maPhong, String tenPhong, int sucChua, int tinhTrang) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.sucChua = sucChua;
		this.tinhTrang = tinhTrang;
	}

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public int getSucChua() {
		return sucChua;
	}

	public void setSucChua(int sucChua) {
		this.sucChua = sucChua;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
}

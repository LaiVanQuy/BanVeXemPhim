package vn.hcmute.models;

import java.util.Date;


public class PhimModel {
	private int maPhim;
	private String TenPhim;
	private String HinhAnh;
	private String MoTa;
	private TheLoaiModel theLoaiModel;
	
	private String trailer;
	private int trangThai;
	private String dienVien;
	private Date ngayXuatBan;
	
	
	
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public String getDienVien() {
		return dienVien;
	}
	public void setDienVien(String dienVien) {
		this.dienVien = dienVien;
	}
	public Date getNgayXuatBan() {
		return ngayXuatBan;
	}
	public void setNgayXuatBan(Date ngayXuatBan) {
		this.ngayXuatBan = ngayXuatBan;
	}
	public TheLoaiModel getTheLoaiModel() {
		return theLoaiModel;
	}
	public void setTheLoaiModel(TheLoaiModel theLoaiModel) {
		this.theLoaiModel = theLoaiModel;
	}
	public int getMaPhim() {
		return maPhim;
	}
	public void setMaPhim(int maPhim) {
		this.maPhim = maPhim;
	}
	public String getTenPhim() {
		return TenPhim;
	}
	public void setTenPhim(String tenPhim) {
		TenPhim = tenPhim;
	}
	public String getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	
}

package vn.hcmute.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Phim")
public class PhimEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maPhim;
	
	
	@Column(name="TenPhim",columnDefinition = "nvarchar(50)")
	private String tenPhim;
	
	@Column(name="HinhAnh")
	private String hinhAnh;
	
	@Column(name="MoTa",columnDefinition = "nvarchar(MAX)")
	private String moTa;
	@Column(name="trailer",columnDefinition = "nvarchar(80)")
	private String trailer;
	
	@Column(name="trangthai")
	private int trangThai;
	@Column(name="dienvien",columnDefinition = "nvarchar(MAX)")
	private String dienVien;
	@Column(name="ngayxuatban",columnDefinition = "Date")
	private Date ngayXuatBan;
	@ManyToOne
	@JoinColumn(name = "maTheLoai")
	private TheLoaiEntity theLoaiEntity;
	
	@OneToMany(mappedBy = "phimEntity",cascade = CascadeType.ALL)
	List<SuatChieuEntity> suatChieuEntities;
	
	
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


	public int getMaPhim() {
		return maPhim;
	}


	public String getTenPhim() {
		return tenPhim;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}
	public TheLoaiEntity getTheLoaiEntity() {
		return theLoaiEntity;
	}


	public void setTheLoaiEntity(TheLoaiEntity theLoaiEntity) {
		this.theLoaiEntity = theLoaiEntity;
	}


	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
}

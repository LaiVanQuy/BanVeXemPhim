package vn.hcmute.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

@Entity
@Table(name="PhongChieu")
@Check(constraints = "TinhTrang=1 or TinhTrang=0")
public class PhongChieuEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maPhong;
	
	@Column(name="TenPhong")
	private String tenPhong;
	
	@Column(name="SucChua")
	private int sucChua;
	
	@Column(name="TinhTrang")
	private int tinhTrang;
	
	@OneToMany(mappedBy = "phongChieuEntity")
	List<SuatChieuEntity> litSuatChieuEntities;
	
	@OneToMany(mappedBy = "phongChieuEntity",cascade = CascadeType.ALL)
	List<SeatEntity>listSeatEntities;

	public int getMaPhong() {
		return maPhong;
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

	public List<SuatChieuEntity> getLitSuatChieuEntities() {
		return litSuatChieuEntities;
	}

	public void setLitSuatChieuEntities(List<SuatChieuEntity> litSuatChieuEntities) {
		this.litSuatChieuEntities = litSuatChieuEntities;
	}

	public List<SeatEntity> getListSeatEntities() {
		return listSeatEntities;
	}

	public void setListSeatEntities(List<SeatEntity> listSeatEntities) {
		this.listSeatEntities = listSeatEntities;
	}

	public PhongChieuEntity(int maPhong, String tenPhong, int sucChua, int tinhTrang,
			List<SuatChieuEntity> litSuatChieuEntities, List<SeatEntity> listSeatEntities) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.sucChua = sucChua;
		this.tinhTrang = tinhTrang;
		this.litSuatChieuEntities = litSuatChieuEntities;
		this.listSeatEntities = listSeatEntities;
	}

	public PhongChieuEntity() {
		super();
	}
	
	
}

package vn.hcmute.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

@Entity
@Table(name = "Ve")
@Check(constraints = "trangThai=1 or trangThai=0")
public class VeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maVe;

	@ManyToOne
	@JoinColumn(name = "maSuatChieu")
	private SuatChieuEntity suatChieuEntity;
	
	@Column(name = "GiaVe")
	private int giaVe;

	@ManyToOne
	@JoinColumn(name = "ChoNgoi")
	private SeatEntity seatEntity;
	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	@Column(name = "trangThai")
	private int trangThai;

	public int getMaVe() {
		return maVe;
	}

	public void setMaVe(int maVe) {
		this.maVe = maVe;
	}

	public SuatChieuEntity getSuatChieuEntity() {
		return suatChieuEntity;
	}

	public void setSuatChieuEntity(SuatChieuEntity suatChieuEntity) {
		this.suatChieuEntity = suatChieuEntity;
	}

	public int getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(int giaVe) {
		this.giaVe = giaVe;
	}

	public SeatEntity getSeatEntity() {
		return seatEntity;
	}

	public void setSeatEntity(SeatEntity seatEntity) {
		this.seatEntity = seatEntity;
	}

	public VeEntity(int maVe, SuatChieuEntity suatChieuEntity, int giaVe, SeatEntity seatEntity) {
		super();
		this.maVe = maVe;
		this.suatChieuEntity = suatChieuEntity;
		this.giaVe = giaVe;
		this.seatEntity = seatEntity;
	}

	public VeEntity() {
		super();
	}

}

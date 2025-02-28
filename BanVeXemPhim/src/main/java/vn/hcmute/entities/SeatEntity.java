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
@Table(name="Seats")
@Check(constraints = "trangThai=1 or trangThai=0")
public class SeatEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int seatId;
	
	@ManyToOne
	@JoinColumn(name="maPhong")
	private PhongChieuEntity phongChieuEntity;
	
	@Column(name="Hang",columnDefinition = "varchar(1)")
	private String hang;
	
	@Column(name="Soghe")
	private int soGhe;
	
	@Column(name="TrangThai")
	private int trangTrai;

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public PhongChieuEntity getPhongChieuEntity() {
		return phongChieuEntity;
	}

	public void setPhongChieuEntity(PhongChieuEntity phongChieuEntity) {
		this.phongChieuEntity = phongChieuEntity;
	}

	public String getHang() {
		return hang;
	}

	public void setHang(String hang) {
		this.hang = hang;
	}

	public int getSoGhe() {
		return soGhe;
	}

	public void setSoGhe(int soGhe) {
		this.soGhe = soGhe;
	}

	public int getTrangTrai() {
		return trangTrai;
	}

	public void setTrangTrai(int trangTrai) {
		this.trangTrai = trangTrai;
	}

	public SeatEntity(int seatId, PhongChieuEntity phongChieuEntity, String hang, int soGhe, int trangTrai) {
		super();
		this.seatId = seatId;
		this.phongChieuEntity = phongChieuEntity;
		this.hang = hang;
		this.soGhe = soGhe;
		this.trangTrai = trangTrai;
	}

	public SeatEntity() {
		super();
	}
	
	
	
	
}

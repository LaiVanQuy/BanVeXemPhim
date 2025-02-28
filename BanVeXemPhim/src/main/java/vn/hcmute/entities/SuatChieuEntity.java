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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="SuatChieu")
public class SuatChieuEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maSuatChieu;
	
	@Column(name = "GioChieu", columnDefinition = "DateTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date gioChieu;
	
	@ManyToOne
	@JoinColumn(name="maPhim")
	private PhimEntity phimEntity;
	
	@ManyToOne
	@JoinColumn(name="maPhong")
	private PhongChieuEntity phongChieuEntity;
	
	@OneToMany(mappedBy = "suatChieuEntity",cascade = CascadeType.ALL)
	List<VeEntity>lisEntities;

	
	
	
	public SuatChieuEntity() {
		super();
	}

	public SuatChieuEntity(int maSuatChieu, Date gioChieu, PhimEntity phimEntity, PhongChieuEntity phongChieuEntity) {
		super();
		this.maSuatChieu = maSuatChieu;
		this.gioChieu = gioChieu;
		this.phimEntity = phimEntity;
		this.phongChieuEntity = phongChieuEntity;
	}

	public int getMaSuatChieu() {
		return maSuatChieu;
	}

	public Date getGioChieu() {
		return gioChieu;
	}

	public void setGioChieu(Date gioChieu) {
		this.gioChieu = gioChieu;
	}

	public PhimEntity getPhimEntity() {
		return phimEntity;
	}

	public void setPhimEntity(PhimEntity phimEntity) {
		this.phimEntity = phimEntity;
	}

	public PhongChieuEntity getPhongChieuEntity() {
		return phongChieuEntity;
	}

	public void setPhongChieuEntity(PhongChieuEntity phongChieuEntity) {
		this.phongChieuEntity = phongChieuEntity;
	}

	public List<VeEntity> getLisEntities() {
		return lisEntities;
	}

	public void setLisEntities(List<VeEntity> lisEntities) {
		this.lisEntities = lisEntities;
	}
	
	
	

}

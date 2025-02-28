package vn.hcmute.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ChiTietDH")
public class ChiTietDonHangEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	 @ManyToOne
	 @JoinColumn(name = "maDH")
	 private DonHangEntity donHangEntity;
	
	 @ManyToOne
	 @JoinColumn(name = "maVe")
	 private VeEntity veEntity;

	public int getId() {
		return id;
	}

	public DonHangEntity getDonHangEntity() {
		return donHangEntity;
	}

	public void setDonHangEntity(DonHangEntity donHangEntity) {
		this.donHangEntity = donHangEntity;
	}

	public VeEntity getVeEntity() {
		return veEntity;
	}

	public void setVeEntity(VeEntity veEntity) {
		this.veEntity = veEntity;
	}

	public ChiTietDonHangEntity(int id, DonHangEntity donHangEntity, VeEntity veEntity) {
		super();
		this.id = id;
		this.donHangEntity = donHangEntity;
		this.veEntity = veEntity;
	}

	public ChiTietDonHangEntity() {
		super();
	}
	 
	 
}


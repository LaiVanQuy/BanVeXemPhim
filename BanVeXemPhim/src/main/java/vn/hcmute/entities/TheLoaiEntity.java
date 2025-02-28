package vn.hcmute.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TheLoai")
public class TheLoaiEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maTheLoai;
	
	@Column(name="TenTheLoai",columnDefinition = "nvarchar(50)")
	private String tenTheLoai;
	
	@OneToMany(mappedBy = "theLoaiEntity")
	List<PhimEntity> listPhimEntities;

	public int getMaTheLoai() {
		return maTheLoai;
	}

	public void setMaTheLoai(int maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public List<PhimEntity> getListPhimEntities() {
		return listPhimEntities;
	}

	public void setListPhimEntities(List<PhimEntity> listPhimEntities) {
		this.listPhimEntities = listPhimEntities;
	}
	
	
	

}

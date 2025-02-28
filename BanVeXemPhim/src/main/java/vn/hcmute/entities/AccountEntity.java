package vn.hcmute.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

@Entity
@Table(name="TaiKhoan")
@Check(constraints = "rolee=1 or rolee=0")
public class AccountEntity {
	@Id
	private String email;
	
	@Column(name="Pass")
	private String pass;
	
	@Column(name="Rolee")
	private int rolee;
	
	@Column(name="Ten",columnDefinition = "nvarchar(50)")
	private String ten;
	
	

	public AccountEntity() {
		super();
	}

	public AccountEntity(String email, String pass, int rolee, String ten) {
		super();
		this.email = email;
		this.pass = pass;
		this.rolee = rolee;
		this.ten = ten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getRolee() {
		return rolee;
	}

	public void setRolee(int rolee) {
		this.rolee = rolee;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}
	
	
}

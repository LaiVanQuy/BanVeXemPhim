package vn.hcmute.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="DonHang")
public class DonHangEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int maDH;
	
	@Column(name = "GioDat", columnDefinition = "DateTime")
	@Temporal(TemporalType.TIMESTAMP)
//	@DateTimeFormat(pattern = "EEE MMM dd HH:mm:ss 'GMT'Z yyyy")
	private Date gioDat;

	@ManyToOne
	@JoinColumn(name = "account")
	private AccountEntity accountEntity;
	
	public AccountEntity getAccountEntity() {
		return accountEntity;
	}


	public void setAccountEntity(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
	}


	public int getMaDH() {
		return maDH;
	}


	public Date getGioDat() {
		return gioDat;
	}

	public void setGioDat(Date gioDat) {
		this.gioDat = gioDat;
	}


	

	public DonHangEntity(int maDH, Date gioDat, AccountEntity accountEntity) {
		super();
		this.maDH = maDH;
		this.gioDat = gioDat;
		this.accountEntity = accountEntity;
	}


	public DonHangEntity() {
		super();
	}
	
}

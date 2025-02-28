package vn.hcmute.models;

import java.util.Date;

public class DonHangModel {
	private int maDH;

	private Date gioDat;
	private AccountModel accountModel;

	public int getMaDH() {
		return maDH;
	}

	public void setMaDH(int maDH) {
		this.maDH = maDH;
	}

	public Date getGioDat() {
		return gioDat;
	}

	public void setGioDat(Date gioDat) {
		this.gioDat = gioDat;
	}

	public AccountModel getAccountModel() {
		return accountModel;
	}

	public void setAccountModel(AccountModel accountModel) {
		this.accountModel = accountModel;
	}

	public DonHangModel(int maDH, Date gioDat,AccountModel accountModel) {
		super();
		this.maDH = maDH;
		this.gioDat = gioDat;
		this.accountModel=accountModel;
	}

	public DonHangModel() {
		super();
	}
	
	

}

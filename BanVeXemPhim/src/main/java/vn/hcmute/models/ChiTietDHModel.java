package vn.hcmute.models;

public class ChiTietDHModel {
	private int id;
	private DonHangModel donHangModel;

	private VeModel veModel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DonHangModel getDonHangModel() {
		return donHangModel;
	}

	public void setDonHangModel(DonHangModel donHangModel) {
		this.donHangModel = donHangModel;
	}

	public VeModel getVeModel() {
		return veModel;
	}

	public void setVeModel(VeModel veModel) {
		this.veModel = veModel;
	}

	public ChiTietDHModel(int id, DonHangModel donHangModel, VeModel veModel) {
		super();
		this.id = id;
		this.donHangModel = donHangModel;
		this.veModel = veModel;
	}

	public ChiTietDHModel() {
		super();
	}
	
}

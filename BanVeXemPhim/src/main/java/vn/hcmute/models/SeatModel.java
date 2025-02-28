package vn.hcmute.models;

public class SeatModel {
	private int seatId;

	private PhongChieuModel phongChieuModel;

	private String hang;

	private int soGhe;

	private int trangTrai;

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}

	public PhongChieuModel getPhongChieuModel() {
		return phongChieuModel;
	}

	public void setPhongChieuModel(PhongChieuModel phongChieuModel) {
		this.phongChieuModel = phongChieuModel;
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

	public SeatModel(int seatId, PhongChieuModel phongChieuEntity, String hang, int soGhe, int trangTrai) {
		super();
		this.seatId = seatId;
		this.phongChieuModel = phongChieuEntity;
		this.hang = hang;
		this.soGhe = soGhe;
		this.trangTrai = trangTrai;
	}

	public SeatModel() {
		super();
	}
	
}

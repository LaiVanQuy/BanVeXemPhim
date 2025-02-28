package vn.hcmute.models;


public class VeModel {
	private int maVe;
	private SuatChieuModel suatChieuModel;;
	private int giaVe;
	private SeatModel seatModel;
	private int trangThai;
	
	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public int getMaVe() {
		return maVe;
	}
	public void setMaVe(int maVe) {
		this.maVe = maVe;
	}
	public SuatChieuModel getSuatChieuModel() {
		return suatChieuModel;
	}
	public void setSuatChieuModel(SuatChieuModel suatChieuModel) {
		this.suatChieuModel = suatChieuModel;
	}
	public int getGiaVe() {
		return giaVe;
	}
	public void setGiaVe(int giaVe) {
		this.giaVe = giaVe;
	}
	public SeatModel getSeatModel() {
		return seatModel;
	}
	public void setSeatModel(SeatModel seatModel) {
		this.seatModel = seatModel;
	}
	public VeModel(int maVe, SuatChieuModel suatChieuModel, int giaVe, SeatModel seatModel) {
		super();
		this.maVe = maVe;
		this.suatChieuModel = suatChieuModel;
		this.giaVe = giaVe;
		this.seatModel = seatModel;
	}
	public VeModel() {
		super();
	}
	
}

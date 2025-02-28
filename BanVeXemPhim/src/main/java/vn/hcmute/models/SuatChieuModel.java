package vn.hcmute.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SuatChieuModel {
	private int maSuatChieu;
	private Date gioChieu;
	private PhimModel phimModel;

	private PhongChieuModel phongChieuModel;
	


	public SuatChieuModel() {
		super();
	}

	public SuatChieuModel(int maSuatChieu, Date gioChieu, PhimModel phimModel,
			PhongChieuModel phongChieuModel) {
		super();
		this.maSuatChieu = maSuatChieu;
		this.gioChieu = gioChieu;
		this.phimModel = phimModel;
		this.phongChieuModel = phongChieuModel;
	}

	public int getMaSuatChieu() {
		return maSuatChieu;
	}

	public void setMaSuatChieu(int maSuatChieu) {
		this.maSuatChieu = maSuatChieu;
	}

	public Date getGioChieu() {
		return gioChieu;
	}

	public void setGioChieu(String gioChieu) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		Date date=new Date();
		try {
			date = dateFormat.parse(gioChieu);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.gioChieu = date;
	}

	public PhimModel getPhimModel() {
		return phimModel;
	}

	public void setPhimModel(PhimModel phimModel) {
		
		this.phimModel = phimModel;
	}

	public PhongChieuModel getPhongChieuModel() {
		return phongChieuModel;
	}

	public void setPhongChieuModel(PhongChieuModel phongChieuModel) {
		this.phongChieuModel = phongChieuModel;
	}
	
	
}

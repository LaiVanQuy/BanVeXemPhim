package vn.hcmute.service;

import java.util.Date;
import java.util.List;

import org.hibernate.type.NTextType;

import vn.hcmute.entities.PhimEntity;
import vn.hcmute.models.SuatChieuModel;

public interface ISuatChieuService {
	List<SuatChieuModel> getSuatChieuByPhim(PhimEntity phimEntity);
	
	SuatChieuModel addSuatChieu(Date gioChieu, int maPhim, int maPhong);
}

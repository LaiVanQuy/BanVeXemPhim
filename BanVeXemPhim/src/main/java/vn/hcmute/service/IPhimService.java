package vn.hcmute.service;

import java.util.List;

import vn.hcmute.entities.TheLoaiEntity;
import vn.hcmute.models.AccountModel;
import vn.hcmute.models.PhimModel;
import vn.hcmute.models.TheLoaiModel;

public interface IPhimService {
	
	List<PhimModel>findAllMovie();
	
	List<PhimModel>findByTheLoai(TheLoaiEntity theLoaiModel);
	List<PhimModel>findByTrangThai(int trangThai);
	
	PhimModel findByMaPhim(int maPhim);
	
	PhimModel addPhim(PhimModel model);
	void deletePhim(int maPhim);
}

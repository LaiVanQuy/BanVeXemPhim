package vn.hcmute.service;

import java.util.List;

import vn.hcmute.models.TheLoaiModel;

public interface ITheLoaiService {
	List<TheLoaiModel>findAllCategory();
	
	TheLoaiModel findOneByMaTheLoai(int maTheLoai);
}

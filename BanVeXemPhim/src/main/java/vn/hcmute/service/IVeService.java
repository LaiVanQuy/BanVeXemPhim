package vn.hcmute.service;

import java.util.List;

import vn.hcmute.entities.SuatChieuEntity;
import vn.hcmute.models.VeModel;

public interface IVeService {
	List<VeModel> getListVeBySuatChieu(SuatChieuEntity suatChieuEntity);
	
	
}

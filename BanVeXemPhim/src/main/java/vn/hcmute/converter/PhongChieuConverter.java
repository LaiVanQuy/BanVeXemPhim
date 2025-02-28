package vn.hcmute.converter;

import org.springframework.stereotype.Component;

import vn.hcmute.entities.PhimEntity;
import vn.hcmute.entities.PhongChieuEntity;
import vn.hcmute.models.PhimModel;
import vn.hcmute.models.PhongChieuModel;

@Component
public class PhongChieuConverter {
	public PhongChieuModel entityToModel(PhongChieuEntity phongChieuEntity) {
		PhongChieuModel phongChieuModel=new PhongChieuModel();
		phongChieuModel.setMaPhong(phongChieuEntity.getMaPhong());
		phongChieuModel.setSucChua(phongChieuEntity.getSucChua());
		phongChieuModel.setTenPhong(phongChieuEntity.getTenPhong());
		phongChieuModel.setTinhTrang(phongChieuEntity.getTinhTrang());
		return phongChieuModel;
	}

	public PhongChieuEntity modelToEntity(PhongChieuModel phongChieuModel) {
		PhongChieuEntity phongChieuEntity=new PhongChieuEntity();
		phongChieuEntity.setTenPhong(phongChieuModel.getTenPhong());
		phongChieuEntity.setSucChua(phongChieuModel.getSucChua());
		phongChieuEntity.setTinhTrang(phongChieuModel.getTinhTrang());
		return phongChieuEntity;
	}

}

package vn.hcmute.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.hcmute.entities.SuatChieuEntity;
import vn.hcmute.models.SuatChieuModel;

@Component
public class SuatChieuConverter {
	
	@Autowired
	private PhimConverter phimConverter;
	
	@Autowired
	private PhongChieuConverter phongChieuConverter;
	public SuatChieuModel entityToModel(SuatChieuEntity suatChieuEntity) {
		SuatChieuModel suatChieuModel=new SuatChieuModel();
		suatChieuModel.setGioChieu(suatChieuEntity.getGioChieu().toString());
		suatChieuModel.setMaSuatChieu(suatChieuEntity.getMaSuatChieu());
		suatChieuModel.setPhimModel(phimConverter.entityToModel(suatChieuEntity.getPhimEntity()));
		suatChieuModel.setPhongChieuModel(phongChieuConverter.entityToModel(suatChieuEntity.getPhongChieuEntity()));
		return suatChieuModel;
	}

	public SuatChieuEntity modelToEntity(SuatChieuModel suatChieuModel) {
		SuatChieuEntity suatChieuEntity=new SuatChieuEntity();
		suatChieuEntity.setGioChieu(suatChieuModel.getGioChieu());
		suatChieuEntity.setPhimEntity(phimConverter.modelToEntity(suatChieuModel.getPhimModel()));
		suatChieuEntity.setPhongChieuEntity(phongChieuConverter.modelToEntity(suatChieuModel.getPhongChieuModel()));
		return suatChieuEntity;
	}
}

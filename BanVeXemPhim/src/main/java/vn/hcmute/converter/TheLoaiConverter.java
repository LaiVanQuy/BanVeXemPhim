package vn.hcmute.converter;

import org.springframework.stereotype.Component;

import vn.hcmute.entities.TheLoaiEntity;
import vn.hcmute.models.TheLoaiModel;

@Component
public class TheLoaiConverter {
	
	public TheLoaiModel entityToModel(TheLoaiEntity theLoaiEntity) {
		TheLoaiModel theLoaiModel=new TheLoaiModel();
		theLoaiModel.setTenTheLoai(theLoaiEntity.getTenTheLoai());
		theLoaiModel.setMaTheLoai(theLoaiEntity.getMaTheLoai());
		return theLoaiModel;
	
	}

	public TheLoaiEntity modelToEntity(TheLoaiModel theLoaiModel) {
		TheLoaiEntity theLoaiEntity=new TheLoaiEntity();
		theLoaiEntity.setMaTheLoai(theLoaiModel.getMaTheLoai());
		theLoaiEntity.setTenTheLoai(theLoaiModel.getTenTheLoai());
		return theLoaiEntity;
	}
}

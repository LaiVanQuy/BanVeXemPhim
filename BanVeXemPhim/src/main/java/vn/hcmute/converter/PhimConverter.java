package vn.hcmute.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.hcmute.entities.PhimEntity;
import vn.hcmute.entities.TheLoaiEntity;
import vn.hcmute.models.PhimModel;

@Component
public class PhimConverter {
	@Autowired
	private TheLoaiConverter theLoaiConverter;
	
	public PhimModel entityToModel(PhimEntity phimEntity) {
		PhimModel phimModel=new PhimModel();
		phimModel.setTenPhim(phimEntity.getTenPhim());
		phimModel.setHinhAnh(phimEntity.getHinhAnh());
		phimModel.setMoTa(phimEntity.getMoTa());
		phimModel.setMaPhim(phimEntity.getMaPhim());
		phimModel.setTheLoaiModel(theLoaiConverter.entityToModel(phimEntity.getTheLoaiEntity()));;
		phimModel.setDienVien(phimEntity.getDienVien());
		phimModel.setNgayXuatBan(phimEntity.getNgayXuatBan());
		phimModel.setTrailer(phimEntity.getTrailer());
		phimModel.setTrangThai(phimEntity.getTrangThai());
		return phimModel;
	}

	public PhimEntity modelToEntity(PhimModel phimModel) {
		PhimEntity phimEntity=new PhimEntity();
		phimEntity.setTenPhim(phimModel.getTenPhim());
		phimEntity.setHinhAnh(phimModel.getHinhAnh());
		phimEntity.setMoTa(phimModel.getMoTa());
		
		phimEntity.setTheLoaiEntity(theLoaiConverter.modelToEntity(phimModel.getTheLoaiModel()));
		phimEntity.setDienVien(phimModel.getDienVien());
		phimEntity.setNgayXuatBan(phimModel.getNgayXuatBan());
		phimEntity.setTrailer(phimModel.getTrailer());
		phimEntity.setTrangThai(phimModel.getTrangThai());
		return phimEntity;
	}

}

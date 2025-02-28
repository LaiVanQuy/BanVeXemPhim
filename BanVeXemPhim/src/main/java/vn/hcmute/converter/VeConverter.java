package vn.hcmute.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.hcmute.entities.VeEntity;
import vn.hcmute.models.VeModel;

@Component
public class VeConverter {
	
	@Autowired 
	private SeatConverter seatConverter;
	@Autowired 
	private SuatChieuConverter suatChieuConverter;
	
	public VeModel entityToModel(VeEntity veEntity) {
		VeModel veModel=new VeModel();
		veModel.setGiaVe(veEntity.getGiaVe());
		veModel.setMaVe(veEntity.getMaVe());
		veModel.setSeatModel(seatConverter.entityToModel(veEntity.getSeatEntity()));
		veModel.setSuatChieuModel(suatChieuConverter.entityToModel(veEntity.getSuatChieuEntity()));
		veModel.setTrangThai(veEntity.getTrangThai());
		return veModel;
	}

	public VeEntity modelToEntity(VeModel veModel) {
		VeEntity veEntity=new VeEntity();
		veEntity.setGiaVe(veModel.getGiaVe());
		veEntity.setSeatEntity(seatConverter.modelToEntity(veModel.getSeatModel()));
		veEntity.setSuatChieuEntity(suatChieuConverter.modelToEntity(veModel.getSuatChieuModel()));
		veEntity.setTrangThai(veModel.getTrangThai());
		return veEntity;
	}
}

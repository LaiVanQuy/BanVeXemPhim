package vn.hcmute.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.hcmute.entities.SeatEntity;
import vn.hcmute.models.SeatModel;

@Component
public class SeatConverter {
	
	@Autowired 
	private PhongChieuConverter phongChieuConverter;
	public SeatModel entityToModel(SeatEntity seatEntity) {
		SeatModel seatModel=new SeatModel();
		seatModel.setSeatId(seatEntity.getSeatId());
		seatModel.setHang(seatEntity.getHang());
		seatModel.setPhongChieuModel(phongChieuConverter.entityToModel(seatEntity.getPhongChieuEntity()));
		seatModel.setSoGhe(seatEntity.getSoGhe());
		seatModel.setTrangTrai(seatEntity.getTrangTrai());
		return seatModel;
	}

	public SeatEntity modelToEntity(SeatModel seatModel) {
		SeatEntity seatEntity=new SeatEntity();
		seatEntity.setHang(seatModel.getHang());
		seatEntity.setPhongChieuEntity(phongChieuConverter.modelToEntity(seatModel.getPhongChieuModel()));
		seatEntity.setSoGhe(seatModel.getSoGhe());
		seatEntity.setTrangTrai(seatModel.getTrangTrai());
		return seatEntity;
	}
}

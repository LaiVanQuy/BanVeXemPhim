package vn.hcmute.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.hcmute.entities.ChiTietDonHangEntity;
import vn.hcmute.entities.DonHangEntity;
import vn.hcmute.models.ChiTietDHModel;
import vn.hcmute.models.DonHangModel;

@Component
public class ChiTietDHConverter {
	
	@Autowired 
	private DonHangConverter donHangConverter;
	@Autowired 
	private VeConverter veConverter;
	public ChiTietDHModel entityToModel(ChiTietDonHangEntity chiTietDonHangEntity) {
		ChiTietDHModel chiTietDHModel=new ChiTietDHModel();
		chiTietDHModel.setId(chiTietDonHangEntity.getId());
		chiTietDHModel.setDonHangModel(donHangConverter.entityToModel(chiTietDonHangEntity.getDonHangEntity()));
		chiTietDHModel.setVeModel(veConverter.entityToModel(chiTietDonHangEntity.getVeEntity()));
		return chiTietDHModel;
	}

	public ChiTietDonHangEntity modelToEntity(ChiTietDHModel chiTietDHModel) {
		ChiTietDonHangEntity entity=new ChiTietDonHangEntity();
		entity.setDonHangEntity(donHangConverter.modelToEntity(chiTietDHModel.getDonHangModel()));
		entity.setVeEntity(veConverter.modelToEntity(chiTietDHModel.getVeModel()));
		return entity;
	}
}

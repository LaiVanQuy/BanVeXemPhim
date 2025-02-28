package vn.hcmute.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.hcmute.entities.DonHangEntity;
import vn.hcmute.models.DonHangModel;

@Component
public class DonHangConverter {
	@Autowired
	private AccountConverter accountConverter;
	public DonHangModel entityToModel(DonHangEntity donHangEntity) {
		DonHangModel donHangModel=new DonHangModel();
		donHangModel.setMaDH(donHangEntity.getMaDH());
		donHangModel.setGioDat(donHangEntity.getGioDat());
		donHangModel.setAccountModel(accountConverter.entityToModel(donHangEntity.getAccountEntity()));
		return donHangModel;
	}

	public DonHangEntity modelToEntity(DonHangModel donHangModel) {
		DonHangEntity donHangEntity=new DonHangEntity();
		donHangEntity.setGioDat(donHangModel.getGioDat());
		donHangEntity.setAccountEntity(accountConverter.modelToEntity(donHangModel.getAccountModel()));
		return donHangEntity;
	}
}

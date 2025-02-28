package vn.hcmute.service.ipl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.hcmute.converter.AccountConverter;
import vn.hcmute.converter.DonHangConverter;
import vn.hcmute.entities.AccountEntity;
import vn.hcmute.entities.DonHangEntity;
import vn.hcmute.models.AccountModel;
import vn.hcmute.models.DonHangModel;
import vn.hcmute.repository.AccountRepo;
import vn.hcmute.repository.DonHangRepo;
import vn.hcmute.service.IDonHangService;

@Service
public class DonHangServiceImple implements IDonHangService {

	@Autowired 
	private AccountRepo accountRepo;
	@Autowired 
	private DonHangConverter donHangConverter;
	@Autowired 
	private AccountConverter accountConverter;
	@Autowired 
	private DonHangRepo donHangRepo;
	@Override
	public DonHangModel addDonHang( String email,String pass) {
		DonHangEntity donHangEntity=new DonHangEntity();
		AccountEntity accountEntity=accountRepo.findAccount(email, pass);
		donHangEntity.setAccountEntity(accountEntity);
		donHangEntity.setGioDat(new Date());
		donHangEntity=donHangRepo.save(donHangEntity);
		return donHangConverter.entityToModel(donHangEntity);
	}
	
	@Override
	public List<DonHangModel> getByAccount(AccountModel accountModel) {
		List<DonHangEntity>donHangEntities=new ArrayList<>();
		AccountEntity accountEntity=accountConverter.modelToEntity(accountModel);
		donHangEntities=donHangRepo.findByAccountEntity(accountEntity);
		List< DonHangModel>donHangModels=new ArrayList<>();
		for (DonHangEntity donHangEntity : donHangEntities) {
			DonHangModel donHangModel=new DonHangModel();
			donHangModel=donHangConverter.entityToModel(donHangEntity);
			donHangModels.add(donHangModel);
		}
		return donHangModels;
	}

}

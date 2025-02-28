package vn.hcmute.service.ipl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.hcmute.converter.PhimConverter;
import vn.hcmute.entities.PhimEntity;
import vn.hcmute.entities.TheLoaiEntity;
import vn.hcmute.models.PhimModel;
import vn.hcmute.repository.PhimRepository;
import vn.hcmute.repository.TheLoaiRepo;
import vn.hcmute.service.IPhimService;

@Service
public class PhimServiceImple implements IPhimService {

	@Autowired
	private PhimRepository phimRepo;
	@Autowired
	private PhimConverter phimConverter;
	@Autowired
	private TheLoaiRepo theLoaiRepo;
	


	@Override
	public List<PhimModel> findAllMovie() {
		List<PhimEntity> listPhimEntity = phimRepo.findAll();
		List<PhimModel> listModel = new ArrayList<>();
		for (PhimEntity pE : listPhimEntity) {

			listModel.add(phimConverter.entityToModel(pE));
		}
		return listModel;
	}



	@Override
	public List<PhimModel> findByTheLoai(TheLoaiEntity theLoaiEntity) {
		List<PhimEntity> listPhimEntities = phimRepo.findByTheLoai(theLoaiEntity);
		List<PhimModel> lisPhimModels = new ArrayList<>();
		for (PhimEntity pE : listPhimEntities) {

			lisPhimModels.add(phimConverter.entityToModel(pE));
		}
		return lisPhimModels;
	}

	@Override
	public PhimModel findByMaPhim(int maPhim) {
		PhimEntity phimEntity=phimRepo.findByMaPhim(maPhim);
		if(phimEntity==null)
			return null;
		PhimModel phimModel=new PhimModel();
		phimModel=phimConverter.entityToModel(phimEntity);
		return phimModel;
	}

	@Override
	public PhimModel addPhim(PhimModel model) {
		TheLoaiEntity theLoaiEntity=theLoaiRepo.findOneByMaTheLoai(model.getTheLoaiModel().getMaTheLoai());
		PhimEntity phimEntity=phimConverter.modelToEntity(model);
		phimEntity.setTheLoaiEntity(theLoaiEntity);
		phimEntity=phimRepo.save(phimEntity);
		return phimConverter.entityToModel(phimEntity);
	}



	@Override
	public void deletePhim(int maPhim) {
		phimRepo.deleteById(maPhim);
	}



	@Override
	public List<PhimModel> findByTrangThai(int trangThai) {
		List<PhimEntity> listPhimEntities = phimRepo.findByTrangThai(trangThai);
		List<PhimModel> lisPhimModels = new ArrayList<>();
		for (PhimEntity pE : listPhimEntities) {

			lisPhimModels.add(phimConverter.entityToModel(pE));
		}
		return lisPhimModels;
	}

}

package vn.hcmute.service.ipl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.hcmute.converter.VeConverter;
import vn.hcmute.entities.SuatChieuEntity;
import vn.hcmute.entities.VeEntity;
import vn.hcmute.models.VeModel;
import vn.hcmute.repository.VeRepo;
import vn.hcmute.service.IVeService;

@Service
public class VeServiceImple implements IVeService {

	@Autowired
	private VeRepo veRepo;
	@Autowired
	private VeConverter veConverter;
	
	@Override
	public List<VeModel> getListVeBySuatChieu(SuatChieuEntity suatChieuEntity) {
		List<VeEntity> listVeEntities=new ArrayList<>();
		List<VeModel>listVeModels=new ArrayList<>();
		listVeEntities=veRepo.findBySuatChieu(suatChieuEntity);
		for (VeEntity veEntity: listVeEntities) {
			listVeModels.add(veConverter.entityToModel(veEntity));
		}
		return listVeModels;
	}

}

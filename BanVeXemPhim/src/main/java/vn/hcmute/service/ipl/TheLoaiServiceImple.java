package vn.hcmute.service.ipl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.hcmute.converter.TheLoaiConverter;
import vn.hcmute.entities.TheLoaiEntity;
import vn.hcmute.models.TheLoaiModel;
import vn.hcmute.repository.TheLoaiRepo;
import vn.hcmute.service.ITheLoaiService;

@Service
public class TheLoaiServiceImple implements ITheLoaiService {
	
	@Autowired
	private TheLoaiRepo theLoaiRepo;

	@Autowired
	private TheLoaiConverter theLoaiConverter;

	@Override
	public List<TheLoaiModel> findAllCategory() {
		List<TheLoaiEntity> listTheLoaiEntities = theLoaiRepo.findAll();
		List<TheLoaiModel> listModel = new ArrayList<>();
		for (TheLoaiEntity pE : listTheLoaiEntities) {

			listModel.add(theLoaiConverter.entityToModel(pE));
		}
		return listModel;
	}

	@Override
	public TheLoaiModel findOneByMaTheLoai(int maTheLoai) {
		TheLoaiEntity theLoaiEntity= theLoaiRepo.findOneByMaTheLoai(maTheLoai);
		TheLoaiModel theLoaiModel=new TheLoaiModel();
		theLoaiModel=theLoaiConverter.entityToModel(theLoaiEntity);
		return theLoaiModel;
	}

}

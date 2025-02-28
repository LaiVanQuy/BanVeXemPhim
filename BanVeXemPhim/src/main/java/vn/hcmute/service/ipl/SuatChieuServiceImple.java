package vn.hcmute.service.ipl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.hcmute.converter.PhimConverter;
import vn.hcmute.converter.PhongChieuConverter;
import vn.hcmute.converter.SuatChieuConverter;
import vn.hcmute.entities.PhimEntity;
import vn.hcmute.entities.PhongChieuEntity;
import vn.hcmute.entities.SuatChieuEntity;
import vn.hcmute.models.SuatChieuModel;
import vn.hcmute.repository.PhimRepository;
import vn.hcmute.repository.PhongChieuRepo;
import vn.hcmute.repository.SuatChieuRepo;
import vn.hcmute.service.ISuatChieuService;

@Service
public class SuatChieuServiceImple implements ISuatChieuService {

	@Autowired
	private SuatChieuRepo suatChieuRepo;
	@Autowired
	private SuatChieuConverter suatChieuConverter;
	@Autowired
	private PhimRepository phimRepository;
	@Autowired
	private PhongChieuRepo phongChieuRepo;
	
	@Override
	public List<SuatChieuModel> getSuatChieuByPhim(PhimEntity phimEntity) {
		List<SuatChieuModel> listSuatChieuModels=new ArrayList<>();
		List<SuatChieuEntity> listSuatChieuEntities=suatChieuRepo.findByMaPhim(phimEntity);
		
		for (SuatChieuEntity suatChieuEntity : listSuatChieuEntities) {
			listSuatChieuModels.add(suatChieuConverter.entityToModel(suatChieuEntity));
		}
		return listSuatChieuModels;
	}
	@Override
	public SuatChieuModel addSuatChieu(Date gioChieu,int maPhim, int maPhong) {
		PhimEntity phimEntity=phimRepository.findByMaPhim(maPhim);
		PhongChieuEntity phongChieuEntity=phongChieuRepo.findByMaPhong(maPhong);
		SuatChieuEntity suatChieuEntity=new SuatChieuEntity();
		suatChieuEntity.setGioChieu(gioChieu);
		suatChieuEntity.setPhongChieuEntity(phongChieuEntity);
		suatChieuEntity.setPhimEntity(phimEntity);
		suatChieuEntity=suatChieuRepo.save(suatChieuEntity);
		return suatChieuConverter.entityToModel(suatChieuEntity);
		
	
	}

}

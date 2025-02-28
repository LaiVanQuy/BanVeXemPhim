package vn.hcmute.service.ipl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.hcmute.converter.ChiTietDHConverter;
import vn.hcmute.converter.DonHangConverter;
import vn.hcmute.entities.ChiTietDonHangEntity;
import vn.hcmute.entities.DonHangEntity;
import vn.hcmute.entities.SeatEntity;
import vn.hcmute.entities.VeEntity;
import vn.hcmute.models.ChiTietDHModel;
import vn.hcmute.repository.ChiTietDHRepo;
import vn.hcmute.repository.DonHangRepo;
import vn.hcmute.repository.VeRepo;
import vn.hcmute.service.IChiTietDHService;
import vn.hcmute.service.IDonHangService;

@Service
public class ChiTietDHServiceImple implements IChiTietDHService {

	@Autowired
	private VeRepo veRepo;
	@Autowired
	private DonHangRepo donHangRepo;
	@Autowired
	private ChiTietDHRepo chiTietDHRepo;

	@Autowired
	private ChiTietDHConverter chiTietDHConverter;

	@Autowired
	private IDonHangService donHangService;

	@Override
	public List<ChiTietDHModel> addChiTietDH(List<Integer> listmaVe, String email, String pass) {
		List<ChiTietDHModel> lisTietDHModels=new ArrayList<>();
		List<ChiTietDonHangEntity>lisTietDonHangEntities=new ArrayList<>();
		List<VeEntity> listVeEntities = new ArrayList<>();
		for (Integer maVe : listmaVe) {
			listVeEntities.add(veRepo.findByMaVe(maVe));
		}
		boolean f = true;
		for (VeEntity veEntity : listVeEntities) {
			if (veEntity.getTrangThai() == 1) {
				f = false;
				break;
			}
		}
		if (f) {
			donHangService.addDonHang( email, pass);
			for (VeEntity veEntity : listVeEntities) {
				ChiTietDonHangEntity chiTietDonHangEntity = new ChiTietDonHangEntity();
				List<DonHangEntity> list = donHangRepo.findTopByMaDH();
				DonHangEntity donHangEntity = list.get(0);
				chiTietDonHangEntity.setDonHangEntity(donHangEntity);
				veEntity.setTrangThai(1);
				chiTietDonHangEntity.setVeEntity(veEntity);
				SeatEntity seatEntity = veEntity.getSeatEntity();
				seatEntity.setTrangTrai(1);
				chiTietDonHangEntity = chiTietDHRepo.save(chiTietDonHangEntity);
				lisTietDonHangEntities.add(chiTietDonHangEntity);
			}
		}
		for (ChiTietDonHangEntity chiTietDonHangEntity : lisTietDonHangEntities) {
			lisTietDHModels.add(chiTietDHConverter.entityToModel(chiTietDonHangEntity));
		}
		return lisTietDHModels;

	}

	@Override
	public List<ChiTietDHModel> getByOrder(DonHangEntity donHangEntity) {
		List<ChiTietDonHangEntity> listChiTietDonHangEntities=chiTietDHRepo.findByDonHangEntity(donHangEntity);
		List<ChiTietDHModel>listChiTietDHModels=new ArrayList<>();
		for (ChiTietDonHangEntity chiTietDHEntity : listChiTietDonHangEntities) {
			ChiTietDHModel chiTietDHModel=chiTietDHConverter.entityToModel(chiTietDHEntity);
			listChiTietDHModels.add(chiTietDHModel);	
		}
		return listChiTietDHModels;
	}

}

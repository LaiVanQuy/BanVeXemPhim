package vn.hcmute.service;

import java.util.List;

import vn.hcmute.entities.DonHangEntity;
import vn.hcmute.models.ChiTietDHModel;

public interface IChiTietDHService {
	List<ChiTietDHModel> addChiTietDH( List<Integer> maVe, String email,String pass);
	List<ChiTietDHModel>getByOrder(DonHangEntity donHangEntity);

}

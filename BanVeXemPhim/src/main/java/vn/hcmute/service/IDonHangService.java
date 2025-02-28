package vn.hcmute.service;

import java.util.List;

import vn.hcmute.models.AccountModel;
import vn.hcmute.models.DonHangModel;

public interface IDonHangService {
	DonHangModel addDonHang(String email,String pass);
	List<DonHangModel> getByAccount(AccountModel accountModel);
}

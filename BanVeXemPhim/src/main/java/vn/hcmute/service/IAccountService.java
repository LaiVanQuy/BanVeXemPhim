package vn.hcmute.service;

import vn.hcmute.models.AccountModel;

public interface IAccountService {
	AccountModel getAccount(String email,String pass);
	int checkAccount(AccountModel accountModel);
	
	AccountModel registerAccount(String email, String pass,String ten);
	
	public Boolean checkAccountExist(AccountModel accountModel);
	AccountModel findOneByEmail(String email);
	AccountModel changePassword(String email,String oldPass,String newPass);
}

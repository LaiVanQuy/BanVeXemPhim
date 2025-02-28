package vn.hcmute.converter;

import org.springframework.stereotype.Component;

import vn.hcmute.entities.AccountEntity;
import vn.hcmute.models.AccountModel;

@Component
public class AccountConverter {
	
	public AccountModel entityToModel(AccountEntity accountEntity) {
		AccountModel accountModel=new AccountModel();
		accountModel.setEmail(accountEntity.getEmail());
		accountModel.setPass(accountEntity.getPass());
		accountModel.setRolee(accountEntity.getRolee());
		accountModel.setTen(accountEntity.getTen());
		return accountModel;
	}

	public AccountEntity modelToEntity(AccountModel accountModel) {
		AccountEntity accountEntity=new AccountEntity();
		accountEntity.setEmail(accountModel.getEmail());
		accountEntity.setPass(accountModel.getPass());
		accountEntity.setRolee(accountModel.getRolee());
		accountEntity.setTen(accountModel.getTen());
		return accountEntity;
	}
}

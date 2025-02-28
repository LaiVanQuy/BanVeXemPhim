package vn.hcmute.service.ipl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.hcmute.converter.AccountConverter;
import vn.hcmute.entities.AccountEntity;
import vn.hcmute.models.AccountModel;
import vn.hcmute.repository.AccountRepo;
import vn.hcmute.service.IAccountService;

@Service
public class AccountServiceImple implements IAccountService {

	@Autowired
	private AccountRepo accountRepo;
	@Autowired
	private AccountConverter accountConverter;

	@Override
	public AccountModel getAccount(String email, String pass) {
		AccountEntity accountEntity = accountRepo.findAccount(email, pass);

		if (accountEntity != null) {
			AccountModel accountModel = new AccountModel();
			accountModel = accountConverter.entityToModel(accountEntity);
			return accountModel;
		} else {
			return null;
		}

	}

	@Override
	public int checkAccount(AccountModel accountModel) {
		int check = 0;
		if (accountModel != null) {
			if (accountModel.getRolee() == 0)
				check = 1;
			else {
				check = 2;
			}
		}
		return check;
	}

	@Override
	public Boolean checkAccountExist(AccountModel accountModel) {
		boolean f = false;
		if (findOneByEmail(accountModel.getEmail()) != null) {
			f = true;
		}
		return f;
	}

	@Override
	public AccountModel registerAccount(String email, String pass, String ten) {
		AccountEntity accountEntity = new AccountEntity(email, pass, 0, ten);
		accountEntity = accountRepo.saveAndFlush(accountEntity);
		return accountConverter.entityToModel(accountEntity);
	}

	@Override
	public AccountModel findOneByEmail(String email) {
		AccountEntity accountEntity = accountRepo.findOneByEmail(email);
		if (accountEntity != null) {
			AccountModel accountModel = accountConverter.entityToModel(accountEntity);
			return accountModel;
		} else {
			return null;
		}

	}

	@Override
	public AccountModel changePassword(String email, String oldPass, String newPass) {
		AccountEntity accountEntity = accountRepo.findOneByEmail(email);
		AccountModel accountModel = new AccountModel();
		if (accountEntity != null && accountEntity.getPass().equals(oldPass)) {
			accountEntity.setPass(newPass);
			accountRepo.save(accountEntity);
			accountModel = accountConverter.entityToModel(accountEntity);
			return accountModel;
		} else {
			return null;
		}

	}
}

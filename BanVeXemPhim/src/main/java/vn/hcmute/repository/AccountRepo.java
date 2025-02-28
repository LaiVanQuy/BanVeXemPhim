package vn.hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.hcmute.entities.AccountEntity;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, String> {
	@Query("Select new AccountEntity(email,pass,rolee,ten) from AccountEntity where email=:email and Pass=:password")
	AccountEntity findAccount(@Param ("email")String email,@Param("password")String password);
	AccountEntity findOneByEmail(String email);
	
}

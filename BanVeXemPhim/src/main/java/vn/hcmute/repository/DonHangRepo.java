package vn.hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import vn.hcmute.entities.AccountEntity;
import vn.hcmute.entities.DonHangEntity;

@Repository
public interface DonHangRepo extends JpaRepository<DonHangEntity, Integer>  {
	@Query("select dh from DonHangEntity dh order by dh.maDH DESC")
	public List<DonHangEntity> findTopByMaDH();
	
	@Query
	public List<DonHangEntity> findByAccountEntity(AccountEntity accountEntity);
}

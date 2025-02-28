package vn.hcmute.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.hcmute.entities.PhimEntity;
import vn.hcmute.entities.SuatChieuEntity;

@Repository
public interface SuatChieuRepo extends JpaRepository<SuatChieuEntity, Integer>{
	
	@Query("select m from SuatChieuEntity m where m.phimEntity=:phim")
	List<SuatChieuEntity>findByMaPhim(@Param("phim") PhimEntity phimEntity);
	
	
}

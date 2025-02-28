package vn.hcmute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.hcmute.entities.SuatChieuEntity;
import vn.hcmute.entities.VeEntity;

@Repository
public interface VeRepo extends JpaRepository<VeEntity, Integer>{
	@Query("select m from VeEntity m where m.suatChieuEntity=:suatChieu")
	List<VeEntity>findBySuatChieu(@Param("suatChieu")SuatChieuEntity suatChieuEntity);
	
	VeEntity findByMaVe(int maVe);
}

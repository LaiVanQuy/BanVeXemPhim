package vn.hcmute.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.hcmute.entities.PhimEntity;
import vn.hcmute.entities.TheLoaiEntity;
@Repository

public interface PhimRepository extends JpaRepository<PhimEntity,Integer> {
	List<PhimEntity> findAll();
	
	@Query("select m from PhimEntity m where m.theLoaiEntity=:theLoai")
	List<PhimEntity>findByTheLoai(@Param("theLoai")TheLoaiEntity theLoaiEntity);
	
	PhimEntity findByMaPhim(int maPhim);
	
	
	@Query("select m from PhimEntity m where m.trangThai=:trangThai")
	List<PhimEntity> findByTrangThai(@Param("trangThai") int trangThai);
}

package vn.hcmute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hcmute.entities.TheLoaiEntity;
import vn.hcmute.models.TheLoaiModel;

@Repository
public interface TheLoaiRepo extends JpaRepository<TheLoaiEntity,Integer> {
	List<TheLoaiEntity> findAll();
	
	TheLoaiEntity findOneByMaTheLoai(int maTheLoai);
}

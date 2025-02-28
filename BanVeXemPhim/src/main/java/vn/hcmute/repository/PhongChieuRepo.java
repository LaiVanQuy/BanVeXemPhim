package vn.hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hcmute.entities.PhongChieuEntity;

@Repository
public interface PhongChieuRepo extends JpaRepository<PhongChieuEntity, Integer> {
	PhongChieuEntity findByMaPhong(int maPhong);
}

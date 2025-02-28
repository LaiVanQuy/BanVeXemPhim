package vn.hcmute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.hcmute.entities.ChiTietDonHangEntity;
import vn.hcmute.entities.DonHangEntity;

public interface ChiTietDHRepo extends JpaRepository<ChiTietDonHangEntity, Integer> {
	List<ChiTietDonHangEntity>findByDonHangEntity(DonHangEntity donHangEntity);

}

package vn.hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hcmute.entities.SeatEntity;

@Repository
public interface SeatRepo extends JpaRepository<SeatEntity, Integer>{
	SeatEntity findOneBySeatId(int seatId);

}

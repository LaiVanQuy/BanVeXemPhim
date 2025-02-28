package vn.hcmute.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.hcmute.entities.PhimEntity;
import vn.hcmute.models.SuatChieuModel;
import vn.hcmute.service.ISuatChieuService;

@RestController
@CrossOrigin("http://localhost:3000")
public class SuatChieuAPI {
	
	@Autowired
	private ISuatChieuService service;
	
	@GetMapping("/SuatChieuByPhim")
	
	public List<SuatChieuModel> getSuatChieuByPhim(@RequestParam("movieId") PhimEntity phimEntity) {
		return service.getSuatChieuByPhim(phimEntity);
	}
	
	@PostMapping("/SuatChieu")
	public SuatChieuModel addSuatChieu(@RequestParam ("gioChieu") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date gioChieu,@RequestParam("movieId") int maPhim,@RequestParam("roomId")int maPhong) {
		return service.addSuatChieu(gioChieu,maPhim,maPhong);
	}
}

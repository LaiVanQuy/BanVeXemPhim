package vn.hcmute.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.hcmute.entities.SuatChieuEntity;
import vn.hcmute.models.VeModel;
import vn.hcmute.service.IVeService;

@RestController
@CrossOrigin("http://localhost:3000")
public class VeAPI {
	
	@Autowired
	private IVeService service;
	@GetMapping("veBySuatChieu")
	public List<VeModel> getVeBySuatChieu(@RequestParam("suatChieuId") SuatChieuEntity suatChieuEntity){
		return service.getListVeBySuatChieu(suatChieuEntity);
	}
}

package vn.hcmute.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hcmute.models.TheLoaiModel;
import vn.hcmute.service.ITheLoaiService;

@RestController
@CrossOrigin("http://localhost:3000")
public class TheLoaiAPI {
	@Autowired
	private ITheLoaiService service;
	@GetMapping("/categories")
	public List<TheLoaiModel> getAllCategory() {

		return service.findAllCategory();
	}
}

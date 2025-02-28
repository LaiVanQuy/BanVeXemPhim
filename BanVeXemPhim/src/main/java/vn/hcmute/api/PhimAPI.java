package vn.hcmute.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.hcmute.entities.TheLoaiEntity;
import vn.hcmute.models.PhimModel;
import vn.hcmute.service.IPhimService;

@RestController
@CrossOrigin("http://localhost:3000")
public class PhimAPI {

	@Autowired
	private IPhimService service;

	@GetMapping("/movies")
	public List<PhimModel> getAllMovie() {

		return service.findAllMovie();
	}
	
	@GetMapping("/movieByCategory")
	public List<PhimModel> getMovieByCategory(@RequestParam("categoryId") TheLoaiEntity theLoaiEntity) {

		return service.findByTheLoai(theLoaiEntity);
	}
	@GetMapping("/movieByStatus")
	public List<PhimModel> getMovieByStatus(@RequestParam("status") int status) {

		return service.findByTrangThai(status);
	}
	
	@GetMapping("/movieDetail")
	public PhimModel getMovieDetail(@RequestParam("movieId")int maPhim) {
		return service.findByMaPhim(maPhim);
	}
	
	@PostMapping("/movies")
	public PhimModel addPhim(@RequestBody PhimModel phimModel) {
		return service.addPhim(phimModel);
	}
	
	@DeleteMapping("/movies")
	
	public void deletePhim(@RequestParam("movieId") int maPhim) {
		service.deletePhim(maPhim);
	}
	
}

package vn.hcmute.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.hcmute.entities.DonHangEntity;
import vn.hcmute.models.ChiTietDHModel;
import vn.hcmute.models.DonHangModel;
import vn.hcmute.models.OrderResponseModel;
import vn.hcmute.service.IAccountService;
import vn.hcmute.service.IChiTietDHService;
import vn.hcmute.service.IDonHangService;

@RestController
@CrossOrigin("http://localhost:3000")
public class DonHangAPI {

	@Autowired
	private IChiTietDHService chiTietDHService;
	@Autowired
	private IDonHangService donHangService;
	@Autowired 
	private IAccountService accountService;
	@PostMapping("Order")
	public ResponseEntity<OrderResponseModel> order(@RequestParam("email") String email,
			@RequestParam("password")String password,@RequestParam("listmaVe")List<Integer> mave) {
		List<ChiTietDHModel> lChiTietDHModel= chiTietDHService.addChiTietDH(mave,email,password);
		if(lChiTietDHModel.size()==0) {
			String message="Order Failure!";
			OrderResponseModel response=new OrderResponseModel(lChiTietDHModel,false,message);
			return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
		}
		else {
			String message="Order Successful!";
			OrderResponseModel response=new OrderResponseModel(lChiTietDHModel,true,message);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	}
	@PostMapping("ordersByAccount")
	public List<DonHangModel> getOrdersByAccount(@RequestParam ("email") String email,@RequestParam("password") String password){
		List< DonHangModel> donHangModels=donHangService.getByAccount(accountService.getAccount(email, password));
		return donHangModels;
	}
	@PostMapping("orderDetailById")
	public List<ChiTietDHModel>getDetailByOrderId(@RequestParam("orderId")DonHangEntity donHangEntity){
		List<ChiTietDHModel>chiTietDHModels=chiTietDHService.getByOrder(donHangEntity);
		return chiTietDHModels;
	}
}

package vn.hcmute.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.hcmute.models.AccountModel;
import vn.hcmute.models.LoginResponse;
import vn.hcmute.service.IAccountService;

@RestController
@CrossOrigin("http://localhost:3000")
public class AccountAPI {
	
	@Autowired
	private IAccountService service;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> loginAccount(@RequestParam("email")String email,@RequestParam("Pass") String pass) {
		AccountModel accountModel=service.getAccount(email, pass);
		if(service.checkAccount(accountModel)==0) {
			String message="Login Failure";
			LoginResponse response=new LoginResponse(false,message);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		else {
			String message="Login Successful!";
			LoginResponse loginResponse=new LoginResponse(true,message,accountModel);
			return new ResponseEntity<>(loginResponse,HttpStatus.OK);
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<LoginResponse> registerAccount(@RequestParam("email")String email,
			@RequestParam("Pass") String pass,@RequestParam("name")String ten){
			AccountModel accountModel=new AccountModel(email,pass,0,ten);
			if(service.checkAccountExist(accountModel)) {
				String message="Account aready exist";
				LoginResponse response=new LoginResponse(false,message);
				return new ResponseEntity<>(response,HttpStatus.OK);
			}
			else {
				accountModel=service.registerAccount(email, pass, ten);
				String message="Register Successful!";
				LoginResponse loginResponse=new LoginResponse(true,message,accountModel);
				return new ResponseEntity<>(loginResponse,HttpStatus.OK);
			}
	}
	@PostMapping("/change_password")
	public ResponseEntity<LoginResponse>changePassword(@RequestParam ("email")String email,
			@RequestParam("oldPass")String oldPass,@RequestParam("newPass")String newPass){
		AccountModel accountModel=service.changePassword(email, oldPass, newPass);
		if(accountModel!=null) {
			String message="Change password successful!";
			LoginResponse response=new LoginResponse(true,message,accountModel);
			return new ResponseEntity<LoginResponse>(response,HttpStatus.OK);
					
		}
		else {
			String message="Change password failure!";
			LoginResponse response=new LoginResponse(false,message);
			return new ResponseEntity<LoginResponse>(response,HttpStatus.OK);
		}
	}
	
}

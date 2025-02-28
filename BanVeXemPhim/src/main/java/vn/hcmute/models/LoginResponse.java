package vn.hcmute.models;

public class LoginResponse {
	
	private boolean success;
	private String message;
	private AccountModel accountModel;
	
	
	public LoginResponse() {
		super();
	}
	public LoginResponse(boolean success, String message, AccountModel accountModel) {
		super();
		this.success = success;
		this.message = message;
		this.accountModel = accountModel;
	}
	public LoginResponse(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
		
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AccountModel getAccountModel() {
		return accountModel;
	}
	public void setAccountModel(AccountModel accountModel) {
		this.accountModel = accountModel;
	}
	
	

}

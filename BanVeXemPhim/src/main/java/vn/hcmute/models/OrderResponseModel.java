package vn.hcmute.models;

import java.util.List;

public class OrderResponseModel {
	private List<ChiTietDHModel>lChiTietDHModels;
	private Boolean status;
	private String message;
	
	
	public OrderResponseModel(List<ChiTietDHModel> lChiTietDHModels, Boolean status, String message) {
		super();
		this.lChiTietDHModels = lChiTietDHModels;
		this.status = status;
		this.message = message;
	}


	public List<ChiTietDHModel> getlChiTietDHModels() {
		return lChiTietDHModels;
	}


	public void setlChiTietDHModels(List<ChiTietDHModel> lChiTietDHModels) {
		this.lChiTietDHModels = lChiTietDHModels;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public OrderResponseModel() {
		super();
	}
	
}

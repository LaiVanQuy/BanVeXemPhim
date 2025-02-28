package vn.quylang.movie_bookinh.Models;

import java.io.Serializable;
import java.util.List;

public class OrderResponse implements Serializable {
    private List<OrderDetail> lChiTietDHModels;
    private Boolean status;
    private String message;


    public OrderResponse(List<OrderDetail> lChiTietDHModels, Boolean status, String message) {
        super();
        this.lChiTietDHModels = lChiTietDHModels;
        this.status = status;
        this.message = message;
    }


    public List<OrderDetail> getlChiTietDHModels() {
        return lChiTietDHModels;
    }


    public void setlChiTietDHModels(List<OrderDetail> lChiTietDHModels) {
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


    public OrderResponse() {
        super();
    }
}

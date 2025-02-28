package vn.quylang.movie_booking_admin.Model;

import java.io.Serializable;

public class LoginResponse implements Serializable {
    private boolean success;
    private String message;
    private Account accountModel;


    public LoginResponse() {
        super();
    }
    public LoginResponse(boolean success, String message, Account accountModel) {
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
    public Account getAccountModel() {
        return accountModel;
    }
    public void setAccountModel(Account accountModel) {
        this.accountModel = accountModel;
    }
}

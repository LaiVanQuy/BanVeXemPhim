package vn.quylang.movie_booking_admin.Model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private int maDH;

    private Date gioDat;
    private Account accountModel;

    public int getMaDH() {
        return maDH;
    }

    public void setMaDH(int maDH) {
        this.maDH = maDH;
    }

    public Date getGioDat() {
        return gioDat;
    }

    public void setGioDat(Date gioDat) {
        this.gioDat = gioDat;
    }

    public Account getAccountModel() {
        return accountModel;
    }

    public void setAccountModel(Account accountModel) {
        this.accountModel = accountModel;
    }

    public Order(int maDH, Date gioDat,Account accountModel) {
        super();
        this.maDH = maDH;
        this.gioDat = gioDat;
        this.accountModel=accountModel;
    }

    public Order() {
        super();
    }
}

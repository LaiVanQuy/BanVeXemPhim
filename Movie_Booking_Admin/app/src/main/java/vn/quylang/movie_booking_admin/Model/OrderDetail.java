package vn.quylang.movie_booking_admin.Model;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private int id;
    private Order donHangModel;

    private Ticket veModel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getDonHangModel() {
        return donHangModel;
    }

    public void setDonHangModel(Order donHangModel) {
        this.donHangModel = donHangModel;
    }

    public Ticket getVeModel() {
        return veModel;
    }

    public void setVeModel(Ticket veModel) {
        this.veModel = veModel;
    }

    public OrderDetail(int id,Order donHangModel, Ticket veModel) {
        super();
        this.id = id;
        this.donHangModel = donHangModel;
        this.veModel = veModel;
    }

    public OrderDetail() {
        super();
    }
}

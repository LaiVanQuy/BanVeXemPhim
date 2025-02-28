package vn.quylang.movie_booking_admin.Model;

import java.io.Serializable;

public class Seat implements Serializable {
    private int seatId;

    private CinemaRoom phongChieuModel;

    private String hang;

    private int soGhe;

    private int trangTrai;

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public CinemaRoom getPhongChieuModel() {
        return phongChieuModel;
    }

    public void setPhongChieuModel(CinemaRoom phongChieuModel) {
        this.phongChieuModel = phongChieuModel;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    public int getTrangTrai() {
        return trangTrai;
    }

    public void setTrangTrai(int trangTrai) {
        this.trangTrai = trangTrai;
    }

    public Seat(int seatId, CinemaRoom phongChieuModel, String hang, int soGhe, int trangTrai) {
        super();
        this.seatId = seatId;
        this.phongChieuModel = phongChieuModel;
        this.hang = hang;
        this.soGhe = soGhe;
        this.trangTrai = trangTrai;
    }

    public Seat() {
        super();
    }
}

package vn.quylang.movie_bookinh.Models;

import java.io.Serializable;

public class Ticket  implements Serializable {
    private int maVe;
    private Showtime suatChieuModel;;
    private int giaVe;
    private Seat seatModel;
    private int trangThai;

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    public int getMaVe() {
        return maVe;
    }
    public void setMaVe(int maVe) {
        this.maVe = maVe;
    }
    public Showtime getSuatChieuModel() {
        return suatChieuModel;
    }
    public void setSuatChieuModel(Showtime suatChieuModel) {
        this.suatChieuModel = suatChieuModel;
    }
    public int getGiaVe() {
        return giaVe;
    }
    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;
    }
    public Seat getSeatModel() {
        return seatModel;
    }
    public void setSeatModel(Seat seatModel) {
        this.seatModel = seatModel;
    }
    public Ticket(int maVe, Showtime suatChieuModel, int giaVe, Seat seatModel) {
        super();
        this.maVe = maVe;
        this.suatChieuModel = suatChieuModel;
        this.giaVe = giaVe;
        this.seatModel = seatModel;
    }
    public Ticket() {
        super();
    }
}

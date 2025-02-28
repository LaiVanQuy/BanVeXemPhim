package vn.quylang.movie_booking_admin.Model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Showtime implements Serializable {
    private int maSuatChieu;
    private Date gioChieu;
    private Movie phimModel;

    private CinemaRoom phongChieuModel;



    public Showtime() {
        super();
    }

    public Showtime(int maSuatChieu, Date gioChieu, Movie phimModel,
                          CinemaRoom phongChieuModel) {
        super();
        this.maSuatChieu = maSuatChieu;
        this.gioChieu = gioChieu;
        this.phimModel = phimModel;
        this.phongChieuModel = phongChieuModel;
    }

    public int getMaSuatChieu() {
        return maSuatChieu;
    }

    public void setMaSuatChieu(int maSuatChieu) {
        this.maSuatChieu = maSuatChieu;
    }

    public Date getGioChieu() {
        return gioChieu;
    }

    public void setGioChieu(String gioChieu) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        Date date=new Date();
        try {
            date = dateFormat.parse(gioChieu);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.gioChieu = date;
    }

    public Movie getPhimModel() {
        return phimModel;
    }

    public void setPhimModel(Movie phimModel) {

        this.phimModel = phimModel;
    }

    public CinemaRoom getPhongChieuModel() {
        return phongChieuModel;
    }

    public void setPhongChieuModel(CinemaRoom phongChieuModel) {
        this.phongChieuModel = phongChieuModel;
    }
}

package vn.quylang.movie_booking_admin.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Movie implements Serializable {

    @SerializedName("maPhim")
    private int maPhim;
    @SerializedName("tenPhim")
    private String TenPhim;

    @SerializedName("hinhAnh")
    private String HinhAnh;

    @SerializedName("moTa")
    private String MoTa;
    @SerializedName("trailer")
    private String trailer;

    @SerializedName("trangThai")
    private int trangThai;
    @SerializedName("dienVien")
    private String dienVien;
    @SerializedName("ngayXuatBan")
    private Date ngayXuatBan;

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getDienVien() {
        return dienVien;
    }

    public void setDienVien(String dienVien) {
        this.dienVien = dienVien;
    }

    public Date getNgayXuatBan() {
        return ngayXuatBan;
    }

    public void setNgayXuatBan(Date ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    private Category theLoaiModel;



    public Category getTheLoaiModel() {
        return theLoaiModel;
    }
    public void setTheLoaiModel(Category theLoaiModel) {
        this.theLoaiModel = theLoaiModel;
    }
    public int getMaPhim() {
        return maPhim;
    }
    public void setMaPhim(int maPhim) {
        this.maPhim = maPhim;
    }
    public String getTenPhim() {
        return TenPhim;
    }
    public void setTenPhim(String tenPhim) {
        TenPhim = tenPhim;
    }
    public String getHinhAnh() {
        return HinhAnh;
    }
    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }
    public String getMoTa() {
        return MoTa;
    }
    public void setMoTa(String moTa) {
        MoTa = moTa;
    }
}

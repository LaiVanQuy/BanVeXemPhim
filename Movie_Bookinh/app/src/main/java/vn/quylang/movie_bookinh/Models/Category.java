package vn.quylang.movie_bookinh.Models;

import java.io.Serializable;

public class Category implements Serializable {

    private int maTheLoai;
    private String tenTheLoai;
    public int getMaTheLoai() {
        return maTheLoai;
    }
    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }
    public String getTenTheLoai() {
        return tenTheLoai;
    }
    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }
}

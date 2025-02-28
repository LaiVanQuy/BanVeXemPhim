package vn.quylang.movie_booking_admin.Model;

import java.io.Serializable;

public class Account implements Serializable {
    private String email;

    private String pass;

    private int rolee;

    private String ten;



    public Account() {
        super();
    }

    public Account(String email, String pass, int rolee, String ten) {
        super();
        this.email = email;
        this.pass = pass;
        this.rolee = rolee;
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRolee() {
        return rolee;
    }

    public void setRolee(int rolee) {
        this.rolee = rolee;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

}

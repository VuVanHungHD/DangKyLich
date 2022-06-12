/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hung
 */
public class lopHoc {

    private String maLop, tenLop, maGV, maMon;
    private int soLuongSV;

    public lopHoc() {
    }

    public lopHoc(String maLop, String tenLop, String maGV, String maMon, int soLuongSV) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.maGV = maGV;
        this.maMon = maMon;
        this.soLuongSV = soLuongSV;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public int getSoLuongSV() {
        return soLuongSV;
    }

    public void setSoLuongSV(int soLuongSV) {
        this.soLuongSV = soLuongSV;
    }

}

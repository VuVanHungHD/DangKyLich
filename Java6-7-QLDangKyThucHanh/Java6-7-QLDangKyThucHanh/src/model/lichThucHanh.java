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
public class lichThucHanh {

    private int maDK;
    private String nhom;
    private String maLop;
    private int tuan, thu;
    private String maPhong;
    private int ca;
    private static int sMaDK=0;

    public lichThucHanh() {
        this.maDK = sMaDK++;
    }

    public lichThucHanh(String nhom, String maLop, int tuan, int thu, String maPhong, int ca) {
        this.maDK = sMaDK++;
        this.nhom = nhom;
        this.maLop = maLop;
        this.tuan = tuan;
        this.thu = thu;
        this.maPhong = maPhong;
        this.ca = ca;
    }

    public int getMaDK() {
        return maDK;
    }

    public void setMaDK(int maDK) {
        this.maDK = maDK;
    }

    public String getNhom() {
        return nhom;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public int getTuan() {
        return tuan;
    }

    public void setTuan(int tuan) {
        this.tuan = tuan;
    }

    public int getThu() {
        return thu;
    }

    public void setThu(int thu) {
        this.thu = thu;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public static int getsMaDK() {
        return sMaDK;
    }

    public static void setsMaDK(int sMaDK) {
        lichThucHanh.sMaDK = sMaDK++;
    }
}

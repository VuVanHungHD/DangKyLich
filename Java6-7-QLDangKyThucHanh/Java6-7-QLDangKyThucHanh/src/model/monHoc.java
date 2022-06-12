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
public class monHoc {
    private String maMon, tenMon;
    private int soTC;

    public monHoc() {
    }

    public monHoc(String maMon, String tenMon, int soTC) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.soTC = soTC;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getSoTC() {
        return soTC;
    }

    public void setSoTC(int soTC) {
        this.soTC = soTC;
    }


    
}

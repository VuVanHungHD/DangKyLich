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
public class phongHoc {
    private String maPhong,tenPhong,HDH,Ram,CPU;
    private int soMay;

    public phongHoc() {
    }

    public phongHoc(String maPhong, String tenPhong, String HDH, String Ram, String CPU, int soMay) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.HDH = HDH;
        this.Ram = Ram;
        this.CPU = CPU;
        this.soMay = soMay;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getHDH() {
        return HDH;
    }

    public void setHDH(String HDH) {
        this.HDH = HDH;
    }

    public String getRam() {
        return Ram;
    }

    public void setRam(String Ram) {
        this.Ram = Ram;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public int getSoMay() {
        return soMay;
    }

    public void setSoMay(int soMay) {
        this.soMay = soMay;
    }
    
}

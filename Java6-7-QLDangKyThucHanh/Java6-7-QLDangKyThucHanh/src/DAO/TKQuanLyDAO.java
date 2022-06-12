/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.QuanLy;

/**
 *
 * @author hung
 */
public class TKQuanLyDAO {
    private static TKQuanLyDAO instance;
    QuanLy taiKhoan = new QuanLy();

    public TKQuanLyDAO() {
    }

    public static TKQuanLyDAO getInstance() {
        if (instance == null) {
            instance = new TKQuanLyDAO();
        }
        return instance;
    }

    public static void setInstance(TKQuanLyDAO instance) {
        TKQuanLyDAO.instance = instance;
    }

    public Boolean Login(String username, String password) {
        Connection con = ConnectDB.getConnectDB();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM QuanLy WHERE maAdmin = ? AND matKhau = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                taiKhoan.setMaAdmin(rs.getString(1));
                taiKhoan.setTenAdmin(rs.getString(2));
                taiKhoan.setMatKhau(rs.getString(3));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TKQuanLyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public QuanLy GetTaiKhoan() {
        return taiKhoan;
    }

    public List<QuanLy> listTaiKhoan() {
        List<QuanLy> list = new ArrayList<QuanLy>();
        Connection con = ConnectDB.getConnectDB();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM GV");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                QuanLy taiKhoan = new QuanLy(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(taiKhoan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TKQuanLyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

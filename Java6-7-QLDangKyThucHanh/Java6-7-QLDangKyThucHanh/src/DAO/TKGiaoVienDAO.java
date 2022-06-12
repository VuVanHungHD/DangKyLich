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
import model.GV;

/**
 *
 * @author hung
 */
public class TKGiaoVienDAO {
    private static TKGiaoVienDAO instance;
    GV taiKhoan = new GV();

    public TKGiaoVienDAO() {
    }

    public static TKGiaoVienDAO getInstance() {
        if (instance == null) {
            instance = new TKGiaoVienDAO();
        }
        return instance;
    }

    public static void setInstance(TKGiaoVienDAO instance) {
        TKGiaoVienDAO.instance = instance;
    }

    public Boolean Login(String username, String password) {
        Connection con = ConnectDB.getConnectDB();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM GV WHERE maGV = ? AND matKhau = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                taiKhoan.setMaGV(rs.getString(1));
                taiKhoan.setTenGV(rs.getString(2));
                taiKhoan.setMatKhau(rs.getString(3));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TKGiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public GV GetTaiKhoan() {
        return taiKhoan;
    }

    public List<GV> listTaiKhoan() {
        List<GV> list = new ArrayList<GV>();
        Connection con = ConnectDB.getConnectDB();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM GV");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                GV taiKhoan = new GV(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(taiKhoan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TKGiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

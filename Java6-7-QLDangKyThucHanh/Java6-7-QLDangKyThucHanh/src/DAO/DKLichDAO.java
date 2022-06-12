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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.lichThucHanh;

/**
 *
 * @author hung
 */
public class DKLichDAO {

    Connection con = ConnectDB.getConnectDB();
    private static DKLichDAO Instance;//khaii báo biến toàn cục

    public DKLichDAO() {
    }

    //khởi tạo liên kết nếu chưa tồn tại
    public static DKLichDAO getInstance() {
        if (Instance == null) {
            Instance = new DKLichDAO();
        }
        return Instance;
    }

    public List<lichThucHanh> GetListDKLich() {
        List<lichThucHanh> list = new ArrayList<lichThucHanh>();

        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM LICH_PHONG");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                lichThucHanh dk = new lichThucHanh( rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getInt(5),
                        rs.getString(6), rs.getInt(7));
                list.add(dk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DKLichDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

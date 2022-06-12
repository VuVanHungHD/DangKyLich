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
import model.phongHoc;

/**
 *
 * @author hung
 */
public class PhongDAO {
    Connection con= ConnectDB.getConnectDB();
    private static PhongDAO Instance;
    public PhongDAO() {
    }
    //khởi tạo liên kết nếu chưa tồn tại
    public static PhongDAO getInstance() {
        if (Instance == null) {
            Instance = new PhongDAO();
        }
        return Instance;
    }
    
    public  List<phongHoc> GetListPhong() {
        List<phongHoc> list = new ArrayList<phongHoc>();
        
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM PHONG");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                phongHoc phong = new phongHoc(rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5), rs.getInt(6));
                list.add(phong);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}

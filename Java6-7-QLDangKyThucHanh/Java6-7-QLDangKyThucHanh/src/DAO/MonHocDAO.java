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
import model.monHoc;

/**
 *
 * @author hung
 */
public class MonHocDAO {
    Connection con= ConnectDB.getConnectDB();
    private static MonHocDAO Instance;//khaii báo biến toàn cục
    public MonHocDAO() {
    }
    //khởi tạo liên kết nếu chưa tồn tại
    public static MonHocDAO getInstance() {
        if (Instance == null) {
            Instance = new MonHocDAO();
        }
        return Instance;
    }
    
    public  List<monHoc> GetListMon() {
        List<monHoc> list = new ArrayList<monHoc>();
        
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM MONHOC");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                monHoc mon = new monHoc(rs.getString(1), rs.getString(2),rs.getInt(3));
                list.add(mon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    
}

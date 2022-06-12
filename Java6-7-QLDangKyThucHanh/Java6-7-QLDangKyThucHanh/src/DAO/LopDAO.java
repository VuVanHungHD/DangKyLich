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
import model.lopHoc;

/**
 *
 * @author hung
 */
public class LopDAO{
    Connection con= ConnectDB.getConnectDB();
    private static LopDAO Instance;//khaii báo biến toàn cục
    public LopDAO() {
    }
    //khởi tạo liên kết với model lop 
    public static LopDAO getInstance() {
        if (Instance == null) {
            Instance = new LopDAO();
        }
        return Instance;
    }
    public  List<lopHoc> GetListLop() {
        List<lopHoc> list = new ArrayList<lopHoc>();
        
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM LOP");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                lopHoc lop = new lopHoc(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                list.add(lop);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
  
}

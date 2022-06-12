
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
public class GiaoVienDAO{
    Connection con= ConnectDB.getConnectDB();
    private static GiaoVienDAO Instance;//khaii báo biến toàn cục
    public GiaoVienDAO() {
    }
    //khởi tạo liên kết nếu chưa tồn tại
    public static GiaoVienDAO getInstance() {
        if (Instance == null) {
            Instance = new GiaoVienDAO();
        }
        return Instance;
    }
    
    public  List<GV> GetListGV() {
        List<GV> list = new ArrayList<GV>();
        
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM GV");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                GV gv = new GV(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(gv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiaoVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
  
    
}

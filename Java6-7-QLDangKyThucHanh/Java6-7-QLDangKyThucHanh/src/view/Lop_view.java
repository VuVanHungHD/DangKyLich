package view;

import DAO.ConnectDB;
import java.sql.Connection;
import java.util.List;
import model.lopHoc;
import DAO.LopDAO;
import controller.CustomTable_Lop;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Lop_view extends javax.swing.JFrame {

    //khoi tao lien ket
    LopDAO conn = new LopDAO();
    ArrayList<String> dsGV = new ArrayList<String>();
    ArrayList<String> dsMon = new ArrayList<String>();

    public Lop_view() {
        initComponents();
        loadTable();
//        load cbMon
        String sqlCBMon = "select * from MONHOC";
        dsMon = loadDataCB2(sqlCBMon, cbGV, "maMon");
        for (String mon : dsMon) {
            cbMonHoc.addItem(mon);
        }
        //load cb giao vien
        String sqlCBMGV = "select * from GV";
        dsGV = loadDataCB2(sqlCBMGV, this.cbGV, "maGV");
        for (String gv : dsGV) {
            cbGV.addItem(gv);
        }

    }

    public void loadTable() {
        List<lopHoc> list = LopDAO.getInstance().GetListLop();
        tblLop.setModel(new CustomTable_Lop((ArrayList<lopHoc>) list));
    }
    
    public ArrayList<String> loadDataCB2(String sql, JComboBox cb, String bien) {
        ArrayList<String> d = new ArrayList<String>();
        Connection con = ConnectDB.getConnectDB();
        try {
            PreparedStatement pts = con.prepareStatement(sql);
            ResultSet rs = pts.executeQuery();
            while (rs.next()) {
                d.add(rs.getString(bien));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public void loadCbTxt(String sql, JComboBox cb, JTextField lb, String bien) {
        Connection con = ConnectDB.getConnectDB();
        try {
            PreparedStatement ptsm = con.prepareStatement(sql);
            ptsm.setString(1, (String) cb.getSelectedItem());
            ResultSet rs = ptsm.executeQuery();
            lb.enable(false);
            while (rs.next()) {
                lb.setText(rs.getString(bien));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaLop = new javax.swing.JTextField();
        txtTenLop = new javax.swing.JTextField();
        txtSLSV = new javax.swing.JTextField();
        btlThem = new javax.swing.JButton();
        butSua = new javax.swing.JButton();
        butXoa = new javax.swing.JButton();
        jbtBack = new javax.swing.JButton();
        btXoaTrang = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbGV = new javax.swing.JComboBox<>();
        cbMonHoc = new javax.swing.JComboBox<>();
        txtTenGV = new javax.swing.JTextField();
        txtTenMon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLop = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã lớp");

        jLabel2.setText("Tên lớp");

        jLabel5.setText("Số lượng SV");

        txtMaLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaLopMouseClicked(evt);
            }
        });

        btlThem.setText("Thêm");
        btlThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlThemActionPerformed(evt);
            }
        });

        butSua.setText("Cập nhật");
        butSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSuaActionPerformed(evt);
            }
        });

        butXoa.setText("Xóa");
        butXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butXoaActionPerformed(evt);
            }
        });

        jbtBack.setText("Quay lại");
        jbtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBackActionPerformed(evt);
            }
        });

        btXoaTrang.setText("Xóa Trắng");
        btXoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaTrangActionPerformed(evt);
            }
        });

        jLabel3.setText("Mã giáo viên");

        jLabel4.setText("Mã môn");

        cbGV.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbGVPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbMonHoc.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbMonHocPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        txtTenGV.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtTenMon.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTenMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenMonActionPerformed(evt);
            }
        });

        jLabel6.setText("Tên giáo viên");

        jLabel8.setText("Tên môn học");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtBack)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(butXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btlThem, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(butSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btXoaTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbGV, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenGV, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSLSV)
                                    .addComponent(cbMonHoc, 0, 165, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jbtBack)
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbMonHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtSLSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btlThem)
                            .addComponent(butSua))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butXoa)
                            .addComponent(btXoaTrang)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblLop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblLop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLopMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLop);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outline_class_black_24dp.png"))); // NOI18N
        jLabel7.setText("Quản lý lớp học");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void butXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butXoaActionPerformed
        Connection con;
        PreparedStatement pstmt;
        int vt = tblLop.getSelectedRow();
        if (vt >= 0) {
            con = ConnectDB.getConnectDB();
            try {
                pstmt = con.prepareStatement("Delete from LOP where maLop='" + txtMaLop.getText() + "'");

                int i = pstmt.executeUpdate();
                if (i > 0) {
                    loadTable();
                    vt = -1;
                    txtMaLop.enable(true);
                    txtMaLop.setText("");
                    txtTenLop.setText("");
                    txtSLSV.setText("");
                    txtTenGV.setText("");
                    txtTenMon.setText("");
                    JOptionPane.showMessageDialog(null, "Xóa thành công!!");
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại!!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Lop_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chọn ô cần xóa!!");
        }
    }//GEN-LAST:event_butXoaActionPerformed

    private void jbtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBackActionPerformed
        new Home_view().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbtBackActionPerformed
    int vitri;
    private void tblLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLopMouseClicked
        int row = tblLop.getSelectedRow();
        vitri = evt.getClickCount();
        if (vitri >= 0) {
            txtMaLop.enable(false);
            txtMaLop.setText(tblLop.getValueAt(row, 0).toString());
            txtTenLop.setText(tblLop.getValueAt(row, 1).toString());
            String gv = tblLop.getValueAt(row, 2).toString();
            int idx = dsGV.indexOf(gv);
            String sql = "select * from GV where maGV=?";
            loadCbTxt(sql, this.cbGV, this.txtTenGV, "tenGV");
            cbGV.setSelectedIndex(idx);
            String mon = tblLop.getValueAt(row, 3).toString();
            int idxM = dsMon.indexOf(mon);
            String sql2 = "select * from MONHOC where maMon=?";
            loadCbTxt(sql2, this.cbMonHoc, this.txtTenMon, "tenMon");
            cbMonHoc.setSelectedIndex(idxM);
            txtSLSV.setText(tblLop.getValueAt(row, 4).toString());
        }
    }//GEN-LAST:event_tblLopMouseClicked

    private void btlThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlThemActionPerformed
        Connection con = ConnectDB.getConnectDB();
        int indexCbMon = cbMonHoc.getSelectedIndex();
        int indexCbGV = cbGV.getSelectedIndex();
        try {
            Statement stmt = con.createStatement();
            if (txtMaLop.getText().isEmpty() || txtTenLop.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Nhập đầy đủ thông tin");
            } else if (txtSLSV.getText().isEmpty()) {
                try {
                    Integer.parseInt(txtSLSV.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập kiểu số trong mục số lượng sinh viên!!");
                }
            } else {
                int i = stmt.executeUpdate("INSERT INTO LOP(maLop, tenLop,maGV,maMoN, soLuongSV) VALUES ('" + txtMaLop.getText() + "',N'"
                        + txtTenLop.getText() + "','" + cbGV.getItemAt(indexCbGV) + "','" + cbMonHoc.getItemAt(indexCbMon) + "','" + txtSLSV.getText() + "')");
                if (i > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm mới thành công!");
                    loadTable();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Lỗi!!");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Mã không được trùng");
        }
    }//GEN-LAST:event_btlThemActionPerformed

    private void butSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSuaActionPerformed
        int vt = tblLop.getSelectedRow();
        int indexCbMon = cbMonHoc.getSelectedIndex();
        int indexCbGV = cbGV.getSelectedIndex();
        if (vt >= 0) {
            Connection con = ConnectDB.getConnectDB();
            try {
                PreparedStatement pstmt = con.prepareStatement("update LOP set tenLop=?, maGV=?, maMon=?,soLuongSV=? where maLop='" + txtMaLop.getText() + "'");
                pstmt.setString(1, txtTenLop.getText());
                pstmt.setString(2, cbGV.getItemAt(indexCbGV));

                pstmt.setString(3, cbMonHoc.getItemAt(indexCbMon));
                loadTable();
                pstmt.setInt(4, Integer.parseInt(txtSLSV.getText()));
                int i = pstmt.executeUpdate();
                if (i > 0) {
                    loadTable();
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                } else {
                    JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Lop_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chọn ô cần sửa");
        }
    }//GEN-LAST:event_butSuaActionPerformed

    private void btXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaTrangActionPerformed
        txtMaLop.enable(true);
        txtMaLop.setText("");
        txtTenLop.setText("");
        txtSLSV.setText("");
        txtTenGV.setText("");
        txtTenMon.setText("");
    }//GEN-LAST:event_btXoaTrangActionPerformed

    private void txtMaLopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaLopMouseClicked
        txtMaLop.enable(true);
    }//GEN-LAST:event_txtMaLopMouseClicked

    private void txtTenMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenMonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenMonActionPerformed

    private void cbGVPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbGVPopupMenuWillBecomeInvisible
        String sql = "select * from GV where maGV=?";
        loadCbTxt(sql, this.cbGV, this.txtTenGV, "tenGV");
    }//GEN-LAST:event_cbGVPopupMenuWillBecomeInvisible

    private void cbMonHocPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbMonHocPopupMenuWillBecomeInvisible
        String sql = "select * from MONHOC where maMon=?";
        loadCbTxt(sql, this.cbMonHoc, this.txtTenMon, "tenMon");
    }//GEN-LAST:event_cbMonHocPopupMenuWillBecomeInvisible

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lop_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lop_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lop_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lop_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lop_view().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btXoaTrang;
    private javax.swing.JButton btlThem;
    private javax.swing.JButton butSua;
    private javax.swing.JButton butXoa;
    private javax.swing.JComboBox<String> cbGV;
    private javax.swing.JComboBox<String> cbMonHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtBack;
    private javax.swing.JTable tblLop;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtSLSV;
    private javax.swing.JTextField txtTenGV;
    private javax.swing.JTextField txtTenLop;
    private javax.swing.JTextField txtTenMon;
    // End of variables declaration//GEN-END:variables
}
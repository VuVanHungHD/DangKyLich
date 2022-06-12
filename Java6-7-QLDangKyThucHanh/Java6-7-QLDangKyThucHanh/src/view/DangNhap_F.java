
package view;

import DAO.*;
import DAO.TKGiaoVienDAO;

public class DangNhap_F extends javax.swing.JFrame {

    public DangNhap_F() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        butDangNhap = new javax.swing.JButton();
        txtMaGV = new javax.swing.JTextField();
        cbLoaiTK = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtPassW = new javax.swing.JPasswordField();
        lbThongBao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tên đăng nhập");

        jLabel2.setText("Mật khẩu");

        jLabel3.setText("Loại tài khoản");

        butDangNhap.setText("Đăng nhập");
        butDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDangNhapActionPerformed(evt);
            }
        });

        cbLoaiTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giáo viên", "Quản trị viên" }));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outline_people_black_24dp.png"))); // NOI18N

        lbThongBao.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbThongBao.setForeground(new java.awt.Color(255, 51, 0));
        lbThongBao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outline_error_black_24dp.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbLoaiTK, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaGV, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtPassW)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(butDangNhap))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbLoaiTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(lbThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(butDangNhap)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void XacNhanGV_Login() {
        int indexCbLoaiTK = cbLoaiTK.getSelectedIndex();
        if (txtMaGV.getText().isEmpty()) {
            lbThongBao.setText("Bạn chưa nhập tài khoản");
            return;
        }
        if (txtPassW.getText().isEmpty()) {
            lbThongBao.setText("Vui lòng nhập mật khẩu");
            return;
        }
        
        if (!TKGiaoVienDAO.getInstance().Login(txtMaGV.getText(), txtPassW.getText())) {
            lbThongBao.setText("Sai tên đăng nhập hoặc mật khẩu");
            return;
        }
        if (indexCbLoaiTK == 0) {
            new Home_GiaoVien().setVisible(true);
            dispose();
        }

    }

    private void XacNhanAD_Login() {
        int indexCbLoaiTK = cbLoaiTK.getSelectedIndex();
        if (txtMaGV.getText().isEmpty()) {
            lbThongBao.setText("Bạn chưa nhập tài khoản");
            return;
        }
        if (txtPassW.getText().isEmpty()) {
            lbThongBao.setText("Vui lòng nhập mật khẩu");
            return;
        }
        
        if (!TKQuanLyDAO.getInstance().Login(txtMaGV.getText(), txtPassW.getText())) {
            lbThongBao.setText("Sai tên đăng nhập hoặc mật khẩu");
            return;
        }
        
        if(indexCbLoaiTK ==1){
            Home_view home_Ad= new Home_view();
            home_Ad.setVisible(true);
            dispose();
        }
        
    }
    
    private void butDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDangNhapActionPerformed

        XacNhanGV_Login();
        XacNhanAD_Login();
        
    }//GEN-LAST:event_butDangNhapActionPerformed

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
            java.util.logging.Logger.getLogger(DangNhap_F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap_F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap_F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap_F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap_F().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butDangNhap;
    private javax.swing.JComboBox<String> cbLoaiTK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JTextField txtMaGV;
    private javax.swing.JPasswordField txtPassW;
    // End of variables declaration//GEN-END:variables
}
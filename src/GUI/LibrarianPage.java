/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import login.CurrentUser;

/**
 *
 * @author User
 */
public class LibrarianPage extends javax.swing.JFrame {
        QLSach qls = new QLSach();
        QLNXB qlxb = new QLNXB();
        QLMuon qlm = new QLMuon();
        QLTra qlt = new QLTra();
        QLPhat qlp = new QLPhat();
        ThongTinTK tttk = new ThongTinTK();
        BaoCaoTK bc = new BaoCaoTK();
        DSDKMuonSach dsdk = new DSDKMuonSach(qlm);
        
        

    /**
     * Creates new form LibrarianPage
     */
    public LibrarianPage() {
        initComponents();
        btnLogOut.setFocusPainted(false);
        LibrarianMain.add(qls);
        LibrarianMain.add(qlxb);
        LibrarianMain.add(qlm);
        LibrarianMain.add(qlt);
        LibrarianMain.add(qlp);
        LibrarianMain.add(tttk);
        tttk.setVisible(false);
       
        LibrarianMain.add(bc);
        LibrarianMain.add(dsdk);
        qls.setVisible(false);
        qlxb.setVisible(false);
        qlm.setVisible(false);
        qlt.setVisible(false);
        qlp.setVisible(false);
        bc.setVisible(false);
        dsdk.setVisible(false);
        String MaTT = CurrentUser.getInstance().getMaND(); 
        jLabel2.setText(MaTT);
    }
    
    
    public void setColor(JPanel jpanel) {
        Color color = new Color(51,102,0);
        jpanel.setBackground(color);
    }
    public void resetColor(JPanel jpanel) {
        Color recolor = new Color (51,153,0);
        jpanel.setBackground(recolor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnQLSach = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnQLNXB = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnDSPhieuTra = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        btnDSPhieuMuon = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnDSDangKy = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnThongTinTK = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btnDSPhieuPhat = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btnThongKe = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        LibrarianMain = new javax.swing.JLayeredPane();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 14, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Thủ thư");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        btnQLSach.setBackground(new java.awt.Color(51, 153, 0));
        btnQLSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQLSachMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book.png"))); // NOI18N
        jLabel3.setText("Quản lý sách");

        javax.swing.GroupLayout btnQLSachLayout = new javax.swing.GroupLayout(btnQLSach);
        btnQLSach.setLayout(btnQLSachLayout);
        btnQLSachLayout.setHorizontalGroup(
            btnQLSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnQLSachLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        btnQLSachLayout.setVerticalGroup(
            btnQLSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(btnQLSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 115, -1, 40));

        btnQLNXB.setBackground(new java.awt.Color(51, 153, 0));
        btnQLNXB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQLNXBMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-microsoft-publisher-32.png"))); // NOI18N
        jLabel4.setText("Nhà xuất bản");

        javax.swing.GroupLayout btnQLNXBLayout = new javax.swing.GroupLayout(btnQLNXB);
        btnQLNXB.setLayout(btnQLNXBLayout);
        btnQLNXBLayout.setHorizontalGroup(
            btnQLNXBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnQLNXBLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        btnQLNXBLayout.setVerticalGroup(
            btnQLNXBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(btnQLNXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 154, -1, 40));

        btnDSPhieuTra.setBackground(new java.awt.Color(51, 153, 0));
        btnDSPhieuTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDSPhieuTraMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png"))); // NOI18N
        jLabel13.setText("Quản lý trả sách");

        javax.swing.GroupLayout btnDSPhieuTraLayout = new javax.swing.GroupLayout(btnDSPhieuTra);
        btnDSPhieuTra.setLayout(btnDSPhieuTraLayout);
        btnDSPhieuTraLayout.setHorizontalGroup(
            btnDSPhieuTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDSPhieuTraLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel13)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        btnDSPhieuTraLayout.setVerticalGroup(
            btnDSPhieuTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(btnDSPhieuTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 210, 40));

        btnLogOut.setBackground(new java.awt.Color(51, 153, 0));
        btnLogOut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/log-out.png"))); // NOI18N
        btnLogOut.setText("Đăng xuất");
        btnLogOut.setBorderPainted(false);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));

        btnDSPhieuMuon.setBackground(new java.awt.Color(51, 153, 0));
        btnDSPhieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDSPhieuMuonMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrow.png"))); // NOI18N
        jLabel12.setText("Quản lý mượn sách");

        javax.swing.GroupLayout btnDSPhieuMuonLayout = new javax.swing.GroupLayout(btnDSPhieuMuon);
        btnDSPhieuMuon.setLayout(btnDSPhieuMuonLayout);
        btnDSPhieuMuonLayout.setHorizontalGroup(
            btnDSPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDSPhieuMuonLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel12)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        btnDSPhieuMuonLayout.setVerticalGroup(
            btnDSPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(btnDSPhieuMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 210, 40));

        btnDSDangKy.setBackground(new java.awt.Color(51, 153, 0));
        btnDSDangKy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDSDangKyMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/request.png"))); // NOI18N
        jLabel11.setText("DS đăng kí mượn sách");

        javax.swing.GroupLayout btnDSDangKyLayout = new javax.swing.GroupLayout(btnDSDangKy);
        btnDSDangKy.setLayout(btnDSDangKyLayout);
        btnDSDangKyLayout.setHorizontalGroup(
            btnDSDangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDSDangKyLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        btnDSDangKyLayout.setVerticalGroup(
            btnDSDangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDSDangKyLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11))
        );

        jPanel1.add(btnDSDangKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 210, 40));
        btnDSDangKy.getAccessibleContext().setAccessibleName("");

        btnThongTinTK.setBackground(new java.awt.Color(51, 153, 0));
        btnThongTinTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThongTinTKMouseClicked(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user (2).png"))); // NOI18N
        jLabel18.setText("Thông tin người dùng");

        javax.swing.GroupLayout btnThongTinTKLayout = new javax.swing.GroupLayout(btnThongTinTK);
        btnThongTinTK.setLayout(btnThongTinTKLayout);
        btnThongTinTKLayout.setHorizontalGroup(
            btnThongTinTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThongTinTKLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel18)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        btnThongTinTKLayout.setVerticalGroup(
            btnThongTinTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(btnThongTinTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, -1, 40));

        btnDSPhieuPhat.setBackground(new java.awt.Color(51, 153, 0));
        btnDSPhieuPhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDSPhieuPhatMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/administrative-fine.png"))); // NOI18N
        jLabel14.setText("Quản lý phiếu phạt");

        javax.swing.GroupLayout btnDSPhieuPhatLayout = new javax.swing.GroupLayout(btnDSPhieuPhat);
        btnDSPhieuPhat.setLayout(btnDSPhieuPhatLayout);
        btnDSPhieuPhatLayout.setHorizontalGroup(
            btnDSPhieuPhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDSPhieuPhatLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel14)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        btnDSPhieuPhatLayout.setVerticalGroup(
            btnDSPhieuPhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(btnDSPhieuPhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 210, 40));

        btnThongKe.setBackground(new java.awt.Color(51, 153, 0));
        btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThongKeMouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/analytics.png"))); // NOI18N
        jLabel15.setText("Thống kê");

        javax.swing.GroupLayout btnThongKeLayout = new javax.swing.GroupLayout(btnThongKe);
        btnThongKe.setLayout(btnThongKeLayout);
        btnThongKeLayout.setHorizontalGroup(
            btnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThongKeLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel15)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        btnThongKeLayout.setVerticalGroup(
            btnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(btnThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 210, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 550));

        LibrarianMain.setLayout(new java.awt.CardLayout());
        getContentPane().add(LibrarianMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 830, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?", "Đăng xuất", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            this.dispose();
            LoginForm login = new LoginForm();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        }

    }//GEN-LAST:event_btnLogOutActionPerformed
    
    private void btnQLSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQLSachMouseClicked

        setColor(btnQLSach);
        resetColor(btnQLNXB);
        resetColor(btnDSPhieuMuon);
        resetColor(btnDSPhieuTra);
        resetColor(btnDSPhieuPhat);
        resetColor(btnThongKe);
        resetColor(btnThongTinTK);
        resetColor(btnDSDangKy);
        qls.setVisible(true);
        qlxb.setVisible(false);
        qlm.setVisible(false);
        qlt.setVisible(false);
        qlp.setVisible(false);
        tttk.setVisible(false);
        bc.setVisible(false);
        dsdk.setVisible(false);
        
        
    }//GEN-LAST:event_btnQLSachMouseClicked

    private void btnDSPhieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDSPhieuMuonMouseClicked
      
        setColor(btnDSPhieuMuon);
        resetColor(btnQLSach);
        resetColor(btnQLNXB);
        resetColor(btnDSPhieuTra);
        resetColor(btnDSPhieuPhat);
        resetColor(btnThongKe);
        resetColor(btnThongTinTK);
        resetColor(btnDSDangKy);
        qls.setVisible(false);
        qlxb.setVisible(false);
        qlm.setVisible(true);
        qlt.setVisible(false);
        qlp.setVisible(false);
        tttk.setVisible(false);
        bc.setVisible(false);
        dsdk.setVisible(false);
    }//GEN-LAST:event_btnDSPhieuMuonMouseClicked

    private void btnDSPhieuTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDSPhieuTraMouseClicked
       
        setColor(btnDSPhieuTra);
        resetColor(btnQLNXB);
        resetColor(btnDSPhieuMuon);
        resetColor(btnQLSach);
        resetColor(btnDSPhieuPhat);
        resetColor(btnThongKe);
        resetColor(btnThongTinTK);
        resetColor(btnDSDangKy);
        qls.setVisible(false);
        qlxb.setVisible(false);
        qlm.setVisible(false);
        qlt.setVisible(true);
        qlp.setVisible(false);
        tttk.setVisible(false);
        bc.setVisible(false);
        dsdk.setVisible(false);
        
    }//GEN-LAST:event_btnDSPhieuTraMouseClicked

    private void btnDSDangKyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDSDangKyMouseClicked
        
        setColor(btnDSDangKy);
        resetColor(btnQLNXB);
        resetColor(btnDSPhieuMuon);
        resetColor(btnDSPhieuTra);
        resetColor(btnDSPhieuPhat);
        resetColor(btnThongKe);
        resetColor(btnQLSach);
        resetColor(btnThongTinTK);
        qls.setVisible(false);
        qlxb.setVisible(false);
        qlm.setVisible(false);
        qlt.setVisible(false);
        qlp.setVisible(false);
        tttk.setVisible(false);
        bc.setVisible(false);
        dsdk.setVisible(true);
    }//GEN-LAST:event_btnDSDangKyMouseClicked

    private void btnQLNXBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQLNXBMouseClicked
        
        setColor(btnQLNXB);
        resetColor(btnQLSach);
        resetColor(btnDSPhieuMuon);
        resetColor(btnDSPhieuTra);
        resetColor(btnDSPhieuPhat);
        resetColor(btnThongKe);
        resetColor(btnThongTinTK);
        resetColor(btnDSDangKy);
        qls.setVisible(false);
        qlxb.setVisible(true);
        qlm.setVisible(false);
        qlt.setVisible(false);
        qlp.setVisible(false);
        tttk.setVisible(false);
        bc.setVisible(false);
        dsdk.setVisible(false);
    }//GEN-LAST:event_btnQLNXBMouseClicked

    private void btnThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseClicked
       
        setColor(btnThongKe);
        resetColor(btnQLNXB);
        resetColor(btnDSPhieuMuon);
        resetColor(btnDSPhieuTra);
        resetColor(btnDSPhieuPhat);
        resetColor(btnQLSach);
        resetColor(btnThongTinTK);
        resetColor(btnDSDangKy);
        qls.setVisible(false);
        qlxb.setVisible(false);
        qlm.setVisible(false);
        qlt.setVisible(false);
        qlp.setVisible(false);
        tttk.setVisible(false);
        bc.setVisible(true);
        dsdk.setVisible(false);
    }//GEN-LAST:event_btnThongKeMouseClicked

    private void btnDSPhieuPhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDSPhieuPhatMouseClicked
       
        setColor(btnDSPhieuPhat);
        resetColor(btnQLNXB);
        resetColor(btnDSPhieuMuon);
        resetColor(btnDSPhieuTra);
        resetColor(btnQLSach);
        resetColor(btnThongKe);
        resetColor(btnThongTinTK);
        resetColor(btnDSDangKy);
        qls.setVisible(false);
        qlxb.setVisible(false);
        qlm.setVisible(false);
        qlt.setVisible(false);
        qlp.setVisible(true);
        tttk.setVisible(false);
        bc.setVisible(false);
        dsdk.setVisible(false);

    }//GEN-LAST:event_btnDSPhieuPhatMouseClicked

    private void btnThongTinTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongTinTKMouseClicked
        
        setColor(btnThongTinTK);
        resetColor(btnQLNXB);
        resetColor(btnDSPhieuMuon);
        resetColor(btnDSPhieuTra);
        resetColor(btnQLSach);
        resetColor(btnThongKe);
        resetColor(btnDSDangKy);
        qls.setVisible(false);
        qlxb.setVisible(false);
        qlm.setVisible(false);
        qlt.setVisible(false);
        qlp.setVisible(false);
        tttk.setVisible(true);
        bc.setVisible(false);
        dsdk.setVisible(false);
    }//GEN-LAST:event_btnThongTinTKMouseClicked

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
            java.util.logging.Logger.getLogger(LibrarianPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibrarianPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibrarianPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibrarianPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibrarianPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane LibrarianMain;
    private javax.swing.JPanel btnDSDangKy;
    private javax.swing.JPanel btnDSPhieuMuon;
    private javax.swing.JPanel btnDSPhieuPhat;
    private javax.swing.JPanel btnDSPhieuTra;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JPanel btnQLNXB;
    private javax.swing.JPanel btnQLSach;
    private javax.swing.JPanel btnThongKe;
    private javax.swing.JPanel btnThongTinTK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

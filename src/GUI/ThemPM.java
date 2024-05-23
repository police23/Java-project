/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BookBUS;
import BUS.PhieuMuonBUS;
import DAO.BookDAO;
import DAO.PhieuMuonDAO;
import DTO.Book;
import DTO.PhieuMuon;
import JDBCConnection.JDBCConnection;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import login.CurrentUser;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

/**
 *
 * @author User
 */
public class ThemPM extends javax.swing.JFrame {
     DefaultTableModel dtm;
     Connection conn;
     JDBCConnection cn = new JDBCConnection();
     PreparedStatement pst;
     ResultSet rs;
     QLMuon qlpm;
     PhieuMuonBUS PhieuMuonBUS;
     PhieuMuon pm;
    /**
     * Creates new form ThemPM
     */
    public ThemPM(QLMuon qlpm) {
        initComponents();
        LoadMaDG();
        LoadSach();
        CurrentUser currentUser = CurrentUser.getInstance();
        String maND = currentUser.getMaND();
        txtMaTT.setText(maND);
        txtMaTT.setEditable(false);
        Text_HoTenDG.setEditable(false);
        pm = new PhieuMuon();
        PhieuMuonBUS = new PhieuMuonBUS();
        this.qlpm = qlpm;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 14);
        Date_HanTra.setDate(c.getTime());
        ComboBox_MaDG.addItemListener(new ItemListener() {
            public void itemStateChanged (ItemEvent ie) {
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    String MaDG = ComboBox_MaDG.getSelectedItem().toString();
                    String HoTenDG = getHoTenDG(MaDG);
                    Text_HoTenDG.setText(HoTenDG);
                }
            }
        });
    }
    private void LoadMaDG() {
        conn = cn.getJDBCConnection();
        if (conn != null) {
                String sql = "SELECT MADOCGIA FROM DOCGIA " +
                             "WHERE MADOCGIA NOT IN (" +
                                "SELECT MADOCGIA FROM PHIEUMUON PM " +
                                "JOIN CTPHIEUMUON CT ON PM.MAPHIEUMUON = CT.MAPHIEUMUON " +
                                "WHERE TRANGTHAI = 0" +
                                ") AND MADOCGIA NOT IN (" +
                                    "SELECT MADOCGIA FROM DANGKYMUONSACH" +
                            ")";
                try {
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    ComboBox_MaDG.removeAllItems();
                    ComboBox_MaDG.addItem("--Chọn độc giả--");
                    while (rs.next()) {
                        String maDG = rs.getString("MADOCGIA");
                        ComboBox_MaDG.addItem(maDG);
                    }
                    rs.close();
                    pst.close();
                }
             catch (SQLException e) {
                e.printStackTrace();
            }
            }
    }
   
    private String getHoTenDG (String maDG) {
        String HoTenDG = "";
        try {
            String sql = "SELECT HOTEN FROM DOCGIA WHERE MADOCGIA = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1,maDG);
            rs = pst.executeQuery();
            if (rs.next()) {
                HoTenDG = rs.getString("HOTEN");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return HoTenDG;
    }
    private void LoadSach() {
        List<Book> books = new BookDAO().getBooksAvailable();
        ComboBox_Sach.removeAllItems();
        for (Book book : books) {
        ComboBox_Sach.addItem(book.getMaSach());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboBox_MaDG = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Date_HanTra = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        ComboBox_Sach = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableDSSachMuon = new javax.swing.JTable();
        btnThemSach = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        Text_HoTenDG = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMaTT = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TẠO PHIẾU MƯỢN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã độc giả :");

        ComboBox_MaDG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Họ tên độc giả :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Hạn trả sách :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Sách mượn :");

        ComboBox_Sach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setText("Danh sách sách mượn :");

        tableDSSachMuon.setAutoCreateRowSorter(true);
        tableDSSachMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách"
            }
        ));
        jScrollPane6.setViewportView(tableDSSachMuon);

        btnThemSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-book-16.png"))); // NOI18N
        btnThemSach.setText("Thêm");
        btnThemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSachActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove (1).png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cancel-24.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-ok-24.png"))); // NOI18N
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Người lập phiếu : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel7))
                                    .addGap(31, 31, 31)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ComboBox_MaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Date_HanTra, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                        .addComponent(ComboBox_Sach, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Text_HoTenDG)
                                        .addComponent(txtMaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnXoa))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(385, 385, 385))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35))))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboBox_MaDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Text_HoTenDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Date_HanTra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ComboBox_Sach)
                    .addComponent(btnThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnXoa)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        String noti = "";
        Date today = new Date();
        if (ComboBox_MaDG.getSelectedIndex() == 0) {
            noti += "Chưa chọn độc giả\n";
        }
        if (Date_HanTra.getDate() == null) {
            noti += "Chưa chọn ngày trả sách\n";
        }
        else if (Date_HanTra.getDate().before(today)) {
            noti += "Ngày trả sách phải là ngày ở tương lai\n";
        }
       
        
        if (!noti.isEmpty()) {
            JOptionPane.showMessageDialog(null,noti);
        }
        else {
            int rowCount = tableDSSachMuon.getRowCount();
            String[] maSachArray = new String[rowCount];
            for (int i = 0; i < rowCount; i++) {
                maSachArray[i] = tableDSSachMuon.getValueAt(i, 0).toString();
            }
            pm.setMaTT(txtMaTT.getText()); 
            pm.setMaDG(ComboBox_MaDG.getSelectedItem().toString()); 
            pm.setNgayLap(new java.sql.Date(today.getTime())); 
            pm.setHanTra(new java.sql.Date(Date_HanTra.getDate().getTime()));
            PhieuMuonDAO pmDAO = new PhieuMuonDAO();
            pmDAO.addPhieuMuon(pm, maSachArray);
            System.out.println(pm.getMaTT());
            JOptionPane.showMessageDialog(null,"Thêm phiếu mượn thành công");
            qlpm.updateTable();
            this.dispose();
            
        }
            
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSachActionPerformed
        String sach = ComboBox_Sach.getSelectedItem().toString();
        Book bk = new BookBUS().getBookByMaSach(sach);
        DefaultTableModel dtm = (DefaultTableModel) tableDSSachMuon.getModel();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            if (dtm.getValueAt(i,0).equals(bk.getMaSach())) {
                JOptionPane.showMessageDialog(null,"Sách đã tồn tại trong danh sách ");
                return;
            }
        }
        if (dtm.getRowCount() > 2) {
            JOptionPane.showMessageDialog(null,"Chỉ được mượn tối đa 3 quyển sách");
            return;
        }
        dtm.addRow(new Object [] {bk.getMaSach(), bk.getTenSach()});
    }//GEN-LAST:event_btnThemSachActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int selected = tableDSSachMuon.getSelectedRow();
        if (selected != -1) {
            DefaultTableModel dtm = (DefaultTableModel) tableDSSachMuon.getModel();
            dtm.removeRow(selected);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(ThemPM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemPM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemPM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemPM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_MaDG;
    private javax.swing.JComboBox<String> ComboBox_Sach;
    private com.toedter.calendar.JDateChooser Date_HanTra;
    private javax.swing.JTextField Text_HoTenDG;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnThemSach;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableDSSachMuon;
    private javax.swing.JTextField txtMaTT;
    // End of variables declaration//GEN-END:variables
}
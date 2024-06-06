/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BookBUS;
import DTO.Book;
import JDBCConnection.JDBCConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ThemSach extends javax.swing.JFrame {
    BookBUS BookBUS;
    Book book;
    JDBCConnection cn = new JDBCConnection();
    Connection conn;
    QLSach qls;
    
    
    /**
     * Creates new form ThemSach
     */
    public ThemSach(QLSach qls) {
        initComponents();
        BookBUS = new BookBUS();
        book = new Book();
        LoadTheLoai();
        LoadNhaXB();
        LoadNamXB();
        this.qls = qls;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void LoadTheLoai() {
        conn = cn.getJDBCConnection();
    if (conn != null) {
        String sql = "SELECT * FROM THELOAI";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ComboBox_TheLoai.removeAllItems();
            ComboBox_TheLoai.addItem("--Chọn thể loại--");
            while (rs.next()) {
                ComboBox_TheLoai.addItem(rs.getString("TENTHELOAI"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } else {
        System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
    }
}
    public void LoadNhaXB() {
        conn = cn.getJDBCConnection();
    if (conn != null) {
        String sql = "SELECT * FROM NHAXUATBAN";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ComboBox_NXB.removeAllItems();
            ComboBox_NXB.addItem("--Chọn nhà xuất bản--");
            while (rs.next()) {
                ComboBox_NXB.addItem(rs.getString("TENNXB"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } else {
        System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
    }
    }
    public void LoadNamXB() {
        ComboBox_NamXB.removeAllItems();
        ComboBox_NamXB.addItem("--Chọn năm XB--");

    
    for (int year = 2018; year <= 2024; year++) {
        ComboBox_NamXB.addItem(String.valueOf(year));
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtTacGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ComboBox_TheLoai = new javax.swing.JComboBox<>();
        ComboBox_NXB = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSoTrang = new javax.swing.JTextField();
        spinSoLuong = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ComboBox_NamXB = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextPane();
        jLabel13 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel11.setText("jLabel11");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnOK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-ok-24.png"))); // NOI18N
        btnOK.setText("Thêm");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnHuy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-cancel-24.png"))); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã sách");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên sách");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tác giả");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Thể loại");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nhà xuất bản");

        ComboBox_TheLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBox_TheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_TheLoaiActionPerformed(evt);
            }
        });

        ComboBox_NXB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Năm XB ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Mô tả : ");

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-reset-24.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Số lượng");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Giá");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Số trang");

        jPanel2.setBackground(new java.awt.Color(0, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("THÊM SÁCH MỚI ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(245, 245, 245)
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

        ComboBox_NamXB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jScrollPane3.setViewportView(txtMoTa);

        jLabel13.setText("VNĐ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btnOK)
                        .addGap(85, 85, 85)
                        .addComponent(btnReset)
                        .addGap(77, 77, 77)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel9)
                                            .addComponent(spinSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addGap(248, 248, 248))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTacGia)
                                        .addGap(117, 117, 117)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboBox_NamXB, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(117, 117, 117)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(ComboBox_TheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboBox_NXB, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(108, 108, 108))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)))
                .addGap(0, 130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(ComboBox_TheLoai))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(ComboBox_NXB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox_NamXB, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtMaSach.setText("");
        txtTenSach.setText("");
        txtTacGia.setText("");
        ComboBox_NamXB.setSelectedIndex(0);
        spinSoLuong.setValue(0);
        txtSoTrang.setText("");
        txtGia.setText("");
        txtMoTa.setText("");
        ComboBox_TheLoai.setSelectedIndex(0);
        ComboBox_NXB.setSelectedIndex(0);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        String noti = "";
        if (txtMaSach.getText().equals("")) {
            noti += "Chưa nhập mã sách\n";
        }
        if (txtTenSach.getText().equals("")) {
            noti += "Chưa nhập tên sách\n";
        }
        else if (!Pattern.matches("[\\p{L} ]+", txtTenSach.getText())) {
            noti += "Tên sách chỉ được chứa các ký tự chữ cái\n";
        }
       
        if (txtTacGia.getText().equals("")) {
            noti += "Chưa nhập tác giả\n";
        }
        else if (!Pattern.matches("[\\p{L} ]+", txtTacGia.getText())) {
            noti += "Tên tác giả chỉ được chứa các ký tự chữ cái\n";
        }
        if ((int)spinSoLuong.getValue() <= 0) {
            noti += "Số lượng sách phải lớn hơn 0\n";
        }
        if (ComboBox_TheLoai.getSelectedIndex() == 0) {
            noti += "Chưa chọn thể loại\n";
        }
        if (ComboBox_NXB.getSelectedIndex() == 0) {
            noti += "Chưa chọn nhà xuất bản\n";
        }
        if (txtSoTrang.getText().isEmpty()) {
        noti += "Chưa nhập số trang\n";
        }
        else {
        try {
            int soTrang = Integer.parseInt(txtSoTrang.getText());
            if (soTrang <= 0) {
                noti += "Số trang phải là số nguyên lớn hơn 0\n";
            }
        }
            catch (NumberFormatException e) {
            noti += "Số trang phải là số nguyên\n";
        }
    }
        if (txtGia.getText().isEmpty()) {
        noti += "Chưa nhập giá sách\n";
        }
        else {
        try {
            int gia = Integer.parseInt(txtGia.getText());
            if (gia <= 0) {
                noti += "Giá sách phải là số nguyên dương\n";
            }
        } catch (NumberFormatException e) {
            noti += "Giá sách phải là số nguyên dương\n";
        }
    }
        if (ComboBox_TheLoai.getSelectedIndex() == 0) {
        noti += "Chưa chọn thể loại sách\n";
    }
        if (ComboBox_NXB.getSelectedIndex() == 0) {
        noti += "Chưa chọn nhà xuất bản\n";
        }
        if (!noti.isEmpty()) {
        
        JOptionPane.showMessageDialog(this, noti, "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        else {
            String maSach = txtMaSach.getText();
            boolean idExists = BookBUS.checkBookIdExists(maSach);
    
        if (idExists) {
        JOptionPane.showMessageDialog(this, "Mã sách đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;}
        else {
            String tenTheLoai = ComboBox_TheLoai.getSelectedItem().toString();
            String tenNXB = ComboBox_NXB.getSelectedItem().toString();
            String maTheLoai = BookBUS.getMaTheLoaiByTen(tenTheLoai);
            String maNXB = BookBUS.getMaNXBByTen(tenNXB);
            book.setMaSach(txtMaSach.getText());
            book.setTenSach(txtTenSach.getText());
            book.setTacGia(txtTacGia.getText());
            book.setSoLuong((int) spinSoLuong.getValue());
            int soTrang = Integer.parseInt(txtSoTrang.getText()); // Chuyển đổi chuỗi văn bản sang kiểu int
            book.setSoTrang(soTrang);
            int NamXB = Integer.parseInt(ComboBox_NamXB.getSelectedItem().toString());
            book.setNamXB(NamXB);
            book.setGia(Integer.parseInt(txtGia.getText()));
            book.setMoTa(txtMoTa.getText());
            book.setMaTheLoai(maTheLoai);
            book.setMaNXB(maNXB);
            BookBUS.addBook(book);
            JOptionPane.showMessageDialog(this, "Thêm sách thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            qls.updateTable();
    }
         this.dispose(); 
        }

            
    }//GEN-LAST:event_btnOKActionPerformed

    private void ComboBox_TheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_TheLoaiActionPerformed
        
    }//GEN-LAST:event_ComboBox_TheLoaiActionPerformed

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
            java.util.logging.Logger.getLogger(ThemSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QLSach qls = new QLSach();
                new ThemSach(qls).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_NXB;
    private javax.swing.JComboBox<String> ComboBox_NamXB;
    private javax.swing.JComboBox<String> ComboBox_TheLoai;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JSpinner spinSoLuong;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextPane txtMoTa;
    private javax.swing.JTextField txtSoTrang;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}

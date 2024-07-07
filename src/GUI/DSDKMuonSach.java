/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.DKMuonBUS;
import DTO.Book;
import DTO.DKMuon;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import login.CurrentUser;
/**
 *
 * @author User
 */
public class DSDKMuonSach extends javax.swing.JPanel {
     DKMuonBUS DKMuonBUS;
     DefaultTableModel dtmDSDK;
     DefaultTableModel dtmCTDK;
     QLMuon qlpm;
    

    /**
     * Creates new form DSDKMuonSach
     */
    public DSDKMuonSach(QLMuon qlpm) {
        initComponents();
        DKMuonBUS = new DKMuonBUS();
        dtmDSDK = new DefaultTableModel();
        dtmCTDK = new DefaultTableModel();
        this.qlpm = qlpm;
        tableDSDK.setModel(dtmDSDK);
        tableCTDK.setModel(dtmCTDK);
        tableCTDK.setRowHeight(25);
        dtmDSDK.addColumn("Mã đăng ký");
        dtmDSDK.addColumn("Độc giả đăng ký");
        dtmDSDK.addColumn("Ngày đăng ký");
        dtmCTDK.addColumn("Mã sách");
        dtmCTDK.addColumn("Tên sách");
        updateTable();
        LoadSearchBy();
        tableDSDK.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                int selectedRow = tableDSDK.getSelectedRow();
                if (selectedRow != -1) { 
                    String maDG = (String) dtmDSDK.getValueAt(selectedRow, 1); 

                    DKMuon dkmuon = new DKMuon();
                    dkmuon.setMaDG(maDG);
                    try {
                    List<Book> books = DKMuonBUS.getSachDaDK(dkmuon);
                    dtmCTDK.setRowCount(0);

                    for (Book book : books) {
                        dtmCTDK.addRow(new Object[] {book.getMaSach(), book.getTenSach()});
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            }
        });
    }
    public void updateTable() {   
        dtmDSDK.setRowCount(0);
        try {
        List<DKMuon> ds = DKMuonBUS.getDSDK();
        ds.sort((DKMuon b1, DKMuon b2) -> b1.getMaDK().compareTo(b2.getMaDK()));
        for (DKMuon dk : ds) {
            dtmDSDK.addRow(new Object[] {dk.getMaDK(), dk.getMaDG(), dk.getNgayDK()});
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    this.tableDSDK.setRowHeight(30);
}
    public void LoadSearchBy() {
        ComboBox_Search.removeAllItems();
        ComboBox_Search.addItem("Mã đăng ký");
        ComboBox_Search.addItem("Độc giả đăng ký");
        //ComboBox_Search.addItem("Tên độc giả");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableDSDK = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        ComboBox_Search = new javax.swing.JComboBox<>();
        btnTim = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableCTDK = new javax.swing.JTable();
        btnXacNhan = new javax.swing.JButton();

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel9.setPreferredSize(new java.awt.Dimension(830, 550));

        tableDSDK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đăng ký", "Mã độc giả", "Tên độc giả", "Ngày đăng ký"
            }
        ));
        jScrollPane5.setViewportView(tableDSDK);

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jLabel20.setText("Tìm theo :");

        ComboBox_Search.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loupe.png"))); // NOI18N
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-refresh-24.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTim, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBox_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtTim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(ComboBox_Search)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sách đã đăng ký"));

        tableCTDK.setAutoCreateRowSorter(true);
        tableCTDK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách"
            }
        ));
        jScrollPane6.setViewportView(tableCTDK);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        btnXacNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-confirm-26.png"))); // NOI18N
        btnXacNhan.setText("Xác nhận cho mượn sách");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(btnXacNhan)
                        .addGap(162, 162, 162))))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
       String query = txtTim.getText();
       List<DKMuon> searchResults = null;
    try {
        if (ComboBox_Search.getSelectedIndex() == 0) {
            searchResults = DKMuonBUS.searchDSByID(query);
        }
        else if (ComboBox_Search.getSelectedIndex() == 1) {
            searchResults = DKMuonBUS.searchDSByMaDG(query);
        }
        else if (ComboBox_Search.getSelectedIndex() == 2) {
            searchResults = DKMuonBUS.searchDSByTenDG(query);
        }
        if (searchResults != null && !searchResults.isEmpty()) {
            dtmDSDK.setRowCount(0);
            for (DKMuon dk : searchResults) {
                dtmDSDK.addRow(new Object[] {dk.getMaDK(), dk.getMaDG(), dk.getHoTen(), dk.getNgayDK()});
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        updateTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        int row = tableDSDK.getSelectedRow();
        if (row == -1) {    
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng.");
            return;
    }
        int confirm = JOptionPane.showConfirmDialog(this,"Bạn có muốn xác nhận cho mượn sách ? ");
        if (confirm == JOptionPane.YES_OPTION) {
            String MaDK = (String) dtmDSDK.getValueAt(row,0);
            String MaTT = CurrentUser.getInstance().getMaND();
            try {
                DKMuonBUS.XacNhanChoMuon(MaDK, MaTT);
                JOptionPane.showMessageDialog(this,"Xác nhận cho mượn sách thành công ");
                updateTable();
                qlpm.updateTable();
                dtmCTDK.setRowCount(0);
                
                
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_Search;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tableCTDK;
    private javax.swing.JTable tableDSDK;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.PhieuMuonBUS;
import BUS.PhieuTraBUS;
import DTO.PhieuMuon;
import DTO.PhieuTra;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class QLTra extends javax.swing.JPanel {

    /**
     * Creates new form QLTra
     */
    PhieuTraBUS PhieuTraBUS;
    DefaultTableModel dtm;

    /**
     * Creates new form QLMuon
     */
    public QLTra() {
        initComponents();
        PhieuTraBUS = new PhieuTraBUS();
        dtm = new DefaultTableModel();
        tablePhieuTra.setModel(dtm);
        dtm.addColumn("Mã phiếu trả");
        dtm.addColumn("Độc giả trả sách");
        dtm.addColumn("Ngày trả");
        updateTable();
        LoadSearchBy();
    }
    public void updateTable() {
        dtm.setRowCount(0);
        List <PhieuTra> pts = PhieuTraBUS.getAllPhieuTra();
        pts.sort((PhieuTra p1, PhieuTra p2) -> p1.getMaPT().compareTo(p2.getMaPT()));
        for (PhieuTra p : pts) {
            dtm.addRow(new Object[] {p.getMaPT(), p.getMaDG(), p.getNgayTra()}); 
        }
        this.tablePhieuTra.setRowHeight(30);
    }
    public void LoadSearchBy() {
        ComboBox_Search.removeAllItems();
        ComboBox_Search.addItem("Mã phiếu trả");
        ComboBox_Search.addItem("Mã độc giả");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel22 = new javax.swing.JPanel();
        btnThemSach = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCTSach = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        ComboBox_Search = new javax.swing.JComboBox<>();
        btnTim = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablePhieuTra = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(850, 515));

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thao tác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        btnThemSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus (5).png"))); // NOI18N
        btnThemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSachActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove (1).png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCTSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/file.png"))); // NOI18N
        btnCTSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCTSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCTSach, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCTSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addComponent(txtTim, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBox_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
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

        tablePhieuTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phiếu trả", "Mã độc giả", "Ngày trả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablePhieuTra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSachActionPerformed
        ThemPT pt = new ThemPT(this);
        pt.setLocationRelativeTo(null);
        pt.setVisible(true);
    }//GEN-LAST:event_btnThemSachActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
       int row = tablePhieuTra.getSelectedRow();
        if (row == -1) {    
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu trả để xóa.");
            return;
    }
        int confirm = JOptionPane.showConfirmDialog(this,"Bạn có chắc xóa phiếu trả này không ? ");
        if (confirm == JOptionPane.YES_OPTION) {
           
            String maPT = tablePhieuTra.getValueAt(row, 0).toString();
            PhieuTraBUS.deletePhieuTra(maPT);
            JOptionPane.showMessageDialog(this, "Xóa phiếu trả thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            updateTable();
        } 
            

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCTSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCTSachActionPerformed
        int selectedRow = tablePhieuTra.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng để xem chi tiết", "Thông báo", JOptionPane.WARNING_MESSAGE);}
        else {
            String selectedMaPT = (String) dtm.getValueAt(selectedRow, 0);
            PhieuTra pt = PhieuTraBUS.getPhieuTraByID(selectedMaPT);
            CTTra ct = new CTTra(pt,this);
            ct.setLocationRelativeTo(null);
            ct.setVisible(true);
        }
    }//GEN-LAST:event_btnCTSachActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
       String query = txtTim.getText();
        List <PhieuTra> searchResults = null;
        if (ComboBox_Search.getSelectedIndex() == 0) {
            System.out.println("DANG TIM THEO ID");
            searchResults = PhieuTraBUS.searchPhieuTraByID(query);}
        else if (ComboBox_Search.getSelectedIndex() == 1) {
            System.out.println("DANG TIM THEO MADG");
            searchResults = PhieuTraBUS.searchPhieuTraByMaDG(query);}
        System.out.println(searchResults);
        for (PhieuTra pt : searchResults) {
            System.out.println("MaPT: " + pt.getMaPT());
            System.out.println("MaDG: " + pt.getMaDG());
            
        }
        if (searchResults != null && !searchResults.isEmpty()) {
            dtm.setRowCount(0);
            for (PhieuTra pt : searchResults) {
                dtm.addRow(new Object[] {pt.getMaPT(), pt.getMaDG(), pt.getNgayTra()});
        }
        }
        else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        updateTable();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_Search;
    private javax.swing.JButton btnCTSach;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnThemSach;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tablePhieuTra;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.NhaXBBUS;
import DTO.NhaXB;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class QLNXB extends javax.swing.JPanel {
    NhaXBBUS NXBBUS;
    DefaultTableModel dtm;
    
    

   
    public QLNXB() {
        initComponents();
        NXBBUS = new NhaXBBUS();
        dtm = new DefaultTableModel();
        tableNXB.setModel(dtm);
        dtm.addColumn("Mã NXB");
        dtm.addColumn("Tên NXB");
        dtm.addColumn("Địa chỉ NXB");
        dtm.addColumn("Số điện thoại NXB");
        updateTable();
        LoadSearchBy();
    }
    public void updateTable() {   
        dtm.setRowCount(0); // Clear existing rows
        List<NhaXB> nxbs = NXBBUS.getAllNXB();
        for (NhaXB nxb : nxbs) {
            dtm.addRow(new Object[] {nxb.getMaNXB(), nxb.getTenNXB(), nxb.getDiaChi(), nxb.getSDT()});
        }
        this.tableNXB.setRowHeight(30);
    };
    public void LoadSearchBy() {
        ComboBox_Tim.removeAllItems();
        ComboBox_Tim.addItem("Mã NXB");
        ComboBox_Tim.addItem("Tên NXB");
        ComboBox_Tim.addItem("Địa chỉ NXB");
        ComboBox_Tim.addItem("Số ĐT NXB");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableNXB = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        btnXoaNXB = new javax.swing.JButton();
        btnSuaNXB = new javax.swing.JButton();
        btnThemNXB = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        ComboBox_Tim = new javax.swing.JComboBox<>();
        btnTim = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();

        tableNXB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã NXB", "Tên NXB", "Địa chỉ", "Số điện thoại"
            }
        ));
        jScrollPane3.setViewportView(tableNXB);

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thao tác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        btnXoaNXB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove (1).png"))); // NOI18N
        btnXoaNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNXBActionPerformed(evt);
            }
        });

        btnSuaNXB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit (1).png"))); // NOI18N
        btnSuaNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNXBActionPerformed(evt);
            }
        });

        btnThemNXB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus (5).png"))); // NOI18N
        btnThemNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNXBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThemNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnXoaNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnSuaNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoaNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jLabel21.setText("Tìm theo :");

        ComboBox_Tim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTim, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBox_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtTim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(ComboBox_Tim)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addComponent(jScrollPane3)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNXBActionPerformed
        ThemNXB anxb = new ThemNXB(this); 
        anxb.setLocationRelativeTo(null);
        anxb.setVisible(true);
    }//GEN-LAST:event_btnThemNXBActionPerformed

    private void btnXoaNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNXBActionPerformed
        int row = tableNXB.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhà xuất bản để xóa.");
            return; 
    }
        String MaNXB = String.valueOf(tableNXB.getValueAt(row, 0));
        NhaXBBUS nhaXBBUS = new NhaXBBUS();
        boolean hasReferences = nhaXBBUS.checkNXBReferences(MaNXB);
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc xóa nhà xuất bản này không ?");
        if (confirm == JOptionPane.YES_OPTION) {
            if (hasReferences) {
            JOptionPane.showMessageDialog(this, "Không thể xóa nhà xuất bản này vẫn còn sách thuộc nhà xuất bản đó");
            }
            else {
                nhaXBBUS.deleteNXB(MaNXB);
                JOptionPane.showMessageDialog(this, "Xóa nhà xuất bản thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                updateTable();
        }
            }
    }//GEN-LAST:event_btnXoaNXBActionPerformed

    private void btnSuaNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNXBActionPerformed
        int selectedRow = tableNXB.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng để cập nhật", "Thông báo", JOptionPane.WARNING_MESSAGE);}
        else { // A row is selected
        String selectedMaNXB = (String) dtm.getValueAt(selectedRow, 0);
        NhaXB nxb = NXBBUS.getNXBByMa(selectedMaNXB);
        CapNhatNXB cn = new CapNhatNXB(nxb, this);
        cn.setLocationRelativeTo(null);
        cn.setVisible(true);
    }
    }//GEN-LAST:event_btnSuaNXBActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        String query = txtTim.getText(); 
        List <NhaXB> searchResults = null;
        if (ComboBox_Tim.getSelectedIndex() == 0) {
            searchResults = NXBBUS.searchNXBByID(query);}
        else if (ComboBox_Tim.getSelectedIndex() == 1) {
            searchResults = NXBBUS.searchNXBByName(query);}
        else if (ComboBox_Tim.getSelectedIndex() == 2) {
            searchResults = NXBBUS.searchNXBByAddress(query);}
        else if (ComboBox_Tim.getSelectedIndex() == 3) {
            searchResults = NXBBUS.searchNXBByPhone(query);}

   
    
    if (searchResults != null && !searchResults.isEmpty()) {
        dtm.setRowCount(0);
        for (NhaXB nxb : searchResults) {
            dtm.addRow(new Object[] {nxb.getMaNXB(), nxb.getTenNXB(), nxb.getDiaChi(), nxb.getSDT()});
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
    private javax.swing.JComboBox<String> ComboBox_Tim;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSuaNXB;
    private javax.swing.JButton btnThemNXB;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoaNXB;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableNXB;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}

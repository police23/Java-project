/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.BookBUS;
import DTO.Book;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class QLSach extends javax.swing.JPanel {
     private static QLSach instance; 
    BookBUS BookBUS;
    DefaultTableModel dtm;
    

    /**
     * Creates new form QLSach
     */
    public QLSach() {
        initComponents();
        BookBUS = new BookBUS();
        dtm = new DefaultTableModel();
        tableSach.setModel(dtm);
        dtm.addColumn("Mã sách");
        dtm.addColumn("Tên sách");
        dtm.addColumn("Tác giả");
        dtm.addColumn("Thể loại");
        dtm.addColumn("Số lượng");
        updateTable();
        LoadSearchBy();
    }
    public static QLSach getInstance() {
        if (instance == null) {
            instance = new QLSach();
        }
        return instance;
    }
    public void updateTable() {   
        dtm.setRowCount(0); 
        List<Book> bks = BookBUS.getAllBooks();
        bks.sort((Book b1, Book b2) -> b1.getMaSach().compareTo(b2.getMaSach()));
        for (Book bk : bks) {
            dtm.addRow(new Object[] {bk.getMaSach(), bk.getTenSach(), bk.getTacGia(), bk.getTheLoai(), bk.getSoLuong()});
        }
        dtm.fireTableDataChanged();
        tableSach.revalidate();
        tableSach.repaint();
        this.tableSach.setRowHeight(30);
    };
    public void repaintTable() {
        tableSach.revalidate();
        tableSach.repaint();
    }
    
    public void LoadSearchBy() {
        ComboBox_Search.removeAllItems();
        ComboBox_Search.addItem("Mã sách");
        ComboBox_Search.addItem("Tên sách");
        ComboBox_Search.addItem("Tác giả");
        ComboBox_Search.addItem("Thể loại");
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
        jPanel22 = new javax.swing.JPanel();
        btnThemSach = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnCTSach = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableSach = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        ComboBox_Search = new javax.swing.JComboBox<>();
        btnTim = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(850, 515));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel9.setPreferredSize(new java.awt.Dimension(830, 550));

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

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit (1).png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
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
                .addGap(12, 12, 12)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCTSach, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCTSach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Tác giả", "Thể loại", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tableSach);
        if (tableSach.getColumnModel().getColumnCount() > 0) {
            tableSach.getColumnModel().getColumn(3).setHeaderValue("Thể loại");
            tableSach.getColumnModel().getColumn(4).setHeaderValue("Số lượng");
        }

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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        String query = txtTim.getText();
        List <Book> searchResults = null;
        if (ComboBox_Search.getSelectedIndex() == 0) {
            searchResults = BookBUS.searchBookByID(query);}
        else if (ComboBox_Search.getSelectedIndex() == 1) {
            searchResults = BookBUS.searchBookByName(query);}
        else if (ComboBox_Search.getSelectedIndex() == 2) {
            searchResults = BookBUS.searchBookByAuthor(query);}
        else if (ComboBox_Search.getSelectedIndex() == 3) {
            searchResults = BookBUS.searchBookByCategory(query);}


    
    if (searchResults != null && !searchResults.isEmpty()) {
        dtm.setRowCount(0);
        for (Book bk : searchResults) {
            dtm.addRow(new Object[] {bk.getMaSach(), bk.getTenSach(), bk.getTacGia(), bk.getTheLoai(), bk.getSoLuong()});
    }
    }
    else {
        JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }                                    
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        updateTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnCTSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCTSachActionPerformed
        int selectedRow = tableSach.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng để xem chi tiết", "Thông báo", JOptionPane.WARNING_MESSAGE);}
        else {
            String selectedMaSach = (String) dtm.getValueAt(selectedRow, 0);
            Book bk = BookBUS.getBookByMaSach(selectedMaSach);
            CTSach bd = new CTSach(bk, this);
            bd.setLocationRelativeTo(null);
            bd.setVisible(true);
        }
    }//GEN-LAST:event_btnCTSachActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int selectedRow = tableSach.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng để cập nhật", "Thông báo", JOptionPane.WARNING_MESSAGE);}
        else { // A row is selected
            String selectedMaSach = (String) dtm.getValueAt(selectedRow, 0);
            Book bk = BookBUS.getBookByMaSach(selectedMaSach);
            CapNhatSach upbk = new CapNhatSach(bk, this);
            upbk.setLocationRelativeTo(null);
            upbk.setVisible(true);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tableSach.getSelectedRow();
        if (row == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        return;
    }
        int confirm = JOptionPane.showConfirmDialog(this,"Bạn có chắc xóa sách này không ? ");
        if (confirm == JOptionPane.YES_OPTION) {
            try {
            String MaSach = String.valueOf(String.valueOf(tableSach.getValueAt(row,0)));
           // BookBUS BookBUS = new BookBUS();
            BookBUS.deleteBook(MaSach);
            JOptionPane.showMessageDialog(this, "Xóa sách thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            updateTable();   
        }
            catch (SQLException ex) {
                
            if (ex.getErrorCode() == 20002) {
                JOptionPane.showMessageDialog(null,"Không thể xóa do còn độc giả đang mượn sách này","Lỗi",JOptionPane.ERROR_MESSAGE);
        }
        }
            }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSachActionPerformed
        ThemSach addb = new ThemSach(this);
        addb.setLocationRelativeTo(null);
        addb.setVisible(true);
    }//GEN-LAST:event_btnThemSachActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_Search;
    private javax.swing.JButton btnCTSach;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThemSach;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tableSach;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}

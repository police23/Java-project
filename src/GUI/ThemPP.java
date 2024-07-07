/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;




import BUS.BookBUS;
import BUS.PhieuPhatBUS;
import DAO.BookDAO;
import DAO.PhieuMuonDAO;
import DAO.PhieuPhatDAO;
import DTO.Book;
import DTO.PhieuPhat;
import JDBCConnection.JDBCConnection;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import login.CurrentUser;
import java.util.Date;
/**
 *
 * @author VINH
 */
public class ThemPP extends javax.swing.JFrame {
    DefaultTableModel dtm;
    Connection conn;
     JDBCConnection cn = new JDBCConnection();
     PreparedStatement pst;
     ResultSet rs;
     QLPhat qlp;
     PhieuPhatBUS PhieuPhatBUS;
     PhieuMuonDAO pm = new PhieuMuonDAO();
     PhieuPhat pp;
     SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * Creates new form ThemPP
     */
    public ThemPP(QLPhat qlp) {
        initComponents();
        LoadMaDG();
        tableDSSachPhat.setRowHeight(26);
        ComboBox_Sach.removeAllItems();
        ComboBox_Sach.addItem("--Chọn sách--");
        CurrentUser currentUser = CurrentUser.getInstance();
        String maND = currentUser.getMaND();
        txtMaTT.setText(maND);
        txtMaTT.setEditable(false);
        Text_HoTenDG.setEditable(false);
        pp = new PhieuPhat();
        PhieuPhatBUS = new PhieuPhatBUS();
        this.qlp = qlp;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Date today = new Date();
        String NgayTra = dateFormat.format(new Date(today.getTime()));
        //txtNgayLap.setText(NgayTra);
        //txtNgayLap.setEditable(false);
        LoadLiDo();
        ComboBox_MaDG.addItemListener(new ItemListener() {
            public void itemStateChanged (ItemEvent ie) {
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    String MaDG = ComboBox_MaDG.getSelectedItem().toString();
                    String HoTenDG = getHoTenDG(MaDG);
                    Text_HoTenDG.setText(HoTenDG);
                    LoadSach(MaDG);
                    
                }
            }
        });
        ComboBox_Sach.addItemListener(new ItemListener() {
            public void itemStateChanged (ItemEvent ie) {
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    if (ComboBox_Sach.getSelectedIndex() != 0) {
                        String maSach = ComboBox_Sach.getSelectedItem().toString();
                        String maDG = ComboBox_MaDG.getSelectedItem().toString();
                        txtHanTra.setText(getHanTra(maSach, maDG));
                        txtHanTra.setEditable(false);
                    }
                        
                }
            }
        });
    }
    
    private boolean LoadLiDo() {
        ComboBox_LiDo.removeAllItems();
        ComboBox_LiDo.addItem("--Chọn lí do phạt--");
        ComboBox_LiDo.addItem("Quá hạn");
        ComboBox_LiDo.addItem("Mất sách");
        return true;
    }
    
    private boolean LoadMaDG() {
        conn = cn.getJDBCConnection();
        if (conn != null) {
                String sql = "SELECT MADOCGIA FROM DOCGIA " +
                             "WHERE MADOCGIA IN (" +
                                "SELECT MADOCGIA FROM PHIEUMUON PM " +
                                "JOIN CTPHIEUMUON CT ON PM.MAPHIEUMUON = CT.MAPHIEUMUON AND TRANGTHAI = 0" +
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
        return true;
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
    private boolean LoadSach(String maDG) {
        List<Book> books = new BookDAO().getBorrowedBooksByMaDG(maDG);
        
        for (Book book : books) {
        ComboBox_Sach.addItem(book.getMaSach());
        
        
    }
        return true;
    }
    
    private String getHanTra(String maSach, String maDG) {
        String hantra = dateFormat.format(pm.getHanTraBy(maSach, maDG));
        return hantra;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboBox_MaDG = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Text_HoTenDG = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMaTT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ComboBox_Sach = new javax.swing.JComboBox<>();
        btnOK = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ComboBox_LiDo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDSSachPhat = new javax.swing.JTable();
        btnThemSach = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtHanTra = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TẠO PHIẾU PHẠT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(208, 208, 208)
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
        ComboBox_MaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_MaDGActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Họ tên độc giả :");

        Text_HoTenDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_HoTenDGActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Người lập phiếu : ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Sách đang mượn :");

        ComboBox_Sach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnOK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-ok-24.png"))); // NOI18N
        btnOK.setText("OK");
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Lí do phạt:");

        ComboBox_LiDo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBox_LiDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_LiDoActionPerformed(evt);
            }
        });

        tableDSSachPhat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Lí do phạt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDSSachPhat);

        btnThemSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-add-book-16.png"))); // NOI18N
        btnThemSach.setText("Thêm");
        btnThemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSachActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/remove (1).png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Hạn trả :");

        txtHanTra.setText("DD/MM/YY");
        txtHanTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHanTraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(119, 119, 119)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemSach)
                            .addComponent(btnXoa))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ComboBox_LiDo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(229, 229, 229))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboBox_Sach, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Text_HoTenDG, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboBox_MaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboBox_MaDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Text_HoTenDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ComboBox_Sach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtHanTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ComboBox_LiDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBox_MaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_MaDGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_MaDGActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        String noti = "";
        Date today = new Date();
        if (ComboBox_MaDG.getSelectedIndex() == 0) {
            noti += "Chưa chọn độc giả\n";
        }
        if (ComboBox_LiDo.getSelectedIndex() == 0) {
            noti += "Chưa chọn lí do phạt\n";
        }
        if (!noti.isEmpty()) {
            JOptionPane.showMessageDialog(null,noti);
        }
        else {
            int rowCount = tableDSSachPhat.getRowCount();
            List<PhieuPhat.CTPhieuPhat> SachPhatArray = new ArrayList<>();
            PhieuPhatDAO ppDAO = new PhieuPhatDAO();
            int maLiDo = 0;
            double tienphat = 0;
            for (int i = 0; i < rowCount; i++) {
                String maSach = tableDSSachPhat.getValueAt(i, 0).toString();
                String tenSach = tableDSSachPhat.getValueAt(i, 1).toString();
                String liDo = tableDSSachPhat.getValueAt(i, 2).toString();
                if ("Quá hạn".equals(liDo)) {
                    tienphat = ppDAO.tinhTienPhatTraTre(maSach, ComboBox_MaDG.getSelectedItem().toString());
                    maLiDo = 1;
                } else if ("Mất sách".equals(liDo)) {
                    tienphat = ppDAO.tinhTienPhatMatSach(maSach);
                    maLiDo = 2;
                }
                SachPhatArray.add(new PhieuPhat.CTPhieuPhat(maSach, tenSach, tienphat, maLiDo));
            }
            pp.setMaTT(txtMaTT.getText());
            pp.setMaDG(ComboBox_MaDG.getSelectedItem().toString());
            //pp.setNgayLap(new java.sql.Date(today.getTime()));
            ppDAO.addPhieuPhat(pp, SachPhatArray);
            JOptionPane.showMessageDialog(null,"Thêm phiếu phạt thành công");
            qlp.updateTable();
            this.dispose();
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void ComboBox_LiDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_LiDoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ComboBox_LiDoActionPerformed

    private void btnThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSachActionPerformed
                String maSach = ComboBox_Sach.getSelectedItem().toString();
                String maDG = ComboBox_MaDG.getSelectedItem().toString();
                String liDo = ComboBox_LiDo.getSelectedItem().toString();
                Book bk = new BookBUS().getBookByMaSach(maSach);
                int SoNgayTraTre = new PhieuPhatBUS().tinhSoNgayTraTre(maSach, maDG);
                DefaultTableModel dtm = (DefaultTableModel) tableDSSachPhat.getModel();
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    if (dtm.getValueAt(i,0).equals(bk.getMaSach())) {
                        JOptionPane.showMessageDialog(null,"Sách đã tồn tại trong danh sách ");
                        return;
                    }
                }
                if (SoNgayTraTre <= 0 && liDo.equals("Quá hạn")) {
                    JOptionPane.showMessageDialog(null,"Sách " + bk.getTenSach() + " chưa quá hạn trả");
                    return;
                }
                dtm.addRow(new Object [] {bk.getMaSach(), bk.getTenSach(), ComboBox_LiDo.getSelectedItem()});
    }//GEN-LAST:event_btnThemSachActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int selected = tableDSSachPhat.getSelectedRow();
        if (selected != -1) {
            DefaultTableModel dtm = (DefaultTableModel) tableDSSachPhat.getModel();
            dtm.removeRow(selected);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtHanTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHanTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHanTraActionPerformed

    private void Text_HoTenDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_HoTenDGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_HoTenDGActionPerformed

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
            java.util.logging.Logger.getLogger(ThemPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemPP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ThemPP().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_LiDo;
    private javax.swing.JComboBox<String> ComboBox_MaDG;
    private javax.swing.JComboBox<String> ComboBox_Sach;
    private javax.swing.JTextField Text_HoTenDG;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnThemSach;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDSSachPhat;
    private javax.swing.JTextField txtHanTra;
    private javax.swing.JTextField txtMaTT;
    // End of variables declaration//GEN-END:variables
}

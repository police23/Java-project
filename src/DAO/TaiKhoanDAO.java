/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TaiKhoan;
import JDBCConnection.JDBCConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author VINH
 */
public class TaiKhoanDAO {
    public List<TaiKhoan> getAllTaiKhoans() {
        List <TaiKhoan> tks = new ArrayList<TaiKhoan>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT MATAIKHOAN FROM TAIKHOAN";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = getThongTinTK(rs.getString("MATAIKHOAN"));
                tks.add(tk);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return tks;
    }
    public TaiKhoan getThongTinTK(String maND) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT MATAIKHOAN, EMAIL, MAVAITRO, MATKHAU FROM TAIKHOAN WHERE MATAIKHOAN = ?";
        TaiKhoan taiKhoan = new TaiKhoan();

        PreparedStatement ps1 = null;
        ResultSet rs1 = null;
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;

        try {
            ps1 = conn.prepareStatement(sql);
            ps1.setString(1, maND);
            rs1 = ps1.executeQuery();

            if (rs1.next()) {
                String MaTK = rs1.getString("MATAIKHOAN");
//                System.out.println("MATK: " + MaTK);
                String email = rs1.getString("EMAIL");
//                System.out.println("email: " + email);
                int VaiTro = rs1.getInt("MAVAITRO");
                String MatKhau = rs1.getString("MATKHAU");
                rs1.close();
                ps1.close();

                String sql2 = null;
                if (VaiTro == 0 || VaiTro == 1) {
                    sql2 = "SELECT HOTEN, NGAYSINH, GIOITINH, SODT FROM THUTHU WHERE MATHUTHU = ?";
                } else if (VaiTro == 2) {
                    sql2 = "SELECT HOTEN, NGAYSINH, GIOITINH, SODT FROM DOCGIA WHERE MADOCGIA = ?";
                }
                if (sql2 != null) {
                    System.out.println(MaTK + sql2);
                    ps2 = conn.prepareStatement(sql2);
                    ps2.setString(1, MaTK);
                    rs2 = ps2.executeQuery();
                    if (rs2.next()) {
                        String hoTen = rs2.getString("HOTEN");
//                        System.out.println("Ten: " + hoTen);
                        Date ngaySinh = rs2.getDate("NGAYSINH");
//                        System.out.println("Ngaysinh: " + ngaySinh);
                        int gioiTinh = rs2.getInt("GIOITINH");
//                         System.out.println("gioiTinh: " + gioiTinh);
                        String soDt = rs2.getString("SODT");
//                        System.out.println("soDt: " + soDt);
                        

                        taiKhoan = new TaiKhoan(MaTK, email, hoTen, ngaySinh, gioiTinh, soDt, VaiTro, MatKhau);
                    }
                }
            }
        } catch (SQLException ex) {
                System.out.println("Hello");
            } 

        return taiKhoan;
    }
    
    public void addTaiKhoan(TaiKhoan tk) {
        Connection conn = JDBCConnection.getJDBCConnection();
        CallableStatement cstmt = null;
    try {
        String SQL = "{call THEMTAIKHOAN_PROC(?, ?, ?, ?, ?, ?)}"; 
        cstmt = conn.prepareCall(SQL);
        cstmt.setString(1, tk.getEmail());
        cstmt.setInt(2, tk.getVaiTro());
        cstmt.setString(3, tk.getHoTen());
        java.sql.Date sqlDate = new java.sql.Date(tk.getNgaySinh().getTime());
        cstmt.setDate(4, sqlDate);
        cstmt.setInt(5, tk.getGioiTinh());
        cstmt.setString(6, tk.getSoDT());
        cstmt.execute();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }
    
    public void updateTaiKhoan(TaiKhoan tk) {
        System.out.println("CapNhat Sach");
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "{call CAPNHATTAIKHOAN_PROC(?, ?, ?, ?, ?, ?, ?)}"; // Gọi stored procedure
        try (CallableStatement cst = conn.prepareCall(sql)) {
            cst.setString(1, tk.getMaTK());
            System.out.println(tk.getMaTK());
            cst.setString(2, tk.getHoTen());
            System.out.println(tk.getHoTen());
            java.sql.Date sqlDate = new java.sql.Date(tk.getNgaySinh().getTime());
            cst.setDate(3, sqlDate);
            System.out.println(tk.getNgaySinh());
            cst.setInt(4, tk.getGioiTinh());
            
            cst.setString(5, tk.getSoDT());
            System.out.println(tk.getSoDT());
            cst.setString(6, tk.getEmail());
            System.out.println(tk.getEmail());
            cst.setInt(7, tk.getVaiTro());
            System.out.println(tk.getVaiTro());
            int rs = cst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteTaiKhoan(String MaTK) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "{call XOATAIKHOAN_PROC(?)}";
        try (CallableStatement cst = conn.prepareCall(sql)) {
            cst.setString(1, MaTK); 
            int rs = cst.executeUpdate(); 
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public boolean KTMatKhauHienTai(String MaTK, String MKHienTai) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT MATKHAU FROM TAIKHOAN WHERE MATAIKHOAN = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, MaTK);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String MKHT = rs.getString("MATKHAU");
                return MKHT.equals(MKHienTai);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
     public void updateMatKhau(String MaTK, String MKMoi) {
         Connection conn = JDBCConnection.getJDBCConnection();
         String sql = "UPDATE TAIKHOAN SET MATKHAU = ? WHERE MATAIKHOAN = ?";
         try {
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setString(1,MKMoi);
             ps.setString(2,MaTK);
             int rs = ps.executeUpdate();
             ps.close();
         }
         catch (SQLException e) {
             e.printStackTrace();
         }
     }
}
    


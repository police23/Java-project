/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DTO.PhieuTra;
import JDBCConnection.JDBCConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

/**
 *
 * @author VINH
 */
public class PhieuTraDAO {
    public List <PhieuTra> getAllPhieuTra() {
        List <PhieuTra> pts = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT PT.* FROM PHIEUTRA PT";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuTra pt = new PhieuTra();
                pt.setMaPT(rs.getString("MAPHIEUTRA"));
                pt.setMaTT(rs.getString("MATHUTHU"));
                pt.setMaDG(rs.getString("MADOCGIA"));
                pt.setNgayTra(rs.getDate("NGAYTRA"));
                pts.add(pt);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return pts;
        }
    public void addPhieuTra(PhieuTra pt, String[] maSachArray) {
        Connection conn = JDBCConnection.getJDBCConnection();
        CallableStatement cstmt = null;
    try {
        String SQL = "{call THEMPHIEUTRA_PROC(?,?,?)}"; 
        cstmt = conn.prepareCall(SQL);
        cstmt.setString(1, pt.getMaTT());
        cstmt.setString(2, pt.getMaDG());
        //cstmt.setDate(3, new java.sql.Date(pt.getNgayTra().getTime()));
        // Convert list of book IDs to an oracle.sql.ARRAY
        ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("SACH_LIST", conn);
        ARRAY array = new ARRAY(descriptor, conn, maSachArray);
        cstmt.setArray(3, array);
        cstmt.execute();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }
    public void deletePhieuTra(String maPT)  {
        Connection conn = JDBCConnection.getJDBCConnection();
        CallableStatement cstmt = null;
    try {
        
        String SQL = "{call XOAPHIEUTRA_PROC(?)}"; // TAO PROCEDURE MOI
        cstmt = conn.prepareCall(SQL);
        
        cstmt.setString(1, maPT);  
        
        cstmt.execute();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } 
    }
//    public void updatePhieuTra (PhieuMuon pm) {
//        Connection conn = JDBCConnection.getJDBCConnection();
//        CallableStatement cstmt = null;
//    try {
//        String SQL = "{call CAPNHATHANTRA_PROC(?,?)}";
//        cstmt = conn.prepareCall(SQL);
//        cstmt.setString(1, pm.getMaPM());
//        cstmt.setDate(2, new java.sql.Date(pm.getHanTra().getTime()));
//        cstmt.execute();
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//    } finally {
//        
//        if (cstmt != null) {
//            try {
//                cstmt.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }  
//    }
    public PhieuTra getPhieuTraByID(String ID) {
        for (PhieuTra pt : getAllPhieuTra()) {
            if (pt.getMaPT().equals(ID)) {
                return pt;
            }
        }
        return null;
    }
    public List <PhieuTra> searchPhieuTraByID(String query) {
        List <PhieuTra> pts = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT PT.* FROM PHIEUTRA PT WHERE MAPHIEUTRA LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            String searchQuery = "%" + query + "%"; 
            ps.setString(1, searchQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuTra pt = new PhieuTra();
                pt.setMaPT(rs.getString("MAPHIEUTRA"));
                pt.setMaTT(rs.getString("MATHUTHU"));
                pt.setMaDG(rs.getString("MADOCGIA"));
                pt.setNgayTra(rs.getDate("NGAYTRA"));
                pts.add(pt);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return pts;
        }
    
    public List <PhieuTra> searchPhieuTraByMaDG(String query) {
        List <PhieuTra> pts = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT PT.* FROM PHIEUTRA PT WHERE MADOCGIA LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            String searchQuery = "%" + query + "%"; 
            ps.setString(1, searchQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuTra pt = new PhieuTra();
                pt.setMaPT(rs.getString("MAPHIEUTRA"));
                pt.setMaTT(rs.getString("MATHUTHU"));
                pt.setMaDG(rs.getString("MADOCGIA"));
                pt.setNgayTra(rs.getDate("NGAYTRA"));
                pts.add(pt);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return pts;
        }
    
    public List <PhieuTra.CTPhieuTra> getCTPT(String maPT) {
        List <PhieuTra.CTPhieuTra> ds = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT PT.*, CT.*, S.TENSACH "+
                     "FROM PHIEUTRA PT "+
                     "JOIN CTPHIEUTRA CT ON CT.MAPHIEUTRA = PT.MAPHIEUTRA "+ 
                     "JOIN SACH S ON S.MASACH = CT.MASACH " +
                     "WHERE PT.MAPHIEUTRA = ?";
         
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,maPT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuTra.CTPhieuTra ctpt = new PhieuTra.CTPhieuTra(
                rs.getString("MASACH"),
                rs.getString("TENSACH")
            );
                ds.add(ctpt);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            
            }
        return ds;
    }
    }


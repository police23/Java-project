/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DTO.PhieuMuon;
import DTO.PhieuMuon.CTPhieuMuon;
import JDBCConnection.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import java.sql.Date;
/**
 *
 * @author User
 */
public class PhieuMuonDAO { 
    public List <PhieuMuon> getAllPhieuMuon() {
        List <PhieuMuon> pms = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT PM.* FROM PHIEUMUON PM";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuMuon pm = new PhieuMuon();
                pm.setMaPM(rs.getString("MAPHIEUMUON"));
                pm.setMaTT(rs.getString("MATHUTHU"));
                pm.setMaDG(rs.getString("MADOCGIA"));
                pm.setNgayLap(rs.getDate("NGAYLAP"));
                pm.setHanTra(rs.getDate("HANTRA"));
                pms.add(pm);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return pms;
        }
    public void addPhieuMuon(PhieuMuon pm, String[] maSachArray) {
        Connection conn = JDBCConnection.getJDBCConnection();
        CallableStatement cstmt = null;
    try {
        // Create a CallableStatement object.
        String SQL = "{call THEMPHIEUMUON_PROC(?,?,?,?,?)}";
        cstmt = conn.prepareCall(SQL);
        
        cstmt.setString(1, pm.getMaTT());
        cstmt.setString(2, pm.getMaDG());
        cstmt.setDate(3, new java.sql.Date(pm.getNgayLap().getTime()));
        cstmt.setDate(4, new java.sql.Date(pm.getHanTra().getTime()));
        // Convert list of book IDs to an oracle.sql.ARRAY
        ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("SACH_LIST", conn);
        ARRAY array = new ARRAY(descriptor, conn, maSachArray);
        cstmt.setArray(5, array);
        cstmt.execute();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }
    public void deletePhieuMuon(String maPM) throws SQLException {
        Connection conn = JDBCConnection.getJDBCConnection();
        CallableStatement cstmt = null;
    try {
        
        String SQL = "{call XOAPHIEUMUON_PROC(?)}";
        cstmt = conn.prepareCall(SQL);
        
        
        cstmt.setString(1, maPM);  
        
        cstmt.execute();
    } catch (SQLException ex) {
        ex.printStackTrace();
        throw ex;
    } 
    }
    public void updatePhieuMuon (PhieuMuon pm) {
        Connection conn = JDBCConnection.getJDBCConnection();
        CallableStatement cstmt = null;
    try {
        String SQL = "{call CAPNHATHANTRA_PROC(?,?)}";
        cstmt = conn.prepareCall(SQL);
        cstmt.setString(1, pm.getMaPM());
        cstmt.setDate(2, new java.sql.Date(pm.getHanTra().getTime()));
        cstmt.execute();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        
        if (cstmt != null) {
            try {
                cstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }  
    }
    public PhieuMuon getPhieuMuonByID(String ID) {
        for (PhieuMuon pm : getAllPhieuMuon()) {
            if (pm.getMaPM().equals(ID)) {
                return pm;
            }
        }
        return null;
    }
    public List <PhieuMuon> searchPhieuMuonByID(String query) {
        List <PhieuMuon> pms = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT PM.* FROM PHIEUMUON PM WHERE MAPHIEUMUON LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            String searchQuery = "%" + query + "%"; 
            ps.setString(1, searchQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuMuon pm = new PhieuMuon();
                pm.setMaPM(rs.getString("MAPHIEUMUON"));
                pm.setMaTT(rs.getString("MATHUTHU"));
                pm.setMaDG(rs.getString("MADOCGIA"));
                pm.setNgayLap(rs.getDate("NGAYLAP"));
                pm.setHanTra(rs.getDate("HANTRA"));
                pms.add(pm);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return pms;
        }
    public List <PhieuMuon> searchPhieuMuonByMaDG(String query) {
        List <PhieuMuon> pms = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT PM.* FROM PHIEUMUON PM WHERE MADOCGIA LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            String searchQuery = "%" + query + "%"; 
            ps.setString(1, searchQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuMuon pm = new PhieuMuon();
                pm.setMaPM(rs.getString("MAPHIEUMUON"));
                pm.setMaTT(rs.getString("MATHUTHU"));
                pm.setMaDG(rs.getString("MADOCGIA"));
                pm.setNgayLap(rs.getDate("NGAYLAP"));
                pm.setHanTra(rs.getDate("HANTRA"));
                pms.add(pm);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return pms;
        }
    
    public List <CTPhieuMuon> getCTPM(String maPM) {
        List <CTPhieuMuon> ds = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT PM.*, CT.*, S.TENSACH "+
                     "FROM PHIEUMUON PM "+
                     "JOIN CTPHIEUMUON CT ON CT.MAPHIEUMUON = PM.MAPHIEUMUON "+ 
                     "JOIN SACH S ON S.MASACH = CT.MASACH " +
                     "WHERE PM.MAPHIEUMUON = ?";
         
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,maPM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                CTPhieuMuon ctpm = new PhieuMuon.CTPhieuMuon(
                rs.getString("MASACH"),
                rs.getString("TENSACH"),
                rs.getInt("TRANGTHAI")
            );
                ds.add(ctpm);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            
            }
        return ds;
    }
    
    public Date getHanTraBy(String maSach, String maDG) {
        Connection conn = JDBCConnection.getJDBCConnection();
        CallableStatement cstmt = null;
        Date hantra = null;
    try {
        String SQL = "{? = call GET_HANTRA_FUNC(?,?)}";
        cstmt = conn.prepareCall(SQL);
        cstmt.registerOutParameter(1, Types.DATE);
        cstmt.setString(2, maSach);
        cstmt.setString(3, maDG);
        cstmt.execute();
        hantra = cstmt.getDate(1);
    } catch (SQLException ex) {
        ex.printStackTrace();
    } 
     
     return hantra;
    }
    
}
  
   /* public List <PhieuMuon> searchPhieuMuonByID(String maPM) {
         List<PhieuMuon> list = new ArrayList<PhieuMuon>();
         Connection conn = JDBCConnection.getJDBCConnection();
         PreparedStatement pst = null;
         ResultSet rs = null;
    try {
        String sql = "SELECT P.*, CT.* FROM PHIEUMUON P JOIN CTPHIEUMUON CT ON P.MAPHIEUMUON = CT.MAPHIEUMUON WHERE P.MAPHIEUMUON LIKE ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + maPM + "%");
        
        rs = pst.executeQuery();
        while (rs.next()) {
            // Create a new PhieuMuon object and add it to the list
            // You would need to replace this with your actual code
            PhieuMuon pm = new PhieuMuon();
            pm.setMaPM(rs.getString("MAPHIEUMUON"));
            pm.setMaDG(rs.getString("MADOCGIA"));
            pm.setNgayLap(rs.getDate("NGAYLAP"));
            pm.setHanTra(rs.getDate("HANTRA"));
            list.add(pm);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }  
    return list; 
    }
//}
    //public List <PhieuMuon> searchPhieuMuonByMaDG() {
    //}
}*/
    

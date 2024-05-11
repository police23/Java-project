/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Book;
import DTO.DKMuon;
import JDBCConnection.JDBCConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

/**
 *
 * @author User
 */
public class DKMuonDAO {
    public List<DKMuon> getDSDK()throws SQLException {
    List<DKMuon> dsdk = new ArrayList<>();
    Connection conn = JDBCConnection.getJDBCConnection();
    String sql = "SELECT D.MADK, D.MADOCGIA, DG.HOTEN, D.NGAYDK FROM DANGKYMUONSACH D JOIN DOCGIA DG ON D.MADOCGIA = DG.MADOCGIA";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            DKMuon dkmuon = new DKMuon();
            dkmuon.setMaDK(rs.getString("MADK"));
            dkmuon.setMaDG(rs.getString("MADOCGIA"));
            dkmuon.setHoTen(rs.getString("HOTEN"));
            dkmuon.setNgayDK(rs.getDate("NGAYDK"));
            dsdk.add(dkmuon);
        }
    return dsdk;
}
    
        
    public void addDK(DKMuon dkmuon, String[] maSachArray) throws SQLException {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "{call DKMUONSACH_PROC(?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, dkmuon.getMaDG());
            ArrayDescriptor desc = ArrayDescriptor.createDescriptor("MASACH_ARRAY", conn);
            ARRAY masachOracleArray = new ARRAY(desc, conn, maSachArray);
            cs.setArray(2, masachOracleArray);
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        }
        }
    public void HuyDK(String maDG, String[] maSachArray) throws SQLException {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "{call HUY_DKMUONSACH_PROC(?,?)}";
        try {
            CallableStatement cs = conn.prepareCall(sql);
            cs.setString(1, maDG);
            ArrayDescriptor desc = ArrayDescriptor.createDescriptor("MASACH_ARRAY", conn);
            ARRAY masachOracleArray = new ARRAY(desc, conn, maSachArray);
            cs.setArray(2, masachOracleArray);
            cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        }
    }
    public List<Book> getSachDaDK(DKMuon dkmuon) throws SQLException {
    List<Book> sachDaDK = new ArrayList<>();
    Connection conn = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    try {
        conn = JDBCConnection.getJDBCConnection();
        String sql = "{call SACHDGDADK_PROC(?,?)}";
        cs = conn.prepareCall(sql);
        cs.setString(1, dkmuon.getMaDG());
        cs.registerOutParameter(2, OracleTypes.CURSOR);
        cs.execute();
        rs = (ResultSet) cs.getObject(2);
        while (rs.next()) {
            Book bk = new Book();
            bk.setMaSach(rs.getString("MASACH"));
            bk.setTenSach(rs.getString("TENSACH"));
            sachDaDK.add(bk);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
    return sachDaDK;
    }
    public List<DKMuon> searchDSByID(String query) throws SQLException {
        List <DKMuon> dsdk = new ArrayList<DKMuon>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT D.*, DG.HOTEN FROM DANGKYMUONSACH D JOIN DOCGIA DG ON D.MADOCGIA = DG.MADOCGIA WHERE D.MADK LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
        String searchQuery = "%" + query + "%"; 
        ps.setString(1, searchQuery);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            DKMuon dkmuon = new DKMuon();
            dkmuon.setMaDK(rs.getString("MADK"));
            dkmuon.setMaDG(rs.getString("MADOCGIA"));
            dkmuon.setHoTen(rs.getString("HOTEN"));
            dkmuon.setNgayDK(rs.getDate("NGAYDK"));
            dsdk.add(dkmuon);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return dsdk;
    }
    public List<DKMuon> searchDSByMaDG(String query) throws SQLException {
        List <DKMuon> dsdk = new ArrayList<DKMuon>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT D.*, DG.HOTEN FROM DANGKYMUONSACH D JOIN DOCGIA DG ON D.MADOCGIA = DG.MADOCGIA WHERE D.MADK LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            String searchQuery = "%" + query + "%"; 
            ps.setString(1, query);
            ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            DKMuon dkmuon = new DKMuon();
            dkmuon.setMaDK(rs.getString("MADK"));
            dkmuon.setMaDG(rs.getString("MADOCGIA"));
            dkmuon.setHoTen(rs.getString("HOTEN"));
            dkmuon.setNgayDK(rs.getDate("NGAYDK"));
            dsdk.add(dkmuon);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return dsdk;
    }
    public List<DKMuon> searchDSByTenDG(String query) throws SQLException {
        List <DKMuon> dsdk = new ArrayList<DKMuon>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT D.*, DG.HOTEN FROM DANGKYMUONSACH D JOIN DOCGIA DG ON D.MADOCGIA = DG.MADOCGIA WHERE D.MADK LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
        String searchQuery = "%" + query + "%";
        ps.setString(1, searchQuery);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            DKMuon dkmuon = new DKMuon();
            dkmuon.setMaDK(rs.getString("MADK"));
            dkmuon.setMaDG(rs.getString("MADOCGIA"));
            dkmuon.setHoTen(rs.getString("HOTEN"));
            dkmuon.setNgayDK(rs.getDate("NGAYDK"));
            dsdk.add(dkmuon);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return dsdk;
    }
}
   
        
     
   
   
   
    
    
    

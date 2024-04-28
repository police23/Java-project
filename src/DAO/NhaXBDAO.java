/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhaXB;
import JDBCConnection.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class NhaXBDAO {
    public List <NhaXB> getAllNXB() {
        List <NhaXB> nxbs = new ArrayList<NhaXB>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM NHAXUATBAN";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhaXB nxb = new NhaXB();
                nxb.setMaNXB(rs.getString("MANXB"));
                nxb.setTenNXB(rs.getString("TENNXB"));
                nxb.setDiaChi(rs.getString("DIACHI"));
                nxb.setSDT(rs.getString("SODT"));
                nxbs.add(nxb);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return nxbs;
    }
    

    public void addNXB (NhaXB nxb) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO NHAXUATBAN(TENNXB, DIACHI, SODT) VALUES (?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            //pst.setString(1,nxb.getMaNXB());
            pst.setString(1,nxb.getTenNXB());
            pst.setString(2,nxb.getDiaChi());
            pst.setString(3,nxb.getSDT());
            
            int rs = pst.executeUpdate();
            System.out.println(rs);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteNXB( String ID) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM NHAXUATBAN WHERE MANXB = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,ID);
            int rs = pst.executeUpdate();
            System.out.println(rs);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateNXB(NhaXB nxb) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE NHAXUATBAN SET TENNXB = ?, DIACHI = ?, SODT = ? WHERE MANXB = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nxb.getTenNXB());
            pst.setString(2, nxb.getDiaChi());
            pst.setString(3, nxb.getSDT());
            pst.setString(4, nxb.getMaNXB());
            int rs = pst.executeUpdate();
            System.out.println(rs);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<NhaXB> searchNXBByID(String query) {
    List<NhaXB> nxbs = new ArrayList<NhaXB>();
    Connection conn = JDBCConnection.getJDBCConnection();
    String sql = "SELECT * FROM NHAXUATBAN WHERE MANXB LIKE ?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        String searchQuery = "%" + query + "%"; // The '%' is a wildcard character that matches any number of characters
        ps.setString(1, searchQuery);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            NhaXB nxb = new NhaXB();
            nxb.setMaNXB(rs.getString("MANXB"));
            nxb.setTenNXB(rs.getString("TENNXB"));
            nxb.setDiaChi(rs.getString("DIACHI"));
            nxb.setSDT(rs.getString("SODT"));
            nxbs.add(nxb);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return nxbs;
}
    public List<NhaXB> searchNXBByName(String query) {
    List<NhaXB> nxbs = new ArrayList<NhaXB>();
    Connection conn = JDBCConnection.getJDBCConnection();
    String sql = "SELECT * FROM NHAXUATBAN WHERE TENNXB LIKE ?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        String searchQuery = "%" + query + "%"; // The '%' is a wildcard character that matches any number of characters
        ps.setString(1, searchQuery);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            NhaXB nxb = new NhaXB();
            nxb.setMaNXB(rs.getString("MANXB"));
            nxb.setTenNXB(rs.getString("TENNXB"));
            nxb.setDiaChi(rs.getString("DIACHI"));
            nxb.setSDT(rs.getString("SODT"));
            nxbs.add(nxb);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return nxbs;
}
    public List<NhaXB> searchNXBByAddress(String query) {
    List<NhaXB> nxbs = new ArrayList<NhaXB>();
    Connection conn = JDBCConnection.getJDBCConnection();
    String sql = "SELECT * FROM NHAXUATBAN WHERE DIACHI LIKE ?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        String searchQuery = "%" + query + "%"; // The '%' is a wildcard character that matches any number of characters
        ps.setString(1, searchQuery);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            NhaXB nxb = new NhaXB();
            nxb.setMaNXB(rs.getString("MANXB"));
            nxb.setTenNXB(rs.getString("TENNXB"));
            nxb.setDiaChi(rs.getString("DIACHI"));
            nxb.setSDT(rs.getString("SODT"));
            nxbs.add(nxb);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return nxbs;
}
    public List<NhaXB> searchNXBByPhone(String query) {
    List<NhaXB> nxbs = new ArrayList<NhaXB>();
    Connection conn = JDBCConnection.getJDBCConnection();
    String sql = "SELECT * FROM NHAXUATBAN WHERE SODT LIKE ?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        String searchQuery = "%" + query + "%"; // The '%' is a wildcard character that matches any number of characters
        ps.setString(1, searchQuery);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            NhaXB nxb = new NhaXB();
            nxb.setMaNXB(rs.getString("MANXB"));
            nxb.setTenNXB(rs.getString("TENNXB"));
            nxb.setDiaChi(rs.getString("DIACHI"));
            nxb.setSDT(rs.getString("SODT"));
            nxbs.add(nxb);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return nxbs;
}

    
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhaXB;
import JDBCConnection.JDBCConnection;
import java.sql.CallableStatement;
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
        String sql = "{call ThemNXB(?,?,?)}";
        try {
            CallableStatement cst = conn.prepareCall(sql);
            //pst.setString(1,nxb.getMaNXB());
            cst.setString(1,nxb.getTenNXB());
            cst.setString(2,nxb.getDiaChi());
            cst.setString(3,nxb.getSDT());
            
            int rs = cst.executeUpdate();
            System.out.println(rs);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn != null) conn.close(); // Đóng kết nối
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void deleteNXB( String ID) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "{call XoaNXB(?)}";
        try (CallableStatement cst = conn.prepareCall(sql)) {
            cst.setString(1, ID); 
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
    public void updateNXB(NhaXB nxb) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "{call CapNhatNXB(?, ?, ?, ?)}";
        try (CallableStatement cst = conn.prepareCall(sql)) {
            cst.setString(1, nxb.getMaNXB());
            cst.setString(2, nxb.getTenNXB());
            cst.setString(3, nxb.getDiaChi());
            cst.setString(4, nxb.getSDT());
            int rs = cst.executeUpdate();
            System.out.println(rs);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
         finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public List<NhaXB> searchNXBByID(String query) {
    List<NhaXB> nxbs = new ArrayList<NhaXB>();
    Connection conn = JDBCConnection.getJDBCConnection();
    String sql = "SELECT * FROM NHAXUATBAN WHERE MANXB LIKE ?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        String searchQuery = "%" + query + "%"; 
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
    public boolean checkNXBReferences(String MaNXB) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean hasReferences = false;

        try {
            conn = JDBCConnection.getJDBCConnection(); // Thay thế YourDatabaseConnection bằng phương thức kết nối của bạn

            String sql = "SELECT COUNT(*) FROM SACH WHERE MANXB = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, MaNXB);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    hasReferences = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và các đối tượng liên quan
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return hasReferences;
    }
    public NhaXB getNXBByMa(String maNXB) {
    for (NhaXB nxb : getAllNXB()) {
        if (nxb.getMaNXB().equals(maNXB)) {
            return nxb;
        }
    }
    return null; 
}
}



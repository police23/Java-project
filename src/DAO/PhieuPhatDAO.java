/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhieuPhat;
import JDBCConnection.JDBCConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypeMetaData.Struct;
import oracle.jdbc.datasource.OracleDataSource;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
/**
 *
 * @author VINH
 */
public class PhieuPhatDAO {
    public List <PhieuPhat> getAllPhieuPhat() {
        List <PhieuPhat> pps = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT PP.* FROM PHIEUPHAT PP";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuPhat pp = new PhieuPhat();
                pp.setMaPP(rs.getString("MAPHIEUPHAT"));
                pp.setMaTT(rs.getString("MATHUTHU"));
                pp.setMaDG(rs.getString("MADOCGIA"));
                pp.setNgayLap(rs.getDate("NGAYPHAT"));
                pps.add(pp);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return pps;
        }
public void addPhieuPhat(PhieuPhat pp, List<PhieuPhat.CTPhieuPhat> SachPhatArray) {
    Connection conn = JDBCConnection.getJDBCConnection();
    CallableStatement cstmt = null;

    try {
        // Create a CallableStatement object.
        String SQL = "{call THEMPHIEUPHAT_PROC(?,?,?,?)}"; //TAO MOI PROCEDURE PHIEU PHAT
        cstmt = conn.prepareCall(SQL);

        cstmt.setString(1, pp.getMaTT());
        cstmt.setString(2, pp.getMaDG());
        cstmt.setDate(3, new java.sql.Date(pp.getNgayLap().getTime()));

        // Create the descriptor for the nested object type
        StructDescriptor structDescriptor = StructDescriptor.createDescriptor("SACH_PHAT", conn);
        STRUCT[] structArray = new STRUCT[SachPhatArray.size()];

        // Convert list of CTPhieuPhat to STRUCT array
        for (int i = 0; i < SachPhatArray.size(); i++) {
            PhieuPhat.CTPhieuPhat ctPhieuPhat = SachPhatArray.get(i);
            Object[] attributes = new Object[] {
                ctPhieuPhat.getMaSach(),
                ctPhieuPhat.getTenSach(),
                ctPhieuPhat.getTienPhat(),
                ctPhieuPhat.getLiDo()
            };
            structArray[i] = new STRUCT(structDescriptor, conn, attributes);
        }

        // Create the array descriptor for the array of objects
        ArrayDescriptor arrayDescriptor = ArrayDescriptor.createDescriptor("SACH_PHAT_LIST", conn);
        ARRAY array = new ARRAY(arrayDescriptor, conn, structArray);

        cstmt.setArray(4, array);
        cstmt.execute();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } 
}
    public void deletePhieuPhat(String maPP)  {
        Connection conn = JDBCConnection.getJDBCConnection();
        CallableStatement cstmt = null;
    try {
        
        String SQL = "{call XOAPHIEUPHAT_PROC(?)}"; 
        cstmt = conn.prepareCall(SQL);
        cstmt.setString(1, maPP);  
        cstmt.execute();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } 
    }
    
    public PhieuPhat getPhieuPhatByID(String ID) {
            for (PhieuPhat pt : getAllPhieuPhat()) {
                if (pt.getMaPP().equals(ID)) {
                    return pt;
                }
            }
            return null;
        }
    
    public List <PhieuPhat> searchPhieuPhatByID(String query) {
        List <PhieuPhat> pps = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT PP.* FROM PHIEUPHAT PP WHERE MAPHIEUPHAT LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            String searchQuery = "%" + query + "%"; 
            ps.setString(1, searchQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuPhat pp = new PhieuPhat();
                pp.setMaPP(rs.getString("MAPHIEUPHAT"));
                pp.setMaTT(rs.getString("MATHUTHU"));
                pp.setMaDG(rs.getString("MADOCGIA"));
                pp.setNgayLap(rs.getDate("NGAYPHAT"));
                pps.add(pp);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return pps;
        }
    
    public List <PhieuPhat> searchPhieuPhatByMaDG(String query) {
        List <PhieuPhat> pps = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT PP.* FROM PHIEUPHAT PP WHERE MADOCGIA LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            String searchQuery = "%" + query + "%"; 
            ps.setString(1, searchQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuPhat pp = new PhieuPhat();
                pp.setMaPP(rs.getString("MAPHIEUPHAT"));
                pp.setMaTT(rs.getString("MATHUTHU"));
                pp.setMaDG(rs.getString("MADOCGIA"));
                pp.setNgayLap(rs.getDate("NGAYPHAT"));
                pps.add(pp);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return pps;
        }
    
    public List <PhieuPhat.CTPhieuPhat> getCTPP(String maPP) {
        List <PhieuPhat.CTPhieuPhat> ds = new ArrayList<>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT PP.*, CT.*, S.TENSACH "+
                     "FROM PHIEUPHAT PP "+
                     "JOIN CTPHIEUPHAT CT ON CT.MAPHIEUPHAT = PP.MAPHIEUPHAT "+ 
                     "JOIN SACH S ON S.MASACH = CT.MASACH " +
                     "WHERE PP.MAPHIEUPHAT = ?";
         
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,maPP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PhieuPhat.CTPhieuPhat ctpp = new PhieuPhat.CTPhieuPhat(
                rs.getString("MASACH"),
                rs.getString("TENSACH"),
                rs.getDouble("TIENPHAT"),
                rs.getInt("LIDO")
            );
                ds.add(ctpp);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            
            }
        return ds;
    }
    public double tinhTienPhatTraTre(String maSach, String maDG) {
        Connection conn = JDBCConnection.getJDBCConnection();
        CallableStatement cstmt = null;
        double tienPhat = 0;
    try {
        // Create a CallableStatement object.
        String SQL = "{? = call TINH_TIENPHAT_TRE_FUNC(?,?)}"; 
        cstmt = conn.prepareCall(SQL);
        
        // Đăng ký kiểu dữ liệu trả về
        cstmt.registerOutParameter(1, Types.NUMERIC);
        // Đặt giá trị cho tham số đầu vào
        cstmt.setString(2, maSach);
        cstmt.setString(3, maDG);
        cstmt.execute();
        
        // Lấy kết quả trả về
        tienPhat = cstmt.getDouble(1);
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return tienPhat;
    }
    
    public int tinhSoNgayTraTre(String maSach, String maDG) {
        Connection conn = JDBCConnection.getJDBCConnection();
        CallableStatement cstmt = null;
        int songaytre = 0;
    try {
        // Create a CallableStatement object.
        String SQL = "{? = call TINH_SO_NGAY_TRA_TRE_FUNC(?,?)}"; 
        cstmt = conn.prepareCall(SQL);
        
        // Đăng ký kiểu dữ liệu trả về
        cstmt.registerOutParameter(1, Types.INTEGER);
        // Đặt giá trị cho tham số đầu vào
        cstmt.setString(2, maSach);
        cstmt.setString(3, maDG);
        cstmt.execute();
        
        // Lấy kết quả trả về
        songaytre = cstmt.getInt(1);
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return songaytre;
    }
    
    public double tinhTienPhatMatSach(String maSach) {
        Connection conn = JDBCConnection.getJDBCConnection();
        CallableStatement cstmt = null;
        double tienPhat = 0;
    try {
        // Create a CallableStatement object.
        String SQL = "{? = call TINH_TIENPHAT_MAT_SACH_FUNC(?)}"; 
        cstmt = conn.prepareCall(SQL);
        
        // Đăng ký kiểu dữ liệu trả về
        cstmt.registerOutParameter(1, Types.NUMERIC);
        // Đặt giá trị cho tham số đầu vào
        cstmt.setString(2, maSach);
        cstmt.execute();
        
        // Lấy kết quả trả về
        tienPhat = cstmt.getDouble(1);
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return tienPhat;
    }

}


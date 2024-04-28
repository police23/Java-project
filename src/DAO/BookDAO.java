/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Book;
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
public class BookDAO {
    public List <Book> getAllBooks() {
        List <Book> books = new ArrayList<Book>();
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "SELECT S.*, T.TENTHELOAI, N.TENNXB " +
                 "FROM SACH S " +
                 "JOIN THELOAI T ON S.MATHELOAI = T.MATHELOAI " +
                 "JOIN NHAXUATBAN N ON S.MANXB = N.MANXB";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book bo = new Book();
                bo.setMaSach(rs.getString("MASACH"));
                bo.setTenSach(rs.getString("TENSACH"));
                bo.setTacGia(rs.getString("TACGIA"));
                bo.setSoLuong(rs.getInt("SOLUONG"));
                bo.setMaNXB(rs.getString("MANXB"));
                bo.setNXB(rs.getString("TENNXB"));
                bo.setNamXB(rs.getInt("NAMXB"));
                bo.setMaTheLoai(rs.getString("MATHELOAI"));
                bo.setTheLoai(rs.getString("TENTHELOAI"));
                bo.setSoTrang(rs.getInt("SOTRANG"));
                bo.setMoTa(rs.getString("MOTA"));
                bo.setGia(rs.getInt("GIA"));
                books.add(bo);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return books;
    }
    

    public void addBook (Book bo) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO SACH(MASACH,TENSACH,TACGIA,MATHELOAI, MANXB, NAMXB, SOTRANG,SOLUONG, GIA, MOTA) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,bo.getMaSach());
            pst.setString(2,bo.getTenSach());
            pst.setString(3,bo.getTacGia());
            pst.setString(4,bo.getMaTheLoai());
            pst.setString(5,bo.getMaNXB());
            pst.setInt(6,bo.getNamXB());
            pst.setInt(7,bo.getSoTrang());
            pst.setInt(8,bo.getSoLuong());
            pst.setInt(9,bo.getGia());
            pst.setString(10,bo.getMoTa());
            int rs = pst.executeUpdate();
            System.out.println(rs);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteBook( String ID) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM SACH WHERE MASACH = ?";
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
    public void updateBook(Book bo) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String sql = "UPDATE SACH SET MASACH = ?, TENSACH = ?, TACGIA = ?, MATHELOAI = ?, MANXB = ?, NAMXB = ?, SOTRANG = ?, SOLUONG = ?, GIA = ?, MOTA = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,bo.getMaSach());
            pst.setString(2,bo.getTenSach());
            pst.setString(3,bo.getTacGia());
            pst.setString(4, bo.getMaTheLoai());
            pst.setString(5,bo.getMaNXB());
            pst.setInt(6,bo.getNamXB());
            pst.setInt(7,bo.getSoTrang());
            pst.setInt(8,bo.getSoLuong());
            pst.setInt(9,bo.getGia());
            pst.setString(10,bo.getMoTa());
            int rs = pst.executeUpdate();
            System.out.println(rs);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Book> searchBookByID(String query) {
    List<Book> bks = new ArrayList<Book>();
    Connection conn = JDBCConnection.getJDBCConnection();
    String sql = "SELECT S.*, TENTHELOAI, TENNXB " +
                 "FROM SACH S " +
                 "JOIN THELOAI T ON S.MATHELOAI = T.MATHELOAI " +
                 "JOIN NHAXUATBAN N ON S.MANXB = N.MANXB " +
                 "WHERE MASACH LIKE ?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        String searchQuery = "%" + query + "%"; // The '%' is a wildcard character that matches any number of characters
        ps.setString(1, searchQuery);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Book bk = new Book();
            bk.setMaSach(rs.getString("MASACH"));
            bk.setTenSach(rs.getString("TENSACH"));
            bk.setMaTheLoai(rs.getString("MATHELOAI"));
            bk.setTheLoai(rs.getString("TENTHELOAI"));
            bk.setTacGia(rs.getString("TACGIA"));
            bk.setMaNXB(rs.getString("MANXB"));
            bk.setNXB(rs.getString("TENNXB"));
            bk.setNamXB(rs.getInt("NAMXB"));
            bk.setSoLuong(rs.getInt("SOLUONG"));
            bk.setSoTrang(rs.getInt("SOTRANG"));
            bk.setGia(rs.getInt("GIA"));
            bk.setMoTa(rs.getString("MOTA"));
            bks.add(bk);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return bks;
}
    public List<Book> searchBookByName(String query) {
    List<Book> bks = new ArrayList<Book>();
    Connection conn = JDBCConnection.getJDBCConnection();
    String sql = "SELECT S.*, TENTHELOAI, TENNXB " +
                 "FROM SACH S " +
                 "JOIN THELOAI T ON S.MATHELOAI = T.MATHELOAI " +
                 "JOIN NHAXUATBAN N ON S.MANXB = N.MANXB " +
                 "WHERE TENSACH LIKE ?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        String searchQuery = "%" + query + "%"; // The '%' is a wildcard character that matches any number of characters
        ps.setString(1, searchQuery);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Book bk = new Book();
            bk.setMaSach(rs.getString("MASACH"));
            bk.setTenSach(rs.getString("TENSACH"));
            bk.setMaTheLoai(rs.getString("MATHELOAI"));
            bk.setTheLoai(rs.getString("TENTHELOAI"));
            bk.setTacGia(rs.getString("TACGIA"));
            bk.setMaNXB(rs.getString("MANXB"));
            bk.setNXB(rs.getString("TENNXB"));
            bk.setNamXB(rs.getInt("NAMXB"));
            bk.setSoLuong(rs.getInt("SOLUONG"));
            bk.setSoTrang(rs.getInt("SOTRANG"));
            bk.setGia(rs.getInt("GIA"));
            bk.setMoTa(rs.getString("MOTA"));
            bks.add(bk);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return bks;
}
    
    public List<Book> searchBookByCategory(String query) {
    List<Book> bks = new ArrayList<Book>();
    Connection conn = JDBCConnection.getJDBCConnection();
    String sql = "SELECT S.*, TENTHELOAI, TENNXB " +
                 "FROM SACH S " +
                 "JOIN THELOAI T ON S.MATHELOAI = T.MATHELOAI " +
                 "JOIN NHAXUATBAN N ON S.MANXB = N.MANXB " +
                 "WHERE TENTHELOAI LIKE ?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        String searchQuery = "%" + query + "%"; // The '%' is a wildcard character that matches any number of characters
        ps.setString(1, searchQuery);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Book bk = new Book();
            bk.setMaSach(rs.getString("MASACH"));
            bk.setTenSach(rs.getString("TENSACH"));
            bk.setMaTheLoai(rs.getString("MATHELOAI"));
            bk.setTheLoai(rs.getString("TENTHELOAI"));
            bk.setTacGia(rs.getString("TACGIA"));
            bk.setMaNXB(rs.getString("MANXB"));
            bk.setNXB(rs.getString("TENNXB"));
            bk.setNamXB(rs.getInt("NAMXB"));
            bk.setSoLuong(rs.getInt("SOLUONG"));
            bk.setSoTrang(rs.getInt("SOTRANG"));
            bk.setGia(rs.getInt("GIA"));
            bk.setMoTa(rs.getString("MOTA"));
            bks.add(bk);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return bks;
}
    public List<Book> searchBookByAuthor(String query) {
    List<Book> bks = new ArrayList<Book>();
    Connection conn = JDBCConnection.getJDBCConnection();
    String sql = "SELECT S.*, TENTHELOAI, TENNXB " +
                 "FROM SACH S " +
                 "JOIN THELOAI T ON S.MATHELOAI = T.MATHELOAI " +
                 "JOIN NHAXUATBAN N ON S.MANXB = N.MANXB " +
                 "WHERE TACGIA LIKE ?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        String searchQuery = "%" + query + "%"; // The '%' is a wildcard character that matches any number of characters
        ps.setString(1, searchQuery);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Book bk = new Book();
            bk.setMaSach(rs.getString("MASACH"));
            bk.setTenSach(rs.getString("TENSACH"));
            bk.setMaTheLoai(rs.getString("MATHELOAI"));
            bk.setTheLoai(rs.getString("TENTHELOAI"));
            bk.setTacGia(rs.getString("TACGIA"));
            bk.setMaNXB(rs.getString("MANXB"));
            bk.setNXB(rs.getString("TENNXB"));
            bk.setNamXB(rs.getInt("NAMXB"));
            bk.setSoLuong(rs.getInt("SOLUONG"));
            bk.setSoTrang(rs.getInt("SOTRANG"));
            bk.setGia(rs.getInt("GIA"));
            bk.setMoTa(rs.getString("MOTA"));
            bks.add(bk);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return bks;
    }
   
    public String getMaTheLoaiByTen(String tenTheLoai) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String maTheLoai = null;
        String sql = "SELECT MATHELOAI FROM THELOAI WHERE TENTHELOAI = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenTheLoai);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maTheLoai = rs.getString("MATHELOAI");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maTheLoai;
    }
    public String getMaNXBByTen(String tenNXB) {
        Connection conn = JDBCConnection.getJDBCConnection();
        String maNXB = null;
        String sql = "SELECT MANXB FROM NHAXUATBAN WHERE TENNXB = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenNXB);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maNXB = rs.getString("MANXB");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maNXB;
    }
}
    
   

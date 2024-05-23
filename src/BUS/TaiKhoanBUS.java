/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoan;
import java.sql.*;
import java.util.List;
/**
 *
 * @author VINH
 */
public class TaiKhoanBUS {

    private TaiKhoanDAO TaiKhoanDAO;

    public TaiKhoanBUS() {
        this.TaiKhoanDAO = new TaiKhoanDAO();
    }
    public TaiKhoan getThongTinTK(String maND) throws SQLException  {
        return TaiKhoanDAO.getThongTinTK(maND);      
    }
    public List<TaiKhoan> getAllTaiKhoans() {
        return TaiKhoanDAO.getAllTaiKhoans();
    }
    public void addTaiKhoan(TaiKhoan tk) {
        TaiKhoanDAO.addTaiKhoan(tk);
    }
    public void updateTaiKhoan(TaiKhoan tk) {
        TaiKhoanDAO.updateTaiKhoan(tk);
    }
    public void deleteTaiKhoan(String MaTK) {
        TaiKhoanDAO.deleteTaiKhoan(MaTK);
    }
}

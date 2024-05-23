/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;


import DAO.PhieuTraDAO;
import DTO.PhieuTra;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author VINH
 */
public class PhieuTraBUS {
    private PhieuTraDAO PhieuTraDAO;
    
    public PhieuTraBUS() {
        PhieuTraDAO = new PhieuTraDAO();
    }
    public List <PhieuTra> getAllPhieuTra() {
        return PhieuTraDAO.getAllPhieuTra();
    }
    public void addPhieuTra(PhieuTra pt, String[] maSachArray) {
        PhieuTraDAO.addPhieuTra(pt, maSachArray);
    }
    public void deletePhieuTra(String maPT) {
        PhieuTraDAO.deletePhieuTra(maPT);
    }
//    public void updatePhieuTra(PhieuMuon pt) {
//        PhieuTraDAO.updatePhieuTra(pt);
//    }
    public PhieuTra getPhieuTraByID(String ID) {
        return PhieuTraDAO.getPhieuTraByID(ID);
    }
    public List <PhieuTra.CTPhieuTra> getCTPT(String maPT) {
        return PhieuTraDAO.getCTPT(maPT);
    }
    public List <PhieuTra> searchPhieuTraByID(String query) {
        return PhieuTraDAO.searchPhieuTraByID(query);
    }
    public List <PhieuTra> searchPhieuTraByMaDG(String query) {
        return PhieuTraDAO.searchPhieuTraByMaDG(query);
    }
}

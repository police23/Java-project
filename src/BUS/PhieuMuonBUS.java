/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhieuMuonDAO;
import DTO.PhieuMuon;
import DTO.PhieuMuon.CTPhieuMuon;
import java.util.List;
import java.sql.*;

/**
 *
 * @author User
 */
public class PhieuMuonBUS {
    private PhieuMuonDAO PhieuMuonDAO;
    
    public PhieuMuonBUS() {
        PhieuMuonDAO = new PhieuMuonDAO();
    }
    public List <PhieuMuon> getAllPhieuMuon() {
        return PhieuMuonDAO.getAllPhieuMuon();
    }
    public void addPhieuMuon(PhieuMuon pm, String[] maSachArray) {
        PhieuMuonDAO.addPhieuMuon(pm, maSachArray);
    }
    public void deletePhieuMuon(String maPM) throws SQLException {
        PhieuMuonDAO.deletePhieuMuon(maPM);
    }
    public void updatePhieuMuon(PhieuMuon pm) {
        PhieuMuonDAO.updatePhieuMuon(pm);
    }
    public PhieuMuon getPhieuMuonByID(String ID) {
        return PhieuMuonDAO.getPhieuMuonByID(ID);
    }
    public List <CTPhieuMuon> getCTPM(String maPM) {
        return PhieuMuonDAO.getCTPM(maPM);
    }
    public List <PhieuMuon> searchPhieuMuonByID(String query) {
        return PhieuMuonDAO.searchPhieuMuonByID(query);
    }
    public List <PhieuMuon> searchPhieuMuonByMaDG(String query) {
        return PhieuMuonDAO.searchPhieuMuonByMaDG(query);
    }
}

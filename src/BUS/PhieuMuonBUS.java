/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhieuMuonDAO;
import DTO.PhieuMuon;
import java.util.List;

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
    public void addPhieuMuon(PhieuMuon pm) {
        PhieuMuonDAO.addPhieuMuon(pm);
    }
    public void deletePhieuMuon(String ID) {
        PhieuMuonDAO.deletePhieuMuon(ID);
    }
    public void updatePhieuMuon(PhieuMuon pm) {
        PhieuMuonDAO.updatePhieuMuon(pm);
    }
    public List <PhieuMuon> searchPhieuMuonByID() {
        return PhieuMuonDAO.searchPhieuMuonByID();
    }
    public List <PhieuMuon> searchPhieuMuonByMaDG() {
        return PhieuMuonDAO.searchPhieuMuonByMaDG();
    }
}

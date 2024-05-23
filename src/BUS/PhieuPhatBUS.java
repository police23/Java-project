/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.PhieuPhatDAO;
import DTO.PhieuPhat;
import java.util.List;

/**
 *
 * @author VINH
 */
public class PhieuPhatBUS {
    private PhieuPhatDAO PhieuPhatDAO;
    
    public PhieuPhatBUS() {
        PhieuPhatDAO = new PhieuPhatDAO();
    }
    public List <PhieuPhat> getAllPhieuPhat() {
        return PhieuPhatDAO.getAllPhieuPhat();
    }
    public void addPhieuPhat(PhieuPhat pp, List<PhieuPhat.CTPhieuPhat> maSachArray) {
        PhieuPhatDAO.addPhieuPhat(pp, maSachArray);
    }
    public void deletePhieuPhat(String maPP) {
        PhieuPhatDAO.deletePhieuPhat(maPP);
    }
//    public void updatePhieuTra(PhieuMuon pt) {
//        PhieuTraDAO.updatePhieuTra(pt);
//    }
    public PhieuPhat getPhieuPhatByID(String ID) {
        return PhieuPhatDAO.getPhieuPhatByID(ID);
    }
    public List <PhieuPhat.CTPhieuPhat> getCTPP(String maPP) {
        return PhieuPhatDAO.getCTPP(maPP);
    }
    public List <PhieuPhat> searchPhieuPhatByID(String query) {
        return PhieuPhatDAO.searchPhieuPhatByID(query);
    }
    public List <PhieuPhat> searchPhieuPhatByMaDG(String query) {
        return PhieuPhatDAO.searchPhieuPhatByMaDG(query);
    }
    public int tinhSoNgayTraTre(String maSach, String maDG) {
        return PhieuPhatDAO.tinhSoNgayTraTre(maSach, maDG);
    }
}

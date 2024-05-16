/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DKMuonDAO;
import DTO.Book;
import DTO.DKMuon;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class DKMuonBUS {
    private DKMuonDAO DKMuonDAO;

    public DKMuonBUS() {
        DKMuonDAO = new DKMuonDAO();
    }
    public List<DKMuon> getDSDK() throws SQLException {
        return DKMuonDAO.getDSDK();
    }

    public void addDK(DKMuon dkMuon, String[] maSachArray) throws SQLException {
        DKMuonDAO.addDK(dkMuon, maSachArray);
    }
    public void deleteDK(String maDG, String[] maSachArray) throws SQLException { 
        DKMuonDAO.HuyDK(maDG, maSachArray);
    }
    public void XacNhanChoMuon(String MaDK, String MaTT) throws SQLException {
        DKMuonDAO.XacNhanChoMuon(MaDK, MaTT);
    }
    public List<Book> getSachDaDK(DKMuon dkMuon) throws SQLException {
        return DKMuonDAO.getSachDaDK(dkMuon);
    }
    public List <DKMuon> searchDSByID(String query) throws SQLException {
        return DKMuonDAO.searchDSByID(query);
    }
    public List <DKMuon> searchDSByMaDG(String query) throws SQLException {
        return DKMuonDAO.searchDSByMaDG(query);
}
    public List <DKMuon> searchDSByTenDG(String query) throws SQLException {
        return DKMuonDAO.searchDSByTenDG(query);
    
}
}

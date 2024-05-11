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
    private DKMuonDAO dkMuonDAO;

    public DKMuonBUS() {
        dkMuonDAO = new DKMuonDAO();
    }
    public List<DKMuon> getDSDK() throws SQLException {
        return dkMuonDAO.getDSDK();
    }

    public void addDK(DKMuon dkMuon, String[] maSachArray) throws SQLException {
        dkMuonDAO.addDK(dkMuon, maSachArray);
    }
    public void deleteDK(String maDG, String[] maSachArray) throws SQLException { 
        dkMuonDAO.HuyDK(maDG, maSachArray);
    }
    public List<Book> getSachDaDK(DKMuon dkMuon) throws SQLException {
        return dkMuonDAO.getSachDaDK(dkMuon);
}
    public List <DKMuon> searchDSByID(String query) throws SQLException {
        return dkMuonDAO.searchDSByID(query);
    }
    public List <DKMuon> searchDSByMaDG(String query) throws SQLException {
        return dkMuonDAO.searchDSByMaDG(query);
    
}
    public List <DKMuon> searchDSByTenDG(String query) throws SQLException {
        return dkMuonDAO.searchDSByTenDG(query);
    
}
}

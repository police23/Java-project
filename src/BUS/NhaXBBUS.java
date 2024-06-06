/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhaXBDAO;
import DTO.NhaXB;

import java.util.List;

/**
 *
 * @author User
 */
public class NhaXBBUS {
    private NhaXBDAO NhaXBDAO;
    
    public NhaXBBUS() {
        NhaXBDAO = new NhaXBDAO();
    }
    
    
    public List<NhaXB> getAllNXB() {
        return NhaXBDAO.getAllNXB();
    }
    public void addNXB(NhaXB nxb) {
        NhaXBDAO.addNXB(nxb);
    }
    public boolean checkNXBIdExists(String id) {
        List<NhaXB> nxbs = getAllNXB(); 
        for (NhaXB nxb : nxbs) {
            if (nxb.getMaNXB().equals(id)) {
                return true;
            }
        }
        return false; 
}

    public void deleteNXB(String id) {
        NhaXBDAO.deleteNXB(id);
    }
    public void updateNXB(NhaXB nxb) {
        NhaXBDAO.updateNXB(nxb);
    }
    public List<NhaXB> searchNXBByID(String query) {
        return NhaXBDAO.searchNXBByID(query);
    }
    public List<NhaXB> searchNXBByName(String query) {
        return NhaXBDAO.searchNXBByName(query);
    }
    public List<NhaXB> searchNXBByAddress(String query) {
        return NhaXBDAO.searchNXBByAddress(query);
}
    public List<NhaXB> searchNXBByPhone(String query) {
        return NhaXBDAO.searchNXBByPhone(query);
}
    public boolean checkNXBReferences(String MaNXB) {
        return NhaXBDAO.checkNXBReferences(MaNXB);
    }
     public boolean checkTenNXBExists(String tenNXB) {
        return NhaXBDAO.checkTenNXBExists(tenNXB);
     }
     public NhaXB getNXBByMa(String maNXB) {
         return NhaXBDAO.getNXBByMa(maNXB);
    }
    
}
    

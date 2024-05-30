package BUS;

import DAO.BaoCaoTKDAO;
import DTO.BaoCaoTK.DocGiaTraTreSachDTO;
import DTO.BaoCaoTK.LuotMuonSachTheoThangVaTheLoaiDTO;
import DTO.BaoCaoTK.Top5SachCoNhieuLuotMuonDTO;

import java.util.List;

public class BaoCaoTKBUS {
    private BaoCaoTKDAO baoCaoTKDAO;

    public BaoCaoTKBUS() {
        this.baoCaoTKDAO = new BaoCaoTKDAO();
    }

    public List<LuotMuonSachTheoThangVaTheLoaiDTO> getLuotMuonSachTheoThangVaTheLoai(int thang) {
        return baoCaoTKDAO.getLuotMuonSachTheoThangVaTheLoai(thang);
    }

    public List<Top5SachCoNhieuLuotMuonDTO> getTop5SachCoNhieuLuotMuon(int thang) {
        return baoCaoTKDAO.getTop5SachCoNhieuLuotMuon(thang);
    }
    
    public List<DocGiaTraTreSachDTO> getDocGiaTraTreSach() {
        return baoCaoTKDAO.getDocGiaTraTreSach();
    }
}
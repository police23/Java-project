package DTO;

public class BaoCaoTK {
    
    public static class LuotMuonSachTheoThangVaTheLoaiDTO {
        private String MatheLoai;
        private String TentheLoai;
        private String thang;
        private int soLuotMuon;

        public LuotMuonSachTheoThangVaTheLoaiDTO() {
        }

        public LuotMuonSachTheoThangVaTheLoaiDTO(String MatheLoai, String TentheLoai, String thang, int soLuotMuon) {
            this.MatheLoai = MatheLoai;
            this.TentheLoai = TentheLoai;
            this.thang = thang;
            this.soLuotMuon = soLuotMuon;
        }

        // Getters and Setters
        public String getMaTheLoai() {
            return MatheLoai;
        }
        
        public String getTenTheLoai() {
            return TentheLoai;
        }

        public void setMaTheLoai(String MatheLoai) {
            this.MatheLoai = MatheLoai;
        }
        
        public void setTenTheLoai(String TentheLoai) {
            this.TentheLoai = TentheLoai;
        }

        public String getThang() {
            return thang;
        }

        public void setThang(String thang) {
            this.thang = thang;
        }

        public int getSoLuotMuon() {
            return soLuotMuon;
        }

        public void setSoLuotMuon(int soLuotMuon) {
            this.soLuotMuon = soLuotMuon;
        }
    }

    public static class Top5SachCoNhieuLuotMuonDTO {
        private String maSach;
        private String tenSach;
        private String thang;
        private int soLuotMuon;

        public Top5SachCoNhieuLuotMuonDTO() {
        }

        public Top5SachCoNhieuLuotMuonDTO(String maSach, String tenSach, String thang, int soLuotMuon) {
            this.maSach = maSach;
            this.tenSach = tenSach;
            this.thang = thang;
            this.soLuotMuon = soLuotMuon;
        }

        // Getters and Setters
        public String getMaSach() {
            return maSach;
        }

        public void setMaSach(String maSach) {
            this.maSach = maSach;
        }

        public String getTenSach() {
            return tenSach;
        }

        public void setTenSach(String tenSach) {
            this.tenSach = tenSach;
        }

        public String getThang() {
            return thang;
        }

        public void setThang(String thang) {
            this.thang = thang;
        }

        public int getSoLuotMuon() {
            return soLuotMuon;
        }

        public void setSoLuotMuon(int soLuotMuon) {
            this.soLuotMuon = soLuotMuon;
        }
    }
}

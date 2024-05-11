/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author User
 */
public class PhieuMuon {
    private String MaPM;
    private String MaTT;
    private String HoTenTT;
    private String MaDG;
    private String HoTenDG;
    private Date NgayLap;
    private Date HanTra;
    private String MaSach;
    private String TenSach;
    private int MaTrangThai;
    private String TrangThai;

    public PhieuMuon() {
    }

    public PhieuMuon(String MaPM, String MaTT, String HoTenTT, String MaDG, String HoTenDG, Date NgayLap, Date HanTra, String MaSach, String TenSach, int MaTrangThai, String TrangThai) {
        this.MaPM = MaPM;
        this.MaTT = MaTT;
        this.HoTenTT = HoTenTT;
        this.MaDG = MaDG;
        this.HoTenDG = HoTenDG;
        this.NgayLap = NgayLap;
        this.HanTra = HanTra;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.MaTrangThai = MaTrangThai;
        this.TrangThai = TrangThai;
    }

    public String getMaPM() {
        return MaPM;
    }

    public void setMaPM(String MaPM) {
        this.MaPM = MaPM;
    }

    public String getMaTT() {
        return MaTT;
    }

    public void setMaTT(String MaTT) {
        this.MaTT = MaTT;
    }

    public String getHoTenTT() {
        return HoTenTT;
    }

    public void setHoTenTT(String HoTenTT) {
        this.HoTenTT = HoTenTT;
    }

    public String getMaDG() {
        return MaDG;
    }

    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }

    public String getHoTenDG() {
        return HoTenDG;
    }

    public void setHoTenDG(String HoTenDG) {
        this.HoTenDG = HoTenDG;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public Date getHanTra() {
        return HanTra;
    }

    public void setHanTra(Date HanTra) {
        this.HanTra = HanTra;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public int getMaTrangThai() {
        return MaTrangThai;
    }

    public void setMaTrangThai(int MaTrangThai) {
        this.MaTrangThai = MaTrangThai;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}


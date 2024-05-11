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
public class DKMuon {
    private String MaDK;
    private String HoTen;
    private String MaDG;
    private Date NgayDK;

    public DKMuon() {
    }

    public DKMuon(String MaDK, String HoTen, String MaDG, Date NgayDK) {
        this.MaDK = MaDK;
        this.HoTen = HoTen;
        this.MaDG = MaDG;
        this.NgayDK = NgayDK;
    }

    public String getMaDK() {
        return MaDK;
    }

    public void setMaDK(String MaDK) {
        this.MaDK = MaDK;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getMaDG() {
        return MaDG;
    }

    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }

    public Date getNgayDK() {
        return NgayDK;
    }

    public void setNgayDK(Date NgayDK) {
        this.NgayDK = NgayDK;
    }

    
    
    
    
}

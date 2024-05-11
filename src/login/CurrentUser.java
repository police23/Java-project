/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

/**
 *
 * @author User
 */
    public class CurrentUser {
    private static CurrentUser instance;
    private String MaND;

    private CurrentUser() {}

    public static CurrentUser getInstance() {
        if (instance == null) {
            instance = new CurrentUser();
        }
        return instance;
    }

    public void setMaND(String Mand) {
        this.MaND = Mand;
    }

    public String getMaND() {
        return MaND;
    }
}
    

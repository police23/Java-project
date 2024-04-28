/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBCConnection;

/**
 *
 * @author User
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class JDBCConnection {
    public static Connection getJDBCConnection() {
        final String url = "jdbc:oracle:thin:@localhost:1521:XE";
        final String username = "system";
        final String password = "123456";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(url, username, password);
                    
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main (String args[]) throws SQLException {
        Connection con = getJDBCConnection();
        System.out.println(con.toString());
        con.close();
    }
}
    
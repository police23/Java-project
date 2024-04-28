/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import JDBCConnection.JDBCConnection;
import java.security.SecureRandom;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.activation.DataSource;
import java.sql.PreparedStatement;
import login.InputOtp;
/**
 *
 * @author User
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        edtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnForgetPass = new javax.swing.JLabel();
        edtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("MÀN HÌNH ĐĂNG NHẬP");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 410, 48));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 90, 40));

        edtUsername.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        edtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(edtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 210, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 100, 30));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogin.setText("Đăng nhập");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 130, 40));

        btnForgetPass.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnForgetPass.setForeground(new java.awt.Color(51, 51, 51));
        btnForgetPass.setText("Quên mật khẩu ?");
        btnForgetPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnForgetPassMouseClicked(evt);
            }
        });
        getContentPane().add(btnForgetPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 130, 28));

        edtPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(edtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 210, 30));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/HD-wallpaper-stack-of-books-blue-background-education-concepts-books-library-school-learning-concepts.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtUsernameActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String username = "system";
        final String password = "123456";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url,username,password);
            String user = edtUsername.getText();
            String pass = edtPassword.getText();

            if (user.isEmpty() && pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa nhập tên đăng nhập và mật khẩu");
            } else if (user.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa nhập tên đăng nhập");
            } else if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Chưa nhập mật khẩu");
            } else {
                Statement stm = con.createStatement();
                String sql = "SELECT * FROM TAIKHOAN WHERE TENDANGNHAP='" + user + "' AND MATKHAU='" + pass + "'";
                ResultSet rs = stm.executeQuery(sql);

                if (rs.next()) {
                    String role = rs.getString("MAVAITRO");
                    dispose();
                    if ("0".equals(role)) {
                        AdminPage admin = new AdminPage();
                        admin.setVisible(true);
                    }
                    else if ("1".equals(role)) {
                        ReaderPage reader = new ReaderPage();
                        reader.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Tên đăng nhập và/hoặc mật khẩu không đúng");
                }
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnLoginActionPerformed
    private boolean isEmailExists(String email) {
        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String username = "system";
        final String password = "123456";
        boolean exists = false;
      try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM TAIKHOAN WHERE EMAIL = ?");
        pst.setString(1, email);
        ResultSet rs = pst.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            exists = true;
        }
        con.close();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return exists;
}
    private void btnForgetPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnForgetPassMouseClicked
        /*String email = JOptionPane.showInputDialog(this, "Enter your email address:");

        if (email != null && !email.isEmpty()) {
            // Fetch password for the provided email
            String password = getPasswordByEmail(email);

            if (password != null) {
                sendPasswordResetEmail(email, password);
                JOptionPane.showMessageDialog(this, "Password reset instructions sent to your email.");
            } else {
                JOptionPane.showMessageDialog(this, "Email not found in the database.");
            }
        }*/
        String email = JOptionPane.showInputDialog(this, "Enter your email address:");
        if (email != null && !email.isEmpty()) {
        if (isEmailExists(email)) {
            // Generate OTP
            String otp = generateOTP();

            // Save OTP to the database
            saveOTPToDatabase(email, otp);

            // Clean up expired OTPs
            cleanupExpiredOTP();

            // Send OTP via email
            sendOTPByEmail(email, otp);

            // Display input dialog for OTP
            InputOtp ino = new InputOtp(email, otp);
            ino.setLocationRelativeTo(null);
            ino.setVisible(true);
            //String userInputOTP = JOptionPane.showInputDialog(this, "Enter the OTP sent to your email:");

            // Check if user input matches the generated OTP
        }
            else {
            JOptionPane.showMessageDialog(this, "Email not found in the database.");
        }
    }
    }//GEN-LAST:event_btnForgetPassMouseClicked
    private String generateOTP() {
    // Generate a random 6-digit OTP
    SecureRandom random = new SecureRandom();
    int otpValue = 100000 + random.nextInt(900000);
    return String.valueOf(otpValue);
    }
    
    private void saveOTPToDatabase(String email, String otp) {
        JDBCConnection cn = new JDBCConnection();
        Connection conn;
        conn = cn.getJDBCConnection();
        if (conn != null) {
        String sql = "INSERT INTO OTP_STORAGE (email, otp) VALUES (?, ?)";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, otp);
            pst.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    }
    private void sendOTPByEmail(String email, String otp) {
    // Email sending code
    final String username = "haxuanbac244@gmail.com"; // Your email
    final String pass = "cwdtshrxfusgvrdl"; // Your email password

    // Assuming you are using Gmail
    String host = "smtp.gmail.com";
    Properties properties = System.getProperties();
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, pass);
        }
    });

    try {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("Xác thực OTP");
        message.setText("Mã OTP của bạn là: " + otp);
        Transport.send(message);
        System.out.println("OTP sent successfully.");
    } catch (MessagingException mex) {
        mex.printStackTrace();
    }
}
    private void cleanupExpiredOTP() {
        JDBCConnection cn = new JDBCConnection();
        Connection conn;
        conn = cn.getJDBCConnection();
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            CallableStatement cs = conn.prepareCall("{call cleanup_otp}");
            cs.execute();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
    private String getPasswordByEmail(String email) {
        // Database connection code to retrieve password associated with the email
        // You need to implement this method based on your database schema
        // Here's a dummy implementation
        String password = null;
        final String url = "jdbc:oracle:thin:@localhost:1521:XE";
        final String username = "system";
        final String dbPassword = "123456";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, username, dbPassword);
            Statement stm = con.createStatement();
            String sql = "SELECT MATKHAU FROM TAIKHOAN WHERE EMAIL='" + email + "'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                password = rs.getString("MATKHAU");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return password;
     }
    /*private void sendPasswordResetEmail(String email, String password) {
        // Email sending code
        final String username = "haxuanbac244@gmail.com"; // Your email
        final String pass = "cwdtshrxfusgvrdl"; // Your email password
        
        // Assuming you are using Gmail
         String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
    
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, pass);
        }
        });
        
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Lấy lại mật khẩu");
            message.setText("Mật khẩu hiện tại của bạn là :  " + password);
            Transport.send(message);
            System.out.println("Password reset email sent successfully.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }*/
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnForgetPass;
    private javax.swing.JButton btnLogin;
    private javax.swing.JPasswordField edtPassword;
    private javax.swing.JTextField edtUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}

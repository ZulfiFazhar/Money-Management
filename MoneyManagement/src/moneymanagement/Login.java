/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moneymanagement;

import javax.swing.JTextField;

/**
 *
 * @author zulfi
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form MoneyManagement
     */
    public Login() {
        initComponents();
        Koneksi koneksi = new Koneksi();
    }

    public JTextField getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(JTextField loginPassword) {
        this.loginPassword = loginPassword;
    }

    public JTextField getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(JTextField loginUsername) {
        this.loginUsername = loginUsername;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        loginPanel_kiri = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        goToRegister = new javax.swing.JButton();
        loginPanel_kanan = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        loginUsername = new javax.swing.JTextField();
        loginPassword = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginPanel_kiri.setBackground(new java.awt.Color(58, 194, 178));
        loginPanel_kiri.setPreferredSize(new java.awt.Dimension(640, 720));
        loginPanel_kiri.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Selamat Datang");
        loginPanel_kiri.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Untuk selalu terhubung dengan kami");
        loginPanel_kiri.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("login menggunakan akun anda");
        loginPanel_kiri.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Book", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Belum memiliki akun?");
        loginPanel_kiri.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, -1, -1));

        goToRegister.setBackground(new java.awt.Color(255, 255, 255));
        goToRegister.setFont(new java.awt.Font("Franklin Gothic Book", 0, 20)); // NOI18N
        goToRegister.setForeground(new java.awt.Color(61, 146, 136));
        goToRegister.setText("Register Now");
        goToRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToRegisterActionPerformed(evt);
            }
        });
        loginPanel_kiri.add(goToRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 210, 40));

        loginPanel.add(loginPanel_kiri, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        loginPanel_kanan.setBackground(new java.awt.Color(255, 255, 255));
        loginPanel_kanan.setPreferredSize(new java.awt.Dimension(640, 720));
        loginPanel_kanan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Zulfi\\Downloads\\Rupiah (1).png")); // NOI18N
        loginPanel_kanan.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 24)); // NOI18N
        jLabel5.setText("Uangku");
        loginPanel_kanan.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        jLabel7.setText("Aplikasi Manajemen Keuangan");
        loginPanel_kanan.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 37)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(58, 194, 178));
        jLabel8.setText("Sign In");
        loginPanel_kanan.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, -1));

        loginUsername.setBackground(new java.awt.Color(217, 217, 217));
        loginUsername.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        loginUsername.setForeground(new java.awt.Color(255, 255, 255));
        loginUsername.setText("    Username");
        loginPanel_kanan.add(loginUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 380, 50));

        loginPassword.setBackground(new java.awt.Color(217, 217, 217));
        loginPassword.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        loginPassword.setForeground(new java.awt.Color(255, 255, 255));
        loginPassword.setText("    Password");
        loginPanel_kanan.add(loginPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 380, 50));

        loginButton.setBackground(new java.awt.Color(58, 194, 178));
        loginButton.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Sign In");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginPanel_kanan.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 550, 380, 50));

        loginPanel.add(loginPanel_kanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        getContentPane().add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginButtonActionPerformed

    private void goToRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToRegisterActionPerformed
        Register register = new Register();
        register.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_goToRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goToRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel loginPanel_kanan;
    private javax.swing.JPanel loginPanel_kiri;
    private javax.swing.JTextField loginPassword;
    private javax.swing.JTextField loginUsername;
    // End of variables declaration//GEN-END:variables
}
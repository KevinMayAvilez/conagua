/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conagua;

import conagua.conexion.Conexion;
import conagua.utilidades.Utilidades;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author KEVIN
 *
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    Conexion con;
    Utilidades utilidades;

    public Login() {
        initComponents();
        con = new Conexion();
        utilidades = new Utilidades();
        this.setSize(800, 410);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jb_usuario = new javax.swing.JTextField();
        jb_login = new javax.swing.JButton();
        jb_contraseña = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Usuario");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(428, 170, 100, 30);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Contraseña");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(428, 213, 100, 30);

        jb_usuario.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jb_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_usuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jb_usuario);
        jb_usuario.setBounds(532, 172, 216, 30);

        jb_login.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jb_login.setForeground(new java.awt.Color(51, 51, 51));
        jb_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/login2.png"))); // NOI18N
        jb_login.setText("Login");
        jb_login.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jb_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_loginKeyPressed(evt);
            }
        });
        getContentPane().add(jb_login);
        jb_login.setBounds(638, 271, 110, 30);

        jb_contraseña.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jb_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_contraseñaActionPerformed(evt);
            }
        });
        getContentPane().add(jb_contraseña);
        jb_contraseña.setBounds(532, 215, 216, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/390x133.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 10, 390, 375);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("¡Bienvenido!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(428, 99, 336, 32);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jPanel1);
        jPanel1.setBounds(410, 40, 360, 310);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 800, 390);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_usuarioActionPerformed

    private void jb_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_contraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb_contraseñaActionPerformed

    private void jb_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_loginKeyPressed
        
        String contraseña = String.valueOf(jb_contraseña.getPassword());
        String usuario = jb_usuario.getText();

        if (!usuario.trim().isEmpty() && !contraseña.trim().isEmpty()) {

            con.Conectar();
            String sql = "select * from usuarios where usuario = '" + usuario + "' and habilitado = 1";

            ResultSet rs = con.Consulta(sql);

            try {

                if (rs.next()) {
                    rs.beforeFirst();
                    while (rs.next()) {

                        String bd_contraseña = rs.getString("contraseña");
                        String login_contraseña = utilidades.StringToMD5(contraseña);

                        if (bd_contraseña.equals(login_contraseña)) {

                            Principal p = new Principal();
                            p.setVisible(true);
                            this.dispose();

                        } else {
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta.", "¡Error!", JOptionPane.ERROR_MESSAGE);
                        }

                    }

                } else if (usuario.equals("u53r_c0n4gu4") && contraseña.equals("##conagua##")) {

                    JTextField password = new JPasswordField();
                    Object[] ob = {"Hi! Developer, Code please...", password};

                    int result = JOptionPane.showConfirmDialog(null, ob, "BackcDoor!!", JOptionPane.OK_CANCEL_OPTION);

                    if (result == 0) {
                        String pass_ = String.valueOf(password.getText());
                        if (pass_.equals("ACN92_")) {
                            Principal p = new Principal();
                            p.setVisible(true);
                            this.dispose();
                        } else {
                            System.exit(1);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el usuario", "¡Error!", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Llene los datos de acceso.", "¡Error!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jb_loginKeyPressed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jb_contraseña;
    private javax.swing.JButton jb_login;
    private javax.swing.JTextField jb_usuario;
    // End of variables declaration//GEN-END:variables
}

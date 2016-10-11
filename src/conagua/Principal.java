/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conagua;

import conagua.conexion.Conexion;
import conagua.dias.inhabiles.AgregarDia;
import conagua.documentos.NuevoDocumento;
import conagua.documentos.NuevoError;
import conagua.tramites.ListaTramites;
import conagua.usuarios.ListaUsuarios;
import conagua.usuarios.NuevoUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 *
 *
 */
public class Principal extends javax.swing.JFrame {

    Login login;
    Conexion con;
    
    public Principal() {
        initComponents();
        login = new Login();
        this.setSize(800, 438);
        this.setLocationRelativeTo(null);
        con = new Conexion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/CONAGUA-LOGO.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 380);

        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu2.setForeground(new java.awt.Color(51, 51, 51));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/tramites1.png"))); // NOI18N
        jMenu2.setText("Tramites");
        jMenu2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(102, 102, 102));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/tramite2.png"))); // NOI18N
        jMenuItem3.setText("Nuevo Tramite");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu4.setForeground(new java.awt.Color(51, 51, 51));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/doc1.png"))); // NOI18N
        jMenu4.setText("Documentos");
        jMenu4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jMenuItem6.setForeground(new java.awt.Color(102, 102, 102));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/doc2.png"))); // NOI18N
        jMenuItem6.setText("Documentos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jMenuItem5.setForeground(new java.awt.Color(102, 102, 102));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/error1.png"))); // NOI18N
        jMenuItem5.setText("Nuevo Error");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar1.add(jMenu4);

        jMenu3.setForeground(new java.awt.Color(51, 51, 51));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/dias1.png"))); // NOI18N
        jMenu3.setText("Dias Inhabiles");
        jMenu3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jMenuItem4.setForeground(new java.awt.Color(102, 102, 102));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/dias2.png"))); // NOI18N
        jMenuItem4.setText("Agregar Dias");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu1.setForeground(new java.awt.Color(51, 51, 51));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/user2.png"))); // NOI18N
        jMenu1.setText("Usuarios");
        jMenu1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(102, 102, 102));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/list1.png"))); // NOI18N
        jMenuItem2.setText("Lista de Usuarios");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(102, 102, 102));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/adduser.png"))); // NOI18N
        jMenuItem1.setText("Nuevo Usuario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu5.setForeground(new java.awt.Color(51, 51, 51));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/computer1.png"))); // NOI18N
        jMenu5.setText("Sistema");
        jMenu5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N

        jMenuItem16.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jMenuItem16.setForeground(new java.awt.Color(102, 102, 102));
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/logout1.png"))); // NOI18N
        jMenuItem16.setText("Cerrar Sesión");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem16);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        NuevoUsuario n_usuario = new NuevoUsuario();
        n_usuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        ListaTramites n_tramite = new ListaTramites();
        n_tramite.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        AgregarDia a_dia = new AgregarDia();
        a_dia.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        ListaUsuarios l_usuario = new ListaUsuarios();
        l_usuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:

        NuevoError n_error = new NuevoError();
        n_error.setVisible(true);

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        try {
            
            String sql = "select * from tramites";

            con.Conectar();
            ResultSet rs = con.Consulta(sql);

            while (rs.next()) {
                if (rs.getInt(1) > 0) {
                    System.out.println(rs.getInt(1));
                } else {
                    JOptionPane.showMessageDialog(null, "No hay documentos", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NuevoDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
        NuevoDocumento n_doc = new NuevoDocumento();
        n_doc.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
}

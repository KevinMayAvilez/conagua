/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conagua.documentos;

import conagua.Principal;
import conagua.conexion.Conexion;
import conagua.usuarios.EditarUsuario;
import conagua.usuarios.ListaUsuarios;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Néstor
 */
public class ListaDocumentos extends javax.swing.JFrame {

    /**
     * Creates new form ListaDocumentos
     */
    Principal principal;
    Conexion con;
    ArrayList<Integer> ids_tramites;
    ArrayList<Integer> ids_documentos;
    ArrayList<Integer> ids_errores;
    DefaultTableModel modelo;
    String columnas[] = {"Documentos"};
    String empty[] = {"Sin resultados"};
    Object obj;

    DefaultListModel<String> listDocumentos;
    DefaultListModel<String> listErrores;

    public ListaDocumentos() {
        ids_tramites = new ArrayList<Integer>();
        ids_documentos = new ArrayList<Integer>();
        initComponents();
        this.setLocationRelativeTo(null);
        principal = new Principal();
        con = new Conexion();
        this.llenarTramites();
        this.llenarDocumentos();

    }

    public void llenarTramites() {
        try {
            String sql = "select * from tramites";
            con.Conectar();
            ResultSet rs = con.Consulta(sql);
            while (rs.next()) {
                jc_tramites.addItem(rs.getString("codigo") + "-" + rs.getString("nombre"));
                ids_tramites.add(rs.getInt("id"));
            }
            con.Cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(NuevoDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void llenarDocumentos() {
        int id_tramite = ids_tramites.get(jc_tramites.getSelectedIndex());
        ids_documentos = new ArrayList<Integer>();
        listDocumentos = new DefaultListModel<>();

        String sql = "select * from documentos where id_tramite =" + id_tramite;
        con.Conectar();
        ResultSet rs = con.Consulta(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    ids_documentos.add(rs.getInt("id"));
                    listDocumentos.addElement(rs.getString("nombre"));
                }

            } else {
                listDocumentos.addElement("Sin Elementos");
            }

            list_documentos.setModel(listDocumentos);
            this.cleanListErrores();

            con.Cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void llenarErrores(int id_documento) {
        ids_errores = new ArrayList<Integer>();
        listErrores = new DefaultListModel<>();

        String sql = "select * from errores_documentos where id_documento =" + id_documento;
        con.Conectar();
        ResultSet rs = con.Consulta(sql);

        try {
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    ids_errores.add(rs.getInt("id"));
                    listErrores.addElement(rs.getString("error"));
                }

            } else {
                this.cleanListErrores();
                listErrores.addElement("Sin Elementos");
            }

            list_errores.setModel(listErrores);

            con.Cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cleanListErrores() {
        listErrores = new DefaultListModel<>();
        list_errores.setModel(listErrores);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jc_tramites = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        list_documentos = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_errores = new javax.swing.JList();
        jb_addDocumento = new javax.swing.JButton();
        jb_addError = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Tipo de Tramite");

        jc_tramites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc_tramitesActionPerformed(evt);
            }
        });

        list_documentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list_documentos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                list_documentosValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(list_documentos);

        list_errores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(list_errores);

        jb_addDocumento.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jb_addDocumento.setForeground(new java.awt.Color(51, 51, 51));
        jb_addDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/boton_add.png"))); // NOI18N
        jb_addDocumento.setText("Agregar Documento");
        jb_addDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_addDocumentoActionPerformed(evt);
            }
        });

        jb_addError.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jb_addError.setForeground(new java.awt.Color(51, 51, 51));
        jb_addError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/boton_add.png"))); // NOI18N
        jb_addError.setText("Agregar Error");
        jb_addError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_addErrorActionPerformed(evt);
            }
        });

        jb_cancelar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        jb_cancelar.setForeground(new java.awt.Color(51, 51, 51));
        jb_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/boton_cancel.png"))); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/boton_edit.png"))); // NOI18N
        jButton1.setText("Editar Documento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/boton_edit.png"))); // NOI18N
        jButton2.setText("Editar Error");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jb_addDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addComponent(jb_addError)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jc_tramites, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jc_tramites, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jb_addDocumento)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jb_addError)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jb_cancelar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jc_tramitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc_tramitesActionPerformed

        if (ids_tramites.size() > 0) {
            this.llenarDocumentos();
        }
    }//GEN-LAST:event_jc_tramitesActionPerformed

    private void list_documentosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_list_documentosValueChanged

        if (ids_documentos.size() > 0 && list_documentos.getSelectedIndex() > -1) {
            this.llenarErrores(ids_documentos.get(list_documentos.getSelectedIndex()));
        }


    }//GEN-LAST:event_list_documentosValueChanged

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_addErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_addErrorActionPerformed
        NuevoError ne = new NuevoError(this, jc_tramites.getSelectedIndex(),list_documentos.getSelectedIndex());
        ne.setVisible(true);
    }//GEN-LAST:event_jb_addErrorActionPerformed

    private void jb_addDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_addDocumentoActionPerformed

        NuevoDocumento nd = new NuevoDocumento(this, jc_tramites.getSelectedIndex());
            nd.setVisible(true);
    }//GEN-LAST:event_jb_addDocumentoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          if (list_documentos.getSelectedIndex()> -1) {
            EditarDocumento ed = new EditarDocumento(this, ids_documentos.get(list_documentos.getSelectedIndex()));
            ed.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario.", "¡WARNING!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ListaDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaDocumentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jb_addDocumento;
    private javax.swing.JButton jb_addError;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JComboBox jc_tramites;
    private javax.swing.JList list_documentos;
    private javax.swing.JList list_errores;
    // End of variables declaration//GEN-END:variables
}

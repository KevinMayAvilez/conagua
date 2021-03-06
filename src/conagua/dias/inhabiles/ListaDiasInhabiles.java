package conagua.dias.inhabiles;

import conagua.conexion.Conexion;
import conagua.usuarios.EditarUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaDiasInhabiles extends javax.swing.JFrame {

    Conexion con;
    DefaultTableModel modelo;
    String columnas[] = {"Nombre", "Fecha"};
    String empty[] = {"Sin resultados"};
    ArrayList<Integer> ids_fechas;
    Object obj;

    public ListaDiasInhabiles() {
        initComponents();
        this.setLocationRelativeTo(null);
        con = new Conexion();
        this.llenarTabla();
    }
    
    
    public void llenarTabla() {

        ids_fechas = new ArrayList<Integer>();
        modelo = new DefaultTableModel(null, columnas);
        String sql = "select * from dias_inhabiles";
        con.Conectar();
        ResultSet rs = con.Consulta(sql);

        try {
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    Vector vec = new Vector();
                    ids_fechas.add(rs.getInt("id"));
                    vec.add(rs.getString("nombre"));
                    vec.add(rs.getString("fecha"));
                    modelo.addRow(vec);
                }
                t_dias.setModel(modelo);
            } else {
                modelo.addRow(empty);
            }

            con.Cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(ListaDiasInhabiles.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void buscarFecha() {

        ids_fechas= new ArrayList<Integer>();
        modelo = new DefaultTableModel(null, columnas);
        String sql = "select * from dias_inhabiles where "
                + "nombre like '%" + jt_buscar.getText() + "%' or "
                + "fecha like '%" + jt_buscar.getText() + "%' ";

        con.Conectar();
        ResultSet rs = con.Consulta(sql);

        try {
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    Vector vec = new Vector();
                    vec.add(rs.getString("nombre"));
                    vec.add(rs.getString("fecha"));
                    modelo.addRow(vec);
                }
            } else {
                modelo.addRow(empty);
            }
            t_dias.setModel(modelo);
            con.Cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(ListaDiasInhabiles.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        jScrollPane2 = new javax.swing.JScrollPane();
        t_dias = new javax.swing.JTable();
        jb_agregar = new javax.swing.JButton();
        jb_editar = new javax.swing.JButton();
        jb_borrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jt_buscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        t_dias.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        t_dias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        t_dias.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(t_dias);

        jb_agregar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jb_agregar.setForeground(new java.awt.Color(51, 51, 51));
        jb_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/boton_add.png"))); // NOI18N
        jb_agregar.setText("Agregar");
        jb_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_agregarActionPerformed(evt);
            }
        });

        jb_editar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jb_editar.setForeground(new java.awt.Color(51, 51, 51));
        jb_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/boton_edit.png"))); // NOI18N
        jb_editar.setText("Editar");
        jb_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_editarActionPerformed(evt);
            }
        });

        jb_borrar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jb_borrar.setForeground(new java.awt.Color(51, 51, 51));
        jb_borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/trash.png"))); // NOI18N
        jb_borrar.setText("Borrar");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conagua/imagenes/icons/serach.png"))); // NOI18N
        jLabel3.setText("Buscar");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_buscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jb_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jb_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jb_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jt_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jb_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jb_borrar)))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_buscarKeyReleased
             if (!jt_buscar.getText().trim().isEmpty()) {
            buscarFecha();
        } else {
            llenarTabla();
        }
    }//GEN-LAST:event_jt_buscarKeyReleased

    private void jb_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_agregarActionPerformed
            AgregarDia ad = new AgregarDia(this);
            ad.setVisible(true);
    }//GEN-LAST:event_jb_agregarActionPerformed

    private void jb_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_editarActionPerformed

                if (t_dias.getSelectedRow() > -1) {
                    EditarDia ed = new EditarDia(this, ids_fechas.get(t_dias.getSelectedRow()));
            ed.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario.", "¡WARNING!", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jb_editarActionPerformed

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
            java.util.logging.Logger.getLogger(ListaDiasInhabiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaDiasInhabiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaDiasInhabiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaDiasInhabiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaDiasInhabiles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_agregar;
    private javax.swing.JButton jb_borrar;
    private javax.swing.JButton jb_editar;
    private javax.swing.JTextField jt_buscar;
    private javax.swing.JTable t_dias;
    // End of variables declaration//GEN-END:variables
}

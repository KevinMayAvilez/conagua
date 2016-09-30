/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conagua.conexion;

import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Néstor
 */
public class Conexion {

    private String db = "conagua";
    private String server = "localhost";
    private String user = "root";
    private String pass = "mysql";
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    private Connection conexion = null;

    public void Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + server + "/" + db;
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la bade de datos",
                    "Error en conexión", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Cerrar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet Consulta(String sql) {
        try {
            st = conexion.createStatement();
            rs = (ResultSet) st.executeQuery(sql);            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public PreparedStatement InsertPS(String sql) {
        try {
            ps = conexion.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }    

}

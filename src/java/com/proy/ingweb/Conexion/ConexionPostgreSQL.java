/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author TicowST
 */
public class ConexionPostgreSQL {

    String driver;
    String url;
    String user;
    String pass;
    String db;
    private Connection conn = null;

    //En el constructor definimos la conexion
    public ConexionPostgreSQL() {

        //Asignamos los datos
        this.driver = "org.postgresql.Driver";
        this.db = "BACKUP_PIWFARMACIA";
        this.url = "jdbc:postgresql://localhost:5432/" + db;
        this.user = "postgres";
        this.pass = "root";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pass);
            //System.out.println("Conexion exitosa a PostgreSQL");
        } catch (ClassNotFoundException | SQLException ex) {
            java.util.logging.Logger.getLogger(ConexionPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection getConnection() {
        return this.conn;
    }

    public void desconectar() {
        System.out.println("Cerrar conexion de PostgreSQL");
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error al desconectar " + e);
            }
        }
    }

}

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
public class ConexionSQLServer {

    String driver;
    String url;
    private Connection conn = null;

    //En el constructor definimos la conexion
    public ConexionSQLServer() {

        //Asignamos los datos
        this.driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.url = "jdbc:sqlserver://balzar.cjpff9zmygv2.us-east-1.rds.amazonaws.com:1433;databaseName=balzar;user=admin;password=fisi-balzar";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url);
            System.out.println("Conexion exitosa a SQLServer");
        } catch (ClassNotFoundException | SQLException ex) {
            java.util.logging.Logger.getLogger(ConexionSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection getConnection() {
        return this.conn;
    }

    public void desconectar() {
        System.out.println("Se cerró la conexion a SQLServer");
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error al desconectar " + e);
            }
        }
    }

}

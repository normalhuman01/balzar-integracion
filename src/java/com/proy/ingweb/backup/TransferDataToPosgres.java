/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.backup;

import com.proy.ingweb.Conexion.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TicowST
 */
public class TransferDataToPosgres {

    //Abrimos las conexiones a las DB
    ConexionSQLServer conn_SQLServer = new ConexionSQLServer();
    ConexionPostgreSQL conn_PostgreSQL = new ConexionPostgreSQL();

    //Creamos el Array
    ArrayList lista = new ArrayList();

    ResultSet rs11, rs21, rs31, rs41, rs51;
    PreparedStatement cmd11, cmd12, cmd13, cmd21, cmd22, cmd23, cmd31, cmd32, cmd33, cmd41, cmd42, cmd43, cmd51, cmd52, cmd53;

    public void realizarBackupCliente() {
        try {
            cmd11 = conn_PostgreSQL.getConnection().prepareStatement("delete from CLIENTE");
            cmd11.executeUpdate();

            cmd12 = conn_SQLServer.getConnection().prepareStatement("select * from CLIENTE");
            rs11 = cmd12.executeQuery();
            while (rs11.next()) {

                int IdCliente = rs11.getInt("IdCliente");
                String Dni = rs11.getString("Dni");
                String Nombres = rs11.getString("Nombres");
                String Direccion = rs11.getString("Direccion");
                String Telefono = rs11.getString("Telefono");

                //Insertamos en la DB de PostgreSQL
                cmd13 = conn_PostgreSQL.getConnection().prepareStatement("insert into CLIENTE values(?,?,?,?,?)");
                cmd13.setInt(1, IdCliente);
                cmd13.setString(2, Dni);
                cmd13.setString(3, Nombres);
                cmd13.setString(4, Direccion);
                cmd13.setString(5, Telefono);
                cmd13.executeUpdate();

            }
            cmd11.close();
            cmd12.close();
            cmd13.close();
            rs11.close();

        } catch (SQLException e) {
            Logger.getLogger(TransferDataToPosgres.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void realizarBackupMedicamentos() {
        try {
            cmd21 = conn_PostgreSQL.getConnection().prepareStatement("delete from MEDICAMENTO");
            cmd21.executeUpdate();

            cmd22 = conn_SQLServer.getConnection().prepareStatement("select * from MEDICAMENTO");
            rs21 = cmd22.executeQuery();
            while (rs21.next()) {

                String IdMedicamento = rs21.getString("IdMedicamento");
                String Nombre = rs21.getString("Nombre");
                String Tipo = rs21.getString("Tipo");
                float Precio = rs21.getFloat("Precio");
                int Stock = rs21.getInt("Stock");
                String Estado = rs21.getString("Estado");

                //Insertamos en la DB de PostgreSQL
                cmd23 = conn_PostgreSQL.getConnection().prepareStatement("insert into MEDICAMENTO values(?,?,?,?,?,?)");
                cmd23.setString(1, IdMedicamento);
                cmd23.setString(2, Nombre);
                cmd23.setString(3, Tipo);
                cmd23.setFloat(4, Precio);
                cmd23.setInt(5, Stock);
                cmd23.setString(6, Estado);
                cmd23.executeUpdate();

            }
            cmd21.close();
            cmd22.close();
            cmd23.close();
            rs21.close();

        } catch (SQLException e) {
            Logger.getLogger(TransferDataToPosgres.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void realizarBackupOperarios() {
        try {
            cmd31 = conn_PostgreSQL.getConnection().prepareStatement("delete from OPERARIO");
            cmd31.executeUpdate();

            cmd32 = conn_SQLServer.getConnection().prepareStatement("select * from OPERARIO");
            rs31 = cmd32.executeQuery();
            while (rs31.next()) {

                int IdOperario = rs31.getInt("IdOperario");
                String Dni = rs31.getString("Dni");
                String Nombres = rs31.getString("Nombres");
                String Direccion = rs31.getString("Direccion");
                String Telefono = rs31.getString("Telefono");
                String Rol = rs31.getString("Rol");
                String Usuario = rs31.getString("Usuario");
                String Passw = rs31.getString("Passw");

                //Insertamos en la DB de PostgreSQL
                cmd33 = conn_PostgreSQL.getConnection().prepareStatement("insert into OPERARIO values(?,?,?,?,?,?,?,?)");
                cmd33.setInt(1, IdOperario);
                cmd33.setString(2, Dni);
                cmd33.setString(3, Nombres);
                cmd33.setString(4, Direccion);
                cmd33.setString(5, Telefono);
                cmd33.setString(6, Rol);
                cmd33.setString(7, Usuario);
                cmd33.setString(8, Passw);
                cmd33.executeUpdate();

            }
            cmd31.close();
            cmd32.close();
            cmd33.close();
            rs31.close();

        } catch (SQLException e) {
            Logger.getLogger(TransferDataToPosgres.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
        public void realizarBackupVentas() {
        try {
            cmd41 = conn_PostgreSQL.getConnection().prepareStatement("delete from VENTAS");
            cmd41.executeUpdate();

            cmd42 = conn_SQLServer.getConnection().prepareStatement("select * from VENTAS");
            rs41 = cmd42.executeQuery();
            while (rs41.next()) {

                int IdVentas = rs41.getInt("IdVentas");
                int IdCliente = rs41.getInt("IdCliente");
                int IdOperario = rs41.getInt("IdOperario");
                String NumSerie = rs41.getString("NumSerie");
                String FechaVenta = rs41.getString("FechaVenta");
                float Monto = rs41.getFloat("Monto");
                String Estado = rs41.getString("Estado");

                //Insertamos en la DB de PostgreSQL
                cmd43 = conn_PostgreSQL.getConnection().prepareStatement("insert into VENTAS values(?,?,?,?,?,?,?)");
                cmd43.setInt(1, IdVentas);
                cmd43.setInt(2, IdCliente);
                cmd43.setInt(3, IdOperario);
                cmd43.setString(4, NumSerie);
                cmd43.setString(5, FechaVenta);
                cmd43.setFloat(6, Monto);
                cmd43.setString(7, Estado);
                cmd43.executeUpdate();

            }
            cmd41.close();
            cmd42.close();
            cmd43.close();
            rs41.close();

        } catch (SQLException e) {
            Logger.getLogger(TransferDataToPosgres.class.getName()).log(Level.SEVERE, null, e);
        }
    }

                public void realizarBackupDetalleVentas() {
        try {
            cmd51 = conn_PostgreSQL.getConnection().prepareStatement("delete from DETALLE_VENTAS");
            cmd51.executeUpdate();

            cmd52 = conn_SQLServer.getConnection().prepareStatement("select * from DETALLE_VENTAS");
            rs51 = cmd52.executeQuery();
            while (rs51.next()) {

                int IdDetalleVentas = rs51.getInt("IdDetalleVentas");
                int IdVentas = rs51.getInt("IdVentas");
                String IdMedicamento = rs51.getString("IdMedicamento");
                int Cantidad = rs51.getInt("Cantidad");
                float PrecioVenta = rs51.getFloat("PrecioVenta");

                //Insertamos en la DB de PostgreSQL
                cmd53 = conn_PostgreSQL.getConnection().prepareStatement("insert into DETALLE_VENTAS values(?,?,?,?,?)");
                cmd53.setInt(1, IdDetalleVentas);
                cmd53.setInt(2, IdVentas);
                cmd53.setString(3, IdMedicamento);
                cmd53.setInt(4, Cantidad);
                cmd53.setFloat(5, PrecioVenta);
                cmd53.executeUpdate();

            }
            cmd51.close();
            cmd52.close();
            cmd53.close();
            rs51.close();

        } catch (SQLException e) {
            Logger.getLogger(TransferDataToPosgres.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

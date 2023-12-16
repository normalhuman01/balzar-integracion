/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.DAO;

import com.proy.ingweb.Conexion.ConexionSQLServer;
import com.proy.ingweb.Modelo.Venta;
import com.proy.ingweb.iDAO.IVentasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TicowST
 */
public class VentasDAO implements IVentasDAO {

    Connection con;
    ConexionSQLServer cn = new ConexionSQLServer();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    @Override
    public String GenerarSerie() {
        String numserie ="";
        String sql = "SELECT max(NumSerie) FROM VENTAS";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                numserie=rs.getString(1);
            }
        }catch(SQLException e){
        }
        return numserie;
    }

    @Override
    public String IdVentas() {
        String idVentas ="";
        String sql = "SELECT MAX(IdVentas) FROM VENTAS";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                idVentas = rs.getString(1);
            }
        }catch(SQLException e){
        }
        return idVentas;
    }

    @Override
    public int guardarVenta(Venta v) {
        String sql = "INSERT INTO VENTAS(IdCliente,IdOperario,NumSerie,FechaVenta,Monto,Estado) VALUES (?,?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getIdCliente());
            ps.setInt(2, v.getIdOperario());
            ps.setString(3, v.getNumSerie());
            ps.setString(4, v.getFechaVenta());
            ps.setFloat(5, v.getPrecio());
            ps.setString(6, v.getEstado());
            r = ps.executeUpdate();
        }catch(SQLException e){
        }   
        return r;

        }

    @Override
    public int guardarDetalleVentas(Venta v) {
        String sql = "INSERT INTO DETALLE_VENTAS(IdVentas,IdMedicamento,Cantidad,PrecioVenta) VALUES(?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,v.getIdVentas() );
            ps.setString(2, v.getIdMedicamento());
            ps.setInt(3, v.getCantidad());
            ps.setFloat(4, v.getPrecio());
            r = ps.executeUpdate();
            
        }catch(SQLException e){
        }
        return r;
    }
    
    
}

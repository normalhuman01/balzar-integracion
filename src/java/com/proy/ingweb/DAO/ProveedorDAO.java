/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.DAO;

import com.proy.ingweb.Conexion.ConexionSQLServer;
import com.proy.ingweb.Modelo.Proveedor;
import com.proy.ingweb.iDAO.IProveedorDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Luis
 */
public class ProveedorDAO implements IProveedorDAO {
    ConexionSQLServer cn = new ConexionSQLServer();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    @Override
    public List listar() {
        String sql = "SELECT * FROM PROVEEDOR";
        List<Proveedor> lista = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor pro = new Proveedor();
                pro.setIdProveedor(rs.getInt(1));
                pro.setRUC(rs.getString(2));
                pro.setRazonSocial(rs.getString(3));
                pro.setEstado(rs.getString(4));
                pro.setCondicion(rs.getString(5));
                pro.setDireccion(rs.getString(6));
                lista.add(pro);
            }
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public int agregar(Proveedor cli) {
        String sql = "INSERT INTO PROVEEDOR(Ruc, RazonSocial, Estado, "
                + "Condicion, Direccion) "
                + "VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getRUC());
            ps.setString(2, cli.getRazonSocial());
            ps.setString(3, cli.getEstado());
            ps.setString(4, cli.getCondicion());
            ps.setString(5, cli.getDireccion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public int actualizar(Proveedor cli) {
        String sql = "UPDATE PROVEEDOR SET Ruc=?, RazonSocial=?, Estado=?, "
                + "Condicion=?, Direccion=? "
                + "WHERE IdProveedor=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getRUC());
            ps.setString(2, cli.getRazonSocial());
            ps.setString(3, cli.getEstado());
            ps.setString(4, cli.getCondicion());
            ps.setString(5, cli.getDireccion());
            ps.setInt(6, cli.getIdProveedor());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM PROVEEDOR WHERE IdProveedor=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Proveedor listarId(int id) {
        Proveedor cli = new Proveedor();
        String sql = "SELECT * FROM PROVEEDOR WHERE IdProveedor=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setIdProveedor(rs.getInt(1));
                cli.setRUC(rs.getString(2));
                cli.setRazonSocial(rs.getString(3));
                cli.setEstado(rs.getString(4));
                cli.setCondicion(rs.getString(5));
                cli.setDireccion(rs.getString(6));
            }
        } catch (SQLException e) {
        }
        return cli;
    }

    @Override
    public Proveedor listarRUC(String ruc) {
        Proveedor cli = new Proveedor();
        String sql = "SELECT * FROM PROVEEDOR WHERE Ruc='" + ruc + "'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setIdProveedor(rs.getInt(1));
                cli.setRUC(rs.getString(2));
                cli.setRazonSocial(rs.getString(3));
                cli.setEstado(rs.getString(4));
                cli.setCondicion(rs.getString(5));
                cli.setDireccion(rs.getString(6));
            }
        } catch (SQLException e) {
        }
        return cli;
    }
}

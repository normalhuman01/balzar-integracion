/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.DAO;

import com.proy.ingweb.Conexion.ConexionSQLServer;
import com.proy.ingweb.Modelo.Cliente;
import com.proy.ingweb.iDAO.IClienteDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TicowST
 */
public class ClienteDAO implements IClienteDAO {

    ConexionSQLServer cn = new ConexionSQLServer();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    @Override
    public List listar() {
        String sql = "SELECT * FROM CLIENTE";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setIdCliente(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setApellidoPaterno(rs.getString(3));
                cli.setApellidoMaterno(rs.getString(4));
                cli.setNombres(rs.getString(5));
                cli.setDireccion(rs.getString(6));
                cli.setFechaNacimiento(rs.getDate(7).toLocalDate());
                cli.setEdad(rs.getInt(8));
                cli.setTelefono(rs.getString(9));
                lista.add(cli);
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
    public int agregar(Cliente cli) {
        String sql = "INSERT INTO CLIENTE(Dni, ApellidoPaterno, ApellidoMaterno, "
                + "Nombres, Direccion, Telefono, FechaNacimiento, Edad) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getApellidoPaterno());
            ps.setString(3, cli.getApellidoMaterno());
            ps.setString(4, cli.getNombres());
            ps.setString(5, cli.getDireccion());
            ps.setString(6, cli.getTelefono());
            ps.setDate(7, Date.valueOf(cli.getFechaNacimiento()));
            ps.setInt(8, cli.getEdad());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public int actualizar(Cliente cli) {
        String sql = "UPDATE CLIENTE SET Dni=?, ApellidoPaterno=?, ApellidoMaterno=?, "
                + "Nombres=?, Direccion=?, Telefono=?, FechaNacimiento=?, Edad=? "
                + "WHERE IdCliente=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getApellidoPaterno());
            ps.setString(3, cli.getApellidoMaterno());
            ps.setString(4, cli.getNombres());
            ps.setString(5, cli.getDireccion());
            ps.setString(6, cli.getTelefono());
            ps.setDate(7, Date.valueOf(cli.getFechaNacimiento()));
            ps.setInt(8, cli.getEdad());
            ps.setInt(5, cli.getIdCliente());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM CLIENTE WHERE IdCliente=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Cliente listarId(int id) {
        Cliente cli = new Cliente();
        String sql = "SELECT * FROM CLIENTE WHERE IdCliente=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setIdCliente(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setApellidoPaterno(rs.getString(3));
                cli.setApellidoMaterno(rs.getString(4));
                cli.setNombres(rs.getString(5));
                cli.setDireccion(rs.getString(6));
                cli.setTelefono(rs.getString(7));
                cli.setFechaNacimiento(rs.getDate(8).toLocalDate());
                cli.setEdad(rs.getInt(9));
            }
        } catch (SQLException e) {
        }
        return cli;
    }

    @Override
    public Cliente listarDNI(String dni) {
        Cliente cli = new Cliente();
        String sql = "SELECT * FROM CLIENTE WHERE Dni='" + dni + "'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setIdCliente(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setApellidoPaterno(rs.getString(3));
                cli.setApellidoMaterno(rs.getString(4));
                cli.setNombres(rs.getString(5));
                cli.setDireccion(rs.getString(6));
                cli.setTelefono(rs.getString(7));
                cli.setFechaNacimiento(rs.getDate(8).toLocalDate());
                cli.setEdad(rs.getInt(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cli;
    }
}

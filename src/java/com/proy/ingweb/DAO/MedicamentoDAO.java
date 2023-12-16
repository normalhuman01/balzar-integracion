/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.DAO;

import com.proy.ingweb.Conexion.ConexionSQLServer;
import com.proy.ingweb.Modelo.Medicamento;
import com.proy.ingweb.iDAO.IMedicamentoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TicowST
 */
public class MedicamentoDAO implements IMedicamentoDAO {

    ConexionSQLServer cn = new ConexionSQLServer();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    @Override
    public List listar() {
        String sql = "SELECT * FROM MEDICAMENTO";
        List<Medicamento> lista = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Medicamento med = new Medicamento();
                med.setIdMedicamento(rs.getString(1));
                med.setNombre(rs.getString(2));
                med.setTipo(rs.getString(3));
                med.setPrecio(rs.getFloat(4));
                med.setStock(rs.getInt(5));
                med.setEstado(rs.getString(6));
                lista.add(med);
            }
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
        }
        return lista;
    }

    @Override
    public int agregar(Medicamento med) {
        String sql = "INSERT INTO MEDICAMENTO(IdMedicamento,Nombre,Tipo,Precio,Stock,Estado) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, med.getIdMedicamento());
            ps.setString(2, med.getNombre());
            ps.setString(3, med.getTipo());
            ps.setFloat(4, med.getPrecio());
            ps.setInt(5, med.getStock());
            ps.setString(6, med.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    @Override
    public int actualizar(Medicamento med) {
        String sql = "UPDATE MEDICAMENTO SET Nombre=?, Tipo=?, Precio=?, Stock=?, Estado=? WHERE IdMedicamento=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, med.getNombre());
            ps.setString(2, med.getTipo());
            ps.setFloat(3, med.getPrecio());
            ps.setInt(4, med.getStock());
            ps.setString(5, med.getEstado());
            ps.setString(6, med.getIdMedicamento());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    @Override
    public void eliminar(String id) {
        String sql = "DELETE FROM MEDICAMENTO WHERE IdMedicamento='" + id+"'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Medicamento listarId(String id) {
        Medicamento med = new Medicamento();
        String sql = "SELECT * FROM MEDICAMENTO WHERE IdMedicamento='" + id+"'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                med.setIdMedicamento(rs.getString(1));
                med.setNombre(rs.getString(2));
                med.setTipo(rs.getString(3));
                med.setPrecio(rs.getFloat(4));
                med.setStock(rs.getInt(5));
                med.setEstado(rs.getString(6));

            }
        } catch (SQLException e) {
        }
        return med;
    }

    @Override
    public int actualizarStock(String id, int stock) {
        String sql = "UPDATE MEDICAMENTO SET Stock=? WHERE IdMedicamento=?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setString(2, id);
            r = ps.executeUpdate();
        }catch(SQLException e){}
        return r;
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.DAO;

import com.proy.ingweb.Conexion.ConexionSQLServer;
import com.proy.ingweb.Modelo.Operario;
import com.proy.ingweb.iDAO.IOperarioDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TicowST
 */
public class OperarioDAO implements IOperarioDAO {
    ConexionSQLServer  cn = new ConexionSQLServer();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    int msj;

    @Override
    public Operario validar(String user, String passw) {
        Operario oper= new Operario();
        String sql = "SELECT * FROM OPERARIO WHERE Usuario=? and Passw=?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, passw);
            rs=ps.executeQuery();
            while(rs.next()){
                oper.setIdOperario(rs.getInt("IdOperario"));
                oper.setDni(rs.getString("Dni"));
                oper.setNombres(rs.getString("Nombres"));
                oper.setDireccion(rs.getString("Direccion"));
                oper.setTelefono(rs.getString("Telefono"));
                oper.setRol(rs.getString("Rol"));
                oper.setUsuario(rs.getString("Usuario"));
                oper.setPassw(rs.getString("Passw"));
            }
            System.out.println(oper.getUsuario());
        }catch(SQLException e){
        }
        return oper;
    }

    @Override
    public List listar() {
        String sql = "SELECT * FROM OPERARIO";
        List<Operario> lista = new ArrayList<>();
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Operario oper = new Operario();
                oper.setIdOperario(rs.getInt(1));
                oper.setDni(rs.getString(2));
                oper.setNombres(rs.getString(3));
                oper.setDireccion(rs.getString(4));
                oper.setTelefono(rs.getString(5));
                oper.setRol(rs.getString(6));
                oper.setUsuario(rs.getString(7));
                oper.setPassw(rs.getString(8));
                lista.add(oper);
            }

        }catch(SQLException e){
        }
        return lista;
    }

    @Override
    public int agregar(Operario oper) {
       String sql = "INSERT INTO OPERARIO(Dni,Nombres,Direccion,Telefono, Rol,Usuario,Passw) VALUES (?,?,?,?,?,?,?)";
       try{
          //System.out.println(oper.getDni()+oper.getNombres()+oper.getDireccion()+oper.getTelefono()+oper.getEstado()+oper.getUsuario()+oper.getPassw());

           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, oper.getDni());
           ps.setString(2, oper.getNombres());
           ps.setString(3, oper.getDireccion());
           ps.setString(4, oper.getTelefono());
           ps.setString(5, oper.getRol());
           ps.setString(6, oper.getUsuario());
           ps.setString(7, oper.getPassw());
           r=ps.executeUpdate();
           if(r==1){
                msj=0;
            }else{
                msj=1;
            }
       }catch(SQLException e){
           System.err.println(e.getMessage());
       }
       System.out.println(msj);
       return msj;
    }

    @Override
    public int actualizar(Operario oper) {
       String sql = "UPDATE OPERARIO SET Dni=?, Nombres=?, Direccion=?, Telefono=?, Rol=?, Usuario=?, Passw=? WHERE IdOperario=?";
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, oper.getDni());
           ps.setString(2, oper.getNombres());
           ps.setString(3, oper.getDireccion());
           ps.setString(4, oper.getTelefono());
           ps.setString(5, oper.getRol());
           ps.setString(6, oper.getUsuario());
           ps.setString(7, oper.getPassw());
           ps.setInt(8, oper.getIdOperario());
           r = ps.executeUpdate();
           if(r==1){
                msj=0;
            }else{
                msj=1;
            }
       }catch(SQLException e){
       }
       return msj;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM OPERARIO WHERE IdOperario="+id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(SQLException e){
        }
    }

    @Override
    public Operario listarId(int id) {
        Operario oper = new Operario();
        String sql = "SELECT * FROM OPERARIO WHERE IdOperario="+id;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                oper.setDni(rs.getString(2));
                oper.setNombres(rs.getString(3));
                oper.setDireccion(rs.getString(4));
                oper.setTelefono(rs.getString(5));
                oper.setRol(rs.getString(6));
                oper.setUsuario(rs.getString(7));
                oper.setPassw(rs.getString(8));
            }
        }catch(SQLException e){
        }
        return oper;
    }
}

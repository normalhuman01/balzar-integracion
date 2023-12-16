/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.iDAO;

import com.proy.ingweb.Modelo.Cliente;
import java.util.List;

/**
 *
 * @author TicowST
 */
public interface IClienteDAO {
    
    public List listar();
    public int agregar(Cliente cli );
    public int actualizar(Cliente cli);
    public void eliminar(int id);
    public Cliente listarId(int id);
    public Cliente listarDNI(String dni);
 
}

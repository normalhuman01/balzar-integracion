/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.iDAO;

import com.proy.ingweb.Modelo.Cliente;
import com.proy.ingweb.Modelo.Proveedor;
import java.util.List;

/**
 *
 * @author Luis
 */
public interface IProveedorDAO {
    public List listar();
    public int agregar(Proveedor pro );
    public int actualizar(Proveedor pro);
    public void eliminar(int id);
    public Proveedor listarId(int id);
    public Proveedor listarRUC(String ruc);
}

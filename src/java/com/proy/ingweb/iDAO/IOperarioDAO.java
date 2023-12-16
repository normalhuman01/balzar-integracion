/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.iDAO;

import com.proy.ingweb.Modelo.Operario;
import java.util.List;

/**
 *
 * @author TicowST
 */
public interface IOperarioDAO {
 
    public Operario validar(String user, String passw);
    public List listar();
    public int agregar(Operario oper );
    public int actualizar(Operario oper);
    public void eliminar(int id);
    public Operario listarId(int id);
}

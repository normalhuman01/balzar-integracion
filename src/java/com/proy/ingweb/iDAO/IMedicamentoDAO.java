/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.iDAO;

import com.proy.ingweb.Modelo.Medicamento;
import java.util.List;

/**
 *
 * @author TicowST
 */
public interface IMedicamentoDAO {
    public List listar();
    public int agregar(Medicamento med );
    public int actualizar(Medicamento med);
    public void eliminar(String id);
    public Medicamento listarId(String id);    
    public int actualizarStock(String id, int stock);
}

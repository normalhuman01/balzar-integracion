/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.iDAO;

import com.proy.ingweb.Modelo.Venta;

/**
 *
 * @author TicowST
 */
public interface IVentasDAO {
    public String GenerarSerie();
    public String IdVentas();
    public int guardarVenta(Venta v);
    public int guardarDetalleVentas(Venta v);
}

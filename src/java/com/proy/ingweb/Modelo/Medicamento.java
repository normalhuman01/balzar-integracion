/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.Modelo;

/**
 *
 * @author TicowST
 */
public class Medicamento {
    String IdMedicamento;
    String Nombre;
    String Tipo;
    float Precio;
    int Stock;
    String Estado;

    public Medicamento() {
    }

    public Medicamento(String IdMedicamento, String Nombre, String Tipo, float Precio, int Stock, String Estado) {
        this.IdMedicamento = IdMedicamento;
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Precio = Precio;
        this.Stock = Stock;
        this.Estado = Estado;
    }

    public String getIdMedicamento() {
        return IdMedicamento;
    }

    public void setIdMedicamento(String IdMedicamento) {
        this.IdMedicamento = IdMedicamento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
}

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
public class Venta {
    int item;
    int IdVentas;
    int IdCliente;
    int IdOperario;
    String IdMedicamento;
    String NumSerie;
    String NombreMedicamento;
    float precio;
    int cantidad;
    float subTotal;
    String FechaVenta;
    float Monto;
    String Estado;

    public Venta() {
    }

    public Venta(int item,int IdVentas, int IdCliente, int IdOperario, String IdMedicamento, String NumSerie, String NombreMedicamento, float precio, int cantidad, float subTotal, String FechaVenta, float Monto, String Estado) {
        this.item = item;
        this.IdVentas = IdVentas;
        this.IdCliente = IdCliente;
        this.IdOperario = IdOperario;
        this.IdMedicamento = IdMedicamento;
        this.NumSerie = NumSerie;
        this.NombreMedicamento = NombreMedicamento;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.FechaVenta = FechaVenta;
        this.Monto = Monto;
        this.Estado = Estado;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdVentas() {
        return IdVentas;
    }

    public void setIdVentas(int IdVentas) {
        this.IdVentas = IdVentas;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdOperario() {
        return IdOperario;
    }

    public void setIdOperario(int IdOperario) {
        this.IdOperario = IdOperario;
    }

    public String getIdMedicamento() {
        return IdMedicamento;
    }

    public void setIdMedicamento(String IdMedicamento) {
        this.IdMedicamento = IdMedicamento;
    }

    public String getNumSerie() {
        return NumSerie;
    }

    public void setNumSerie(String NumSerie) {
        this.NumSerie = NumSerie;
    }

    public String getNombreMedicamento() {
        return NombreMedicamento;
    }

    public void setNombreMedicamento(String NombreMedicamento) {
        this.NombreMedicamento = NombreMedicamento;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public String getFechaVenta() {
        return FechaVenta;
    }

    public void setFechaVenta(String FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float Monto) {
        this.Monto = Monto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    

    
}

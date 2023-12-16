/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.Modelo;



/**
 *
 * @author Luis
 */
public class Proveedor {
    
    private int IdProveedor;
    private String RUC;
    private String RazonSocial;
    private String Estado;
    private String Condicion;
    private String Direccion;
    
    public Proveedor(){
        
    }

    public Proveedor(int IdProveedor, String RUC, String RazonSocial, String Estado, String Condicion, String Direccion) {
        this.IdProveedor = IdProveedor;
        this.RUC = RUC;
        this.RazonSocial = RazonSocial;
        this.Estado = Estado;
        this.Condicion = Condicion;
        this.Direccion = Direccion;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getCondicion() {
        return Condicion;
    }

    public void setCondicion(String Condicion) {
        this.Condicion = Condicion;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "IdProveedor=" + IdProveedor + ", RUC=" + RUC + ", RazonSocial=" + RazonSocial + ", Estado=" + Estado + ", Condicion=" + Condicion + ", Direccion=" + Direccion + '}';
    }
    

}

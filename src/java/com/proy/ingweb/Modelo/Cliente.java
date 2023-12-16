/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.Modelo;

import java.time.LocalDate;

/**
 *
 * @author TicowST
 */
public class Cliente {

    private int IdCliente;
    private String Dni;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String Nombres;
    private String Direccion;
    private LocalDate FechaNacimiento;
    private Integer Edad;
    private String Telefono;

    public Cliente() {
    }

    public Cliente(int IdCliente, String Dni, String ApellidoPaterno, String ApellidoMaterno, String Nombres, String Direccion, LocalDate FechaNacimiento, Integer Edad, String Telefono) {
        this.IdCliente = IdCliente;
        this.Dni = Dni;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Nombres = Nombres;
        this.Direccion = Direccion;
        this.FechaNacimiento = FechaNacimiento;
        this.Edad = Edad;
        this.Telefono = Telefono;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getNombreCompleto() {
        return ApellidoPaterno + " " + ApellidoMaterno + " " + Nombres;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public LocalDate getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer Edad) {
        this.Edad = Edad;
    }
    
    public void calcularEdad(Integer AñoNacimiento){
        this.setEdad(LocalDate.now().getYear() - AñoNacimiento);
    }

    @Override
    public String toString() {
        return "Cliente{" + "IdCliente=" + IdCliente + ", Dni=" + Dni + ", ApellidoPaterno=" + ApellidoPaterno + ", ApellidoMaterno=" + ApellidoMaterno + ", Nombres=" + Nombres + ", Direccion=" + Direccion + ", FechaNacimiento=" + FechaNacimiento + ", Edad=" + Edad + ", Telefono=" + Telefono + '}';
    }

}

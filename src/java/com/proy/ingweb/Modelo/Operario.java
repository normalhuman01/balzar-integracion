/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proy.ingweb.Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author TicowST
 */
public class Operario {
    private int IdOperario;
    private String Dni;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String Nombres;
    private LocalDateTime FechaNacimiento;
    private Integer Edad;
    private String Direccion;
    private String Telefono;
    private String Rol;
    private String Usuario;
    private String Passw;

    public Operario() {
    }

    public Operario(int IdOperario, String Dni, String ApellidoPaterno, String ApellidoMaterno, String Nombres, LocalDateTime FechaNacimiento, Integer Edad, String Direccion, String Telefono, String Rol, String Usuario, String Passw) {
        this.IdOperario = IdOperario;
        this.Dni = Dni;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Nombres = Nombres;
        this.FechaNacimiento = FechaNacimiento;
        this.Edad = Edad;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Rol = Rol;
        this.Usuario = Usuario;
        this.Passw = Passw;
    }

    public String getPassw() {
        return Passw;
    }

    public void setPassw(String Passw) {
        this.Passw = Passw;
    }

    public int getIdOperario() {
        return IdOperario;
    }

    public void setIdOperario(int IdOperario) {
        this.IdOperario = IdOperario;
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

    public LocalDateTime getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer Edad) {
        this.Edad = Edad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

   


}

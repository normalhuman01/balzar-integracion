<%-- 
    Document   : Operarios
    Created on : 20/08/2020, 06:06:59 PM
    Author     : TicowST
--%>

<%@page import="com.proy.ingweb.DAO.ClienteDAO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Farmacia Balzar</title>
        <link rel="shortcut icon" href="./static/img/hospital.png">
        <script src="./static/js/jquery.min.js"></script>
        <script src="./static/js/bootstrap.min.js"></script>
        <script src="./static/js/validaciones.js"></script>
        <link rel="stylesheet" type="text/css" href="./static/css/bootstrap.min.css"></link>
        <style>.titulo{padding:1px;font-family: Helvetica;font-size: 20px;text-align:center;color:white;}</style>
    </head>
    <body>
        <div class="titulo bg-info">GESTION DE CLIENTES</div>
        <div class="d-flex">
            <div class="col-sm-1" style="background:#cacdcf;">
                <div style="margin-bottom:200px"></div>
                <img style="" src="./static/img/client.png" alt="80" width="80"/>
            </div>
            <div class="card col-sm-3" style="border-left:2px solid #8f8d88; border-right:2px solid #8f8d88;height:840px;">
                <div class="card-body" >
                    <form action="ClienteController" method="POST">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" value="${cliente.getDni()}" id="txtDni" name="txtDni"  maxlength="8" onkeypress="return validarNum(event)" class="form-control" required/>
                        </div>
                        <div class="form-group">
                            <label>Apellido Paterno</label>
                            <input type="text" value="${cliente.getApellidoPaterno()}" id="txtApellidoPaterno" name="txtApellidoPaterno" class="form-control" required/>                        
                        </div>
                        <div class="form-group">
                            <label>Apellido Materno</label>
                            <input type="text" value="${cliente.getApellidoMaterno()}" id="txtApellidoMaterno" name="txtApellidoMaterno" class="form-control" required/>                        
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${cliente.getNombres()}" id="txtNombres" name="txtNombres" class="form-control" required/>                        
                        </div>
                        <div class="form-group">
                            <label>Fecha de Nacimiento</label>
                            <input type="date" value="${cliente.getFechaNacimiento()}" id="txtFechaNacimiento" name="txtFechaNacimiento" class="form-control" required/> 
                        </div>
                        <div class="form-group">
                            <label>Edad</label>
                            <input type="text" value="${cliente.getEdad()}" id="txtEdad" name="txtEdad" class="form-control" required/> 
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" value="${cliente.getDireccion()}" id="txtDireccion" name="txtDireccion" class="form-control"/> 
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" value="${cliente.getTelefono()}" id="txtTelefono" name="txtTelefono" class="form-control"/>                        
                        </div>

                        <c:choose>
                            <c:when test="${cliente.getIdCliente()!=null}">
                                <input type="submit" name="accion" value="Actualizar" class="btn btn-block btn-info">       
                            </c:when>    
                            <c:otherwise>
                                <input type="submit" name="accion" value="Agregar" class="btn btn-block btn-primary">
                            </c:otherwise>
                        </c:choose>                    
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                    <th>DNI</th>
                    <th>NOMBRE COMPLETO</th>
                    <th>DIRECCION</th>
                    <th>EDAD</th>
                    <th>TELEFONO</th>
                    <th>ACCIONES</th>
                    </thead>
                    <tbody>

                        <c:forEach var="cli" items="${lista_clientes}">
                            <tr>
                                <td>${cli.getDni()}</td>
                                <td>${cli.getNombreCompleto()}</td>
                                <td>${cli.getDireccion()}</td>
                                <td>${cli.getEdad()}</td>
                                <td>${cli.getTelefono()}</td>
                                <td><a href="ClienteController?accion=Editar&id=${cli.getIdCliente()}" class="btn-success" style="padding:3px;color:white;">Editar</a>&nbsp; 
                                    <a href="ClienteController?accion=Eliminar&id=${cli.getIdCliente()}" class="btn-danger" style="padding:3px;color:white;" onclick="return confirm('¿Seguro que desea eliminar el Cliente?')">Eliminar</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="./static/js/jquery-3.5.1.min.js"></script>
        <script src="./static/js/clienteR.js"></script>

    </body>

</html>

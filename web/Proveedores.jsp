<%-- 
    Document   : Proveedores
    Created on : 02/01/2021, 05:13:34 PM
    Author     : Luis
--%>

<%@page import="com.proy.ingweb.DAO.ProveedorDAO"%>
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
        <div class="titulo bg-info">GESTION DE PROVEEDORES</div>
        <div class="d-flex">
            <div class="col-sm-1" style="background:#cacdcf;">
                <div style="margin-bottom:200px"></div>
                <img style="" src="./static/img/client.png" alt="80" width="80"/>
            </div>
            <div class="card col-sm-3" style="border-left:2px solid #8f8d88; border-right:2px solid #8f8d88;height:840px;">
                <div class="card-body" >
                    <form action="ProveedorController" method="POST">
                        <div class="form-group">
                            <label>RUC</label>
                            <input type="text" value="${proveedor.getRUC()}" id="txtRuc" name="txtRuc"  maxlength="11" onkeypress="return validarNum(event)" class="form-control" required/>
                        </div>
                        <div class="form-group">
                            <label>Nombre o Razon Social</label>
                            <input type="text" value="${proveedor.getRazonSocial()}" id="txtRazonSocial" name="txtRazonSocial" class="form-control" required/>                        
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${proveedor.getEstado()}" id="txtEstado" name="txtEstado" class="form-control" required/>                        
                        </div>
                        <div class="form-group">
                            <label>Condicion</label>
                            <input type="text" value="${proveedor.getCondicion()}" id="txtCondicion" name="txtCondicion" class="form-control" required/>                        
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" value="${proveedor.getDireccion()}" id="txtDireccion" name="txtDireccion" class="form-control"/> 
                        </div>

                        <c:choose>
                            <c:when test="${proveedor.getIdProveedor()!=null}">
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
                    <th>RUC</th>
                    <th>RAZON SOCIAL</th>
                    <th>ESTADO</th>
                    <th>CONDICION</th>
                    <th>DIRECCION</th>
                    <th>ACCIONES</th>
                    </thead>
                    <tbody>

                        <c:forEach var="pro" items="${lista_proveedores}">
                            <tr>
                                <td>${pro.getRUC()}</td>
                                <td>${pro.getRazonSocial()}</td>
                                <td>${pro.getEstado()}</td>
                                <td>${pro.getCondicion()}</td>
                                <td>${pro.getDireccion()}</td>
                                <td><a href="ProveedorController?accion=Editar&id=${pro.getIdProveedor()}" class="btn-success" style="padding:3px;color:white;">Editar</a>&nbsp; 
                                    <a href="ProveedorController?accion=Eliminar&id=${pro.getIdProveedor()}" class="btn-danger" style="padding:3px;color:white;" onclick="return confirm('¿Seguro que desea eliminar el Proveedor?')">Eliminar</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="./static/js/jquery-3.5.1.min.js"></script>
        <script src="./static/js/ProveedorR.js"></script>

    </body>
</html>

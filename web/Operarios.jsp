<%-- 
    Document   : Operarios
    Created on : 20/08/2020, 06:06:59 PM
    Author     : TicowST
--%>

<%@page import="com.proy.ingweb.DAO.OperarioDAO"%>
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
        <div class="titulo bg-info">GESTION DE OPERARIOS</div>
        <div class="d-flex">
                        <div class="col-sm-1" style="background:#cacdcf;">
                            <div style="margin-bottom:200px"></div>
                            <img style="" src="./static/img/customer-service.png" alt="80" width="80"/>
            </div>
            <div class="card col-sm-3" style="border-left:2px solid #8f8d88; border-right:2px solid #8f8d88;height:515px;">
                <div class="card-body">
                    <form action="OperarioController" method="POST">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" value="${operario.getDni()}" name="txtDni" maxlength="8" onkeypress="return validarNum(event)" class="form-control" required/>
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${operario.getNombres()}" id="txtNombres" name="txtNombres" class="form-control" required/>                        
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" value="${operario.getDireccion()}" name="txtDireccion" class="form-control" required/> 
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label>Telefono</label>
                                <input type="text" value="${operario.getTelefono()}" name="txtTelefono" class="form-control" required/>                        
                            </div>
                            <div class="form-group col-md-6">
                                <label>Rol</label>
                                <select class="form-control" name="txtRol" required>
                                    <option selected disabled>--Seleccione</option>
                                    <option value="2">Supervisor</option>
                                    <option value="1">Comprador</option>
                                    <option value="0">Tecnico</option>
                                </select>
                            </div>  
                        </div>
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label>Usuario</label>
                                <input type="text" value="${operario.getUsuario()}" id="txtUsuario" name="txtUsuario" class="form-control" required/>                        
                            </div>

                            <c:choose>
                                <c:when test="${operario.getPassw()!=null}">
                                    <div class="form-group col-md-6">
                                        <label>Nuevo Password</label>
                                        <input type="password" value="${operario.getPassw()}" name="txtPassw" class="form-control" required/>                        
                                    </div>        
                                </c:when>    
                                <c:otherwise>
                                </c:otherwise>
                            </c:choose>

                        </div>

                            <c:choose>
                                <c:when test="${operario.getPassw()!=null}">
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
                    <th>NOMBRES</th>
                    <th>USUARIO</th>
                    <th>DIRECCION</th>
                    <th>TELEFONO</th>
                    <th>ACCIONES</th>
                    </thead>
                    <tbody>
         
                        <c:forEach var="oper" items="${operarios}">
                            <tr>
                                <td>${oper.getDni()}</td>
                                <td>${oper.getNombres()}</td>
                                <td>${oper.getUsuario()}</td>
                                <td>${oper.getDireccion()}</td>
                                <td>${oper.getTelefono()}</td>
                                <td><a href="OperarioController?accion=Editar&id=${oper.getIdOperario()}" class="btn-success" style="padding:3px;color:white;">Editar</a>&nbsp; 
                                    <a href="OperarioController?accion=Eliminar&id=${oper.getIdOperario()}" class="btn-danger" style="padding:3px;color:white;" onclick="return confirm('¿Seguro que desea eliminar el registro?')">Eliminar</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
                            
                            <script>
                                $('#txtUsuario').on('click',function(){
                                    nombre_completo = $('#txtNombres').val();
                                    user = nombre_completo.split(" ")
                                    user2 = user[0]
                                    usuario= user2.charAt(0)+user[1]
                                    $('#txtUsuario').val(usuario.toLowerCase())
                                })
                            </script>
    </body>
</html>

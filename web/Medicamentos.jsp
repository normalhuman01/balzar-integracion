<%-- 
    Document   : Medicamento
    Created on : 20/08/2020, 06:07:39 PM
    Author     : TicowST
--%>
<%@page import="com.proy.ingweb.DAO.MedicamentoDAO"%>
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
        <link rel="stylesheet" type="text/css" href="./static/css/bootstrap.min.css"></link>    
        <style>.titulo{padding:1px;font-family: Helvetica;font-size: 20px;text-align:center;color:white;}</style>
    </head>
    <body>
        <div class="titulo bg-info">GESTION DE MEDICAMENTOS</div>
        <div class="d-flex">
            <div class="col-sm-1" style="background:#cacdcf;">
                <div style="margin-bottom:200px"></div>
                <img style="" src="./static/img/medicament.png" alt="80" width="80"/>
            </div>
            <div class="card col-sm-3" style="border-left:2px solid #8f8d88; border-right:2px solid #8f8d88;height:515px;">
                <div class="card-body">
                    <form action="MedicamentoController" method="POST">
                        <div class="form-group">
                            <label>Codigo</label>
                            <input type="text" value="${medicamento.getIdMedicamento()}" name="txtIdMedicamento" maxlength="6" class="form-control" required/>
                        </div>
                        <div class="form-group">
                            <label>Nombre del Medicamento</label>
                            <input type="text" value="${medicamento.getNombre()}" name="txtNombre" class="form-control" required/>                        
                        </div>
                        <div class="form-group">
                            <label>Tipo</label>
                            <input type="text" value="${medicamento.getTipo()}" name="txtTipo" class="form-control" required/> 
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" value="${medicamento.getPrecio()}" name="txtPrecio" class="form-control" required/>                        
                        </div>
                        <div class="form-group">
                            <label>Stock</label>
                            <input type="number" value="${medicamento.getStock()}" name="txtStock" class="form-control" placeholder="100" required/>                        

                        </div>


                        <c:choose>
                            <c:when test="${medicamento.getNombre()!=null}">
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
                    <th>CODIGO</th>
                    <th>NOMBRES</th>
                    <th>TIPO</th>
                    <th>PRECIO</th>
                    <th>STOCK</th>
                    </thead>
                    <tbody>

                    <c:forEach var="med" items="${lista_medicamentos}">
                        <tr>
                            <td>${med.getIdMedicamento()}</td>
                            <td>${med.getNombre()}</td>
                            <td>${med.getTipo()}</td>
                            <td>${med.getPrecio()}</td>
                            <td>${med.getStock()}</td>
                            <td><a href="MedicamentoController?accion=Editar&id=${med.getIdMedicamento()}" class="btn-success" style="padding:3px;color:white;">Editar</a>&nbsp; 
                                <a href="MedicamentoController?accion=Eliminar&id=${med.getIdMedicamento()}" class="btn-danger" style="padding:3px;color:white;" onclick="return confirm('¿Seguro que desea eliminar el Medicamento?')">Eliminar</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>

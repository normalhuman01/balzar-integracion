<%-- 
    Document   : Principal
    Created on : 19/08/2020, 08:43:12 PM
    Author     : TicowST
--%>
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
    </head>
    <body style="background:#dbdad7" >
        <!-- Barra de Navegación-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-info" style="font-weight: bold; font-size: 18px;">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>

                    <c:if test="${operario.getRol().equals('2') || operario.getRol().equals('1')}">
                        <li class="nav-item active">
                            <a class="nav-link" href="MenuController?menu=Medicamentos" target="framePrincipal">Medicamentos<span class="sr-only">(current)</span></a>
                        </li>
                    </c:if>

                    <c:if test="${operario.getRol().equals('2')}">
                        <li class="nav-item active">
                            <a class="nav-link" href="MenuController?menu=Operarios" target="framePrincipal">Operarios <span class="sr-only">(current)</span></a>
                        </li>
                    </c:if>
                    <li class="nav-item active">
                        <a class="nav-link" href="MenuController?menu=Clientes" target="framePrincipal">Clientes <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="MenuController?menu=Proveedores" target="framePrincipal">Proveedores</a> <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="MenuController?menu=NuevaVenta" target="framePrincipal">Nueva Venta</a>
                    </li>

                    <c:if test="${operario.getRol().equals('2')}">
                        <li class="nav-item active">
                            <a class="nav-link" href="MenuController?menu=Backup" target="framePrincipal">Realizar Backup<span class="sr-only">(current)</span></a>
                        </li>
                    </c:if>

                </ul>
                <div class="dropdown">
                    <button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${operario.getNombres()}
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item text-center" href="#">
                            <img src="./static/img/doctor.png" alt="70" width="70"/>
                        </a>
                        <a class="dropdown-item text-center" href="#">
                            <c:if test="${operario.getRol().equals('2')}"><b>Supervisor</b></c:if>
                            <c:if test="${operario.getRol().equals('1')}"><b>Comprador</b></c:if>
                            <c:if test="${operario.getRol().equals('0')}"><b>Técnico</b></c:if>
                            </a> 
                            <a class="dropdown-item text-center" href="#">${operario.getUsuario()}</a>
                        <a class="dropdown-item text-center" href="#">${operario.getDni()}</a> 

                        <a class="dropdown-item text-center" href="index.jsp" style="color:red;"><i>Cerrar Sesion</i></a>
                    </div>
                </div>                
            </div>
        </nav>                                  

        <div class="m-4" style="height:720px;" >
            <iframe name="framePrincipal" src="./static/img/pharmaceutical.png" style="height: 100%; width:100%;background:#f5f4f0;border:2px solid #8f8d88;">
            </iframe>
        </div>                
    </body>
</html>

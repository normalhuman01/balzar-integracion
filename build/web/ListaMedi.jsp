<%-- 
    Document   : Medicamento
    Created on : 20/08/2020, 06:07:39 PM
    Author     : TicowST
--%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.proy.ingweb.Conexion.ConexionSQLServer"%>
<%@page import="com.proy.ingweb.Modelo.Medicamento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.proy.ingweb.DAO.MedicamentoDAO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Medicamentos</title>
        <link rel="shortcut icon" href="./static/img/hospital.png">
        <script src="./static/js/jquery.min.js"></script>
        <script src="./static/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="./static/css/bootstrap.min.css"></link>    
        <style>.titulo{padding:1px;font-family: Helvetica;font-size: 20px;text-align:center;color:white;}</style>
    </head>
    <body>
        <div class="titulo bg-info">LISTA DE MEDICAMENTOS</div>
        <div class="d-flex">
            <div class="col-sm-12">


                <table class="table table-hover">
                    <thead>
                    <th>CODIGO</th>
                    <th>NOMBRES</th>
                    </thead>
                    <tbody>

                        <%
                            ConexionSQLServer conn_SQLServer = new ConexionSQLServer();
                            Connection con;
                            ResultSet rs;
                            PreparedStatement cmd;

                            //Para contabilizar las filas que se pasan de una DB a otra
                            try {
                                con = conn_SQLServer.getConnection();
                                cmd = con.prepareStatement("SELECT * FROM MEDICAMENTO;");

                                rs = cmd.executeQuery();
                                while (rs.next()) {
                        %> 
                        <tr>
                            <td><%= rs.getString(1)%></td>
                            <td><%= rs.getString(2)%></td>
                        </tr>
                        <%             }

                            } catch (SQLException e) {
                                e.getMessage();
                            }%>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>

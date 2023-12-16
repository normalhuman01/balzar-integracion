<%-- 
    Document   : Backup
    Created on : 22/09/2020, 11:49:47 PM
    Author     : TicowST
--%>

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
        <div class="titulo bg-info">BACKUP DE LAS VENTAS REALIZADAS</div>
        <div class="d-flex">
            <div class="col-sm-1" style="background:#cacdcf;height: 515px" >
                <div style="margin-bottom:200px"></div>
                <img style="" src="./static/img/backup.png" alt="80" width="80"/>
            </div>
            <div class="col-sm-1">

            </div>
            <div class="col-sm-9">
                <div class="row" style="margin-bottom:40px;"></div>
                <div class="jumbotron">
                    <h1 class="display-4">Copia de Seguridad</h1>
                    <p class="lead">Se va a realizar una copia de seguridad de toda la data referente a las Ventas, actualmente se encuentra
                        en la Base de Datos SQLServer y la copia de dicha información se realizará en la Base de Datos Posgresql</p>
                    <hr class="my-4">
                    <p>Si usted está seguro de realizar una copia de seguridad el
                        <script>
                            var f = new Date();
                            document.write(f.getDate() + "/" + "0" + (f.getMonth() + 1) + "/" + f.getFullYear());
                        </script>
                        pulse el siguiente botón:
                    </p>
                    <p class="lead">
                        <a class="btn btn-warning btn-block" href="BackupServlet?accion=Backup" role="button">Realizar copia de seguridad</a>
                    </p>
                </div>
            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : index
    Created on : 19/08/2020, 08:42:43 PM
    Author     : TicowST
********************************
CLEAN AND BUILD 
CARPETA DEL TRABAJO > dist > war

--%>

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Farmacia Balzar</title>
        <link rel="shortcut icon" href="./static/img/hospital.png">
        <link rel="stylesheet" type="text/css" href="./static/css/bootstrap.min.css"></link>
        <script src="./static/js/jquery.min.js"></script>
    </head>
    <body>

        <div style="margin-bottom:60px"></div>        
        <div class="container mt-4 col-lg-4" style="background:#c6c8ca; border-left: 2px solid #3b3735; border-right: 2px solid #3b3735;">
            <div class="card">
                <div class="card-body">
                    <form class="form-sign" action="ValidarServlet" method="POST">
                        <div class="form-group text-center">
                            <h3>Iniciar Sesion</h3>
                            <img src="./static/img/farmaceutico.png" alt="100" width="100"/>
                            <label>Bienvenidos a Farmacia Balzar</label>
                        </div>
                        <div class="form-group">
                            <label>Usuario:</label>
                            <input type="text" name="txtuser" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="txtpass" class="form-control"/>
                        </div>
                        <div style="margin-bottom:80px"></div>
                        
                        <div>
                            <input type="submit" name="accion" value="Ingresar" class="btn btn-block btn-primary" />
                        </div>
                    </form>
                </div>
                <div style="margin-bottom:10px"></div>
            </div>
            
        </div>
        <div style="margin-bottom:40px"></div>

    </body>
</html>

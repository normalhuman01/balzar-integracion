<%-- 
    Document   : RegistrarVenta
    Created on : 20/08/2020, 06:07:24 PM
    Author     : TicowST
--%>
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
        <style>
            @media print{
                .toelim{
                    display: none;
                }
                
            }
        </style>
</script>
    </head>
    <body>
        <div class="titulo bg-info ">GESTION DE VENTAS</div>
        <div class="d-flex">
            <div class="col-sm-1 toelim" style="background:#cacdcf;">
                <div style="margin-bottom:200px"></div>
                <img style="" src="./static/img/sale.png" alt="80" width="80"/>
            </div>
            <div class="col-sm-11" style="border-left:2px solid #8f8d88;">
                <div style="margin-bottom:15px;"></div>
                <form id="idVentas" action="VentaController" method="POST" >
                    <div class="row col-md-12 toelim" style="margin-bottom:15px; margin-left: 3px; border: 1px solid #cccccc;">
                        <div class="col-md-6">
                            <div class="card-body">
                                <div class="form-group">
                                    <label>Datos del Medicamento</label>
                                    <a href="ListaMedi.jsp" target="_blank" onclick="javascript:window.open(this.href,this.target,'width=320,height=550');return false;"><img src="./static/img/drugs.png" width="15px" height="15px"></a>

                                </div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                        <input type="text" name="txtIdMedicamento"  class="form-control" placeholder="Codigo de Medicamento"/>
                                        <input type="hidden" name="txtCodigo" value="${medicamento.getIdMedicamento()}">
                                        <button name="accion" value="BuscarMedicamento"  class="btn btn-link"><img src="./static/img/search.png" width="25px" height="25px"></button>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" id="txtNomMedicamento" name="txtNomMedicamento" value="${medicamento.getNombre()}" class="form-control" placeholder="Nombre del Medicamento" readonly/>
                                    </div>
                                </div>
                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex form-group">
                                        <label style="text-size:18px;">S/.&nbsp;</label>
                                        <input type="text" name="txtPrecio" value="${medicamento.getPrecio()}" class="form-control" placeholder="Precio" readonly/>
                                    </div>
                                    <div class="col-sm-3">
                                        <input type="number" name="txtCantidad" class="form-control" value="1" />
                                    </div>
                                    <div class="col-sm-3">
                                        <input type="text" name="txtStock" value="${medicamento.getStock()}" class="form-control" placeholder="Stock" readonly/>
                                    </div>
                                </div>
                            </div>
                        </div> 
                        <div class="col-md-6">
                            <div class="card-body">
                                <div class="form-group">
                                    <label>Datos del Cliente</label>  
                                </div>

                                <div class="form-group d-flex">
                                    <div class="col-sm-6 d-flex">
                                        <input type="text" value="${cliente.getDni()}" name="txtDni" class="form-control" placeholder="DNI del Cliente"/>
                                        <button name="accion" value="BuscarCliente" class="btn btn-link"><img src="./static/img/search.png" width="25px" height="25px"></button>
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" value="${cliente.getNombres()}" id="NombreCliente" name="txtNombreCliente" class="form-control" placeholder="Nombre del Cliente" readonly/>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <center>
                                        <button id="AgregarCarrito" name="accion" value="AgregarCarrito" class="btn btn-block btn-info">Agregar al Carrito &nbsp;<img src="./static/img/shopping-cart.png" width="25px" height="25px"></button>
                                    </center>
                                </div>
                            </div>                            

                        </div>
                    </div>
                </form>
                <div class="card col-sm-12">
                    <div class="card-body">
                        <div class="d-flex col-sm-4 ml-auto">
                            <label>Num.Serie&nbsp;&nbsp;</label>
                            <input type="text" value="${NumSerie}" name="txtNumSerie" class="font-weight-bold text-md-right form-control" style="font-size:20px;" readonly>
                        </div>
                        <table class="table table-hover">
                            <thead>
                            <th>NRO</th>
                            <th>CODIGO</th>
                            <th>MEDICAMENTO</th>
                            <th>PRECIO</th>
                            <th>CANTIDAD</th>
                            <th>SUBTOTAL</th>
                            <th class="toelim">ACCIONES</th>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdMedicamento()}</td>
                                        <td>${list.getNombreMedicamento()}</td>
                                        <td>S/. ${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>S/. ${list.getSubTotal()}</td>
                                        <td class="toelim">
                                            <a class="btn btn-success"><img style="" src="./static/img/edit.png" alt="20" width="20"/></a>
                                            <a class="btn btn-danger"><img style="" src="./static/img/close.png" alt="20" width="20"/></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table> 
                    </div>
                    <div class="card-footer">
                        <div class="row">
                            <div class="col-sm-6 toelim">
                                <div style="margin-bottom:18px;"></div>
                                <button form="idVentas" name="accion" id="idGenerarVenta" value="GenerarVenta"  class="btn btn-lg btn-block btn-success">Confirmar Carrito &nbsp;<img src="./static/img/shopping-cart.png" width="28px" height="28px"></button>
                            </div>
                            <div class="col-sm-2 toelim">
                                <div style="margin-bottom:18px;"></div>
                                <button class="btn btn-block btn-lg btn-warning" onclick="print();"><img src="./static/img/print.png" width="22px" height="22px">&nbsp;Imprimir</button>                        
                            </div>                       
                            <div class="col-sm-2">
                                <div class="form-group">
                                    <label>Total a Pagar</label>
                                    <input type="text" value="S/. ${TotalAPagar}" name="txtTotalAPagar" style="font-size:20px;" class="form-control text-center font-weight-bold" readonly/>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>

        </div>
        <script>
            $('#AgregarCarrito').click(function () {
                if ($('#txtNomMedicamento').val() == null || $('#txtNomMedicamento').val() == "") {
                    alert("Debe seleccionar un Medicamento");
                    return false;
                }
               
            });
            $('#idGenerarVenta').click(function(){
                if ($('#NombreCliente').val() == null || $('#NombreCliente').val() == "") {
                    alert("Debe seleccionar un Cliente");
                    return false;
                }else{
                    alert("Se registró la Venta correctamente")
                }                 
            });
        </script>
    </body>
</html>

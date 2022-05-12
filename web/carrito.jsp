<%-- 
    Document   : productosTienda
    Created on : 10/01/2022, 01:34:41 PM
    Author     : Daniel y Kevin Pc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.apache.jasper.tagplugins.jstl.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Carrito"%>
<%@page import="beans.RegistroBeansP"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ListIterator"%>
<%@page import="DAO.RegistroDAOP"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="commons/cdn.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/global.css" type="text/css">
        <title>Carrito - Alore Store</title>
    </head>
    <body>
        <%@include file="commons/cabecera.jsp" %>
        <div class="container mt-4">
            <h2>Carrito</h2>
            <div class="row">
                <table class="table table-striped">
                    <tr>
                        <th>Producto</th>
                        <th>Nombres</th>
                        <th>Descripción</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Subtotal</th>
                        <th>Acción</th>
                    </tr>
                    
                    <c:forEach var="car" items="${carrito}">
                    <tr>
                        <td>${car.getItem()}</td>
                        <td>${car.getNombres()} 
                            <img src="ControladorIMG?id=${car.getIdProducto()}" class="card-img-top mx-auto d-block" width="100" height="100">
                        </td>
                        <td>${car.getDescripcion()}</td>
                        <td>${car.getPrecioCompra()}</td>
                        <td> 
                            <input type="number" id="Cantidad" value="${car.getCantidad()}" class="form-control text-center" min="1">
                            <input type="hidden" id="idPro" value="${car.getIdProducto()}">
                        </td>
                        <td>${car.getSubTotal()}</td>
                        <td>
                            <input type="hidden" id="idp" value="${car.getIdProducto()}">
                            <a href="#" id="btnDelete">Eliminar</a>

                            <!-- href="ControladorCar?action=Delete&idp=${car.getIdProducto()}"-->
                        </td> 
                    </tr>
                    </c:forEach>
                    
                    
                </table> 
            </div>
            <div class="col-sm-4">
                <div class="shadow p-3 mb-5 bg-body rounded">
                    
                    <div class="card">
                        <div class="card-header">
                            <h3>Compra</h3>
                        </div>
                        <div class="card-body">
                            <label>Subtotal</label>
                            <input type="text" value="${totalPagar}" readonly="" class="form-control">
                        </div>
                        <div class="card-footer">
                            <a href="ControladorCar?action=GenerarCompra&estado=${Usu.getEstado()}" class="btn btn-info btn-block">Realizar pago</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <%@include file="commons/pie.jsp" %>


    </body>
    <script src="js/funciones.js" type="text/javascript"></script>
</html>

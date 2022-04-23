<%-- 
    Document   : index
    Created on : 18/11/2021, 03:06:29 PM
    Author     : Aprendiz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="beans.RegistroBeansP"%>
<%@page import="java.util.ListIterator"%>
<%@page import="DAO.RegistroDAOP"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="commons/cdn.jsp" %>
        <link rel="stylesheet" href="css/global.css" type="text/css">
        <title>Tienda</title>
    </head>
    <body>
        <%@include file="commons/cabecera.jsp" %>
        
        <!--
        <div class="col-sm-3 sidebar-col">
            <//%@include file="commons/Sidebar.jsp" %>
        </div>
        -->
        <div class="container mt-4">
            <div class="row">
                <%
                    List lista = new RegistroDAOP().getAll();
                    ListIterator list = lista.listIterator();
                    
                    while(list.hasNext())
                            {
                                RegistroBeansP recorreg = (RegistroBeansP)list.next();
                            
                    //RegistroBeansP RES = (RegistroBeansP) list.next();

                %>
                <!--
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <label><%= recorreg.getNombre()%></label>
                        </div>
                        <div class="card-body">
                            <i>$.<%= recorreg.getCosto()%></i>
                            <img src="ControladorIMG?id=<%= recorreg.getId()%>" width="200" height="180">
                        </div>
                        <div class="card-footer text center">
                            <label><%= recorreg.getDescripcion()%></label>
                            <div>
                                <a class="btn-outline-info" href="ControladorCar?action=AgregarCarrito&id=<%= recorreg.getId()%>">Agregar al Carrito</a>
                                <!--<button href="ControladorUsu?action=AgregarCarrito&id=<%= recorreg.getId()%>" type="button" class="btn btn-primary">Agregar Carrito</button>
                                
                                <button href="" type="button" class="btn btn-warning">Comprar ahora</button>
                            </div>

                        </div>
                            
                    </div>
                </div>
                    -->
                <div class="col">
            <div class="card text-center" style="width: 18rem;">
                <img src="ControladorIMG?id=<%= recorreg.getId()%>" class="card-img-top mx-auto d-block" alt="..." width="200" height="180">
                <i>$<%= recorreg.getCosto()%></i>
                <div class="card-body">
                  <h5 class="card-title"><%= recorreg.getNombre()%></h5>
                  <p class="card-text"><p><%= recorreg.getDescripcion()%></p>
                  <a class="btn-outline-info" href="ControladorCar?action=AgregarCarrito&id=<%= recorreg.getId()%>">Agregar al Carrito</a>
                  <a href="ControladorCar?action=Comprar&id=<%= recorreg.getId()%>" class="btn btn-primary">Comprar ahora</a>
                </div>
            </div>
            <br>
        </div>
               <%
                            }
                %> 
                
                

            </div>


        </div> 



        <%@include file="commons/pie.jsp" %>
        <script src="./tienda.js"></script>
    </body>

</html>

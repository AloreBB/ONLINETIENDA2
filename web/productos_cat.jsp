<%-- 
    Document   : usuarios
    Created on : 22/11/2021, 05:35:31 PM
    Author     : Aprendiz
--%>

<%@page import="beans.RegistroBeansCat"%>
<%@page import="DAO.RegistroDAOCat"%>
<%@page import="DAO.RegistroDAOP"%>
<%@page import="beans.RegistroBeansP"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="commons/cdn.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="commons/comm_categoria/GlobalC.css" type="text/css">
        <title>Usuarios</title>
    </head>
    <body>
        <%@include file="commons/comm_categoria/CabeceraC.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 sidebar-col">
                    <%@include file="commons/comm_categoria/SidebarC.jsp" %>
                </div>
                <div class="col-sm-9 main-col">
                    <br>
                <form action="ControladorC?menu=Categoria" method="POST">
                    <div class="form-group d-flex">
                        <div class="col-sm-3">
                            <label>Nombre</label>
                            <input type="text" class="form-control" value="${Categoria.getNombre()}" name="txtNombreCat">  
                        </div>
                        
                    </div>
                        
                    <div>
                        <button type="submit" name="action" value="insertar" class="btn btn-success mt-4 mr-sm-2">
                        <a class="fas fa-user-plus">Guardar</a>
                        </button>
                        <button type="submit" name="action" value="modificar" class="btn btn-danger mt-4">
                        <a class="fas fa-edit">Modificar</a>
                        </button>
                    </div>
                    
                    
                </form>
                    <h1>Lista de Productos</h1>
                    <!--Filtro para buscar usuario en especifico-->
                        <input class="form-control" id="myInputC" type="text" placeholder="Buscar...">
                        <br/>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Estado</th>
                             
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        
                        <tbody id="myTableC">
                            <%
                            List listaCat = new RegistroDAOCat().getAll();
                            ListIterator listCat = listaCat.listIterator();
                            while(listCat.hasNext())
                            {
                                RegistroBeansCat RESC = (RegistroBeansCat)listCat.next();
                            
                        %>
                        
                        <tr>
                            <td><%= RESC.getId() %></td>
                            <td><%= RESC.getNombre() %></td>      
                            <td><%= RESC.getEstado()%></td>

                            <td>
                                <a class="btn btn-warning" href="ControladorC?menu=Categoria&action=cargar&id=<%=RESC.getId()%>">Editar</a>
                            </td>
                            <td>
                                <a class="btn btn-danger" href="ControladorC?menu=Categoria&action=eliminar&id=<%=RESC.getId()%>">Eliminar</a>
                            </td>
                            <%
                                }
                                %>
                        </tr>
                        </tbody>
                        <script>
                            $(document).ready(function(){
                                $("#myInputC").on("keyup", function (){
                                    var value = $(this).val().toLowerCase();
                                    $("#myTableC tr").filter(function() {
                                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                                    });
                                });
                            });
                        </script>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

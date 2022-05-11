<%-- 
    Document   : usuarios
    Created on : 22/11/2021, 05:35:31 PM
    Author     : Aprendiz
--%>

<%@page import="beans.RegistroBeans"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="DAO.RegistroDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="commons/cdn.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="admin/commons/globalAdmin.css" type="text/css">
        <title>Usuarios</title>
    </head>
    <body>
        <%@include file="admin/commons/cabeceraAdmin.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 sidebar-col">
                    <%@include file="admin/commons/sidebarAdmin.jsp" %>
                </div>
                <div class="col-sm-9 main-col">
                    <br>
                <form action="ControladorAdmin?menu=Admin" method="POST">
                    <div class="form-group d-flex">
                        
                        <div class="col-sm-3">
                            <label>Nombre:</label>
                            <input type="text" class="form-control" value="${usuario.getNombres()}"  name="txtNombres">
                        </div>
                        <div class="col-sm-3">
                            <label>Contacto:</label>
                            <input type="text" class="form-control" value="${usuario.getContacto()}" name="txtContacto">  
                        </div>
                        <div class="col-sm-3">
                            <label>Correo:</label>
                            <input type="email" class="form-control" value="${usuario.getCorreo()}" name="txtCorreo">
                        </div>
                        <div class="col-sm-3">
                            <label>Contraseña:</label>
                            <input type="password" class="form-control" value="${usuario.getPass()}" name="txtPassword" >
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
                    <h1>Lista de Usuarios</h1>
                    <!--Filtro para buscar usuario en especifico-->
                        <input class="form-control" id="myInput" type="text" placeholder="Buscar...">
                        <br/>
                    <table class="table table-bordered" >
                        
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Contacto</th>
                                <th>Correo</th>
                                <th>Rol</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        
                        <tbody id="myTable">
                        <%
                            List rlista = new RegistroDAO().getAll();
                            ListIterator list = rlista.listIterator();
                            while(list.hasNext())
                            {
                                RegistroBeans recorreg = (RegistroBeans)list.next();
                            
                        %>
                        
                            <tr>
                                <td><%= recorreg.getId() %></td>
                                <td><%= recorreg.getNombres() %></td>
                                <td><%= recorreg.getContacto() %></td>
                                <td><%= recorreg.getCorreo() %></td>
                                <td><%= recorreg.getRol() %></td>
                                <td>
                                    <a class="btn btn-warning" href="ControladorAdmin?menu=Admin&action=carga&id=<%=recorreg.getId()%>">Editar</a>
                                </td>
                                <td>
                                    <a class="btn btn-danger" href="ControladorAdmin?menu=Admin&action=eliminar&id=<%=recorreg.getId()%>">Eliminar</a>
                                </td>
                                <%
                                    }
                                    %>
                            </tr>
                        </tbody>
                    </table>
                        <script>
                            $(document).ready(function(){
                                $("#myInput").on("keyup", function (){
                                    var value = $(this).val().toLowerCase();
                                    $("#myTable tr").filter(function() {
                                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                                    });
                                });
                            });
                        </script>
                </div>
            </div>
        </div>
    </body>
</html>

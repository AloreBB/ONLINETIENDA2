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
        <link rel="stylesheet" href="commons/comm_usuarios/GlobalU.css" type="text/css">
        <title>Usuarios</title>
    </head>
    <body>
        <%@include file="commons/comm_usuarios/CabeceraU.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 sidebar-col">
                    <%@include file="commons/comm_usuarios/SidebarU.jsp" %>
                </div>    
                <div class="col-sm-9 main-col">
                    <br>
                <form action="ControladorUsu?menu=Usuario" method="POST">
                    <div class="form-group d-flex">
                        
                        <div class="col-sm-3">
                            <label>Nombre:</label>
                            <input type="hidden" id="idUsu" value="${usuario.getId()}">
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

                        
                    </div>
                        
                    <div>
                        <button type="submit" name="action" value="modificar" class="btn btn-danger mt-4">
                        <a class="fas fa-edit">Actualizar</a>
                        </button>
                    </div>
                    
                </form>
                    <h1>Usuario</h1>
                    <table class="table table-bordered">
                        <tr>
                            <th>ID</th>
                            <th>Nombres</th>
                            <th>Contacto</th>
                            <th>Correo</th>
                            <th>Rol</th>

                        </tr>
                        

                        <tr>
                            <td>${Usu.getId()}</td>
                            <td>${Usu.getNombres()}</td>
                            <td>${Usu.getContacto()}</td>
                            <td>${Usu.getCorreo()}</td>
                            <td>${Usu.getRol()}</td>
                            <td>
                                <a class="btn btn-warning" href="ControladorUsu?menu=Usuario&action=carga&id=${Usu.getId()}">Editar</a>
                            </td>
                            
                            <!--
                            <td>
                                <a class="btn btn-danger" href="ControladorUsu?menu=Usuario&action=eliminar&id=${Usu.getId()}">Eliminar</a>
                            </td>
                            -->
                        
                    </table>
                </div>                
                
                
                
            </div>
        </div>
        
    </body>
</html>

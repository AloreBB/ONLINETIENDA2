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
        <link rel="stylesheet" href="commons/comm_productos/GlobalP.css" type="text/css">
        <title>Productos</title>
    </head>
    <body>
        <%@include file="commons/comm_productos/CabeceraP.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 sidebar-col">
                    <%@include file="commons/comm_productos/SidebarP.jsp" %>
                </div>
                <div class="col-sm-9 main-col">
                    <br>
                <form action="ControladorP?menu=Producto" method="POST">
                    <div class="form-group d-flex">
                        
                        <div class="col-sm-3">
                            <label>Nombre</label>
                            <input type="text" class="form-control" value="${Producto.getNombre()}"  name="txtNom">
                        </div>
                        <div class="col-sm-3">
                            <label>Costo</label>
                            <input type="float" class="form-control" value="${Producto.getCosto()}" name="txtCost">  
                        </div>
                        
                        <div class="col-sm-3">
                            <label>Cantidad</label>
                            <input type="number" class="form-control" value="${Producto.getCantidad()}" name="txtCant">
                        </div>
                        <div class="col-sm-3">
                            <label>Descripción</label>
                            <input type="text" class="form-control" value="${Producto.getDescripcion()}" name="txtDesc">
                        </div>
                        
                        
                    </div>
                        <div class="col-sm-3">
                            <label>Categoria</label> 
                            <!-- Aqui comienzan los cambios para ver categorias con un
                            selector-->
                            <select value="${Producto.getId_categoria()}" name="categoria" class="form-control">
                                <option>Seleccionar</option>
                                <%
                                    List listaCat = new RegistroDAOCat().getAll();
                                    ListIterator listC = listaCat.listIterator();
                                    while(listC.hasNext())
                                    {
                                        RegistroBeansCat cat = (RegistroBeansCat)listC.next();

                                %>
                                <option name="categoria" value="<%= cat.getId()%>"><%= cat.getNombre()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        
                    <div>
                        <button type="submit" name="action" value="insertar" class="btn btn-success mt-4 mr-sm-2">
                        <a class="fas fa-user-plus">Insertar</a>
                        </button>
                        <button type="submit" name="action" value="modificar" class="btn btn-danger mt-4">
                        <a class="fas fa-edit">Modificar</a>
                        </button>
                    </div>
                    
                    
                </form>
                    <h1>Lista de Productos</h1>
                    <table class="table table-bordered">
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Costo</th>
                            <th>Cantidad</th>
                            <th>Descripción</th>
                            <th>Estado</th>
                            <th>Categoria</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <%
                            List lista = new RegistroDAOP().getAll();
                            ListIterator list = lista.listIterator();
                            while(list.hasNext())
                            {
                                RegistroBeansP RES = (RegistroBeansP)list.next();
                            
                        %>
                        
                        <tr>
                            <td><%= RES.getId() %></td>
                            <td><%= RES.getNombre() %></td>      
                            <td><%= RES.getCosto() %></td>
                            <td><%= RES.getCantidad() %></td>
                            <td><%= RES.getDescripcion()%></td>
                            <td><%= RES.getEstado()%></td>
                            <td><%= RES.getCategoria()%></td>

                            <td>
                                <a class="btn btn-warning" href="ControladorP?menu=Producto&action=carga&id=<%=RES.getId()%>">Editar</a>
                            </td>
                            <td>
                                <a class="btn btn-danger" href="ControladorP?menu=Producto&action=eliminar&id=<%=RES.getId()%>">Eliminar</a>
                            </td>
                            <%
                                }
                                %>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

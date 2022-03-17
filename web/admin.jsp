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
        <title>Admin</title>
    </head>
    <body>
        <%@include file="admin/commons/cabeceraAdmin.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 sidebar-col">
                    <%@include file="admin/commons/sidebarAdmin.jsp" %>
                </div>
                <div class="col-sm-9 main-col">
                    
                </div>
            </div>
        </div>
        
        
        
    </body>
    
</html>

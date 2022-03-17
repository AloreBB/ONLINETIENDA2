<%-- 
    Document   : logueo
    Created on : 18/11/2021, 03:12:46 PM
    Author     : Aprendiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="commons/cdn.jsp" %>
        <link rel="stylesheet" href="css/global.css" type="text/css">
        <title>Login</title>
    </head>
    <body>
        <%@include file="commons/cabecera.jsp"%>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sign" action="ValidarLogueo" method="POST">
                        <div class="form-group text-center">
                            <h3>Login</h3>
                            <img src="img/login.png" alt="20" width="120">
                            <br><br>
                            <label>Ingreso al Sistema</label>
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" name="txtUser" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" name="txtPass" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block">
                        <a href="index.jsp" class="btn btn-primary btn-block">Volver</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
    
</html>

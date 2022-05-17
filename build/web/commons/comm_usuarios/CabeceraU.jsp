<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
    <a class="navbar-brand" href="index.jsp">D-Compras</a>

  <!-- Toggler/collapsibe Button -->
  <a href="../../../../../../AppData/Local/Temp/Link.url"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
    </button> 
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="usuarios.jsp">Inicio</a>
            </li>
        </ul>
    </div>
    <div margin-left="-500vh" class="dropdown">
        <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
          <image src="img/usu.png" height="30" width="30">
        </button> 
        <div class="dropdown-menu">
            <form class="form-sign" action="ValidarLogueo" method="POST">
                <input class="dropdown-item" type="submit" name="accion" value="Salir">
            </form>
            
        </div>
    </div>

</nav>



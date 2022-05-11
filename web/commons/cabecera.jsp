<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="index.jsp">D compras bb</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="">Inicio</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Acerca</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Contactos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="registro.jsp">Registro</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="usuarios.jsp">Usuario</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="logueo.jsp">Login <i class="bi bi-person-fill"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
  <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
</svg></i></a>
      </li>
    </ul>
  </div>
  
  <a href="ControladorCar?action=Carrito" aria-label="" class="nav-a nav-a-2 nav-progressive-attribute" id="nav-cart">
    <div id="nav-cart-count-container">
      <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="white" class="bi bi-cart3" viewBox="0 0 16 16">
    <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
    </svg>
    </div>
    <div id="nav-cart-text-container" class=" nav-progressive-attribute">
      <span aria-hidden="true" class="nav-line-1">
        
      </span>
      <span aria-hidden="true" class="nav-line-2">
          <b style="color: white"><i class="fas fa-cart-plus">(<label style="color: fuchsia">${contador}</label>)</i>Carrito</b>
            <span class="nav-icon nav-arrow"></span>
      </span>
    </div>
  </a>
  
  
</nav>
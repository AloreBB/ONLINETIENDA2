$(document).ready(function () {
  $("tr #btnDelete").click(function (){
      var idp = $(this).parent().find("#idp").val();
      Swal.fire({
        title: '¿Borrar del carrito?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Eliminar',
        cancelButtonText: 'Cancelar'
      }).then((result) => {
        if (result.isConfirmed) {
          eliminar(idp);
          Swal.fire(
            '¡Eliminado!',
            'Tu producto se quito del carrito',
            'Listo'
          ).then((willDelete)=>{
              if (willDelete) {
                  parent.location.href="ControladorCar?action=Carrito"
              }
          })

        }
      })
      
      
  }); 
    function eliminar(idp){
        var url = "ControladorCar?action=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp="+idp,
            success: function (data, textStatus, jqXHR){
                
            }
        });
    }
    
    $("tr #Cantidad").click(function (){
        var idp = $(this).parent().find("#idPro").val();
        var cantidad = $(this).parent().find("#Cantidad").val();
        var url = "ControladorCar?action=ActualizarCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp + "&Cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR){
                location.href="ControladorCar?action=Carrito";
            }
        });
    });
    
}) ;



$(function () {
    $('.infoJ').on('click', function () {
        $('.informacionJugador').children('.modal-dialog').children('.modal-content').children('.modal-body').children().remove();
        $(".informacionJugador").modal("show");
        let id = $(this).next().val();
        jugador(id);
    });

    /*$('.btn-warning').on('click', function() {
     $('.tablaJugadores').css('visibility', 'visible');
     $('#datosEquipo').css('visibility', 'visible');
     });*/

});

function jugador(option) {
    $.ajax({
        data: {
            idJugador: option
        },

        type: "post",

        dataType: "json",

        url: "listadoAjax",

        success: function (respuesta) {
            console.log("La solicitud se ha completado correctamente");
            console.log(respuesta);
            crearInfo(respuesta);

        },

        error: function (respuesta) {
            console.log("La solicitud ha fallado " + respuesta);
        }
    });

}

function crearInfo(data) {
    let tablaJugador = `<div id="infoJuaforPersonal"><img id="fotoJug" name="imagen" src="/DataBasket/imagenes/avatares/${data[0].foto}" width="230" height="200"><br>
                                <ul>
                                    <li><h4><Strong>Nombre: </strong>${data[0].nombre}</h4></li>
                                    <li><h4><strong>Posición: </strong>${data[0].posicion}<br></h4></li>
                                    <li><h4><strong>Edad: </strong>${data[0].edad} <strong>Altura: </strong>${data[0].altura} cm <strong>Peso: </strong>${data[0].peso} kg<br></h4></li>
                                    <li><h4><strong>Procedencia: </strong>${data[0].procedencia}<br></h4></li>
                                    <li><h4><strong>Nacionalidad: </strong>${data[0].nacionalidad}<br></h4></li>
                                </ul>
                                </div>`;

    $('.infoJuaforPersonal').remove();
    $('.informacionJugador').children('.modal-dialog').children('.modal-content').children('.modal-body').append(tablaJugador);
}

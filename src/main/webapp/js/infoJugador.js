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
    let tablaJugador = `<TABLE CELLPADDING="20" BORDER="2">
                            <TR><TD ROWSPAN=2><img name="imagen" src="/DataBasket/imagenes/avatares/${data[0].foto}" width="150" height="180"></TD>
                                <TD>Nombre: <strong>${data[0].nombre}</strong></TD> <TD>Posición: <strong>${data[0].posicion}</strong></TD>
                            </TR>
                            <TR><TD>Edad: <strong>${data[0].edad}</strong></TD> <TD>Altura: <strong>${data[0].altura} </strong>cm</TD>
                            </TR>
                            <TR><TD>Procedencia: <strong>${data[0].procedencia}</strong></TD><TD>Nacionalidad: <strong>${data[0].nacionalidad}</strong></TD>
                                <TD>Peso: <strong>${data[0].peso} </strong>kg</TD>
                            </TR>
                        </TABLE>`;

    
    $('.informacionJugador').children('.modal-dialog').children('.modal-content').children('.modal-body').append(tablaJugador);
}

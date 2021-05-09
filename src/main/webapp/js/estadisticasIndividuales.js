$(function () {
    $('.selectJugadores').hide();
    $('.equipos').on('change', function () {
        const  option = $(".equipos option:selected").val();
        //comprobamos que la eleccion del usuario no es la de por defecto
        if (option != 0) {
            $('.jugadores').children().remove();
            jugadores(option);
        }

    });

});

function jugadores(option) {
    $.ajax({
        data: {
            idEquipo: option
        },

        type: "post",

        dataType: "json",

        url: "listadoAjax",

        success: function (respuesta) {
            console.log("La solicitud se ha completado correctamente");
            console.log(respuesta);
            listaJugadores(respuesta);

        },

        error: function (respuesta) {
            console.log("La solicitud ha fallado " + respuesta);
        }
    });

}

/**
 * CREACION TABLA
 * @param {type} data JSON
 * @returns tablaAlumnos
 */
function listaJugadores(data) {
    let opciones;
    
    
    for (let i = 0; i < data.length; i++) {
        opciones += `<option value="${data[i].idJugador}">${data[i].nombre}</option>`;
    }
    $('.jugadores').append('<option selected>Elige uno...</option>');
    $('.jugadores').append(opciones);
    $('.selectJugadores').show();
}


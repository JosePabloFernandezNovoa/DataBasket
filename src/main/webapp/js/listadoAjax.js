$(function () {
    $('.tablaJugadores').hide();
    $('#equipos').on('change', function () {

        const  option = $("#equipos option:selected").val();
        //comprobamos que la eleccion del usuario no es la de por defecto
        if (option != 0) {
            $('#jugadores').children('tbody').children().remove();
            $('#datosEquipo').remove();
            equipos(option);
            jugadores(option);
        }

    });

});

function equipos(option) {
    $.ajax({
        data: {
            equipo: option
        },

        type: "post",

        dataType: "json",

        url: "listadoAjax",

        success: function (respuesta) {
            console.log("La solicitud se ha completado correctamente");
            console.log(respuesta);
            comprobarLista(respuesta);

        },

        error: function (respuesta) {
            console.log("La solicitud ha fallado " + respuesta);
        }
    });

}

//Comprobamos que la lista de equipos que recibimos del servidor no esta vacia,
//en caso de estarlo se dispara una notificaion.
function comprobarLista(data) {
    if (data.length!=0) {
        tablaEquipo(data);
    } else {
        tipo = 'error';
        mensajeNotificacion = 'No existen equipos';
        notificacion(tipo, mensajeNotificacion);
    }
};

/*
 * Creamos el select de equipos y lo rellenamos con los equipos que recibimos del servidor
 */
function tablaEquipo(data) {
    
    let filas;
    
    //creamos las filas y columnas cn los valores recibidos
    for (let i = 0; i < data.length; i++) {
        filas += `<td>${data[i].nombre}</td><td>${data[i].ciudad}</td><td>${data[i].conferencia}</td>
                    <td>${data[i].division}</td><td>${data[i].entrenador}</td><td>${data[i].mascota}</td>`;
    }
    
    let tablaEquipo=`<table class="table table-dark table-striped" id="datosEquipo">
                                <thead>
                                  <tr>
                                    <th scope="col">Info</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Ciudad</th>
                                    <th scope="col">Conferencia</th>
                                    <th scope="col">División</th>
                                    <th scope="col">Entrenador</th>
                                    <th scope="col">Mascota</th>
                                  </tr>
                                </thead>
                                <tbody>
                                  <tr>
                                    <td><button type="button" class="btn btn-info"><i class="fas fa-info"></i></button></td>
                                    ${filas}
                                  </tr>
                                </tbody>
                            </table>`;
    
    $('.datosEquipo').append(tablaEquipo);
}

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
            comprobarListaJugadores(respuesta);

        },

        error: function (respuesta) {
            console.log("La solicitud ha fallado " + respuesta);
        }
    });

}

function comprobarListaJugadores(data) {
    if (data.length!=0) {
        tablaJugadores(data);
    } else {
        tipo = 'error';
        mensajeNotificacion = 'No existen jugadores';
        notificacion(tipo, mensajeNotificacion);
    }
};

/**
 * CREACION TABLA
 * @param {type} data JSON
 * @returns tablaAlumnos
 */
function tablaJugadores(data) {
    let filas;
    
    let boton='<button type="button" class="btn btn-info"><i class="fas fa-info"></i></button>';
    //creamos las filas y columnas cn los valores recibidos
    for (let i = 0; i < data.length; i++) {
        filas += `<tr><td>${boton}
                    </td><td>${data[i].nombre}</td></tr>`;
    }
    
    $('#jugadores').children('tbody').append(filas);
    $('.tablaJugadores').show();
}

//notificacion de error
function notificacion(tipo, mensajeNotificacion) {
    Swal.fire({
        position: 'center',
        width: 450,
        background: 000000,
        icon: tipo,
        title: mensajeNotificacion,
        showConfirmButton: true,
        timer: 4000
    });
}
/* global Swal */
let tipo;
let mensajeNotificacion;

/**
 * Cuando el documento esta totalmente cargado se asigna 2 eventos, 1 al input del DNI
 * y otro al email, ambos se disparan al perder el foco.
 * Cada input tiene un patron, con lo cual si ese patron no se cumple salta una notificacion de error,
 * cuando se cumle se llama a un metodo con el cual se hace la peticion AJAX para su verificacion.
 * Esto es aplicable a ambos input.
 */
$(function () {
    $('#email').on('blur', function () {
        let email=$('#email').val();
        let patron = /^[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;
        if (patron.test(email)) {
            comprobarEmail(email);
        } else {
            tipo = 'error';
            mensajeNotificacion = 'Formato erroneo';
            notificacion(tipo, mensajeNotificacion);
            $('#email').focus();
        }

    });

});


/**
 * Envio del email por AJAX para comprobar que no se repite
 * @returns boolean 
 * Recibimos un booleano como respuesta del servidor, una vez recibimos la respuesta 
 * llaremos a un metodo que compruebe su valor. 
 */
function comprobarEmail(email) {
    $.ajax({
        data: {
            email: email
        },

        type: "post",

        dataType: "json",

        url: "/DataBasket/ajax",

        success: function (respuesta) {
            console.log("La solicitud se ha completado correctamente");
            console.log(respuesta);
            mostrarEmail(respuesta);

        },

        error: function (respuesta) {
            console.log("La solicitud ha fallado " + respuesta);
        }
    });

}

/**
 * COMPROBACION DE DATOS RECIBIDOS POR EL SERVIDOR(EMAIL)
 * @param boolean data
 * @returns notificacion
 * Si el valor de la respuesta del servidor fue TRUE, significa que el email no esta ocupado, 
 * por el contrario si es FALSE significa que ya esta en nuestra BD. En ambos casos se muestra 
 * una notificacion.
 */
function mostrarEmail(data) {
    if (data.verificacion == true) {
        tipo = 'error';
        mensajeNotificacion = 'Email Ocupado';
        notificacion(tipo, mensajeNotificacion);
    }

}

/**
 * NOTIFICACION
 * @param String tipo
 * @param String mensajeNotificacion
 * @returns notificacion
 * recibe 2 paramentros 1 el mensaje que se muestra y otro si es de tipo error
 * o success 
 */
function notificacion(tipo, mensajeNotificacion) {
    Swal.fire({
        position: 'top-end',
        width: 250,
        background: 000000,
        icon: tipo,
        title: mensajeNotificacion,
        showConfirmButton: false,
        timer: 2000
    });
}

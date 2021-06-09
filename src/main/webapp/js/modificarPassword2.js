/* global Swal */

$(document).ready(function () {
    $('.password').on('blur', function (){
        verificarPassword();
    });
    
    $('#enviar').on('mouseover', function (){
        comprobarPassword();
    });
    
});

function verificarPassword() {
    $.ajax({
        data: {
            pass: $('.password').val()
        },

        type: "post",

        dataType: "json",

        url: "ajax",

        success: function (respuesta) {
            console.log("La solicitudd se ha completado correctamente");
            console.log(respuesta);
            mostrarPassword(respuesta);

        },

        error: function (respuesta) {
            console.log("La solicitud ha fallado " + respuesta);
        }
    });

}

function mostrarPassword(data) {
    if (data.verificacion == false) {
        tipo = 'error';
        mensajeNotificacion = 'Password incorrecta';
        notificacion(tipo, mensajeNotificacion);
    }else{
        $(".passConfirm").css('display', 'inline');
    }

}

function comprobarPassword() {
    let pass1=$('.pass1').val();
    let pass2=$('.pass2').val();

    if(pass1!=pass2){
        tipo = 'error';
        mensajeNotificacion = 'Las password deben coincidir';
        notificacion(tipo, mensajeNotificacion);
    }
}

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
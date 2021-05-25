/* global Swal */

$(function () {
    $('#register-form').on('mouseover', '.enviar', function (){
        comprobarPassword();
    });
});

function comprobarPassword() {
    let pass1=$('.pass1').val();
    let pass2=$('.pass2').val();

    if(pass1.length==0 || pass2.length==0){
        tipo = 'error';
        mensajeNotificacion = 'Se deben completar la password';
        notificacion(tipo, mensajeNotificacion);
    }else if(pass1!=pass2){
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
/* global Swal */

$(function () {
    notificacion();
});

function notificacion() {
   Swal.fire({
        position: 'top-end',
        width: 300,
        background: 000000,
        icon: 'error',
        title: 'La imagen sobrepasa el tamaño permitido',
        showConfirmButton: false,
        timer: 3000
    });
}

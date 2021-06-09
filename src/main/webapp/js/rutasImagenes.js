/**
 *Cuando el documento esta cargado por completo asignamos a la etiqueta img un evento,
 *para cada ves que se cambie sucontenido se dispare.
 */
$(document).ready(function () {
    $('#foto').on('change', function () {
        console.log("entra");
        setTimeout(function () {
            let srcValue = $('#vistaPrevia').attr('src');
            console.log(srcValue);
            $('#avatarForm').attr('value', `${srcValue}`);
        }, 5);

    });
});

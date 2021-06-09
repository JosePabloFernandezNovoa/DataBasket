/**
 *Cuando el documento esta cargado por completo asignamos a la etiqueta img un evento,
 *para cada ves que se cambie sucontenido se dispare.
 */
$(document).ready(function() {
    $('#foto').on('change',function () {
        vistaPrevia(this);
    })
});

var imagen;
//Cargamos la imagen en la equiqueta
function vistaPrevia(input) {
    if(input.files && input.files[0]){
        var reader= new FileReader();
        reader.onload=function (e) {
            imagen=e.target.result;
            $('#vistaPrevia').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }    
}

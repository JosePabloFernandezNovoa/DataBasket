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
    
    $('.jugadores').on('change', function () {
        const  option = $(".jugadores option:selected").val();
        //comprobamos que la eleccion del usuario no es la de por defecto
        if (option != 0) {
            listarEstadisticas(option);
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

function listarEstadisticas(option) {
    $.ajax({
        data: {
            jugador: option
        },

        type: "post",

        dataType: "json",

        url: "listadoAjax",

        success: function (respuesta) {
            console.log("La solicitud se ha completado correctamente");
            console.log(respuesta);
            cargarDatos(respuesta);

        },

        error: function (respuesta) {
            console.log("La solicitud ha fallado " + respuesta);
        }
    });

}

function cargarDatos(datos) {
  let nombreJugador=datos[0].jugador.nombre;  
    
  let puntosGrafico=[];
  let puntosTotales=0;
  let mediaPuntos=0;

  let asistenciasGrafico=[];
  let asistenciasTotales=0;
  let mediaAsistencias=0;
  
  let rebotesGrafico=[];
  let rebotesTotales=0;
  let mediaRebotes=0;

  let taponesGrafico=[];
  let taponesTotales=0;
  let mediaTapones=0;

  let partidos=[];

  let medias='';

  for (let i = 0; i < datos.length; i++) {
    /*******PARTIDOS**********/
    let equipoLocal = $(datos[i].partido.equipoLocal).attr('nombre');
    let equipoVisitante= $(datos[i].partido.equipoVisitante).attr('nombre');
    let p=`${equipoLocal}-${equipoVisitante}`;
    partidos.push(p);
  }

  
  /******************DATOS******************/
  for (let i = 0; i < datos.length; i++) {
    /*******PUNTOS PARTIDO**********/
    let puntos = $(datos[i]).attr('puntosPartido');
    puntosGrafico.push(puntos);
    mediaPuntos+=$(datos[i]).attr('puntosPartido');
    /*****************ASISTENCIAS PARTIDO**************/
    let asistencias = $(datos[i]).attr('asistenciasPartido');
    asistenciasGrafico.push(asistencias);
    mediaAsistencias+=$(datos[i]).attr('asistenciasPartido');
    /*****************REBOTES PARTIDO**************/
    let rebotes = $(datos[i]).attr('rebotesPartido');
    rebotesGrafico.push(rebotes);
    mediaRebotes+=$(datos[i]).attr('rebotesPartido');
    /*****************TAPONES PARTIDO**************/
    let tapones=$(datos[i]).attr('taponesPartido');
    taponesGrafico.push(tapones);
    mediaTapones+=$(datos[i]).attr('taponesPartido');
  }

  /**********MEDIAS******************/
  mediaPuntos=mediaPuntos/datos.length;
  mediaAsistencias=mediaAsistencias/datos.length;
  mediaRebotes=mediaRebotes/datos.length;
  mediaTapones=mediaTapones/datos.length;

  medias=`<tr><td class="table-warning">${datos[0].jugador.nombre}</td><td class="table-warning">${mediaPuntos.toFixed(2)}</td><td class="table-warning">${mediaAsistencias}</td><td class="table-primary">${mediaRebotes}</td><td class="table-warning">${mediaTapones}</td></tr>`;

  /*********************CONSTRUCCION GRÁFICOS********************/
  graficoPuntos(partidos, puntosGrafico, nombreJugador);
  /*graficoAsistencias(partidos, asistenciasGrafico, nombreJugador);
  graficoRebotes(partidos, rebotesGrafico, nombreJugador);
  graficoTapones(partidos, taponesGrafico, nombreJugador);*/
  tablaMedias(medias);
}

function tablaMedias(medias){

  let tablaMedias=`<h4 class="tituloGraf">Media de Datos</h4>
    <table class="table">
      <thead class="thead-dark">
        <tr>
          <th scope="col">#</th>
          <th scope="col">Puntos</th>
          <th scope="col">Asistencias</th>
          <th scope="col">Rebotes</th>
          <th scope="col">Tapones</th>
        </tr>
      </thead>
      <tbody>
        ${medias}
      </tbody>
    </table>`;   

    $('.tabla').append(tablaMedias);

}
function graficoPuntos(partidos, puntosGrafico, nombreJugador) {
  
  let graficoPuntos=`<canvas id="puntos"></canvas>`;
  let tituloGrafico=`<h4 class="tituloGraf">Puntos Partido</h4>`;
  $('.graficoPuntos').append(tituloGrafico);
  $('.graficoPuntos').append(graficoPuntos);

  let puntos = $("#puntos");
  Chart.defaults.global.defaultFontFamily = "Lato";
  Chart.defaults.global.defaultFontSize = 18;

  let data = {
      label: `${nombreJugador}`,
      data: puntosGrafico,
      lineTension: 0,
      fill: false,
      borderColor: 'red',
      pointBackgroundColor: 'red'
    };

  let speedData = {
    labels: partidos,
    datasets: [data]
  };

  let chartOptions = {
    legend: {
      display: true,
      position: 'top',
      labels: {
        boxWidth: 50,
        fontColor: 'black'
      }
    }
  };

    let lineChart = new Chart(puntos, {
    type: 'line',
    data: speedData,
    options: chartOptions
  });

}

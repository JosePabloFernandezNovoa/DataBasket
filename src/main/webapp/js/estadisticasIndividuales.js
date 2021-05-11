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
            $('.informacion').children().remove();
            $('.tabla').children().remove();
            $('.graficoPuntos').children().remove();
            $('.graficoAsistencias').children().remove();
            $('.graficoRebotes').children().remove();
            $('.graficoTapones').children().remove();
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
            info(respuesta);

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
  let totales='';

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
    puntosTotales+=$(datos[i]).attr('puntosPartido');
    /*****************ASISTENCIAS PARTIDO**************/
    let asistencias = $(datos[i]).attr('asistenciasPartido');
    asistenciasGrafico.push(asistencias);
    mediaAsistencias+=$(datos[i]).attr('asistenciasPartido');
    asistenciasTotales+=$(datos[i]).attr('asistenciasPartido');
    /*****************REBOTES PARTIDO**************/
    let rebotes = $(datos[i]).attr('rebotesPartido');
    rebotesGrafico.push(rebotes);
    mediaRebotes+=$(datos[i]).attr('rebotesPartido');
    rebotesTotales+=$(datos[i]).attr('rebotesPartido');
    /*****************TAPONES PARTIDO**************/
    let tapones=$(datos[i]).attr('taponesPartido');
    taponesGrafico.push(tapones);
    mediaTapones+=$(datos[i]).attr('taponesPartido');
    taponesTotales+=$(datos[i]).attr('taponesPartido');
  }

  /**********MEDIAS******************/
  mediaPuntos=mediaPuntos/datos.length;
  mediaAsistencias=mediaAsistencias/datos.length;
  mediaRebotes=mediaRebotes/datos.length;
  mediaTapones=mediaTapones/datos.length;

  medias=`<tr><td class="table-danger">${mediaPuntos.toFixed(2)}</td><td class="table-success">${mediaAsistencias.toFixed(2)}</td><td class="table-warning">${mediaRebotes.toFixed(2)}</td><td class="table-info">${mediaTapones.toFixed(2)}</td></tr>`;
  
  totales=`<tr><td class="table-danger">${puntosTotales}</td><td class="table-success">${asistenciasTotales}</td><td class="table-warning">${rebotesTotales}</td><td class="table-info">${taponesTotales}</td></tr>`;

  /*********************CONSTRUCCION GRÁFICOS********************/
  graficoPuntos(partidos, puntosGrafico, nombreJugador);
  graficoAsistencias(partidos, asistenciasGrafico, nombreJugador);
  graficoRebotes(partidos, rebotesGrafico, nombreJugador);
  graficoTapones(partidos, taponesGrafico, nombreJugador);
  tablaMedias(medias);
    tablaTotal(totales);
}

function tablaMedias(medias){

  let tablaMedias=`<h4 class="tituloGraf">Media de Datos</h4>
    <table class="table">
      <thead class="thead-dark">
        <tr>
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

function tablaTotal(total){

  let tablaTotales=`<h4 class="tituloGraf">Datos Totales</h4>
    <table class="table">
      <thead class="thead-dark">
        <tr>
          <th scope="col">Puntos</th>
          <th scope="col">Asistencias</th>
          <th scope="col">Rebotes</th>
          <th scope="col">Tapones</th>
        </tr>
      </thead>
      <tbody>
        ${total}
      </tbody>
    </table>`;   

    $('.tabla').append(tablaTotales);

}

function info(data){
  $('#imagen').attr('src', `/DataBasket/imagenes/avatares/${data[0].jugador.foto}`);
    /*
  let tablaTotales=`<h4 class="tituloGraf">Datos Totales</h4>
    <table class="table">
      <thead class="thead-dark">
        <tr>
          <th scope="col">Puntos</th>
          <th scope="col">Asistencias</th>
          <th scope="col">Rebotes</th>
          <th scope="col">Tapones</th>
        </tr>
      </thead>
      <tbody>
        ${total}
      </tbody>
    </table>`;   

    $('.tabla').append(tablaTotales);
*/
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

function graficoAsistencias(partidos, asistenciasGrafico, nombreJugador) {
  
  let graficoAsistencias=`<canvas id="asistencias"></canvas>`;
  let tituloGrafico=`<h4 class="tituloGraf">Asistencias Partido</h4>`;
  $('.graficoAsistencias').append(tituloGrafico);
  $('.graficoAsistencias').append(graficoAsistencias);

  let asistencias = $("#asistencias");
  Chart.defaults.global.defaultFontFamily = "Lato";
  Chart.defaults.global.defaultFontSize = 18;

  let data = {
      label: `${nombreJugador}`,
      data: asistenciasGrafico,
      fill: false,
      borderColor: 'green',
      pointBackgroundColor: 'green',
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

  let lineChart = new Chart(asistencias, {
    type: 'line',
    data: speedData,
    options: chartOptions
  });

}

function graficoRebotes(partidos, rebotesGrafico, nombreJugador) {

  let graficoRebotes=`<canvas id="rebotes"></canvas>`;
  let tituloGrafico=`<h4 class="tituloGraf">Rebotes Partido</h4>`;
  $('.graficoRebotes').append(tituloGrafico);
  $('.graficoRebotes').append(graficoRebotes);

  Chart.defaults.global.defaultFontFamily = "Lato";
  Chart.defaults.global.defaultFontSize = 18;
  Chart.defaults.global.defaultFontColor = 'blue';

  let color = Chart.helpers.color;

  let data = {
    label: `${nombreJugador}`,
    backgroundColor: color('brown').alpha(0.5).rgbString(),
    borderColor: 'brown',
    data:rebotesGrafico,
    fill: true,
    };

  let speedData = {
    labels: partidos,
    datasets: [data]
  };

  let optionsGrafico = {
      responsive: true,
      plugins: {
        legend: {
          position: 'bottom'
        },
        title: {
          display: true,
          text: `${nombreJugador}`
        }
      },
  };

    let rebotes = $("#rebotes");
    let lineChart = new Chart(rebotes, {
      type: 'line',
      data: speedData,
      options: optionsGrafico
    });

}

function graficoTapones(partidos, taponesGrafico, nombreJugador) {

  let graficoTapones=`<canvas id="tapones"></canvas>`;
  let tituloGrafico=`<h4 class="tituloGraf">Tapones partido</h4>`;
  $('.graficoTapones').append(tituloGrafico);
  $('.graficoTapones').append(graficoTapones);

  Chart.defaults.global.defaultFontFamily = "Lato";
  Chart.defaults.global.defaultFontSize = 18;

  var data = {
    label: `${nombreJugador}`,
    data: taponesGrafico,
    backgroundColor: 'purple',
    borderColor: 'black',
    borderWidth: 0
  };

  var config = {
    labels: partidos,
    datasets: [data]
  };


  let tapones = $("#tapones");
  var barChart = new Chart(tapones, {
    type: 'bar',
    data: config
  });
}

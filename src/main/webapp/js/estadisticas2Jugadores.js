$(function () {
    $('.selectJugadores').hide();
    $('.selectJugadores2').hide();
    $('.equiposDos').hide();
    $('.equipos').on('change', function () {
        const  option = $(".equipos option:selected").val();
        //comprobamos que la eleccion del usuario no es la de por defecto
        if (option != 0) {
            $('.jugadores').children().remove();
            jugadores(option);
        }

    });
    
    $('.equipos2').on('change', function () {
        const  option = $(".equipos2 option:selected").val();
        //comprobamos que la eleccion del usuario no es la de por defecto
        if (option != 0) {
            $('.jugadores2').children().remove();
            jugadores2(option);
        }

    });
    
    $('.jugadores2').on('change', function () {
        const  option1 = $(".jugadores option:selected").val();
        const  option2 = $(".jugadores2 option:selected").val();
        //comprobamos que la eleccion del usuario no es la de por defecto
        if (option1 != 0 && option2 !=0) {
            $('.imagenJ1').children().remove();
            $('.versus').children().remove();
            $('.imagenJ2').children().remove();
            $('.tabla').children().remove();
            $('.graficoPuntos').children().remove();
            $('.graficoAsistencias').children().remove();
            $('.graficoRebotes').children().remove();
            $('.graficoTapones').children().remove();
            listarEstadisticas(option1, option2);
            
        }

    });
    
    $('.jugadores').on('change', function () {
        const  option1 = $(".jugadores option:selected").val();
        //comprobamos que la eleccion del usuario no es la de por defecto
        if (option1 != 0) {
            $('.equiposDos').show();   
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

function jugadores2(option) {
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
            listaJugadores2(respuesta);

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

function listaJugadores2(data) {
    let opciones;
    
    
    for (let i = 0; i < data.length; i++) {
        opciones += `<option value="${data[i].idJugador}">${data[i].nombre}</option>`;
    }
    $('.jugadores2').append('<option selected>Elige uno...</option>');
    $('.jugadores2').append(opciones);
    $('.selectJugadores2').show();
}

function listarEstadisticas(option1, option2) {
    $.ajax({
        data: {
            jugador1: option1,
            jugador2: option2
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
  let ultimaPosc=datos.length/2;
  let nombreJugador1=datos[0].jugador.nombre;
  let nombreJugador2=datos[ultimaPosc].jugador.nombre;
    
  let puntosGraficoJ1=[];
  let puntosTotalesJ1=0;
  let mediaPuntosJ1=0;
  let puntosGraficoJ2=[];
  let puntosTotalesJ2=0;
  let mediaPuntosJ2=0;

  let asistenciasGraficoJ1=[];
  let asistenciasTotalesJ1=0;
  let mediaAsistenciasJ1=0;
  let asistenciasGraficoJ2=[];
  let asistenciasTotalesJ2=0;
  let mediaAsistenciasJ2=0;
  
  let rebotesGraficoJ1=[];
  let rebotesTotalesJ1=0;
  let mediaRebotesJ1=0;
  let rebotesGraficoJ2=[];
  let rebotesTotalesJ2=0;
  let mediaRebotesJ2=0;

  let taponesGraficoJ1=[];
  let taponesTotalesJ1=0;
  let mediaTaponesJ1=0;
  let taponesGraficoJ2=[];
  let taponesTotalesJ2=0;
  let mediaTaponesJ2=0;

  let partidos=[];

  let mediasJ1='';
  let totalesJ1='';
  let mediasJ2='';
  let totalesJ2='';
  
  let triplesDoblesJ1 = 0;
  let doblesDoblesJ1 = 0;

  let triplesDoblesTotalesJ1 = 0;
  let doblesDoblesTotalesJ1 = 0;
  
  let triplesDoblesJ2 = 0;
  let doblesDoblesJ2 = 0;

  let triplesDoblesTotalesJ2 = 0;
  let doblesDoblesTotalesJ2 = 0;

  for (let i = 0; i < datos.length/2; i++) {
    let p=`Partido ${i+1}`;
    partidos.push(p);
  }

  
  /******************DATOS J1******************/
  for (let i = 0; i < (datos.length/2); i++) {
    /*******PUNTOS PARTIDO**********/
    let puntos = $(datos[i]).attr('puntosPartido');
    puntosGraficoJ1.push(puntos);
    mediaPuntosJ1+=$(datos[i]).attr('puntosPartido');
    puntosTotalesJ1+=$(datos[i]).attr('puntosPartido');
    /*****************ASISTENCIAS PARTIDO**************/
    let asistencias = $(datos[i]).attr('asistenciasPartido');
    asistenciasGraficoJ1.push(asistencias);
    mediaAsistenciasJ1+=$(datos[i]).attr('asistenciasPartido');
    asistenciasTotalesJ1+=$(datos[i]).attr('asistenciasPartido');
    /*****************REBOTES PARTIDO**************/
    let rebotes = $(datos[i]).attr('rebotesPartido');
    rebotesGraficoJ1.push(rebotes);
    mediaRebotesJ1+=$(datos[i]).attr('rebotesPartido');
    rebotesTotalesJ1+=$(datos[i]).attr('rebotesPartido');
    /*****************TAPONES PARTIDO**************/
    let tapones=$(datos[i]).attr('taponesPartido');
    taponesGraficoJ1.push(tapones);
    mediaTaponesJ1+=$(datos[i]).attr('taponesPartido');
    taponesTotalesJ1+=$(datos[i]).attr('taponesPartido');
    
    if (puntos >= 10) {
            
            triplesDoblesJ1 += 1;
            doblesDoblesJ1 += 1;
            
        } 
        
        if (asistencias >= 10) {
            
            triplesDoblesJ1 += 1;
            doblesDoblesJ1 += 1;
            
        } 
        
        if (rebotes >= 10) {
            
            triplesDoblesJ1 += 1;
            doblesDoblesJ1 += 1;
            
        } 
        
        if (tapones >= 10) {
            
            triplesDoblesJ1 += 1;
            doblesDoblesJ1 += 1;
        }

        if (triplesDoblesJ1 >= 3) {
            triplesDoblesTotalesJ1 += 1;
            
        }else if (doblesDoblesJ1 == 2) {
            doblesDoblesTotalesJ1 += 1;
        }
        
        triplesDoblesJ1=0;
        doblesDoblesJ1=0;
  }
  
  /******************DATOS J2******************/
  for (let i = (datos.length/2); i < datos.length; i++) {
    /*******PUNTOS PARTIDO**********/
    let puntos = $(datos[i]).attr('puntosPartido');
    puntosGraficoJ2.push(puntos);
    mediaPuntosJ2+=$(datos[i]).attr('puntosPartido');
    puntosTotalesJ2+=$(datos[i]).attr('puntosPartido');
    /*****************ASISTENCIAS PARTIDO**************/
    let asistencias = $(datos[i]).attr('asistenciasPartido');
    asistenciasGraficoJ2.push(asistencias);
    mediaAsistenciasJ2+=$(datos[i]).attr('asistenciasPartido');
    asistenciasTotalesJ2+=$(datos[i]).attr('asistenciasPartido');
    /*****************REBOTES PARTIDO**************/
    let rebotes = $(datos[i]).attr('rebotesPartido');
    rebotesGraficoJ2.push(rebotes);
    mediaRebotesJ2+=$(datos[i]).attr('rebotesPartido');
    rebotesTotalesJ2+=$(datos[i]).attr('rebotesPartido');
    /*****************TAPONES PARTIDO**************/
    let tapones=$(datos[i]).attr('taponesPartido');
    taponesGraficoJ2.push(tapones);
    mediaTaponesJ2+=$(datos[i]).attr('taponesPartido');
    taponesTotalesJ2+=$(datos[i]).attr('taponesPartido');
    
    if (puntos >= 10) {
            
            triplesDoblesJ2 += 1;
            doblesDoblesJ2 += 1;
            
        } 
        
        if (asistencias >= 10) {
            
            triplesDoblesJ2 += 1;
            doblesDoblesJ2 += 1;
            
        } 
        
        if (rebotes >= 10) {
            
            triplesDoblesJ2 += 1;
            doblesDoblesJ2 += 1;
            
        } 
        
        if (tapones >= 10) {
            
            triplesDoblesJ2 += 1;
            doblesDoblesJ2 += 1;
        }

        if (triplesDoblesJ2 >= 3) {
            triplesDoblesTotalesJ2 += 1;
            
        }else if (doblesDoblesJ2 == 2) {
            doblesDoblesTotalesJ2 += 1;
        }
        
        triplesDoblesJ2=0;
        doblesDoblesJ2=0;
  }

  /**********MEDIAS J1******************/
  mediaPuntosJ1=mediaPuntosJ1/(datos.length/2);
  mediaAsistenciasJ1=mediaAsistenciasJ1/(datos.length/2);
  mediaRebotesJ1=mediaRebotesJ1/(datos.length/2);
  mediaTaponesJ1=mediaTaponesJ1/(datos.length/2);
  
  /**********MEDIAS J2******************/
  mediaPuntosJ2=mediaPuntosJ2/(datos.length/2);
  mediaAsistenciasJ2=mediaAsistenciasJ2/(datos.length/2);
  mediaRebotesJ2=mediaRebotesJ2/(datos.length/2);
  mediaTaponesJ2=mediaTaponesJ2/(datos.length/2);

  mediasJ1=`<tr><td class="table-light">${nombreJugador1}</td><td class="table-danger">${mediaPuntosJ1.toFixed(2)}</td><td class="table-success">${mediaAsistenciasJ1.toFixed(2)}</td><td class="table-warning">${mediaRebotesJ1.toFixed(2)}</td><td class="table-info">${mediaTaponesJ1.toFixed(2)}</td></tr>`;
  mediasJ2=`<tr><td class="table-light">${nombreJugador2}</td><td class="table-danger">${mediaPuntosJ2.toFixed(2)}</td><td class="table-success">${mediaAsistenciasJ2.toFixed(2)}</td><td class="table-warning">${mediaRebotesJ2.toFixed(2)}</td><td class="table-info">${mediaTaponesJ2.toFixed(2)}</td></tr>`;

  totalesJ1=`<tr><td class="table-light">${nombreJugador1}</td><td class="table-danger">${puntosTotalesJ1}</td><td class="table-success">${asistenciasTotalesJ1}</td><td class="table-warning">${rebotesTotalesJ1}</td><td class="table-info">${taponesTotalesJ1}</td><td class="table-secondary">${triplesDoblesTotalesJ1}</td><td class="table-light">${doblesDoblesTotalesJ1}</td></tr></tr>`;
  totalesJ2=`<tr><td class="table-light">${nombreJugador2}</td><td class="table-danger">${puntosTotalesJ2}</td><td class="table-success">${asistenciasTotalesJ2}</td><td class="table-warning">${rebotesTotalesJ2}</td><td class="table-info">${taponesTotalesJ2}</td><td class="table-secondary">${triplesDoblesTotalesJ2}</td><td class="table-light">${doblesDoblesTotalesJ2}</td></tr></tr>`;

  /*********************CONSTRUCCION GRÁFICOS********************/
  graficoPuntos(partidos, puntosGraficoJ1, puntosGraficoJ2, nombreJugador1, nombreJugador2);
  graficoAsistencias(partidos, asistenciasGraficoJ1, asistenciasGraficoJ2, nombreJugador1, nombreJugador2);
  graficoRebotes(partidos, rebotesGraficoJ1, rebotesGraficoJ2, nombreJugador1, nombreJugador2);
  graficoTapones(partidos, taponesGraficoJ1, taponesGraficoJ2, nombreJugador1, nombreJugador2);
  tablaMedias(mediasJ1, mediasJ2);
  tablaTotal(totalesJ1, totalesJ2);
}

function tablaMedias(mediasJ1, mediasJ2){

  let tablaMedias=`<h4 class="tituloGraf">Media de Datos</h4>
    <table class="table">
      <thead class="thead-dark">
        <tr>
          <th scope="col">Nombre</th>
          <th scope="col">Puntos</th>
          <th scope="col">Asistencias</th>
          <th scope="col">Rebotes</th>
          <th scope="col">Tapones</th>
        </tr>
      </thead>
      <tbody>
        ${mediasJ1}
        ${mediasJ2}
      </tbody>
    </table>`;   

    $('.tabla').append(tablaMedias);

}

function tablaTotal(totalJ1, totalJ2){

  let tablaTotales=`<h4 class="tituloGraf">Datos Totales</h4>
    <table class="table">
      <thead class="thead-dark">
        <tr>
          <th scope="col">Nombre</th>
          <th scope="col">Puntos</th>
          <th scope="col">Asistencias</th>
          <th scope="col">Rebotes</th>
          <th scope="col">Tapones</th>
          <th scope="col">Triples-Dobles</th>
          <th scope="col">Dobles-Dobles</th>
        </tr>
      </thead>
      <tbody>
        ${totalJ1}
        ${totalJ2}
      </tbody>
    </table>`;   

    $('.tabla').append(tablaTotales);

}

function info(data){
   let ultimaPosc=data.length/2;
   let imagenJ1=`<img name="imagen"  id="imagen" src="/DataBasket/imagenes/avatares/${data[0].jugador.foto}" width="300" height="200">`;
   let imagenJ2=`<img name="imagen"  id="imagen" src="/DataBasket/imagenes/avatares/${data[ultimaPosc].jugador.foto}" width="300" height="200">`;
   let versus=`<img id="versus" src="/DataBasket/imagenes/versus.png" width="100" height="100">`;


    $('.versus').append(versus);
    $('.imagenJ1').append(imagenJ1);
    $('.imagenJ2').append(imagenJ2);   


}
function graficoPuntos(partidos, puntosGraficoJ1, puntosGraficoJ2, nombreJugadorJ1, nombreJugadorJ2) {
  
  let graficoPuntos=`<canvas id="puntos"></canvas>`;
  let tituloGrafico=`<h4 class="tituloGraf">Puntos Partido</h4>`;
  $('.graficoPuntos').append(tituloGrafico);
  $('.graficoPuntos').append(graficoPuntos);

  let puntos = $("#puntos");
  Chart.defaults.global.defaultFontFamily = "Lato";
  Chart.defaults.global.defaultFontSize = 18;

  
  let color = Chart.helpers.color;

    let barChart = new Chart(puntos, {
      type: 'bar',
      data: {
        labels: partidos,
        datasets: [{
          label: `${nombreJugadorJ1}`,
          backgroundColor: color('pink').alpha(0.5).rgbString(),
          borderColor: 'pink',
          borderWidth: 1,
          data: puntosGraficoJ1
        }, {
          label: `${nombreJugadorJ2}`,
          backgroundColor: color('grey').alpha(0.5).rgbString(),
          borderColor: 'grey',
          data: puntosGraficoJ2
        }]
      },  
    });

}

function graficoAsistencias(partidos, asistenciasGraficoJ1, asistenciasGraficoJ2, nombreJugadorJ1, nombreJugadorJ2) {
  
  let graficoAsistencias=`<canvas id="asistencias"></canvas>`;
  let tituloGrafico=`<h4 class="tituloGraf">Asistencias Partido</h4>`;
  $('.graficoAsistencias').append(tituloGrafico);
  $('.graficoAsistencias').append(graficoAsistencias);

  let asistencias = $("#asistencias");
  Chart.defaults.global.defaultFontFamily = "Lato";
  Chart.defaults.global.defaultFontSize = 18;

  let color = Chart.helpers.color;
  let speedData = {
    labels: partidos,
    datasets: [{
      label: `${nombreJugadorJ1}`,
      data: asistenciasGraficoJ1,
      lineTension: 0,
      fill: true,
      borderColor: 'purple',
      backgroundColor: color('purple').alpha(0.5).rgbString(),
      pointBorderColor: 'puple',
      pointBackgroundColor: 'purple',
      pointRadius: 5,
      pointHoverRadius: 10,
      pointHitRadius: 30,
      pointBorderWidth: 2,
      pointStyle: 'rectRounded'
    },{
      label: `${nombreJugadorJ2}`,
      data: asistenciasGraficoJ2,
      lineTension: 0,
      fill: true,
      borderColor: 'orange',
      backgroundColor: color('orange').alpha(0.5).rgbString(),
      pointBorderColor: 'orange',
      pointBackgroundColor: 'orange',
      pointRadius: 5,
      pointHoverRadius: 10,
      pointHitRadius: 30,
      pointBorderWidth: 2,
      pointStyle: 'rectRounded'
    }]
  };

  let chartOptions = {
    legend: {
      display: true,
      position: 'top',
      labels: {
        boxWidth: 80,
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

function graficoRebotes(partidos, rebotesGraficoJ1, rebotesGraficoJ2, nombreJugadorJ1, nombreJugadorJ2) {

  let graficoRebotes=`<canvas id="rebotes"></canvas>`;
  let tituloGrafico=`<h4 class="tituloGraf">Rebotes Partido</h4>`;
  $('.graficoRebotes').append(tituloGrafico);
  $('.graficoRebotes').append(graficoRebotes);

  Chart.defaults.global.defaultFontFamily = "Lato";
  Chart.defaults.global.defaultFontSize = 18;
  Chart.defaults.global.defaultFontColor = 'blue';

  let color = Chart.helpers.color;

  let data = {
    label: `${nombreJugadorJ1}`,
    backgroundColor: color('blue').alpha(0.5).rgbString(),
    borderColor: 'blue',
    data:rebotesGraficoJ1,
    fill: true,
    };

    let data2 = {
    label: `${nombreJugadorJ2}`,
    backgroundColor: color('green').alpha(0.5).rgbString(),
    borderColor: 'green',
    data:rebotesGraficoJ2,
    fill: true,
    };
    
  let speedData = {
    labels: partidos,  
    datasets: [data, data2]
  };

  let optionsGrafico = {
      responsive: true,
      plugins: {
        legend: {
          position: 'bottom'
        },
        title: {
          display: true,
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

function graficoTapones(partidos, taponesGraficoJ1, taponesGraficoJ2, nombreJugadorJ1, nombreJugadorJ2) {

  let graficoTapones=`<canvas id="tapones"></canvas>`;
  let tituloGrafico=`<h4 class="tituloGraf">Tapones partido</h4>`;
  $('.graficoTapones').append(tituloGrafico);
  $('.graficoTapones').append(graficoTapones);

  Chart.defaults.global.defaultFontFamily = "Lato";
  Chart.defaults.global.defaultFontSize = 18;

  let dataDia1 = {
      label: `${nombreJugadorJ1}`,
      data: taponesGraficoJ1,
      fill: false,
      borderColor: 'green',
      pointBackgroundColor: 'green',
    };

  let dataDia2 = {
      label: `${nombreJugadorJ2}`,
      data: taponesGraficoJ2,
      fill: false,
    borderColor: 'orange',
    pointBackgroundColor: 'orange',
    };

  let speedData = {
    labels: partidos,
    datasets: [dataDia1, dataDia2]
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

  let lineChart = new Chart(tapones, {
    type: 'line',
    data: speedData,
    options: chartOptions
  });
}

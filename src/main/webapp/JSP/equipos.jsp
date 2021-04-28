<%-- 
    Document   : equipos
    Created on : 21-abr-2021, 11:41:50
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Equipos</title>
        <link rel="icon" type="image/x-icon" href="${pageContext.servletContext.contextPath}/assets/img/favicon.ico" />
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/dataTables.min.css">
        <link href="${pageContext.servletContext.contextPath}/js/jquery.dataTables.min.js">
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${pageContext.servletContext.contextPath}/css/styles.css" rel="stylesheet" />
        <link href="${pageContext.servletContext.contextPath}/css/tablas.css" rel="stylesheet" />

        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>

    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="${pageContext.servletContext.contextPath}/index.html"><img src="${pageContext.servletContext.contextPath}/assets/img/navbar-logo.svg" alt="" /></a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ml-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ml-auto">
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#portfolio">Estadisticas</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="front?id=partidos">Partidos</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="front?id=equipos">Equipos</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="${pageContext.servletContext.contextPath}/JSP/contactos.html">Contactos</a></li>
                    </ul>
                    &nbsp;
                    <button type="button" class="btn btn-warning">Iniciar Sesión</button>
                </div>
            </div>
        </nav>
        <!-- Contact-->
        <section class="page-section" id="contact">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Equipo</h2>
                    <h3 class="section-subheading text-muted">selecciona un equipo a mostrar.</h3>
                </div>

                <c:set var="error" value="${requestScope.error}"/>
                <c:if test="${error==true}">
                    <script src="${pageContext.servletContext.contextPath}/js/notificacion.js"></script>
                    <script src="${pageContext.servletContext.contextPath}/js/ocultarTabla.js"></script>
                </c:if>  


                <div class="datosEquipo row align-items-stretch mb-5">
                    <form action="listar" method="post">    
                        <div class="form-group">
                            <select class="form-select" name="equipos">
                                <c:forEach var="equipo" items="${requestScope.listado}"> 
                                    <option value="${equipo.idEquipo}">${equipo.nombre}</option>
                                </c:forEach>
                            </select>
                            <button type="submit" value="Buscar" id="buscar" name="datosEquipoJugador" class="btn btn-warning">Buscar</button>
                        </div>
                        <div id="infoEquipo">
                            <c:forEach var="equipo" items="${requestScope.listadoEquipo}"> 
                                <h2 id="nombreEquipo">${equipo.nombre}</h2><br>
                                <img name="imagen" src="<c:url value='/imagenes/logos/${equipo.logotipo}'/>" width="200" height="200"><br>
                                <h4><button type="button" class="btn btn-info info"><i class="fas fa-info"></i></button>&nbsp;
                                    Pulsa para conocer mas sobre los ${equipo.nombre}</h4>
                                </c:forEach>

                        </div>

                </div>

                <div class="tablaJugadores">
                    <table id="jugadores" class="display" style="width:100%">
                        <thead>
                            <tr>
                                <th>Info</th>
                                <th>Nombre</th>
                            </tr>
                        </thead>
                        <tbody>  
                            <c:forEach var="jugador" items="${requestScope.listadoJugadores}"> 
                                <tr>
                                    <td>
                                        <button type="button" class="btn btn-info infoJ"><i class="fas fa-info"></i></button>
                                        <input type="hidden" name="idJugador" value="${jugador.idJugador}">
                                    </td>
                                    <td>${jugador.nombre}</td>
                                </tr>    
                            </c:forEach>
                        </tbody>
                        <tfoot>
                            <tr>
                                <th>Info</th>
                                <th>Nombre</th>
                            </tr>
                        </tfoot>
                    </table>
                    </form>    
                </div>

            </div>
        </section>
        <!-- Footer-->
        <footer class="footer py-4">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 text-lg-left">Copyright © Jose Pablo Fernández Novoa 2021</div>
                    <div class="col-lg-4 my-3 my-lg-0">
                        <a class="btn btn-dark btn-social mx-2" href="https://twitter.com/josepablo_67"><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-dark btn-social mx-2" href="https://es-es.facebook.com/"><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-dark btn-social mx-2" href="https://www.instagram.com/josepablo_fn/"><i class="fab fa-instagram"></i></a>
                    </div>
                    <div class="col-lg-4 text-lg-right">
                        <a class="mr-3" href="#!">Política de Privacidad</a>
                    </div>
                </div>
            </div>
        </footer>
        <div class="modal fade informacionEquipo" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Información del equipo</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>

                    </div>
                    <div class="modal-body">
                        <c:forEach var="equipo" items="${requestScope.listadoEquipo}"> 
                            <div id="listaEquipo">
                                <h2>${equipo.nombre}</h2><br>
                                <img name="imagen" src="<c:url value='/imagenes/logos/${equipo.logotipo}'/>" width="150" height="150"><br><br>
                            </div>
                            <ul>
                                <li><h4>Ciudad :</strong> ${equipo.ciudad}</h4></li>
                                <li><h4><strong>Conferencia :</strong> ${equipo.conferencia}</h4></li>
                                <li><h4><strong>División :</strong> ${equipo.division}</h4></li>
                                <li><h4><strong>Entrenador :</strong> ${equipo.entrenador}</h4></li>
                                <li><h4><strong>Mascota :</strong>
                                            <c:if test="${equipo.mascota!='NULL'}">
                                                ${equipo.mascota}
                                            </c:if>  
                                            <c:if test="${equipo.mascota=='NULL'}">
                                            Sin mascota
                                        </c:if></h4></li>

                            </ul>
                        </c:forEach>
                    </div>
                </div>

            </div>
        </div>
        <div class="modal fade informacionJugador" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Información del Jugador</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body">
                             
                    </div>
                </div>

            </div>
        </div>
        <!-- Portfolio Modals-->
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/js/jquery.dataTables.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/js/datatable.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Core theme JS-->
        <script src="${pageContext.servletContext.contextPath}/js/scripts.js"></script>
        <script src="${pageContext.servletContext.contextPath}/js/equipo.js"></script>
        <script src="${pageContext.servletContext.contextPath}/js/infoJugador.js"></script>
        <!-- Notificaciones-->
        <script src="https://cdn.jsdelivr.net/npm/promise-polyfill"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    </body>
</html>


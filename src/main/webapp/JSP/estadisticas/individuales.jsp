<%-- 
    Document   : individuales
    Created on : 01-may-2021, 12:03:19
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Agency - Start Bootstrap Theme</title>
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <!--Chart-->
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/Chart.min.css">
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/graficos.css">
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/tablas.css">
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/themify-icons.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="index.jsp"><img src="assets/img/navbar-logo.svg" alt="" /></a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ml-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ml-auto">
                        <li class="nav-item menuEstats"><a class="nav-link js-scroll-trigger" href="JSP/estadisticas.jsp">Estadisticas</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="front?id=partidos">Partidos</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="front?id=equipos">Equipos</a></li>
                        <!--<li class="nav-item"><a class="nav-link js-scroll-trigger" href="JSP/contactos.html">Contactos</a></li>-->
                    </ul>
                    &nbsp;&nbsp;
                    
                    <div class="btn-group admin menuEstats">
                        <button type="button" class="btn btn-danger dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="ti-user col-sm-1 col-form-label"></span>
                        </button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item user" href="front?id=perfil">Perfil</a>
                            <a class="dropdown-item user" href="front?id=modificarPerfil">Modificar tus Datos</a>
                            <a class="dropdown-item admin" href="front?id=listaUsuarios">Listar Usuarios</a>
                            <a class="dropdown-item admin" href="front?id=nuevoJugador">Crear Jugador</a>
                            <a class="dropdown-item admin" href="front?id=nuevoEquipo">Crear Equipo</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item cerrar" href="${pageContext.servletContext.contextPath}/VueltaAEmpezar">Cerrar Sesión</a>
                        </div>
                    </div>
                    &nbsp;&nbsp;
                    <button type="button" class="btn btn-warning inicioSesion"><a id="inicioSesion" href="JSP/inicioSesionYRegistro.jsp">Iniciar Sesión</a></button>
                </div>
            </div>
        </nav>
        <!-- Contact-->
        <section class="page-section" id="contact">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Estadísticas de un jugador</h2>
                    <h3 class="section-subheading text-muted">selecciona un equipo y un jugador.</h3>
                </div>
                <div class="row">


                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                        <label for="campos" class="label">Equipo&nbsp;&nbsp;</label>
                            <select class="form-select equipos" aria-label="Default select example">
                                <option selected>Elige uno...</option>
                                <c:forEach var="equipo" items="${requestScope.listado}"> 
                                    <option value="${equipo.idEquipo}">${equipo.nombre}</option>
                                </c:forEach>
                            </select>
                    </div>

                    <div class="selectJugadores col-lg-6 col-md-6 col-sm-12 col-xs-12">
                        <label for="campos" class="label">Jugadores&nbsp;&nbsp;</label>  
                            <select class="form-select jugadores" aria-label="Default select example">
                                <option selected>Elige uno...</option>
                            </select>
                          
                    </div>

                </div>
                <br>
                <div class="container">
                    <div class="row"> 
                        <div class="imagen col-lg-4 col-md-4 col-sm-12 col-xs-12"></div>
                        <div class="informacion col-lg-8 col-md-8 col-sm-12 col-xs-12"></div>
                    </div>
                    <div class="row"> 
                        <div class="medias col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="tabla"></div>
                        </div>
                    </div>
                    <div class="row"> 
                        <div class="centro col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="row">
                                <div class="graficos graficoPuntos col-lg-6 col-md-6 col-sm-6 col-xs-6"></div>
                                <div class="graficos graficoAsistencias col-lg-6 col-md-6 col-sm-6 col-xs-6"></div>
                                <div class="graficos graficoRebotes col-lg-6 col-md-6 col-sm-6 col-xs-6"></div>          
                                <div class="graficos graficoTapones col-lg-6 col-md-6 col-sm-6 col-xs-6"></div>                                    
                            </div>
                        </div>
                    </div>
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
                        <a class="mr-3" href="${pageContext.servletContext.contextPath}/JSP/legales.jsp">Política de Privacidad</a>
                    </div>
                </div>
            </div>
        </footer>
        <c:set var="rol" value="${sessionScope.rol}"/>  
        <c:choose>
            <c:when test="${rol=='ADMIN'}">
                <script src="${pageContext.servletContext.contextPath}/js/rolAdmin.js"></script>
            </c:when>
            <c:when test="${rol=='USER'}">
                <script src="${pageContext.servletContext.contextPath}/js/rolUser.js"></script>
            </c:when>    
        </c:choose>
        <!-- Portfolio Modals-->
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Core theme JS-->
        <script src="${pageContext.servletContext.contextPath}/js/scripts.js"></script>
        <script src="${pageContext.servletContext.contextPath}/js/estadisticasIndividuales.js"></script>
        <!-- Chart -->
        <script src="${pageContext.servletContext.contextPath}/js/Chart.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/js/Chart.bundle.js"></script>  
    </body>
</html>

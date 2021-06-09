<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Inicio</title>
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <!-- Themify-->
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/themify-icons.css">
    </head>
    <body id="page-top">

        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="index.jsp"><img src="${pageContext.servletContext.contextPath}/assets/img/navbar-logo.svg" alt="" /></a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ml-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ml-auto">
                        <li class="nav-item menuEstats"><a class="nav-link js-scroll-trigger" href="${pageContext.servletContext.contextPath}/JSP/estadisticas.jsp"><b>Estadisticas</b></a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="${pageContext.servletContext.contextPath}/front?id=partidos"><b>Partidos</b></a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="${pageContext.servletContext.contextPath}/front?id=equipos"><b>Equipos</b></a></li>
                        <!--<li class="nav-item"><a class="nav-link js-scroll-trigger" href="JSP/contactos.html">Contactos</a></li>-->
                    </ul>
                    &nbsp;&nbsp;
                    
                    <div class="btn-group admin menuEstats">
                        <button type="button" class="btn botonPerfil dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="ti-user col-sm-1 col-form-label">&nbsp;${sessionScope.nombre}</span>
                        </button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item user" href="${pageContext.servletContext.contextPath}/front?id=perfil">Perfil</a>
                            <a class="dropdown-item user" href="${pageContext.servletContext.contextPath}/front?id=modificarPerfil">Modificar tus Datos</a>
                            <a class="dropdown-item admin" href="${pageContext.servletContext.contextPath}/front?id=listaUsuarios">Listar Usuarios</a>
                            <a class="dropdown-item admin" href="${pageContext.servletContext.contextPath}/front?id=nuevoJugador">Crear Jugador</a>
                            <a class="dropdown-item admin" href="${pageContext.servletContext.contextPath}/front?id=nuevoEquipo">Crear Equipo</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item cerrar" href="${pageContext.servletContext.contextPath}/VueltaAEmpezar">Cerrar Sesión</a>
                        </div>
                    </div>
                    &nbsp;&nbsp;
                    <button type="button" class="btn btn-warning inicioSesion"><a id="inicioSesion" href="${pageContext.servletContext.contextPath}/JSP/inicioSesionYRegistro.jsp">Iniciar Sesión</a></button>
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead">
            <div class="container">
                <div class="masthead-subheading">Bienvenido a</div>
                <div class="masthead-heading text-uppercase">DataBasket</div>
                <a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="#services">Saber más</a>
            </div>
        </header>
        <!-- Services-->
        <section class="page-section" id="services">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Funciones</h2>
                    <h3 class="section-subheading text-muted">Aquí­ encontraras todas las funciones disponibles</h3>
                </div>
                <div class="row text-center">
                    <div class="col-md-4">
                        <span class="fa-stack fa-4x">
                            <i class="fas fa-circle fa-stack-2x text-primary"></i>
                            <i class="fas fa-database fa-stack-1x fa-inverse"></i>
                        </span>
                        <h4 class="my-3">Estadísticas</h4>
                        <p class="text-muted">Consulta toda la informacion sobre tu jugador favorito, tu equipo o partidos especificos.</p>
                    </div>
                    <div class="col-md-4">
                        <span class="fa-stack fa-4x">
                            <i class="fas fa-circle fa-stack-2x text-primary"></i>
                            <i class="fas fa-stopwatch-20 fa-stack-1x fa-inverse"></i>
                        </span>
                        <h4 class="my-3">Partidos</h4>
                        <p class="text-muted">Visualiza el resultado de partidos.</p>
                    </div>
                    <div class="col-md-4">
                        <span class="fa-stack fa-4x">
                            <i class="fas fa-circle fa-stack-2x text-primary"></i>
                            <i class="fas fa-tshirt fa-stack-1x fa-inverse"></i>
                        </span>
                        <h4 class="my-3">Equipos</h4>
                        <p class="text-muted">Consulta toda la informacion sobre tu equipo (jugadores, estadio, localización , mascota).</p>
                    </div>
                </div>
            </div>
        </section>
        <!-- Team-->
        <section class="page-section bg-light" id="team">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Desarrolladores</h2>
                    <h3 class="section-subheading text-muted">Desarrolladores prinncipales.</h3>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="team-member">
                            <img class="mx-auto rounded-circle" src="${pageContext.servletContext.contextPath}/imagenes/miFoto.jpg" alt="" />
                            <h4>Jose Pablo Fernández Novoa</h4>
                            <p class="text-muted">Desarrollador Web</p>
                            <a class="btn btn-dark btn-social mx-2" href="https://twitter.com/josepablo_67"><i class="fab fa-twitter"></i></a>
                            <a class="btn btn-dark btn-social mx-2" href="https://www.instagram.com/josepablo_fn/"><i class="fab fa-instagram"></i></a>
                            <a class="btn btn-dark btn-social mx-2" href="#!"><i class="fab fa-linkedin-in"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Clients-->
        <div class="py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-sm-6 my-3">
                        <a href="#!"><img class="img-fluid d-block mx-auto" src="imagenes/spalding-logo.png" alt="" /></a>
                    </div>
                    <div class="col-md-3 col-sm-6 my-3">
                        <a href="#!"><img class="img-fluid d-block mx-auto" src="imagenes/NBA-logo.png" alt="" /></a>
                    </div>
                    <div class="col-md-3 col-sm-6 my-3">
                        <a href="#!"><img class="img-fluid d-block mx-auto" src="imagenes/Nike-Logo.png" alt="" /></a>
                    </div>
                    <div class="col-md-3 col-sm-6 my-3">
                        <a href="#!"><img class="img-fluid d-block mx-auto" src="imagenes/Pepsi-Logo.png" alt="" /></a>
                    </div>
                </div>
            </div>
        </div>
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
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>



    </body>
</html>

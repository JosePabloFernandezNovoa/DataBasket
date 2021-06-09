<%-- 
    Document   : partidos
    Created on : 20-abr-2021, 17:00:06
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
        <title>Partidos</title>
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

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
                    <h2 class="section-heading text-uppercase">Modificar Datos Usuario</h2>
                    <h3 class="section-subheading text-muted">modificar tus datos.</h3>
                </div>
                <div class="contenedor">
                    <div class="form-group">

                        <c:set var="errorPeso" value="${requestScope.errorPeso}"/>
                        <c:if test="${errorPeso==true}">
                            <script src="${pageContext.servletContext.contextPath}/js/notificacionPesoImg.js"></script>
                        </c:if>  


                        <c:set var="errorFormato" value="${requestScope.errorFormato}"/>
                        <c:if test="${errorFormato==true}">
                            <script src="${pageContext.servletContext.contextPath}/js/notificacionFormato.js"></script>
                        </c:if> 

                        <form action="modificarU" method="post" enctype="multipart/form-data">

                            <label class="etiqueta" for="exampleFormControlFile1">Imagen (PNG O JPG < 200 Kb)</label>
                            <input type="file" class="form-control-file" name="avatar" id="foto"><br>
                            <div id="marcoFoto">
                                <img id="vistaPrevia" name="imagen" src="<c:url value='/imagenes/avatares/${usuario.avatar}'/>" width="150" height="150"><br><br>
                                <input type="hidden" name="avatarBD" value="<c:url value='/imagenes/avatares/${usuario.avatar}'/>">
                                <input type="hidden" id="avatarForm" name="avatarForm" value="<c:url value='/imagenes/avatares/${usuario.avatar}'/>">
                            </div>

                            <label  class="etiqueta" for="campos">Usuario</label>
                            <input class="form-control" type="text" name="email" id="email" value="<c:out value="${usuario.usuario}"/>" readonly=""><br>  

                            <label class="etiqueta" for="campos">Password Actual</label>
                            <input class="form-control password" type="password" name="password"><br>

                            <div class="passConfirm">
                                <label class="etiqueta" for="campos">Nueva Password</label>
                                <input class="form-control pass1" type="password" name="pass1"><br>
                                
                                <label class="etiqueta" for="campos">Confirmar Password</label>
                                <input class="form-control pass2" type="password" name="pass2"><br>
                            </div>

                            <label class="etiqueta" for="campos">Nombre</label>
                            <input class="form-control" type="text" name="nombre" value="<c:out value="${usuario.nombre}"/>" maxlength="15" required="""><br>

                            <label  class="etiqueta" for="campos">Apellidos</label>
                            <input class="form-control" type="text" name="apellidos" value="<c:out value="${usuario.apellidos}"/>" maxlength="30" required=""><br>

                            <label  class="etiqueta" for="campos">Teléfono</label>
                            <c:if test="${usuario.telefono==null}">
                                <input class="form-control" type="text" name="telefono" value="Sin teléfono" maxlength="30"><br>
                            </c:if> 
                            <c:if test="${usuario.telefono!=null}">
                                <input class="form-control" type="text" name="telefono" value="<c:out value="${usuario.telefono}"/>" maxlength="30"><br>
                            </c:if>

                            <label class="etiqueta" for="campos">Fecha Nacimiento</label><br>
                            <input type="date" name="fecha" id="fecha" value="${usuario.fechaNacimiento}" required=""><br><br>

                            <input type="submit" value="Enviar" id="enviar" name="boton" class="btn btn-success"/>

                        </form>   
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
                        <a class="mr-3" href="#!">Política de Privacidad</a>
                    </div>
                </div>
            </div>
        </footer>
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

        <script src="${pageContext.servletContext.contextPath}/js/vistaprevia.js"></script>
        <script src="${pageContext.servletContext.contextPath}/js/rutasImagenes.js"></script>
        <script src="${pageContext.servletContext.contextPath}/js/modificarPassword2.js"></script>
        <!--Notificaciones-->
        <script src="https://cdn.jsdelivr.net/npm/promise-polyfill"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    </body>
</html>


<%-- 
    Document   : error
    Created on : 05-feb-2021, 17:01:22
    Author     : jp-9
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/js/jquery.min.js">
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/js/bootstrap.min.js">
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/style.css">
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/formulario.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <title>Error</title>
    </head>
    <body>

        <div class="row fondo">
            <div class="imagen col-lg-4 col-md-4 col-sm-4 col-xs-4">

                <img id="imagen" src="${pageContext.servletContext.contextPath}/imagenes/hibernate.png">

            </div>

            <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
        <div class="row">
            <div class="titulo col-lg-8 col-md-8 col-sm-8 col-xs-8">
                <h2 id="titulo">Final Hibernate</h2>
            </div>
            <div class="info col-lg-4 col-md-4 col-sm-4 col-xs-4">
                <h4>${sessionScope.email}</h4>
                <c:if test="${rol!='ADMIN'}">
                    <h4>${sessionScope.nombreApellidos}</h4>
                </c:if>
                
            </div>
        </div>
    </div>  
        </div>

        <div class="row">
            <div class="barraNav col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <nav class="navbar navbar-dark bg-dark">
        <div class="dropdown show">
          <a class="btn btn-warning dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Nuevo
          </a>
        
          <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
            <a class="admin dropdown-item" href="front?id=nuevoTutor">Tutor</a>
            <a class="tutor dropdown-item" href="front?id=nuevoAlumno">Alumno</a>
            <a class="tutor dropdown-item" href="front?id=nuevoNota">Notas</a>
          </div>
        </div>
        <div class="dropdown show">
          <a class="btn btn-warning dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Listados
          </a>
        
          <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
            <a class="admin dropdown-item" href="front?id=profesores">Profesores con alumnos</a>
            <a class="tutor dropdown-item" href="front?id=alumnos">Alumnos</a>
            <a class="alumno dropdown-item" href="front?id=notas">Notas</a>
            <a class="alumno dropdown-item" href="front?id=modulos">Modulos</a>
          </div>
        </div>
        <div class="dropdown show">
          <a class="btn btn-warning dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Eliminar
          </a>
        
          <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
            <a class="admin dropdown-item" href="front?id=eliminarProfesor">Profesores sin Alumnos</a>
            <a class="tutor dropdown-item" href="front?id=eliminarAlumnos">Alumnos y sus datos</a>
          </div>
        </div>
        <div class="dropdown show">
          <a class="btn btn-warning dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Actualizar
          </a>
        
          <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
            <a class="tutor dropdown-item" href="front?id=modificarDatosProfesor">Tus Datos</a>
            <a class="alumno dropdown-item" href="front?id=modificarDatosAlumno">Tus Datos</a>
          </div>
        </div>
        <a class="btn btn-danger" href="VueltaAEmpezar" role="button">Salir</a>  
      </nav>   
            </div>    
        </div>
        <div class="row" >
            <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 izquierda"> </div>
            <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 centro" >
                
                <br>
                <div class="contenedor">
                    <div class="container">
                        <div class="row">
                            <div class="col-11">
                                <h2 class="tituloForm">No existen datos actualmente</h2>
                                <button type="button" value="Inicio" class="btn btn-success" onclick="location.href = 'VolverVistaPrincipal';">Inicio</button>

                            </div>
                        </div>
                    </div>
                </div> 
            </div>
            <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1 derecha" ></div>
        </div>
    </div> 
    <!-- Footer -->
    <footer class="footer font-small">


        <div class="container-fluid text-center text-md-left">


            <div class="row">


                <div class="col-md-6 mt-md-0 mt-3">


                    <h5 class="text-uppercase">Contenido</h5>
                    <p>Aquí encontraras algunos enlaces que te podrán servir de ayuda 
                        con el manejo de la aplicación, si tienes alguna duda tambien podras contactarnos.
                    </p>

                </div>


                <hr class="clearfix w-100 d-md-none pb-3">


                <div class="col-md-3 mb-md-0 mb-3">


                    <h5 class="text-uppercase">Ayuda</h5>

                    <ul class="list-unstyled">
                        <li>
                            <a href="manuales/Manual_Usuario.pdf" download="Manual_Usuario.pdf">Manual de Usuario</a>
                        </li>
                        <li>
                            <a href="manuales/Manual_Tecnico.pdf" download="Manual_Tecnico.pdf">Guia Técnica</a>
                        </li>
                    </ul>

                </div>



                <div class="col-md-3 mb-md-0 mb-3">


                    <h5 class="text-uppercase">Links</h5>

                    <ul class="list-unstyled">
                        <li>
                            <a href="#!">Localizacion</a>
                        </li>
                        <li>
                            <a href="#!">Sobre Nosotros</a>
                        </li>
                        <li>
                            <a href="#!">Contacto</a>
                        </li>
                    </ul>

                </div>
            </div>
        </div>
        <div class="footer-copyright text-center py-3"><strong>© 2020 Copyright: Jose Pablo Fernandez Novoa</strong></div>
    </footer>
    <c:set var="rol" value="${sessionScope.rol}"/>
    <c:choose>
        <c:when test="${rol=='ADMIN'}">
            <script src="${pageContext.servletContext.contextPath}/js/rolAdmin.js"></script>
        </c:when>
        <c:when test="${rol=='TUTOR'}">
            <script src="${pageContext.servletContext.contextPath}/js/rolTutor.js"></script>
        </c:when>
        <c:when test="${rol=='ALUMNO'}">
            <script src="${pageContext.servletContext.contextPath}/js/rolAlumno.js"></script>
        </c:when>
    </c:choose>
</body>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</html>


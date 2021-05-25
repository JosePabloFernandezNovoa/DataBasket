<%-- 
    Document   : inicioSesionYRegistro
    Created on : 21-may-2021, 12:16:55
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

        <link href="${pageContext.servletContext.contextPath}/css/inicioSesion.css" rel="stylesheet" />
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/themify-icons.css">
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <title>Inicio</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="panel panel-login">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-6">
                                    <a href="#" class="active" id="login-form-link">Iniciar sesión</a>
                                </div>
                                <div class="col-xs-6">
                                    <a href="#" id="register-form-link">Regístrate ahora</a>
                                </div>
                            </div>
                            <hr>
                        </div>

                        <c:set var="error" value="${requestScope.errorCredencial}"/>
                        <c:if test="${error==true}">
                            <script src="${pageContext.servletContext.contextPath}/js/notificacionCredenciales.js"></script>
                        </c:if>  

                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <form id="login-form" action="${pageContext.servletContext.contextPath}/inicio" method="post" role="form" style="display: block;">
                                        <div class="form-group">
                                            <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Usuario" value="">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="passwordInicio" id="passwordInicio" tabindex="2" class="form-control" placeholder="Contraseña">
                                        </div>
                                        <div class="form-group text-center">
                                            <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
                                            <label for="remember"> Recordarme</label>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="login" id="login-submit" tabindex="4" class="form-control btn btn-login login" value="Iniciar sesión">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-lg-12">
                                                    <div class="text-center">
                                                        <a href="#" tabindex="5" class="forgot-password">¿Has olvidado tu contraseña?</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <form id="register-form" action="${pageContext.servletContext.contextPath}/crear" method="post" role="form" style="display: none;">
                                        <div class="form-group">
                                            <input type="text" name="nombre" id="nombre" tabindex="1" class="form-control" placeholder="Nombre" required="">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" name="apellidos" id="apellidos" tabindex="1" class="form-control" placeholder="Apellidos" required="">
                                        </div>
                                        <div class="form-group">
                                            <input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Correo electronico" required="">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="password" id="password" tabindex="2" class="form-control pass1" placeholder="Contraseña">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" name="passwordConfirm" id="passwordConfirm" tabindex="2" class="form-control pass2" placeholder="Confirmar contraseña">
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-sm-6 col-sm-offset-3">
                                                    <input type="submit" name="nuevoUsuario" id="register-submit" tabindex="4" class="form-control btn btn-register enviar" value="Crear cuenta">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="${pageContext.servletContext.contextPath}/js/inicioSesion.js"></script>
        <script src="${pageContext.servletContext.contextPath}/js/restricciones.js"></script> 
        <script src="${pageContext.servletContext.contextPath}/js/modificarPassword.js"></script>
        <!-- Notificaciones-->
        <script src="https://cdn.jsdelivr.net/npm/promise-polyfill"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    </body>
</html>

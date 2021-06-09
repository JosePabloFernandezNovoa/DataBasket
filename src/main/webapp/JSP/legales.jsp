<%-- 
    Document   : legales
    Created on : 05-jun-2021, 13:40:23
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

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

        <link href="${pageContext.servletContext.contextPath}/css/tablas.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/themify-icons.css">
        <link href="${pageContext.servletContext.contextPath}/css/styles.css" rel="stylesheet" />
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
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
                    <button type="button" class="btn btn-warning inicioSesion"><a id="inicioSesion" href="${pageContext.servletContext.contextPath}/JSP/inicioSesionYRegistro.jsp">Iniciar Sesión</a></button>
                </div>
            </div>
        </nav>
        <!-- Contact-->
        <section class="page-section" id="contact">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Aspectos Legales</h2>
                </div>
                <div>
                    <h4 class="legales">Identificación y Titularidad</h4>

                    <p class="legales">En cumplimiento del artículo 10 de la Ley 34/2002, de 11 de julio, de Servicios de la Sociedad de la Información y Comercio Electrónico, el Titular expone sus datos identificativos.</p>
                    <ul class="legales">
                        <li>	Titular: DataBasket.</li>
                        <li>	NIF: 08897141M</li>
                        <li>	Inscrita en el registro mercantil de Mérida, tomo 1, libro 1, sección 21, folio 235, hoja 23, inscripción B.</li>
                        <li>	DataBasket</li>
                        <li>	Domicilio: Avenida Reina Sofia N5, Mérida - España.</li>
                        <li>	Correo electrónico: dataBasket@gmail.com</li>
                        <li>	Teléfono de contacto: 638528932</li>
                    </ul>
                    <h4 class="legales">Finalidad</h4>
                    <p class="legales">La finalidad del sitio Web www.DataBasket.com es información deportiva.</p>

                    <h4 class="legales">Condiciones de Uso</h4>

                    <p class="legales">La utilización del sitio Web le otorga la condición de Usuario, e implica la aceptación completa de todas las cláusulas y condiciones de uso incluidas en las páginas:</p>
                    <ul class="legales">
                        <li>	Aviso Legal</li>
                        <li>	Política de Privacidad</li>
                    </ul>
                    <p class="legales">Si no estuviera conforme con todas y cada una de estas cláusulas y condiciones absténgase de utilizar este sitio Web.</p>
                    <p class="legales">El acceso a este sitio Web no supone, en modo alguno, el inicio de una relación comercial con DataBasket.</p>
                    <p class="legales">A través de este sitio Web, el Titular le facilita el acceso y la utilización de diversos contenidos que el Titular o sus colaboradores han publicado por medio de Internet.</p>
                    <p class="legales">A tal efecto, usted está obligado y comprometido a NO utilizar cualquiera de los contenidos del sitio Web con fines o efectos ilícitos, prohibidos en este Aviso Legal o por la legislación vigente, lesivos de los derechos e intereses de terceros, o que de cualquier forma puedan dañar, inutilizar, sobrecargar, deteriorar o impedir la normal utilización de los contenidos, los equipos informáticos o los documentos, archivos y toda clase de contenidos almacenados en cualquier equipo informático propios o contratados por DataBasket, de otros usuarios o de cualquier usuario de Internet.</p>

                    <h4 class="legales">Mayoría de edad</h4>

                    <p class="legales">Usted debe tener al menos 18 años de edad para usar los servicios ofrecidos por DataBasket o la mayoría de edad que se requiera su país para registrarse en el sitio Web o utilizarlo. Si reside en un país que no pertenezca a la Región europea, debe tener al menos 13 años de edad para usar el sitio Web o la mayoría de edad que se requiera su país para registrarse en el sitio Web o utilizarlo.</p>
                    <p class="legales">Además de tener la edad mínima requerida para usar el sitio Web en virtud de la ley aplicable, si no tiene la edad suficiente para poder las condiciones en su país, su padre, madre, o tutor deben aceptar las condiciones en su nombre.</p>

                    <h4 class="legales">Medidas de seguridad</h4>

                    <p class="legales">Los datos personales que facilite al Titular pueden ser almacenados en bases de datos automatizadas o no, cuya titularidad corresponde en exclusiva a DataBasket, que asume todas las medidas de índole técnica, organizativa y de seguridad que garantizan la confidencialidad, integridad y calidad de la información contenida en las mismas de acuerdo con lo establecido en la normativa vigente en protección de datos.</p>
                    <p class="legales">No obstante, debe ser consciente de que las medidas de seguridad de los sistemas informáticos en Internet no son enteramente fiables y que, por tanto el Titular no puede garantizar la inexistencia de virus u otros elementos que puedan producir alteraciones en los sistemas informáticos (software y hardware) del Usuario o en sus documentos electrónicos y ficheros contenidos en los mismos aunque el Titular pone todos los medios necesarios y toma las medidas de seguridad oportunas para evitar la presencia de estos elementos dañinos.</p>

                    <h4 class="legales">Tratamiento de Datos Personales</h4>

                    <p class="legales">Usted puede consultar toda la información relativa al tratamiento de datos personales que recoge el Titular en la página de Política de Privacidad.</p>

                    <h4 class="legales">Contenidos</h4>

                    <p class="legales">El Titular ha obtenido la información, el contenido multimedia y los materiales incluidos en el sitio Web de fuentes que considera fiables, pero, si bien ha tomado todas las medidas razonables para asegurar que la información contenida es correcta, el Titular no garantiza que sea exacta, completa o actualizada. DataBasket declina expresamente cualquier responsabilidad por error u omisión en la información contenida en las páginas de este sitio Web.
                        Queda prohibido transmitir o enviar a través del sitio Web cualquier contenido ilegal o ilícito, virus informáticos, o mensajes que, en general, afecten o violen derechos de el Titular o de terceros.
                        Los contenidos de DataBasket tienen únicamente una finalidad informativa y bajo ninguna circunstancia deben usarse ni considerarse como oferta de venta, solicitud de una oferta de compra ni recomendación para realizar cualquier otra operación, salvo que así se indique expresamente.
                        DataBasket se reserva el derecho a modificar, suspender, cancelar o restringir el contenido de DataBasket, los vínculos o la información obtenida a través del sitio Web, sin necesidad de previo aviso.
                        DataBasket no es responsable de los daños y perjuicios que pudieran derivarse de la utilización de la información del sitio Web o de la contenida en las redes sociales del Titular.
                    </p>
                    <h4 class="legales">Política de cookies</h4>

                    <p class="legales">El Titular sólo obtiene y conserva la siguiente información acerca de los visitantes del sitio Web:</p>
                    <ul class="legales">
                        <li>	El nombre de dominio del proveedor (PSI) y/o dirección IP que les da acceso a la red.</li>
                        <li>	La fecha y hora de acceso al sitio Web.</li>
                        <li>	La dirección de Internet origen del enlace que dirige al sitio Web.</li>
                        <li>	El número de visitantes diarios de cada sección.</li>
                        <li>	La información obtenida es totalmente anónima, y en ningún caso puede ser asociada a un Usuario concreto e identificado.
                    </ul>
                    <h4 class="legales">Enlaces a otros sitios Web</h4>

                    <p class="legales">El Titular puede proporcionarle acceso a sitios Web de terceros mediante enlaces con la finalidad exclusiva de informar sobre la existencia de otras fuentes de información en Internet en las que podrá ampliar los datos ofrecidos en el sitio Web.
                        Estos enlaces a otros sitios Web no suponen en ningún caso una sugerencia o recomendación para que usted visite las páginas web de destino, que están fuera del control del Titular, por lo que DataBasket no es responsable del contenido de los sitios web vinculados ni del resultado que obtenga al seguir los enlaces.
                        Asimismo, DataBasket no responde de los links o enlaces ubicados en los sitios web vinculados a los que le proporciona acceso.
                        El establecimiento del enlace no implica en ningún caso la existencia de relaciones entre DataBasket y el propietario del sitio en el que se establezca el enlace, ni la aceptación o aprobación por parte del Titular de sus contenidos o servicios.
                        Si accede a un sitio Web externo desde un enlace que encuentre en DataBasket usted deberá leer la propia política de privacidad del otro sitio web que puede ser diferente de la de este sitio Web.
                    </p>
                    <h4 class="legales">Propiedad intelectual e industrial</h4>

                    <p class="legales">Todos los derechos están reservados.</p>
                    <p class="legales">Todo acceso a este sitio Web está sujeto a las siguientes condiciones: la reproducción, almacenaje permanente y la difusión de los contenidos o cualquier otro uso que tenga finalidad pública o comercial queda expresamente prohibida sin el consentimiento previo expreso y por escrito de DataBasket.

                    <h4 class="legales">Limitación de responsabilidad</h4>

                    <p class="legales">La información y servicios incluidos o disponibles a través de este sitio Web pueden incluir incorrecciones o errores tipográficos. De forma periódica el Titular incorpora mejoras y/o cambios a la información contenida y/o los Servicios que puede introducir en cualquier momento.
                        El Titular no declara ni garantiza que los servicios o contenidos sean interrumpidos o que estén libres de errores, que los defectos sean corregidos, o que el servicio o el servidor que lo pone a disposición estén libres de virus u otros componentes nocivos sin perjuicio de que el Titular realiza todos los esfuerzos en evitar este tipo de incidentes.
                        DataBasket declina cualquier responsabilidad en caso de que existan interrupciones o un mal funcionamiento de los Servicios o contenidos ofrecidos en Internet, cualquiera que sea su causa. Asimismo, el Titular no se hace responsable por caídas de la red, pérdidas de negocio a consecuencia de dichas caídas, suspensiones temporales de fluido eléctrico o cualquier otro tipo de daño indirecto que te pueda ser causado por causas ajenas a el Titular.
                        Antes de tomar decisiones y/o acciones con base a la información incluida en el sitio Web, el Titular le recomienda comprobar y contrastar la información recibida con otras fuentes.
                    </p>
                    <h4 class="legales">Derecho de exclusión</h4>

                    <p class="legales">DataBasket se reserva el derecho a denegar o retirar el acceso al sitio Web y los servicios ofrecidos sin necesidad de preaviso, a instancia propia o de un tercero, a aquellos usuarios que incumplan cualquiera de las condiciones de este Aviso Legal.</p>

                    <h4 class="legales">Jurisdicción</h4>

                    <p class="legales">Este Aviso Legal se rige íntegramente por la legislación española.</p>
                    <p class="legales">Siempre que no haya una norma que obligue a otra cosa, para cuantas cuestiones se susciten sobre la interpretación, aplicación y cumplimiento de este Aviso Legal, así como de las reclamaciones que puedan derivarse de su uso, las partes acuerdan someterse a los Jueces y Tribunales de la provincia de Córdoba, con renuncia expresa de cualquier otra jurisdicción que pudiera corresponderles.</p>

                    <h4 class="legales">Contacto</h4>
                    <p class="legales">En caso de que usted tenga cualquier duda acerca de estas Condiciones legales o quiera realizar cualquier comentario sobre este sitio Web, puede enviar un mensaje de correo electrónico a la dirección dataBasket@gmail.com.</p>


                    <p class="pregunta">Sobre esta política de cookies</p>
                    <p class="legales">Esta Política de cookies explica qué son las cookies y cómo las usamos, los tipos de cookies que usamos, es decir, la información que recopilamos usando cookies y cómo se usa esa información, y cómo controlar las preferencias de cookies. Para obtener más información sobre cómo usamos, almacenamos y mantenemos seguros sus datos personales, consulte nuestra Política de privacidad. </p>

                    <p class="legales">En cualquier momento puede cambiar o retirar su consentimiento de la Declaración de cookies en nuestro sitio web.</p>
                    <p class="legales">Obtenga más información sobre quiénes somos, cómo puede comunicarse con nosotros y cómo procesamos los datos personales en nuestra Política de privacidad.</p>
                    <p class="legales">Su consentimiento se aplica a los siguientes dominios: proyectosegundotrimestre.local[user_consent_state]</p>

                    <p class="pregunta">¿Qué son las cookies?</p>
                    <p class="legales">Las cookies son pequeños archivos de texto que se utilizan para almacenar pequeños fragmentos de información. Se almacenan en su dispositivo cuando el sitio web se carga en su navegador. Estas cookies nos ayudan a hacer que el sitio web funcione correctamente, hacerlo más seguro, brindar una mejor experiencia al usuario y comprender cómo funciona el sitio web y analizar qué funciona y dónde necesita mejorar.   Las cookies son pequeños archivos de texto que se utilizan para almacenar pequeños fragmentos de información. Se almacenan en su dispositivo cuando el sitio web se carga en su navegador. Estas cookies nos ayudan a hacer que el sitio web funcione correctamente, hacerlo más seguro, brindar una mejor experiencia al usuario y comprender cómo funciona el sitio web y analizar qué funciona y dónde necesita mejorar. </p>             

                    <p class="pregunta">Cómo usamos las cookies ?</p>
                    <p class="legales">Como la mayoría de los servicios en línea, nuestro sitio web utiliza cookies propias y de terceros para varios propósitos. Las cookies de origen son principalmente necesarias para que el sitio web funcione correctamente y no recopilan ninguno de sus datos de identificación personal.</p> 

                    <p class="legales">Las cookies de terceros que se utilizan en nuestro sitio web son principalmente para comprender cómo funciona el sitio web, cómo interactúa con nuestro sitio web, mantener nuestros servicios seguros, proporcionar anuncios que sean relevantes para usted y, en general, brindarle un usuario mejor y mejorado. experiencia y ayude a acelerar sus interacciones futuras con nuestro sitio web.</p>

                    <p class="pregunta">¿Qué tipos de cookies utilizamos?</p>
                    <p class="legales">Esencial: algunas cookies son esenciales para que pueda experimentar la funcionalidad completa de nuestro sitio. Nos permiten mantener las sesiones de los usuarios y prevenir cualquier amenaza a la seguridad. No recopilan ni almacenan ninguna información personal. Por ejemplo, estas cookies le permiten iniciar sesión en su cuenta y agregar productos a su carrito y realizar el pago de forma segura.</p>

                    <p class="legales">Estadísticas: estas cookies almacenan información como el número de visitantes al sitio web, el número de visitantes únicos, las páginas del sitio web que se han visitado, la fuente de la visita, etc. Estos datos nos ayudan a comprender y analizar el rendimiento del sitio web. y donde necesita mejorar.</p>
                    <p class="legales">Marketing: nuestro sitio web muestra anuncios. Estas cookies se utilizan para personalizar los anuncios que le mostramos para que sean significativos para usted. Estas cookies también nos ayudan a realizar un seguimiento de la eficiencia de estas campañas publicitarias.
                        Los proveedores de publicidad de terceros también pueden utilizar la información almacenada en estas cookies para mostrarle anuncios en otros sitios web en el navegador.
                        Funcionales: Son las cookies que ayudan a determinadas funcionalidades no esenciales de nuestro sitio web. Estas funcionalidades incluyen incrustar contenido como videos o compartir contenido del sitio web en plataformas de redes sociales.
                        Preferencias: estas cookies nos ayudan a almacenar su configuración y preferencias de navegación, como las preferencias de idioma, para que tenga una experiencia mejor y más eficiente en futuras visitas al sitio web.[cookie_audit columns="cookie,description" heading="The below list details the cookies used in our website."]
                    </p>
                    <p class="pregunta">¿Cómo puedo controlar las preferencias de las cookies?</p>
                    <p class="legales">Si decide cambiar sus preferencias más adelante a través de su sesión de navegación, puede hacer clic en la pestaña "Política de privacidad y cookies" en su pantalla. Esto mostrará el aviso de consentimiento nuevamente, lo que le permitirá cambiar sus preferencias o retirar su consentimiento por completo. </p>

                    <p class="legales">Además de esto, diferentes navegadores proporcionan diferentes métodos para bloquear y eliminar las cookies utilizadas por los sitios web. Puede cambiar la configuración de su navegador para bloquear / eliminar las cookies. Para obtener más información sobre cómo administrar y eliminar cookies, visite wikipedia.org, www.allaboutcookies.org.</p>

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
    </body>
</html>


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IUsuarioDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author jp-9
 */
@MultipartConfig
@WebServlet(name = "modificarA", urlPatterns = {"/modificarA"})
public class ModificarDatosAlumno extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = null;

        DAOFactory daof = DAOFactory.getDAOFactory();
        /*IGenericoDAO<Alumno> Adao = daof.getGenericoDAO();
        Alumno alumno = new Alumno();

        if (!request.getParameter("boton").equalsIgnoreCase("Cancelar")) {
            Boolean cambioImagen = false;
            Boolean errorImagen = false;
            StringBuilder nombreFichero = new StringBuilder();
            //Ruta donde almacenaremos las imagenes
            String dirImagen = request.getServletContext().getRealPath("/imagenes/avatares/");
            String filePath = null;
            //recogemos todos los valores del formulario
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String dni = request.getParameter("dni");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Date fechaNacimiento = java.sql.Date.valueOf(request.getParameter("fecha"));
            String avatarBD = request.getParameter("avatarBD");
            String avatarFormulario = request.getParameter("avatarForm");
            String passwordCifrada = getMD5(password);
            Part filePart = request.getPart("avatar");

            //Comprobamos si se introdujo alguna imagen, en caso de que se asigna TRUE.
            if (!avatarBD.equals(avatarFormulario)) {
                cambioImagen = true;

                //Comprobacion de la extension de la imgen
                if (filePart.getContentType().equals("image/png") || filePart.getContentType().equals("image/jpeg")) {
                    // Tamaño maximo permitido
                    if (filePart.getSize() < 200000) {

                        // Extension
                        String extension = ".jpg";
                        if (filePart.getContentType().equals("image/png")) {
                            extension = ".png";
                        }
                        // Obtenemos el nombre del fichero
                        nombreFichero.append("Avatar").append(dni).append(extension);
                        filePath = dirImagen + nombreFichero.toString();
                        // Escribimos el fichero en el servidor
                        filePart.write(filePath);

                    } else {
                        request.setAttribute("errorPeso", true);
                        url = "JSP/update/Actualizar_Datos_Alumno.jsp";
                        errorImagen = true;
                        int idUsuario = (int) request.getSession().getAttribute("usuario");
                        alumno = Adao.getById(idUsuario, Alumno.class);
                        request.setAttribute("alumno", alumno);
                    }
                } else {
                    request.setAttribute("errorFormato", true);
                    url = "JSP/update/Actualizar_Datos_Alumno.jsp";
                    int idUsuario = (int) request.getSession().getAttribute("usuario");
                    alumno = Adao.getById(idUsuario, Alumno.class);
                    request.setAttribute("alumno", alumno);
                    errorImagen = true;
                }

            }
            if (errorImagen == false) {
                int idUsuario = (int) request.getSession().getAttribute("usuario");
                alumno = Adao.getById(idUsuario, Alumno.class);

                //metemos los datos en el bean
                alumno.setNombre(capitalizar(nombre));
                alumno.setApellidos(capitalizar(apellidos));
                alumno.setDni(dni);
                alumno.setEmail(email);
                alumno.setFechaNacimiento(fechaNacimiento);
                alumno.setPassword(passwordCifrada);

                if (cambioImagen == true) {
                    alumno.setAvatar(nombreFichero.toString());
                }

                //mandamos el bean cargado de dichos datos para ser introducidos en la BD
                Adao.insertOrUpdate(alumno);

                //Info usuario
                request.getSession().setAttribute("password", password);
               
                
                String nombreApellidos=nombre+" "+apellidos;
                request.getSession().setAttribute("nombreApellidos", nombreApellidos);
                request.getSession().setAttribute("email", email);

                url = "principal.jsp";
            }

        }
        request.getRequestDispatcher(url).forward(request, response);*/
    }

    public static String capitalizar(String cadena) {
        // Separar palabras de la cadena
        String[] separadaPorEspacios = cadena.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int indice = 0; indice < separadaPorEspacios.length; indice++) {
            String palabra = separadaPorEspacios[indice];
            // De la palabra, primero agregar la primera letra ya convertida a mayúscula
            char primeraLetra = palabra.charAt(0);
            sb.append(Character.toUpperCase(primeraLetra));
            // Luego agregarle "lo sobrante" de la palabra
            sb.append(palabra.substring(1));
            // Y si no es el último elemento del array, le añadimos un espacio
            if (indice < separadaPorEspacios.length - 1) {
                sb.append(" ");
            }
        }
        // Finalmente devolveos la cadena
        return sb.toString();
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

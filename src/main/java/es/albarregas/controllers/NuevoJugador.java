/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;


import es.albarregas.beans.Equipo;
import es.albarregas.beans.Jugador;
import es.albarregas.beans.Usuario;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Controlador que añade un nuevo jugador a la BD
 * @author Jose Pablo Fernández Novoa
 */
@MultipartConfig
@WebServlet(name = "nuevoJugador", urlPatterns = {"/nuevoJugador"})
public class NuevoJugador extends HttpServlet {

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
        IGenericoDAO<Equipo> Edao = daof.getGenericoDAO();
        IGenericoDAO<Jugador> Jdao = daof.getGenericoDAO();
        Equipo equipo = new Equipo();
        Jugador jugador=new Jugador();

        List<Equipo> listaEquipos = null;
        
        if (request.getParameter("boton") != null) {
            Boolean errorImagen = false;
            StringBuilder nombreFichero = new StringBuilder();
            //Ruta donde almacenaremos las imagenes
            String dirImagen = request.getServletContext().getRealPath("/imagenes/avatares/");
            String filePath = null;
            //recogemos todos los valores del formulario
            String nombre = request.getParameter("nombre");
            String procedencia = request.getParameter("procedencia");
            String idEquipo = request.getParameter("equipo");
            String altura = request.getParameter("altura");
            String peso = request.getParameter("peso");
            String edad = request.getParameter("edad");
            String posicion = request.getParameter("posicion");
            String nacionalidad = request.getParameter("nacionalidad");
            Part filePart = request.getPart("avatar");

            System.out.println(filePart);
            
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
                        nombreFichero.append("Avatar").append(nombre).append(extension);
                        filePath = dirImagen + nombreFichero.toString();
                        // Escribimos el fichero en el servidor
                        filePart.write(filePath);

                    } else {
                        request.setAttribute("errorPeso", true);
                         listaEquipos = Edao.selectAll(Equipo.class);
                        request.setAttribute("listado", listaEquipos);
                        url = "JSP/funcionesRol/nuevoJugador.jsp";
                        errorImagen = true;
                    }
                } else {
                    request.setAttribute("errorFormato", true);
                     listaEquipos = Edao.selectAll(Equipo.class);
                    request.setAttribute("listado", listaEquipos);
                    url = "JSP/funcionesRol/nuevoJugador.jsp";
                    errorImagen = true;
                }

            
            if (errorImagen == false) {
                
                equipo = Edao.getById(Short.valueOf(idEquipo), Equipo.class);
                
                jugador.setNombre(capitalizar(nombre));
                jugador.setAltura(altura);
                jugador.setProcedencia(capitalizar(procedencia));
                jugador.setEquipo(equipo);
                jugador.setEdad(Byte.valueOf(edad));
                jugador.setPeso(Byte.valueOf(peso));
                jugador.setPosicion(posicion);
                jugador.setNacionalidad(nacionalidad);
                jugador.setFoto(nombreFichero.toString());
                
                //mandamos el bean cargado de dichos datos para ser introducidos en la BD
                Jdao.insertOrUpdate(jugador);
           
                url = "index.jsp";
            }

        }
        request.getRequestDispatcher(url).forward(request, response);
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

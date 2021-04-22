package es.albarregas.controllers;

import es.albarregas.beans.Usuario;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IUsuarioDAO;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import es.albarregas.dao.IJugadorDAO;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Inicio", urlPatterns = {"/inicio"})
public class Inicio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO<Usuario> Udao = daof.getGenericoDAO();
        //IUsuarioDAO adaoU = daof.getUsuarioDAO();
       // IJugadorDAO adaoT = daof.getTutorDAO();

        Usuario usuario = new Usuario();
        String url = null;
        Boolean comprobacion = false;

        /*if (request.getParameter("enviar") != null) {

            String user = request.getParameter("user");
            String password = request.getParameter("password");

            //Cifrar password 
            //String passwordCifrada=getMD5(password);
            
            //comprobacion = adaoU.comprobarCredenciales(user, passwordCifrada);

            //if (comprobacion == true) {
               // Integer idUsuario = adaoU.getIdUsuario(user);
               // request.getSession().setAttribute("usuario", idUsuario);

               // Object rol = adaoU.getRol(user);
                //request.getSession().setAttribute("rol", rol.toString());

                //Comprobar primer acceso
               // Boolean primerAcceso = adaoU.getPrimerAcceso(idUsuario);
                
                
               // Object[] nomApe=adaoU.getNombreApelidos(idUsuario);
               // String nombreApellidos=nomApe[0]+" "+nomApe[1];
               // request.getSession().setAttribute("nombreApellidos", nombreApellidos);
                //request.getSession().setAttribute("email", user);

               /* if (primerAcceso == true && !rol.equals("ADMIN")) {
                    request.setAttribute("primerAcceso", true);
                }*/

              /*  if (rol.toString().equals("TUTOR")) {
                    Object idCiclo = adaoT.getIdCicloTutor(idUsuario);
                    System.out.println(idCiclo.toString());
                    request.getSession().setAttribute("idCiclo", idCiclo.toString());
                    request.getSession().setAttribute("password", password);
                }
                
                if (rol.toString().equals("ALUMNO")) {
                    request.getSession().setAttribute("password", password);
                }

                //Modificar fecha de acceso
                Date date = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date fecha = formato.parse(formato.format(date));

                usuario = Udao.getById(idUsuario, Usuario.class);
                usuario.setUltimoAcceso(fecha);
                Udao.insertOrUpdate(usuario);

                url = "principal.jsp";
            } else {
                url = "index.jsp";
                request.setAttribute("errorCredencial", true);
            }

        }*/

        request.getRequestDispatcher(url).forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
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

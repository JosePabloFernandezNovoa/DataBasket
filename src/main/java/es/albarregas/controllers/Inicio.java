package es.albarregas.controllers;

import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.albarregas.dao.IUsuarioDAO;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;

/**
 * Controlador de inicio de sesion
 * el usuario se logue con sus credenciales de acceso
 * @author Jose Pablo Fernández Novoa
 */
@WebServlet(name = "inicio", urlPatterns = {"/inicio"})
public class Inicio extends HttpServlet {

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws ParseException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IUsuarioDAO adaoU = daof.getUsuarioDAO();

        String url = null;
        Boolean comprobacion = false;

        Cookie cookie = null;
        Cookie[] cookies = request.getCookies();

        //Comprobar si existe alguna cookie con el usuario recordado
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("usuario")) {
                    cookie = cookies[i];
                    break;
                }
            }
        }
        //Comprobar si existe la cookie (Si el usuario a seleccionado el chexbox para recoradar el usuario)
        
        if (request.getParameter("remember") == null) {
            if(cookie!=null){
                //Eliminamos el usuario recordado(cuando se deseleccina el checkbox del login)
                for (int i = 0; i < cookies.length; i++) {
                        cookie = cookies[i];
                        if (cookie.getName().equals("usuario")) {
                            cookie.setMaxAge(0);
                            response.addCookie(cookie);
                            break;
                        }
                    }
            }
               
        }else{
            //Guaardamos el usuario en una cookie
            String nombreUsuario = request.getParameter("username");
                System.out.println(nombreUsuario);
         
                Cookie userCookie = new Cookie("usuario", nombreUsuario);
                userCookie.setMaxAge(60 * 60);

                userCookie.setValue(nombreUsuario);
                response.addCookie(userCookie);
        }

        
        if (request.getParameter("login") != null) {

            String user = request.getParameter("username");
            String password = request.getParameter("passwordInicio");

            //Cifrar password 
            String passwordCifrada = getMD5(password);

            //comprobar la existencia de las credenciales de acceso en la BD 
            comprobacion = adaoU.comprobarCredenciales(user, passwordCifrada);

            //si son correctas se hace login en la aplicacion y se meten en sesion diferentes parametros para su manejo posterior
            if (comprobacion == true) {
                Integer idUsuario = adaoU.getIdUsuario(user);
                request.getSession().setAttribute("idUser", idUsuario);

                Object rol = adaoU.getRol(user);
                request.getSession().setAttribute("rol", rol.toString());

                
                Object[] nomApe = adaoU.getNombreApelidos(idUsuario);
                String nombreApellidos = nomApe[0]+ "";
                request.getSession().setAttribute("nombre", nombreApellidos);
                request.getSession().setAttribute("usuario", user);

                if (rol.toString().equals("USER")) {
                    request.getSession().setAttribute("password", password);
                }

                url = "index.jsp";
            } else {
                url = "JSP/inicioSesionYRegistro.jsp";
                request.setAttribute("errorCredencial", true);
            }

        }

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

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
import org.json.JSONObject;

/**
 * Controlador Ajax 
 * Se encarga de realizar las operaciones de consulta 
 * mediante funciones AJAX
 * @author Jose Pablo Fernández Novoa
 */
@WebServlet(name = "ajax", urlPatterns = {"/ajax"})
public class Ajax extends HttpServlet {

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
        JSONObject objeto = new JSONObject();
        DAOFactory daof = DAOFactory.getDAOFactory();
        
        IUsuarioDAO adaoU = daof.getUsuarioDAO();

        Boolean operacion = false;
        
        if (request.getParameter("email") != null) {
            String email = request.getParameter("email");
            boolean emailRepetido = false;

            //buscamos en la BD si el email esta ya registrado estaconsulta devuelve un listado
            operacion = adaoU.comprobarUsuarioRepetido(email);

            //si el listado contiene algo quiere decir que si esta repetido
            if (operacion == true) {
                emailRepetido = true;
            } else {
                emailRepetido = false;
            }
            //devolvemos el resultado de la comrpbacion
            objeto.put("verificacion", emailRepetido);

        }
        
        if (request.getParameter("pass") != null) {
            int idUsuario = (int) request.getSession().getAttribute("idUser");
            String pass = request.getParameter("pass");

            //buscamos en la BD si el email esta ya registrado estaconsulta devuelve un listado
            operacion = adaoU.comprobarPassword(getMD5(pass), idUsuario);

            //devolvemos el resultado de la comrpbacion
            objeto.put("verificacion", operacion);

        }
       
       response.setContentType("application/json");
       response.getWriter().print(objeto);

       
        
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

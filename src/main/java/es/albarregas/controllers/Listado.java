package es.albarregas.controllers;

import es.albarregas.beans.Equipo;
import es.albarregas.beans.Jugador;
import es.albarregas.beans.Usuario;
import es.albarregas.dao.IEquipoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.albarregas.dao.IGenericoDAO;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import es.albarregas.dao.IJugadorDAO;

/**
 * Controlador que lista todos los datos de 
 * los jugadores de un equipo especifico
 * @author Jose Pablo Fernández Novoa
 */
@WebServlet(name = "Listado", urlPatterns = {"/listar"})
public class Listado extends HttpServlet {

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws ParseException
     * @throws InvocationTargetException 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, InvocationTargetException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        String url=null;
        
        IJugadorDAO adaoJ = daof.getJugadorDAO();
        IEquipoDAO adaoE = daof.getEquipoDAO();
        IGenericoDAO<Equipo> Edao = daof.getGenericoDAO();
        
        List<Jugador> listadoJugadores = null;
        List<Equipo> listadoEquipo = null;
        List<Equipo> listaEquipos = null;
        
        if (request.getParameter("datosEquipoJugador") != null) {
            String idEquipo = request.getParameter("equipos");
          
            listadoEquipo = adaoE.getEquipo(Short.valueOf(idEquipo));
            listadoJugadores = adaoJ.getJugadoresEquipo(Short.valueOf(idEquipo));
            listaEquipos = Edao.selectAll(Equipo.class);
                
            
            if (listadoJugadores.isEmpty()) {
                request.setAttribute("error", true);
            }
             
            request.setAttribute("listadoJugadores", listadoJugadores);
            request.setAttribute("listadoEquipo", listadoEquipo);
            request.setAttribute("listado", listaEquipos);
            url = "JSP/equipos.jsp";
            
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
            Logger.getLogger(Listado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Listado.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Listado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Listado.class.getName()).log(Level.SEVERE, null, ex);
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

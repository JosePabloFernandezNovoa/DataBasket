package es.albarregas.controllers;

import es.albarregas.beans.Equipo;
import es.albarregas.beans.Estadisticas;
import es.albarregas.beans.Jugador;
import es.albarregas.dao.IEquipoDAO;
import es.albarregas.dao.IEstadisticaDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IJugadorDAO;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Controlador que lista los datos de jugadores y equipos
 * @author Jose Pablo Fernández Novoa
 */
@WebServlet(name = "listadoAjax", urlPatterns = {"/listadoAjax"})
public class ListadoAjax extends HttpServlet {

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
        JSONArray arrayJSON =null;
        JSONObject objeto = new JSONObject();
        DAOFactory daof = DAOFactory.getDAOFactory();
        
        IGenericoDAO<Jugador> Jdao = daof.getGenericoDAO();
        IJugadorDAO adaoJ = daof.getJugadorDAO();
        IEquipoDAO adaoE = daof.getEquipoDAO();
        IEstadisticaDAO adaoEQ = daof.getEstadisticaDAO();
        
        Jugador jugador= null;
        List<Jugador> listadoJugador = null;
        List<Equipo> listadoEquipo = null;
        List<Estadisticas> listadoEstadisticas = null;
        
        if (request.getParameter("equipo") != null) {
            String idEquipo = request.getParameter("equipo");

            //recogemos todos los jugadores de eses equipo
            listadoEquipo = adaoE.getEquipo(Short.valueOf(idEquipo));
            
            arrayJSON = new JSONArray(listadoEquipo);
            

        }
        
        if (request.getParameter("idJugador") != null) {
            String idJugador = request.getParameter("idJugador");

            //recogemos todos los jugadores de ese equipo
            listadoJugador = adaoJ.getInfoJugador(Short.valueOf(idJugador));
            
            arrayJSON = new JSONArray(listadoJugador);
            
        }
        
        if (request.getParameter("idEquipo") != null) {
            String idEquipo = request.getParameter("idEquipo");

            //recogemos todos los jugadores de ese equipo
            listadoJugador = adaoJ.getJugadoresEquipo(Short.valueOf(idEquipo));
            
            arrayJSON = new JSONArray(listadoJugador);
            
        }
        
        if (request.getParameter("jugador") != null) {
            String idJugador = request.getParameter("jugador");
            
            //recogemos las estadisticas de un jugador
            listadoEstadisticas = adaoEQ.getEstadisticasJugador(Short.valueOf(idJugador));
            
            arrayJSON = new JSONArray(listadoEstadisticas);
            
        }
        
        if (request.getParameter("jugador1") != null && request.getParameter("jugador2") != null) {
            String idJugador1 = request.getParameter("jugador1");
            String idJugador2 = request.getParameter("jugador2");
            //listado de estadisticas de 2 jugadores en concreto
            listadoEstadisticas = adaoEQ.getEstadisticas2Jugadores(Short.valueOf(idJugador1),Short.valueOf(idJugador2));
            
            arrayJSON = new JSONArray(listadoEstadisticas);
            
        }
        
        response.setContentType("application/json");
        response.getWriter().print(arrayJSON);
        
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

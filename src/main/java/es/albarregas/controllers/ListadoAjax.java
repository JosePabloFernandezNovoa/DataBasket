package es.albarregas.controllers;

import es.albarregas.beans.Equipo;
import es.albarregas.beans.Jugador;
import es.albarregas.dao.IEquipoDAO;
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
 *
 * @author Jesus
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
        
        Jugador jugador= null;
        List<Jugador> listadoJugador = null;
        List<Equipo> listadoEquipo = null;
        
        if (request.getParameter("equipo") != null) {
            String idEquipo = request.getParameter("equipo");

            //recogemos todos los jugadores de eses equipo
            listadoEquipo = adaoE.getEquipo(Short.valueOf(idEquipo));
            
            arrayJSON = new JSONArray(listadoEquipo);
            

        }
        
        if (request.getParameter("idJugador") != null) {
            String idJugador = request.getParameter("idJugador");

            //recogemos todos los jugadores de eses equipo
            listadoJugador = adaoJ.getInfoJugador(Short.valueOf(idJugador));
            
            arrayJSON = new JSONArray(listadoJugador);
            
        }
        
        if (request.getParameter("idEquipo") != null) {
            String idEquipo = request.getParameter("idEquipo");

            //recogemos todos los jugadores de eses equipo
            listadoJugador = adaoJ.getJugadoresEquipo(Short.valueOf(idEquipo));
            
            arrayJSON = new JSONArray(listadoJugador);
            
        }
        
        /*if (request.getParameter("nif") != null) {
            String nif = request.getParameter("nif");
            boolean nifRepetido = false;

            //buscamos en la BD si el email esta ya registrado estaconsulta devuelve un listado
            operacion = adaoU.comprobarNif(nif);

            //si el listado contiene algo quiere decir que si esta repetido
            if (operacion == true) {
                nifRepetido = true;
            } else {
                nifRepetido = false;
            }
            //devolvemos el resultado de la comrpbacion
            objeto.put("verificacion", nifRepetido);

        }*/
        
        /*if (request.getParameter("nota")!= null) {

            int idNota = Integer.parseInt(request.getParameter("idNota"));
            Byte notas = Byte.valueOf(request.getParameter("nota"));
            
            
            nota=Ndao.getById(idNota, Nota.class);
            
            nota.setNota(notas);
           
            Ndao.insertOrUpdate(nota);

            objeto.put("verificacion", true);

        }*/
        
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

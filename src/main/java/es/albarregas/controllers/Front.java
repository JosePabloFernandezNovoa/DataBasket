/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Equipo;
import es.albarregas.beans.Estadisticas;
import es.albarregas.beans.Partido;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import es.albarregas.dao.IJugadorDAO;
import es.albarregas.dao.IEstadisticaDAO;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "front", urlPatterns = {"/front"})
public class Front extends HttpServlet {

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
        IGenericoDAO<Partido> Pdao = daof.getGenericoDAO();
        IGenericoDAO<Equipo> Edao = daof.getGenericoDAO();
        IGenericoDAO<Estadisticas> Esdao = daof.getGenericoDAO();

        IJugadorDAO adaoJ = daof.getJugadorDAO();
        IEstadisticaDAO adaoE = daof.getEstadisticaDAO();
        IUsuarioDAO adaoU = daof.getUsuarioDAO();

        List<Partido> listaPartidos = null;
        List<Equipo> listaEquipos = null;
        List<Estadisticas> listaEstadisticas = null;
        List<Object[]> listaProfesoresAlumnos = null;
        List<Object[]> listaA = null;

        Boolean vacio = false;

        switch (request.getParameter("id")) {

            case "partidos":

                listaPartidos = Pdao.selectAll(Partido.class);
                request.setAttribute("listado", listaPartidos);

                break;

            case "equipos":

                listaEquipos = Edao.selectAll(Equipo.class);
                request.setAttribute("listado", listaEquipos);

                break;

            case "anotadores":

                listaEstadisticas = adaoE.getAnotadores();
                request.setAttribute("listado", listaEstadisticas);
                break;

            case "nuevoAlumno":
                url = "JSP/nuevo/Nuevo_Alumno.jsp";
                break;

            case "nuevoNota":

                String codigoCiclo = (String) request.getSession().getAttribute("idCiclo");
                // listaAlumnos = adaoA.getAlumnosDeunCiclo(codigoCiclo);
                //request.setAttribute("listadoAlumnos", listaAlumnos);

                //listaModulos = adaoC.getModulosCiclo(codigoCiclo);
                //request.setAttribute("listadoModulos", listaModulos);
                //listaNotas = adaoC.getNotasCiclo(codigoCiclo);
                // request.setAttribute("listadoNotas", listaNotas);
                /*if(listaAlumnos.isEmpty() || listaNotas.isEmpty()){
                    vacio=true;
                }*/
                break;
            case "eliminarAlumnos":
                String idCiclo = (String) request.getSession().getAttribute("idCiclo");
                // listaAlumnos = adaoA.getAlumnosDeunCiclo(idCiclo);
                // request.setAttribute("listado", listaAlumnos);

                break;

        }
        if (request.getParameter("id").equals("partidos") || request.getParameter("id").equals("nuevoAlumno")
                || request.getParameter("id").equals("nuevoNota") || request.getParameter("id").equals("modificarDatosProfesor")
                || request.getParameter("id").equals("modificarDatosAlumno")
                || (listaPartidos != null && !listaPartidos.isEmpty()) || (listaEquipos != null && !listaEquipos.isEmpty())
                || (listaEstadisticas != null && !listaEstadisticas.isEmpty())) {
            switch (request.getParameter("id")) {
                case "partidos":
                    url = "JSP/partidos.jsp";
                    break;

                case "equipos":
                    url = "JSP/equipos.jsp";
                    break;

                case "anotadores":
                    url = "JSP/estadisticas/anotadores.jsp";
                    break;

                case "alumnos":
                    url = "JSP/listado/Notas_Alumnos.jsp";
                    break;

                case "nuevoNota":
                    if (vacio == false) {
                        url = "JSP/nuevo/Nuevo_Notas.jsp";
                    } else {
                        url = "JSP/errores/error.jsp";
                    }
                    break;

                case "eliminarProfesor":
                    url = "JSP/listado/Ver_Profesores_Eliminar.jsp";
                    break;

                case "eliminarAlumnos":
                    url = "JSP/listado/Ver_AlumnosCiclo_Eliminar.jsp";
                    break;

                case "modificarDatosProfesor":
                    url = "JSP/update/Actualizar_Datos_Tutor.jsp";
                    break;

                case "modificarDatosAlumno":
                    url = "JSP/update/Actualizar_Datos_Alumno.jsp";
                    break;

            }
        } else {
            url = "JSP/errores/error.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);
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

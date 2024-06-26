/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Equipo;
import es.albarregas.beans.Estadisticas;
import es.albarregas.beans.Jugador;
import es.albarregas.beans.Partido;
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
import es.albarregas.dao.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import es.albarregas.dao.IEstadisticaDAO;

/**
 * Controlador Front de entrada cada vez se hace click
 * en un enlace se direge aqui y redirige a una URL concreta
 * @author Jose Pablo Fernández Novoa
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
        IGenericoDAO<Usuario> Udao = daof.getGenericoDAO();

        IEstadisticaDAO adaoE = daof.getEstadisticaDAO();
        IUsuarioDAO adaoU = daof.getUsuarioDAO();
        IEquipoDAO adaoEQ = daof.getEquipoDAO();

        List<Usuario> datosUsuario=null;
        List<Usuario> listaUsuarios=null;
        List<Estadisticas> listaEstadisticas=null;
        List<Partido> listaPartidos = null;
        List<Equipo> listaEquipos = null;
        List<Object[]> listEstadisticas = null;
        
        Estadisticas estadisticas = null;
        Jugador jugador=null;
        Equipo equipo=null;
        Usuario usuario=null;
        switch (request.getParameter("id")) {

            case "partidos":

                listaPartidos = Pdao.selectAll(Partido.class);
                request.setAttribute("listado", listaPartidos);

                break;

            case "equipos":

                listaEquipos = Edao.selectAll(Equipo.class);
                request.setAttribute("listado", listaEquipos);

                break;
            
            case "individuales":
                listaEquipos = adaoEQ.getEquiposConJugadores();
                request.setAttribute("listado", listaEquipos);
                
                break;
                
            case "compararEstadisticas":
                listaEquipos = adaoEQ.getEquiposConJugadores();
                request.setAttribute("listado", listaEquipos);
                
                break;    

            case "anotadores":

                listEstadisticas = adaoE.getAnotadores();
                
                listaEstadisticas = new ArrayList<>();

                for (int i = 0; i < listEstadisticas.size(); i++) {
                    jugador =new Jugador();
                    estadisticas = new Estadisticas();
                    equipo =new Equipo();
                    Object[] resultado = listEstadisticas.get(i);
                    
                    jugador.setNombre(resultado[0].toString());
                    
                    equipo.setNombre(resultado[1].toString());
                    equipo.setLogotipo(resultado[2].toString());
                    jugador.setEquipo(equipo);
                    
                    estadisticas.setJugador(jugador);
                    estadisticas.setMediaEstadisticasPartido(Short.valueOf(resultado[3].toString()));

                    listaEstadisticas.add(estadisticas);
                }
                request.setAttribute("listado", listaEstadisticas);
                break;
            
            case "asistentes":

                listEstadisticas = adaoE.getAsistentes();
                
                listaEstadisticas = new ArrayList<>();

                for (int i = 0; i < listEstadisticas.size(); i++) {
                    jugador =new Jugador();
                    estadisticas = new Estadisticas();
                    equipo =new Equipo();
                    Object[] resultado = listEstadisticas.get(i);
                    
                    jugador.setNombre(resultado[0].toString());
                    
                    equipo.setNombre(resultado[1].toString());
                    equipo.setLogotipo(resultado[2].toString());
                    jugador.setEquipo(equipo);
                    
                    estadisticas.setJugador(jugador);
                    estadisticas.setMediaEstadisticasPartido(Short.valueOf(resultado[3].toString()));

                    listaEstadisticas.add(estadisticas);
                }
                request.setAttribute("listado", listaEstadisticas);
                break; 
                
            case "reboteadores":

                listEstadisticas = adaoE.getReboteadores();
                
                listaEstadisticas = new ArrayList<>();

                for (int i = 0; i < listEstadisticas.size(); i++) {
                    jugador =new Jugador();
                    estadisticas = new Estadisticas();
                    equipo =new Equipo();
                    Object[] resultado = listEstadisticas.get(i);
                    
                    jugador.setNombre(resultado[0].toString());
                    
                    equipo.setNombre(resultado[1].toString());
                    equipo.setLogotipo(resultado[2].toString());
                    jugador.setEquipo(equipo);
                    
                    estadisticas.setJugador(jugador);
                    estadisticas.setMediaEstadisticasPartido(Short.valueOf(resultado[3].toString()));

                    listaEstadisticas.add(estadisticas);
                }
                request.setAttribute("listado", listaEstadisticas);
                break;   
            
            case "taponadores":

                listEstadisticas = adaoE.getTaponadores();
                
                listaEstadisticas = new ArrayList<>();

                for (int i = 0; i < listEstadisticas.size(); i++) {
                    jugador =new Jugador();
                    estadisticas = new Estadisticas();
                    equipo =new Equipo();
                    Object[] resultado = listEstadisticas.get(i);
                    
                    jugador.setNombre(resultado[0].toString());
                    
                    equipo.setNombre(resultado[1].toString());
                    equipo.setLogotipo(resultado[2].toString());
                    jugador.setEquipo(equipo);
                    
                    estadisticas.setJugador(jugador);
                    estadisticas.setMediaEstadisticasPartido(Short.valueOf(resultado[3].toString()));

                    listaEstadisticas.add(estadisticas);
                }
                request.setAttribute("listado", listaEstadisticas);
                break;    

            case "perfil":
                int idUsuario = (int) request.getSession().getAttribute("idUser");
                datosUsuario=adaoU.getDatosUsuario(idUsuario);
                
                request.setAttribute("listado", datosUsuario);
                break;
            
            case "modificarPerfil":
                int idUser = (int) request.getSession().getAttribute("idUser");
                usuario=Udao.getById(idUser, Usuario.class);
                
                request.setAttribute("usuario", usuario);
                break;  
                
            case "nuevoEquipo":
                url = "JSP/funcionesRol/nuevoEquipo.jsp";
                break;
                
            case "nuevoJugador":
                listaEquipos = Edao.selectAll(Equipo.class);
                request.setAttribute("listado", listaEquipos);
                
                url = "JSP/funcionesRol/nuevoJugador.jsp";
                break;  
             
            case "listaUsuarios":

                listaUsuarios = Udao.selectAll(Usuario.class);
                request.setAttribute("listado", listaUsuarios);

                break;
    
   
        }
        if (request.getParameter("id").equals("partidos") || request.getParameter("id").equals("modificarPerfil") || request.getParameter("id").equals("nuevoEquipo")
                || request.getParameter("id").equals("nuevoNota") || request.getParameter("id").equals("modificarDatosProfesor")
                || request.getParameter("id").equals("modificarDatosAlumno") || (listaUsuarios != null && !listaUsuarios.isEmpty())
                || (listaPartidos != null && !listaPartidos.isEmpty()) || (listaEquipos != null && !listaEquipos.isEmpty())
                || (listaEstadisticas != null && !listaEstadisticas.isEmpty()) || (datosUsuario != null && !datosUsuario.isEmpty())) {
            switch (request.getParameter("id")) {
                case "partidos":
                    url = "JSP/partidos.jsp";
                    break;

                case "equipos":
                    url = "JSP/equipos.jsp";
                    break;
                
                case "individuales":
                    url = "JSP/estadisticas/individuales.jsp";
                    break;  
                 
                case "compararEstadisticas":
                    url = "JSP/estadisticas/compararjugadores.jsp";
                    break;    

                case "anotadores":
                    url = "JSP/estadisticas/anotadores.jsp";
                    break;
                
                case "asistentes":
                    url = "JSP/estadisticas/asistencias.jsp";
                    break;    
                
                case "reboteadores":
                    url = "JSP/estadisticas/rebotes.jsp";
                    break;
                
                case "taponadores":
                    url = "JSP/estadisticas/tapones.jsp";
                    break;      

                case "perfil":
                    url = "JSP/funcionesRol/perfil.jsp";
                    break;
                
                case "modificarPerfil":
                    url = "JSP/funcionesRol/modificarPerfil.jsp";
                    break;    
                        
                case "nuevoJugador":
                url = "JSP/funcionesRol/nuevoJugador.jsp";
                break; 
               
                case "listaUsuarios":
                url = "JSP/usuarios.jsp";
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

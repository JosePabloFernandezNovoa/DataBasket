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
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jesus
 */
@WebServlet(name = "crear", urlPatterns = {"/crear"})
public class CrearDatos extends HttpServlet {

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
            throws ServletException, IOException, ParseException, InvocationTargetException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO<Usuario> Udao = daof.getGenericoDAO();

        Usuario usuario = new Usuario();
     
        String url = null;

        if (request.getParameter("nuevoUsuario") != null) {

            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String passwordCifrada=getMD5(password);
            
            Date date = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date fecha = formato.parse(formato.format(date));

            usuario.setNombre(nombre);
            usuario.setApellidos(apellidos);
            usuario.setUsuario(email);
            usuario.setPassword(passwordCifrada);
            usuario.setAvatar("avatar.png");
            usuario.setFechaNacimiento(fecha);
            usuario.setRol(Usuario.Rol.USER);

            Udao.insertOrUpdate(usuario);
            url = "index.jsp";
        }
        /*

        if (request.getParameter("nuevoAlumno") != null) {

            String dni = request.getParameter("dni");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Date fechaNacimiento = Date.valueOf(request.getParameter("fecha"));
            String sexo = request.getParameter("genero");
            String cicloNombre = request.getParameter("idCiclo");
            String passwordCifrada=getMD5(password);
            
            alumno.setDni(dni);
            alumno.setEmail(email);
            alumno.setPassword(passwordCifrada);
            alumno.setRol(Usuario.Rol.ALUMNO);
            alumno.setAvatar("avatar.png");
            alumno.setFechaNacimiento(fechaNacimiento);

            if (sexo.equals("MUJER")) {
                alumno.setGenero(Alumno.Genero.MUJER);
            } else {
                alumno.setGenero(Alumno.Genero.HOMBRE);
            }

            ciclo = Cdao.getById(cicloNombre, Ciclo.class);
            alumno.setCiclo(ciclo);
            
            listaModulos=adaoA.getModulosAlumnoCiclo(cicloNombre);
            
            for (int i = 0; i < listaModulos.size(); i++) {
                nota=new Nota();

                nota.setAlumno(alumno);
                nota.setModulo(listaModulos.get(i));
                nota.setNota(Byte.valueOf("5"));
                listaNotas.add(nota);
            }
            alumno.setNotas(listaNotas);
            
            Adao.insertOrUpdate(alumno);
            url = "principal.jsp";
        }

        if (request.getParameter("visualizarModulos") != null) {
            //recogemos las opciones escogidas
            checks = request.getParameter("opcion");
            //comprobamos si se lecciono alguna
            if (checks == null) {
                String idCiclo=(String) request.getSession().getAttribute("idCiclo");
                listaAlumnos =  adaoA.getAlumnosDeunCiclo(idCiclo);
                request.setAttribute("listado", listaAlumnos);

                url = "JSP/listado/Ver_AlumnosCiclo.jsp";

                request.setAttribute("error", true);
            } else {

                request.getSession().setAttribute("idAlumno", checks);

                String idCiclo = (String) request.getSession().getAttribute("idCiclo");
                listaModulos = adaoC.getModulosCiclo(idCiclo);
                request.setAttribute("listado", listaModulos);

                url = "JSP/nuevo/Nuevo_Notas.jsp";
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
            Logger.getLogger(CrearDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CrearDatos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CrearDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CrearDatos.class.getName()).log(Level.SEVERE, null, ex);
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

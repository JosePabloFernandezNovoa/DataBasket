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
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import es.albarregas.dao.IEstadisticaDAO;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Modificar", urlPatterns = {"/modificar"})
public class ModificarDatos extends HttpServlet {

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
        
       // IEstadisticaDAO adaoA = daof.getAlumnoDAO();

        Usuario usuario = new Usuario();
       // List<Alumno> listaAlumnos = null;
        //List<Nota> listaNotas = null;
        String url = null;
        String checks = null;

        if (request.getParameter("modificarPassword") != null) {
            Integer idUsuario = (Integer) request.getSession().getAttribute("usuario");

            String nombre = request.getParameter("nombre");
            String apelidos = request.getParameter("apellidos");
            String password = request.getParameter("password");
            String passwordCifrada = getMD5(password);

            usuario = Udao.getById(idUsuario, Usuario.class);

            usuario.setNombre(capitalizar(nombre));
            usuario.setApellidos(capitalizar(apelidos));
            usuario.setPassword(passwordCifrada);
            Udao.insertOrUpdate(usuario);
            
            
            String nombreApellidos=nombre+" "+apelidos;
            request.getSession().setAttribute("nombreApellidos", nombreApellidos);
            
            url = "principal.jsp";
        }

        if (request.getParameter("visualizarDatosAlumno") != null) {
            //recogemos las opciones escogidas
            checks = request.getParameter("opcion");
            //comprobamos si se lecciono alguna
            if (checks == null) {
                String idCiclo = (String) request.getSession().getAttribute("idCiclo");
                //listaAlumnos = adaoA.getAlumnosDeunCiclo(idCiclo);
                //request.setAttribute("listado", listaAlumnos);

                url = "JSP/listado/Ver_AlumnosCiclo_Modificar.jsp";

                request.setAttribute("error", true);
            } else {

                request.getSession().setAttribute("idAlumno", checks);

                //listaNotas = adaoA.getNotasAlumno(Integer.parseInt(checks));
               // request.setAttribute("listado", listaNotas);

                url = "JSP/update/Modificar_Notas.jsp";
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ModificarDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ModificarDatos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ModificarDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ModificarDatos.class.getName()).log(Level.SEVERE, null, ex);
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

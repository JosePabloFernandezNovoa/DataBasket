package es.albarregas.dao;

import es.albarregas.beans.Usuario;
import java.util.List;


public interface IUsuarioDAO {
    
    public boolean comprobarCredenciales(String usuario, String password);
    public Object getRol(String usuario);
    public boolean comprobarEmail(String email);
    public boolean comprobarNif(String nif);
    public Integer getIdUsuario(String email);
    public boolean getPrimerAcceso(Integer id);
    public List<Usuario> getProfesoresSinAlumnos();
    public String getIdCicloUsuario(int idUsuario);
    public String getAvatar(int idUsuario);
    public Object[] getNombreApelidos(int idUsuario);
    
}
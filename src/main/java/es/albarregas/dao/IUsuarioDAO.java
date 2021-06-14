package es.albarregas.dao;

import es.albarregas.beans.Usuario;
import java.util.List;


public interface IUsuarioDAO {
    
    public boolean comprobarCredenciales(String usuario, String password);
    public Object getRol(String usuario);
    public boolean comprobarUsuarioRepetido(String email);
    public Integer getIdUsuario(String email);
    public String getAvatar(int idUsuario);
    public Object[] getNombreApelidos(int idUsuario);
    public List<Usuario> getDatosUsuario(int idUsuario);
    public boolean comprobarPassword(String password, int id);
    
}
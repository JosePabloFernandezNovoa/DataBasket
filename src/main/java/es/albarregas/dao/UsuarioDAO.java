/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author jp-9
 */
public class UsuarioDAO extends GenericoDAO implements IUsuarioDAO {

    @Override
    public boolean comprobarCredenciales(String usuario, String password) {
        Boolean resultado=false;
       String hql="SELECT u.email, u.password FROM Usuario AS u where u.email = :usuario and u.password = :password";
        Query consulta=null;
        List<Object> credenciales=null;
        try {
            startTransaction();
            consulta=sesion.createQuery(hql);
            
            consulta.setParameter("usuario", usuario);
            consulta.setParameter("password", password);
            
            credenciales=(List<Object>)consulta.list();
            
            if(!credenciales.isEmpty()){
               resultado=true;
            }
        } catch (HibernateException he) {
            handleException(he);
        }finally{
            endTransaction();
        }
        return resultado;
    }   

    @Override
    public Object getRol(String usuario) {
       String hql="SELECT u.rol FROM Usuario AS u where u.email = :usuario";
        Query consulta=null;
        Object rol=null;
        try {
            startTransaction();
            consulta=sesion.createQuery(hql);
            
            consulta.setParameter("usuario", usuario);
            
            rol=(Object)consulta.uniqueResult();
        } catch (HibernateException he) {
            handleException(he);
        }finally{
            endTransaction();
        }
        return rol;
    }

    @Override
    public boolean comprobarEmail(String email) {
       Boolean resultado=false;
       String hql="SELECT u.email FROM Usuario AS u where u.email = :email";
        Query consulta=null;
        List<Object> emails=null;
        try {
            startTransaction();
            consulta=sesion.createQuery(hql);
            
            consulta.setParameter("email", email);
            
            emails=(List<Object>)consulta.list();
            
            if(!emails.isEmpty()){
               resultado=true;
            }
        } catch (HibernateException he) {
            handleException(he);
        }finally{
            endTransaction();
        }
        return resultado;
    }

    @Override
    public Integer getIdUsuario(String email) {
        String hql="SELECT u.idUsuario FROM Usuario AS u where u.email = :email";
        Query consulta=null;
        Integer id=null;
        try {
            startTransaction();
            consulta=sesion.createQuery(hql);
            
            consulta.setParameter("email", email);
            
            id=(Integer)consulta.uniqueResult();
        } catch (HibernateException he) {
            handleException(he);
        }finally{
            endTransaction();
        }
        return id;
    }
    
    public boolean getPrimerAcceso(Integer id) {
       Boolean resultado=false;
       String hql="SELECT u.ultimoAcceso FROM Usuario AS u where u.idUsuario = :id";
        Query consulta=null;
        Object fecha=null;
        try {
            startTransaction();
            consulta=sesion.createQuery(hql);
            
            consulta.setParameter("id", id);
            
            fecha=consulta.uniqueResult();
            
            if(fecha==null){
               resultado=true;
            }
        } catch (HibernateException he) {
            handleException(he);
        }finally{
            endTransaction();
        }
        return resultado;
    }

    @Override
    public List<Usuario> getProfesoresSinAlumnos() {
         String hql="select distinct u.idUsuario, u.nombre, u.apellidos from Usuario as u inner join Tutor"
                 + " as t inner join Alumno as a where u.idUsuario=t.idUsuario and t.ciclo<>a.ciclo";
        Query consulta=null;
        List<Usuario> profesores=null;
        try {
            startTransaction();
            consulta=sesion.createQuery(hql);
            profesores=(List<Usuario>)consulta.list();
        } catch (HibernateException he) {
            handleException(he);
        }finally{
            endTransaction();
        }
        return profesores;
    }
    
    @Override
    public String getIdCicloUsuario(int idUsuario) {
        String hql="SELECT a.ciclo.idCiclo FROM Alumno AS a where a.idUsuario = :id";
        Query consulta=null;
        String id=null;
        try {
            startTransaction();
            consulta=sesion.createQuery(hql);
            
            consulta.setParameter("id", idUsuario);
            
            id= (String) consulta.uniqueResult();
        } catch (HibernateException he) {
            handleException(he);
        }finally{
            endTransaction();
        }
        return id;
    }

    @Override
    public boolean comprobarNif(String nif) {
        Boolean resultado=false;
       String hql="SELECT u.dni FROM Usuario AS u where u.dni = :nif";
        Query consulta=null;
        List<Object> nifResult=null;
        try {
            startTransaction();
            consulta=sesion.createQuery(hql);
            
            consulta.setParameter("nif", nif);
            
            nifResult=(List<Object>)consulta.list();
            
            if(!nifResult.isEmpty()){
               resultado=true;
            }
        } catch (HibernateException he) {
            handleException(he);
        }finally{
            endTransaction();
        }
        return resultado;
    }

    @Override
    public String getAvatar(int idUsuario) {
        String hql="SELECT a.avatar FROM Usuario AS a where a.idUsuario = :id";
        Query consulta=null;
        String avatar=null;
        try {
            startTransaction();
            consulta=sesion.createQuery(hql);
            
            consulta.setParameter("id", idUsuario);
            
            avatar= (String) consulta.uniqueResult();
        } catch (HibernateException he) {
            handleException(he);
        }finally{
            endTransaction();
        }
        return avatar;
    }
    
    @Override
    public Object[] getNombreApelidos(int idUsuario) {
        String hql="SELECT a.nombre,a.apellidos FROM Usuario AS a where a.idUsuario = :id";
        Query consulta=null;
        Object[] nombreApe=null;
        try {
            startTransaction();
            consulta=sesion.createQuery(hql);
            
            consulta.setParameter("id", idUsuario);
            
            nombreApe= (Object[]) consulta.uniqueResult();
        } catch (HibernateException he) {
            handleException(he);
        }finally{
            endTransaction();
        }
        return nombreApe;
    }
}

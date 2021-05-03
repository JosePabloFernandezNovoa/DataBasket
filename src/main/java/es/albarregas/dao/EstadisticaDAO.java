/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Estadisticas;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author jp-9
 */
public class EstadisticaDAO extends GenericoDAO implements IEstadisticaDAO {

    @Override
    public List<Estadisticas> getAnotadores() {
        /*String hql = "SELECT e.jugador.nombre,e.jugador.equipo.nombre,e.jugador.equipo.logotipo,sum(e.puntosPartido) AS mediaPuntosPartido FROM Estadisticas AS e "
                + "GROUP BY e.jugador.idJugador ORDER BY mediaPuntosPartido desc";*/
        String hql = "SELECT e FROM Estadisticas AS e "
                + "GROUP BY e.jugador.idJugador";
        Query consulta = null;
        List<Estadisticas> anotadores = null;
        try {
            startTransaction();
            consulta = sesion.createQuery(hql);

            anotadores = (List<Estadisticas>) consulta.list();
        } catch (HibernateException he) {
            handleException(he);
        } finally {
            endTransaction();
        }
        return anotadores;
    }

    /*@Override
    public List<Alumno> getAlumnosDeunCiclo(String idciclo) {
        String hql = "SELECT a FROM Alumno AS a WHERE a.ciclo.idCiclo = :ciclo and a.ultimoAcceso IS NOT NULL";
        Query consulta = null;
        List<Alumno> alumnos = null;
        try {
            startTransaction();
            consulta = sesion.createQuery(hql);

            consulta.setParameter("ciclo", idciclo);

            alumnos = (List<Alumno>) consulta.list();
        } catch (HibernateException he) {
            handleException(he);
        } finally {
            endTransaction();
        }
        return alumnos;
    }

    @Override
    public List<Nota> getNotasAlumno(int idUsuario) {
        String hql = "SELECT n FROM Nota AS n WHERE n.alumno.idUsuario = :id";
        Query consulta = null;
        List<Nota> notas = null;
        try {
            startTransaction();
            consulta = sesion.createQuery(hql);

            consulta.setParameter("id", idUsuario);

            notas = (List<Nota>) consulta.list();
        } catch (HibernateException he) {
            handleException(he);
        } finally {
            endTransaction();
        }
        return notas;
    }

    @Override
    public List<Modulo> getModulosAlumnoCiclo(String idCiclo) {
        String hql = "SELECT m FROM Ciclo AS c inner join c.modulos as m where c.idCiclo=:ciclo";
        Query consulta = null;
        List<Modulo> modulos = null;
        try {
            startTransaction();
            consulta = sesion.createQuery(hql);

            consulta.setParameter("ciclo", idCiclo);

            modulos = (List<Modulo>) consulta.list();
        } catch (HibernateException he) {
            handleException(he);
        } finally {
            endTransaction();
        }
        return modulos;
    }*/
}

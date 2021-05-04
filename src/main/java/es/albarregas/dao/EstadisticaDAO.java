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
    public List<Object[]> getAnotadores() {
        String hql = "SELECT e.jugador.nombre,e.jugador.equipo.nombre,e.jugador.equipo.logotipo,sum(e.puntosPartido) AS mediaPuntosPartido FROM Estadisticas AS e "
                + "GROUP BY e.jugador.idJugador ORDER BY mediaPuntosPartido desc";
        Query consulta = null;
        List<Object[]> anotadores = null;
        try {
            startTransaction();
            consulta = sesion.createQuery(hql);

            anotadores = (List<Object[]>) consulta.list();
        } catch (HibernateException he) {
            handleException(he);
        } finally {
            endTransaction();
        }
        return anotadores;
    }

    @Override
    public List<Object[]> getAsistentes() {
String hql = "SELECT e.jugador.nombre,e.jugador.equipo.nombre,e.jugador.equipo.logotipo,sum(e.asistenciasPartido) AS mediaAsistenciasPartido FROM Estadisticas AS e "
                + "GROUP BY e.jugador.idJugador ORDER BY mediaAsistenciasPartido desc";
        Query consulta = null;
        List<Object[]> asistentes = null;
        try {
            startTransaction();
            consulta = sesion.createQuery(hql);

            asistentes = (List<Object[]>) consulta.list();
        } catch (HibernateException he) {
            handleException(he);
        } finally {
            endTransaction();
        }
        return asistentes;    }

    @Override
    public List<Object[]> getReboteadores() {
String hql = "SELECT e.jugador.nombre,e.jugador.equipo.nombre,e.jugador.equipo.logotipo,sum(e.rebotesPartido) AS mediaRebotesPartido FROM Estadisticas AS e "
                + "GROUP BY e.jugador.idJugador ORDER BY mediaRebotesPartido desc";
        Query consulta = null;
        List<Object[]> reboteadores = null;
        try {
            startTransaction();
            consulta = sesion.createQuery(hql);

            reboteadores = (List<Object[]>) consulta.list();
        } catch (HibernateException he) {
            handleException(he);
        } finally {
            endTransaction();
        }
        return reboteadores;    }

    @Override
    public List<Object[]> getTaponadores() {
String hql = "SELECT e.jugador.nombre,e.jugador.equipo.nombre,e.jugador.equipo.logotipo,sum(e.taponesPartido) AS mediaTaponesPartido FROM Estadisticas AS e "
                + "GROUP BY e.jugador.idJugador ORDER BY mediaTaponesPartido desc";
        Query consulta = null;
        List<Object[]> taponadores = null;
        try {
            startTransaction();
            consulta = sesion.createQuery(hql);

            taponadores = (List<Object[]>) consulta.list();
        } catch (HibernateException he) {
            handleException(he);
        } finally {
            endTransaction();
        }
        return taponadores;    }
}

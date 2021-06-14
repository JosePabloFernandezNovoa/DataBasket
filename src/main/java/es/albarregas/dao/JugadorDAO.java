/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Jugador;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author jp-9
 */
public class JugadorDAO extends GenericoDAO implements IJugadorDAO {

    @Override
    public List<Jugador> getJugadoresEquipo(Short id) {
        String hql="SELECT j FROM Jugador AS j where j.equipo.idEquipo = :id";
        Query consulta=null;
        List<Jugador> listaJugadores=null;
        try {
            startTransaction();
            consulta=sesion.createQuery(hql);
            
            consulta.setParameter("id", id);
            
            listaJugadores=(List<Jugador>)consulta.list();
        } catch (HibernateException he) {
            handleException(he);
        }finally{
            endTransaction();
        }
        return listaJugadores;
    }

    @Override
    public List<Jugador> getInfoJugador(Short id) {
         String hql="SELECT j FROM Jugador AS j where j.idJugador = :id";
        Query consulta=null;
        List<Jugador> listaJugadores=null;
        try {
            startTransaction();
            consulta=sesion.createQuery(hql);
            
            consulta.setParameter("id", id);
            
            listaJugadores=(List<Jugador>)consulta.list();
        } catch (HibernateException he) {
            handleException(he);
        }finally{
            endTransaction();
        }
        return listaJugadores;
    }

    @Override
    public List<Jugador> getJugadoresEquipoEstadisticas(Short id) {
        String hql="SELECT DISTINCT j FROM Jugador AS j INNER JOIN Estadisticas as e ON j.idJugador=e.jugador.idJugador where j.equipo.idEquipo = :id";
        Query consulta=null;
        List<Jugador> listaJugadores=null;
        try {
            startTransaction();
            consulta=sesion.createQuery(hql);
            
            consulta.setParameter("id", id);
            
            listaJugadores=(List<Jugador>)consulta.list();
        } catch (HibernateException he) {
            handleException(he);
        }finally{
            endTransaction();
        }
        return listaJugadores;
    }
}

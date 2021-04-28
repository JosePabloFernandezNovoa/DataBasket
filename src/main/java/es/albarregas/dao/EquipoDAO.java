/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Equipo;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author jp-9
 */
public class EquipoDAO extends GenericoDAO implements IEquipoDAO {

    @Override
    public List<Equipo> getEquipo(Short id) {
        String hql="SELECT e FROM Equipo AS e where e.idEquipo = :id";
        Query consulta=null;
        List<Equipo> listaEquipo=null;
        try {
            startTransaction();
            consulta=sesion.createQuery(hql);
            
            consulta.setParameter("id", id);
            
            listaEquipo=(List<Equipo>)consulta.list();
        } catch (HibernateException he) {
            handleException(he);
        }finally{
            endTransaction();
        }
        return listaEquipo;
    }
}

package es.albarregas.dao;

import es.albarregas.persistencia.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class GenericoDAO<T> implements IGenericoDAO<T> {

    protected Session sesion;
    
    protected void startTransaction() {
        sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
    }

    protected void endTransaction() {
        if (sesion.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
            sesion.getTransaction().commit();
        }
        sesion.close();
    }

    protected void handleException(HibernateException he) throws HibernateException {
        if (sesion.getTransaction().isActive()) {
            sesion.getTransaction().rollback();
        }
        throw he;
    }

    @Override
    public void insertOrUpdate(T objeto) {
        try {
            this.startTransaction();
            sesion.saveOrUpdate(objeto);
            sesion.flush();
        } catch (HibernateException he) {
            handleException(he);
        } finally {
            this.endTransaction();
        }
    }

    @Override
    public <T> List<T> selectAll(Class<T> claseEntidad) {
        List<T> listadoResultados = null;
        try {
            startTransaction();
            listadoResultados = sesion.createQuery("from " + claseEntidad.getSimpleName()).list();
        } catch (HibernateException he) {
            handleException(he);
        } finally {
            endTransaction();
        }
        return listadoResultados;
    }

    @Override
    public <T> T getById(Serializable pk, Class<T> claseEntidad) {
        T objetoRecuperado = null;

        try {
            startTransaction();
            objetoRecuperado = sesion.get(claseEntidad, pk);
        } catch (HibernateException he) {
            handleException(he);
        } finally {
            endTransaction();
        }
        return objetoRecuperado;
    }

    @Override
    public void delete(T objeto) {
        try {
            startTransaction();
            sesion.delete(objeto);
        } catch (HibernateException he) {
            handleException(he);
        } finally {
            endTransaction();
        }
    }

    @Override
    public <T> List<T> get() {
        

        List<T> listadoResultados = null;
        try {
            this.startTransaction();
            listadoResultados = sesion.createQuery("Select u from Usuario as u").list();
        } catch (HibernateException he) {
            this.handleException(he);
        } finally {
            this.endTransaction();
        }
        return listadoResultados;
    }
}

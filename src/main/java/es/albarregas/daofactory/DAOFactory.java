package es.albarregas.daofactory;


import es.albarregas.dao.IEquipoDAO;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IJugadorDAO;
import es.albarregas.dao.IEstadisticaDAO;
import es.albarregas.dao.IUsuarioDAO;


public abstract class DAOFactory {

   
    public abstract IGenericoDAO getGenericoDAO();
    public abstract IJugadorDAO getJugadorDAO();
    public abstract IEstadisticaDAO getEstadisticaDAO();
    public abstract IEquipoDAO getEquipoDAO();
    public abstract IUsuarioDAO getUsuarioDAO();
    
    public static DAOFactory getDAOFactory() {
        DAOFactory daof = null;

        daof = new MySQLDAOFactory();

        return daof;
    }

}

package es.albarregas.daofactory;


import es.albarregas.dao.EquipoDAO;
import es.albarregas.dao.EstadisticaDAO;
import es.albarregas.dao.JugadorDAO;
import es.albarregas.dao.GenericoDAO;
import es.albarregas.dao.IEquipoDAO;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IJugadorDAO;
import es.albarregas.dao.IEstadisticaDAO;
import es.albarregas.dao.IUsuarioDAO;
import es.albarregas.dao.UsuarioDAO;


public class MySQLDAOFactory extends DAOFactory{

    @Override
    public IGenericoDAO getGenericoDAO() {
        return new GenericoDAO();
    }
    
    @Override
    public IJugadorDAO getJugadorDAO() {
        return new JugadorDAO();
    }

    @Override
    public IEstadisticaDAO getEstadisticaDAO() {
        return new EstadisticaDAO();
    }

    @Override
    public IUsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO();
    }
    
    @Override
    public IEquipoDAO getEquipoDAO() {
        return new EquipoDAO();
    }


}

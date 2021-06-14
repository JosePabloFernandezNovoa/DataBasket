package es.albarregas.dao;

import es.albarregas.beans.Estadisticas;
import java.util.List;


public interface IEstadisticaDAO {
    
    public List<Object[]> getAnotadores();
    public List<Object[]> getAsistentes();
    public List<Object[]> getReboteadores();
    public List<Object[]> getTaponadores();
    public List<Estadisticas> getEstadisticasJugador(Short id);
    public List<Estadisticas> getEstadisticas2Jugadores(Short id1, Short id2);
}
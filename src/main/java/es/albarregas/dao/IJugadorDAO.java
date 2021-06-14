package es.albarregas.dao;

import es.albarregas.beans.Jugador;
import java.util.List;


public interface IJugadorDAO {
    
    public List<Jugador> getJugadoresEquipo(Short id);
    public List<Jugador> getJugadoresEquipoEstadisticas(Short id);
    public List<Jugador> getInfoJugador(Short id);
    
}
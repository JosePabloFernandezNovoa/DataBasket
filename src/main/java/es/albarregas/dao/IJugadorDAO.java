package es.albarregas.dao;

import es.albarregas.beans.Jugador;
import java.util.List;


public interface IJugadorDAO {
    
    /*public List<Tutor> profesoresSinAlumnos();
    public Object getIdCicloTutor(int id);
    public List<Object[]> getProfesoresAlumnosAsociados();*/
    public List<Jugador> getJugadoresEquipo(Short id);
    public List<Jugador> getInfoJugador(Short id);
    
}
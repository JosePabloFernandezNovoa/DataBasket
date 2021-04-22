package es.albarregas.dao;

import es.albarregas.beans.Equipo;
import java.util.List;


public interface IEquipoDAO {
    
    public List<Equipo> getEquipo(Short id);
    
}
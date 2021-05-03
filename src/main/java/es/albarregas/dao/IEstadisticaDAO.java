package es.albarregas.dao;

import es.albarregas.beans.Estadisticas;
import java.util.List;


public interface IEstadisticaDAO {
    
    /*public List<Alumno> getAlumnosDeunCiclo(String idciclo);
    public List<Nota> getNotasAlumno(int idAlumno);
    public List<Modulo> getModulosAlumnoCiclo(String idCiclo);*/
    public List<Estadisticas> getAnotadores();
}
package es.albarregas.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase Equipo
 * @author Jose Pablo Fernández Novoa
 */
@Entity
@Table(name="equipos")
public class Equipo implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idEquipo")
    private Short idEquipo;
    
    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;
    
    @Column(name = "ciudad", length = 20, nullable = false)
    private String ciudad;
    
    @Column(name = "conferencia", length = 4, nullable = false)
    private String conferencia;
    
    @Column(name = "division", length = 9, nullable = false)
    private String division;
    
    @Column(name = "entrenador", length = 45, nullable = false)
    private String entrenador;
    
    @Column(name = "mascota", length = 20, nullable = false)
    private String mascota;
    
    @Column(name = "logotipo", length = 45, nullable = false)
    private String logotipo;

    public Short getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Short idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public String getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(String logotipo) {
        this.logotipo = logotipo;
    }
    
    

}


    

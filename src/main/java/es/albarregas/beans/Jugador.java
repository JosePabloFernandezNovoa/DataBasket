package es.albarregas.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 * Clase Jugador
 * @author Jose Pablo Fernández Novoa
 */
@Entity
@Table(name="jugadores")
public class Jugador implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idJugador")
    private Short idJugador;
    
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="idEquipo", foreignKey = @ForeignKey(name = "FK_jugadores_equipos"))
    private Equipo equipo;
    
    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;
    
    @Column(name = "procedencia", length = 20, nullable = false)
    private String procedencia;
    
    @Column(name = "altura", length = 4, nullable = false)
    private String altura;
    
    @Column(name = "peso", nullable = false)
    private byte peso;
    
    @Column(name = "edad", nullable = false)
    private byte edad;
    
    @Column(name = "posicion", length = 10, nullable = false)
    private String posicion;
    
    @Column(name = "nacionalidad", length = 45, nullable = false)
    private String nacionalidad;
    
    @Column(name = "foto", length = 45, nullable = false)
    private String foto;

    public Short getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Short idJugador) {
        this.idJugador = idJugador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public byte getPeso() {
        return peso;
    }

    public void setPeso(byte peso) {
        this.peso = peso;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
    

}


    

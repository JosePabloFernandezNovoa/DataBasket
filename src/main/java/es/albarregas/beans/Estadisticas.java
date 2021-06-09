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
import javax.persistence.Transient;

/**
 * Clase Estadisticas
 * @author Jose Pablo Fernández Novoa
 */
@Entity
@Table(name="estadisticas")
public class Estadisticas implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idEstadistica")
    private Short idEstadistica;
    
    @ManyToOne
    @JoinColumn(name="idJugador", foreignKey = @ForeignKey(name = "FK_estadisticas_jugadores"))
    private Jugador jugador;
    
    @ManyToOne
    @JoinColumn(name="idPartido", foreignKey = @ForeignKey(name = "FK_estadisticas_partido"))
    private Partido partido;
    
    @Column(name = "temporada", length = 10, nullable = false)
    private String temporada;
    
    @Column(name = "puntosPartido", nullable = false)
    private Short puntosPartido;
    
    @Column(name = "asistenciasPartido", nullable = false)
    private Short asistenciasPartido;
    
    @Column(name = "taponesPartido", nullable = false)
    private Short taponesPartido;
    
    @Column(name = "rebotesPartido", nullable = false)
    private Short rebotesPartido;
    
    @Transient
    private Short mediaEstadisticasPartido;  

    public Short getIdEstadistica() {
        return idEstadistica;
    }

    public void setIdEstadistica(Short idEstadistica) {
        this.idEstadistica = idEstadistica;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public Short getPuntosPartido() {
        return puntosPartido;
    }

    public void setPuntosPartido(Short puntosPartido) {
        this.puntosPartido = puntosPartido;
    }

    public Short getAsistenciasPartido() {
        return asistenciasPartido;
    }

    public void setAsistenciasPartido(Short asistenciasPartido) {
        this.asistenciasPartido = asistenciasPartido;
    }

    public Short getTaponesPartido() {
        return taponesPartido;
    }

    public void setTaponesPartido(Short taponesPartido) {
        this.taponesPartido = taponesPartido;
    }

    public Short getRebotesPartido() {
        return rebotesPartido;
    }

    public void setRebotesPartido(Short rebotesPartido) {
        this.rebotesPartido = rebotesPartido;
    }

    public Short getMediaEstadisticasPartido() {
        return mediaEstadisticasPartido;
    }

    public void setMediaEstadisticasPartido(Short mediaEstadisticasPartido) {
        this.mediaEstadisticasPartido = mediaEstadisticasPartido;
    }
    
   

}
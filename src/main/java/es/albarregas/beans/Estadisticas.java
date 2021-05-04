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
    private byte puntosPartido;
    
    @Column(name = "asistenciasPartido", nullable = false)
    private byte asistenciasPartido;
    
    @Column(name = "taponesPartido", nullable = false)
    private byte taponesPartido;
    
    @Column(name = "rebotesPartido", nullable = false)
    private byte rebotesPartido;
    
    @Transient
    private byte mediaEstadisticasPartido;  

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

    public byte getPuntosPartido() {
        return puntosPartido;
    }

    public void setPuntosPartido(byte puntosPartido) {
        this.puntosPartido = puntosPartido;
    }

    public byte getAsistenciasPartido() {
        return asistenciasPartido;
    }

    public void setAsistenciasPartido(byte asistenciasPartido) {
        this.asistenciasPartido = asistenciasPartido;
    }

    public byte getTaponesPartido() {
        return taponesPartido;
    }

    public void setTaponesPartido(byte taponesPartido) {
        this.taponesPartido = taponesPartido;
    }

    public byte getRebotesPartido() {
        return rebotesPartido;
    }

    public void setRebotesPartido(byte rebotesPartido) {
        this.rebotesPartido = rebotesPartido;
    }

    public byte getMediaEstadisticasPartido() {
        return mediaEstadisticasPartido;
    }

    public void setMediaEstadisticasPartido(byte mediaEstadisticasPartido) {
        this.mediaEstadisticasPartido = mediaEstadisticasPartido;
    }
    
   

}
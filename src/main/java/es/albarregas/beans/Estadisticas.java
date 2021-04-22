package es.albarregas.beans;

import java.io.Serializable;


public class Estadisticas implements Serializable {

    private Jugador jugador;
    private Equipo equipo;
    private String temporada;
    private byte puntosPartido;
    private byte asistenciasPartido;
    private byte taponesPartido;
    private byte rebotesPartido;

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
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
    
    
    
    
}


    

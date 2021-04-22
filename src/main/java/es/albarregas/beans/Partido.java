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

@Entity
@Table(name="partidos")
public class Partido implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "IdPartido")
    private Short idPartido;
    
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="equipoLocal", foreignKey = @ForeignKey(name = "FK_partido_equiposL"))
    private Equipo equipoLocal;
    
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="equipoVisitante", foreignKey = @ForeignKey(name = "FK_partido_equiposV"))
    private Equipo equipoVisitante;
    
    @Column(name = "puntosLocal", nullable = false)
    private byte puntosLocal;
    
    @Column(name = "puntosVisitante", nullable = false)
    private byte puntosVisitante;
    
    @Column(name = "temporada", length = 10, nullable = false)
    private String temporada;

    public Short getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Short idPartido) {
        this.idPartido = idPartido;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public byte getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(byte puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public byte getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(byte puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    
    
}


    

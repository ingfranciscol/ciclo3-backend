
package com.fady.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paridos")
public class Partidos implements Serializable {
    @Id
    @Column(name="id", columnDefinition = "bigint(10)" )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    @Column(name="usuario", columnDefinition="int(4)")
    int usuario;
    @Column(name="local", columnDefinition="int(4)")
    int local;
    @Column(name="visitante", columnDefinition="int(4)")
    int visitante;
    @Column(name="fecha", length=25)
    String fecha;
    @Column(name="goles_local", columnDefinition="int(4)")
    int goles_local;
    @Column(name="goles_visitante", columnDefinition="int(4)")
    int goles_visitante;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public int getVisitante() {
        return visitante;
    }

    public void setVisitante(int visitante) {
        this.visitante = visitante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getGoles_local() {
        return goles_local;
    }

    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    public int getGoles_visitante() {
        return goles_visitante;
    }

    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }
    
}

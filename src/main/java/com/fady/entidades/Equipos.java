
package com.fady.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equipos")
public class Equipos implements Serializable {
    @Id
    @Column(name="id", columnDefinition = "bigint(10)" )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    @Column(name="nombre", nullable=false, length=100)
    String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

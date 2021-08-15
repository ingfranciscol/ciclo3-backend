
package com.fady.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable {
    
    @Id
    @Column(name="id", columnDefinition = "bigint(10)" )
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    @Column(name="nombre", nullable=false, length=100)
    String nombre;
    @Column(name="correo", nullable=false, length=50)
    String correo;
    @Column(name="username", nullable=false, length=10, unique=true)
    String username;
    @Column(name="password", nullable=false, length=10)
    String password;

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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}

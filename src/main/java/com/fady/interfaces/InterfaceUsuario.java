
package com.fady.interfaces;

import com.fady.entidades.Usuarios;
import java.io.Serializable;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author F
 */
@Repository("interfaceUsuario")
public interface InterfaceUsuario extends JpaRepository<Usuarios, Serializable>{
    
    public abstract Usuarios findByUsername(String usuario);
    
    //public abstract Usuarios findByUsernameAndPassword(String username,String password);

    public Optional<Usuarios> findByUsernameAndPassword(String username, String password);
    
}
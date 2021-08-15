
package com.fady.interfaces;

import com.fady.entidades.Partidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author F
 */
//@Repository("interfacePartido")
public interface InterfacePartido extends JpaRepository<Partidos, Integer>{
    
}
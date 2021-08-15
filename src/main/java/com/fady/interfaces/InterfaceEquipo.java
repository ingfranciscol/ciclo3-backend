
package com.fady.interfaces;

import com.fady.entidades.Equipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author F
 */
//@Repository("interfaceEquipo")
public interface InterfaceEquipo extends JpaRepository<Equipos, Integer>{
    
}
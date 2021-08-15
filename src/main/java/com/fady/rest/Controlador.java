
package com.fady.rest;

import com.fady.interfaces.InterfaceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class Controlador {
    @Autowired
    private InterfaceUsuario interfaceUsuario;
    
    @GetMapping
    public ResponseEntity<String> frank(int id){
            return ResponseEntity.ok( "Hola Frank");
    }
    
}
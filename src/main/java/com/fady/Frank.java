/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fady;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("frankperez")
public class Frank {
    
    //@GetMapping
    @RequestMapping(value="{frase}")
    public ResponseEntity<String> frank(@PathVariable("frase") String frase){
            return ResponseEntity.ok( "Hola Frank"+frase);
    }
}

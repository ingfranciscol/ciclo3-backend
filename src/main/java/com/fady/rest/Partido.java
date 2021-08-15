
package com.fady.rest;

import com.fady.interfaces.InterfacePartido;
import com.fady.entidades.Partidos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("partido")
public class Partido {
    @Autowired
    private InterfacePartido interfacePartido;
    
    @RequestMapping(value="lista", method=RequestMethod.GET)
    public ResponseEntity<List<Partidos>> listadoPartidos(){
        List<Partidos> partidos = interfacePartido.findAll();
        return ResponseEntity.ok(partidos);
    }
    
    @RequestMapping(value="buscar/{id}", method=RequestMethod.GET)
    public ResponseEntity<Partidos> partidoId(@PathVariable("id") int id){
        Optional<Partidos> optionalPartido = interfacePartido.findById(id);
        if (optionalPartido.isPresent()) {
            return ResponseEntity.ok(optionalPartido.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    
    @PostMapping(value="agregar")
    public ResponseEntity<Partidos> crearPartido(@RequestBody Partidos partido){
        Partidos newPartido = interfacePartido.save(partido);
        return ResponseEntity.ok(newPartido);
    }
    
    @PutMapping(value="actualizar")
    public ResponseEntity<Partidos> partidoUpdate(@RequestBody Partidos partido){
        Optional<Partidos> optionalPartido = interfacePartido.findById(partido.getId());
        if (optionalPartido.isPresent()) {
            Partidos updatePartido = optionalPartido.get();
            updatePartido.setUsuario(partido.getUsuario());
            updatePartido.setLocal(partido.getLocal());
            updatePartido.setVisitante(partido.getVisitante());
            updatePartido.setFecha(partido.getFecha());
            updatePartido.setGoles_local(partido.getGoles_local());
            updatePartido.setGoles_visitante(partido.getGoles_visitante());
            interfacePartido.save(partido);
            return ResponseEntity.ok(optionalPartido.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}

package com.fady.rest;
import com.fady.interfaces.InterfaceEquipo;
import com.fady.entidades.Equipos;
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
@RequestMapping("equipo")
public class Equipo {
    @Autowired
    private InterfaceEquipo interfaceEquipo;
    
    @RequestMapping(value="lista", method=RequestMethod.GET)
    public ResponseEntity<List<Equipos>> listadoEquipos(){
        List<Equipos> equipos = interfaceEquipo.findAll();
        return ResponseEntity.ok(equipos);
    }
    
    @RequestMapping(value="buscar/{id}", method=RequestMethod.GET)
    public ResponseEntity<Equipos> equipoId(@PathVariable("id") int id){
        Optional<Equipos> optionalEquipo = interfaceEquipo.findById(id);
        if (optionalEquipo.isPresent()) {
            return ResponseEntity.ok(optionalEquipo.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    
    @PostMapping(value="agregar")
    public ResponseEntity<Equipos> crearEquipo(@RequestBody Equipos equipo){
        Equipos newEquipo = interfaceEquipo.save(equipo);
        return ResponseEntity.ok(newEquipo);
    }
    
    @PutMapping(value="actualizar")
    public ResponseEntity<Equipos> equipoUpdate(@RequestBody Equipos equipo){
        Optional<Equipos> optionalEquipo = interfaceEquipo.findById(equipo.getId());
        if (optionalEquipo.isPresent()) {
            Equipos updateEquipo = optionalEquipo.get();
            updateEquipo.setNombre(equipo.getNombre());
            interfaceEquipo.save(equipo);
            return ResponseEntity.ok(optionalEquipo.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}

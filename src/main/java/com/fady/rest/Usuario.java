
package com.fady.rest;

import com.fady.interfaces.InterfaceUsuario;
import com.fady.entidades.Usuarios;
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
@RequestMapping("usuario")
public class Usuario {
    @Autowired
    private InterfaceUsuario interfaceUsuario;
    
    @RequestMapping(value="lista", method=RequestMethod.GET)
    public ResponseEntity<List<Usuarios>> listadoUsuarios(){
        List<Usuarios> usuarios = interfaceUsuario.findAll();
        return ResponseEntity.ok(usuarios);
    }
    
    @RequestMapping(value="buscar/{id}", method=RequestMethod.GET)
    public ResponseEntity<Usuarios> usuarioId(@PathVariable("id") int id){
        Optional<Usuarios> optionalUsuario = interfaceUsuario.findById(id);
        if (optionalUsuario.isPresent()) {
            return ResponseEntity.ok(optionalUsuario.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    @RequestMapping(value="buscar/{username}/{password}", method=RequestMethod.GET)
    public ResponseEntity<Usuarios> usuarioUsernameAndPassword(@PathVariable("username") String username,@PathVariable("password") String password){
        Optional<Usuarios> optionalUsuario = interfaceUsuario.findByUsernameAndPassword(username, password);
        if (optionalUsuario.isPresent()) {
            return ResponseEntity.ok(optionalUsuario.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    public Usuarios usuarioUsernameAndPassword2(String username,String password){
        Optional<Usuarios> optionalUsuario = interfaceUsuario.findByUsernameAndPassword(username, password);
        if (optionalUsuario.isPresent()) {
            return optionalUsuario.get();
        }else{
            return null;
        }
    }
    @PostMapping(value="agregar")
    public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuario){
        Usuarios newUsuario = interfaceUsuario.save(usuario);
        return ResponseEntity.ok(newUsuario);
    }
    
    @PutMapping(value="actualizar")
    public ResponseEntity<Usuarios> usuarioUpdate(@RequestBody Usuarios usuario){
        Optional<Usuarios> optionalUsuario = interfaceUsuario.findById(usuario.getId());
        if (optionalUsuario.isPresent()) {
            Usuarios updateUsuario = optionalUsuario.get();
            updateUsuario.setNombre(usuario.getNombre());
            updateUsuario.setCorreo(usuario.getCorreo());
            updateUsuario.setUsername(usuario.getUsername());
            updateUsuario.setPassword(usuario.getPassword());
            interfaceUsuario.save(usuario);
            return ResponseEntity.ok(optionalUsuario.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
}
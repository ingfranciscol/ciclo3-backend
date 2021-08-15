
package com.fady.servicios;

import com.fady.entidades.Usuarios;
import com.fady.interfaces.InterfaceUsuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio implements UserDetailsService{
    @Autowired
    @Qualifier("interfaceUsuario")
    private InterfaceUsuario interfaceUsuario;
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        Usuarios usuario = interfaceUsuario.findByUsername(username);
        return new User(usuario.getUsername(),encoder.encode(usuario.getPassword()) , true, true, true, true, builGrantedAuthoritys());
    }
    
    public List<GrantedAuthority> builGrantedAuthoritys(){
        String[] roles = {"USUARIO","ADMIN"};
        List<GrantedAuthority> autor = new ArrayList<>();
        autor.add(new SimpleGrantedAuthority(roles[0]));
        return autor;
    }
}

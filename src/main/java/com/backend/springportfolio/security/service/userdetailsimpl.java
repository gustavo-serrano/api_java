
package com.backend.springportfolio.security.service;

import com.backend.springportfolio.security.entity.usuario;
import com.backend.springportfolio.security.entity.usuarioprincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class userdetailsimpl implements UserDetailsService{
    @Autowired
    usuarioservice usuarioservice;

    @Override
    public UserDetails loadUserByUsername(String nombreusuario) throws UsernameNotFoundException {
        usuario usuario = usuarioservice.getBynombreusuario(nombreusuario).get();
        return usuarioprincipal.build(usuario);
    }
    
    
}

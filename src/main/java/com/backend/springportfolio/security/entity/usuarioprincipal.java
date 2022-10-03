package com.backend.springportfolio.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class usuarioprincipal implements UserDetails {

    private String nombre;
    private String nombreusuario;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    //constructor

    public usuarioprincipal(String nombre, String nombreusuario, String email, String password, Collection<? extends GrantedAuthority> authorithies) {
        this.nombre = nombre;
        this.nombreusuario = nombreusuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static usuarioprincipal build(usuario usuario) {
        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolnombre().name())).collect(Collectors.toList());
        return new usuarioprincipal(usuario.getNombre(), usuario.getNombreusuario(), usuario.getEmail(), usuario.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getnombre() {
        return nombre;
    }

    public String getemail() {
        return email;
    }

    @Override
    public String getUsername() {
        return nombreusuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

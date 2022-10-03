
package com.backend.springportfolio.security.dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;


public class jwtdto {
    
    private String token;
    private String bearer = "bearer";
    private String nombreusuario;
    private Collection<? extends GrantedAuthority> authorities;
    //constructor

    public jwtdto(String token, String nombreusuario, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.nombreusuario = nombreusuario;
        this.authorities = authorities;
    }
    // getter and setter

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    
}

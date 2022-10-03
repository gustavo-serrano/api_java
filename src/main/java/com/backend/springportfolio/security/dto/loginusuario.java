
package com.backend.springportfolio.security.dto;


public class loginusuario {
    
    private String nombreusuario;
    
    private String password;
    
    // g and s

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}

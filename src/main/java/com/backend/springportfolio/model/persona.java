
package com.backend.springportfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    
    public persona(){
    }
    
    public persona (Long id,String nombre,String apellido){
    this.id = id;
    this.nombre=nombre;        
    this.apellido=apellido;        
    }
    
}
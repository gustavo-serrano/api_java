package com.portfolio.ler.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(min = 1, max = 70, message = "Es demasiado corto o demasiado largo.")
    private String nombre;
    
    @NotBlank
    @Size(min = 1, max = 70, message = "Es demasiado corto o demasiado largo.")
    private String apellido;
    
    @NotNull
    @Size(min = 1, max = 200, message = "Es demasiado corto o demasiado largo.")
    private String img;
 
}


package com.backend.springportfolio.controladora;

import com.backend.springportfolio.model.persona;
import com.backend.springportfolio.service.ipersonaservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class controller {
    
   @Autowired
   private ipersonaservice persoserv;
    
    @PostMapping("/personas/crear")
    public String agregarpersona (@RequestBody persona pers){
persoserv.crearpersona(pers);
return "la persona fue creada correctamente";
    }
    @GetMapping("/personas/traer")
    @ResponseBody
    public List<persona> getpersona (){
    return persoserv.getpersona();
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String borrarpersona (@PathVariable Long id){
    persoserv.borrarpersona(id);
    
    return "la persona fue eliminada correctamente";
    }
    //ej http://localhost:8080/persona/editar/6?nombre=leo&apellido=messi
    @PutMapping("/personas/editar/{id}")
    public persona editpersona (@PathVariable long id,
            @RequestParam("nombre") String nuevonombre,
            @RequestParam("apellido") String nuevoapellido)
    {  persona persona = persoserv.findpersona(id);
            persona.setNombre(nuevonombre);
            persona.setApellido(nuevoapellido);
            persoserv.crearpersona(persona);
            return persona;
    }
    @GetMapping("/personas/traer/perfil")
    public persona findpersona (){
    return persoserv.findpersona ((long)1);
    }
     
}

package com.backend.springportfolio.controladora;

import com.backend.springportfolio.model.persona;
import com.backend.springportfolio.service.ipersonaservice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class controller {
    
   @Autowired
   private ipersonaservice persoserv;
    
    @PostMapping("/new/persona")
    public void  agregarpersona (@RequestBody persona pers){
persoserv.crearpersona(pers);    
    }
    @GetMapping("/ver/personas")
    @ResponseBody
    public List<persona> verpersonas (){
    return persoserv.verpersonas();
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarpersona (@PathVariable Long id){
    persoserv.borrarpersona(id);
    }
    
    
    
}
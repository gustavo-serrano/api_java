package com.portfolio.ler.Controller;

import com.portfolio.ler.Dto.dtoSkills;
import com.portfolio.ler.Entity.Skills;
import com.portfolio.ler.Service.ServSkills;
import com.portfolio.ler.Security.Controller.Mensaje;
import java.util.List;
import java.lang.Integer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "https://front-port.web.app")
public class CSkills {
    @Autowired
    ServSkills servskills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = servskills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!servskills.existsById(id))
            return new ResponseEntity(new Mensaje("Esta skill no existe."), HttpStatus.NOT_FOUND);
        Skills skills = servskills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!servskills.existsById(id)) {
            return new ResponseEntity(new Mensaje("La skill que buscaste no existe."), HttpStatus.NOT_FOUND);
        }
        servskills.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada correctamente."), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){      
        if(StringUtils.isBlank(dtoskills.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        if(servskills.existsByNombre(dtoskills.getNombre()))
            return new ResponseEntity(new Mensaje("Esta skill ya existe."), HttpStatus.BAD_REQUEST);
        
        Skills skills = new Skills(dtoskills.getNombre(), dtoskills.getPorcentaje());
        servskills.save(skills);
        
        return new ResponseEntity(new Mensaje("Skill agregada satisfactoriamente."), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills){
        
        Integer percentage = dtoskills.getPorcentaje();

        if(!servskills.existsById(id))
            return new ResponseEntity(new Mensaje("Este ID no existe."), HttpStatus.BAD_REQUEST);

        if(servskills.existsByNombre(dtoskills.getNombre()) && servskills.getByNombre(dtoskills.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esta skill ya existe."), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(dtoskills.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(percentage.toString()))
            return new ResponseEntity(new Mensaje("El porcentaje es obligatorio."), HttpStatus.BAD_REQUEST);
        
        Skills skills = servskills.getOne(id).get();
        skills.setNombre(dtoskills.getNombre());
        skills.setPorcentaje(dtoskills.getPorcentaje());
        
        servskills.save(skills);
        return new ResponseEntity(new Mensaje("Skill actualizada satisfactoriamente."), HttpStatus.OK);
             
    }
}


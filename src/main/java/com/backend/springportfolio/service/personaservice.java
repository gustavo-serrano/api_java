

package com.backend.springportfolio.service;

import com.backend.springportfolio.model.persona;
import com.backend.springportfolio.repository.personarepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class personaservice implements ipersonaservice {
     @Autowired
     public personarepository persorepo;

    @Override
    public List<persona> verpersonas() {
       return persorepo.findAll();
        
    }

    @Override
    public void crearpersona(persona per) {
        persorepo.save(per);
    }

    @Override
    public void borrarpersona(Long id) {
        persorepo.deleteById(id);
    }

    @Override
    public persona buscarpersona(Long id) {
        return persorepo.findById(id).orElse(null);
    }
    
}

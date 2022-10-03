
package com.backend.springportfolio.security.service;

import com.backend.springportfolio.security.entity.rol;
import com.backend.springportfolio.security.enums.rolnombre;
import com.backend.springportfolio.security.repository.irolrepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class rolservice {
    @Autowired
    irolrepository irolrepository;
    public Optional <rol> getByrolnombre(rolnombre rolnombre){
    return irolrepository.findByrolnombre (rolnombre);
    }
    
    
    public void save (rol rol){
    irolrepository.save(rol);
    }
    
    
}

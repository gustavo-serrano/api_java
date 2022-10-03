
package com.backend.springportfolio.security.service;

import com.backend.springportfolio.security.entity.usuario;
import com.backend.springportfolio.security.repository.iusuariorepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class usuarioservice {
    @Autowired
    iusuariorepository iusuariorepository;
    
    public Optional<usuario> getBynombreusuario(String nombreusuario){
    return iusuariorepository.findByNombreUsuario(nombreusuario);
    }
    public boolean existsBynombreusuario(String nombreusuario){
    return iusuariorepository.existsByNombreUsuario(nombreusuario);
    }
    public boolean existsByemail(String email){
    return iusuariorepository.existsByEmail(email);
    }
    public void save(usuario usuario){
    iusuariorepository.save(usuario);
    }
}

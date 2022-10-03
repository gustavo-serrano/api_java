
package com.backend.springportfolio.security.repository;

import com.backend.springportfolio.security.entity.usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iusuariorepository extends JpaRepository <usuario, Integer> {
    Optional<usuario> findByNombreUsuario(String nombreusuario);  
    
    boolean existsByNombreUsuario(String nombreusuario);
    boolean existsByEmail(String email);
}


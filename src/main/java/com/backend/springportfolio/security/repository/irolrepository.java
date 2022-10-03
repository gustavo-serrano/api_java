
package com.backend.springportfolio.security.repository;

import com.backend.springportfolio.security.entity.rol;
import com.backend.springportfolio.security.enums.rolnombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface irolrepository extends JpaRepository<rol, Integer> {
    
    Optional<rol> findByrolnombre (rolnombre rolnombre);
}


package com.backend.springportfolio.repository;

import com.backend.springportfolio.model.persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface personarepository extends JpaRepository <persona, Long> {
    
    
    
    
    
    
}
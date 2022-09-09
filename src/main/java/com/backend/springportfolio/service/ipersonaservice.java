
package com.backend.springportfolio.service;

import com.backend.springportfolio.model.persona;
import java.util.List;


public interface ipersonaservice {
    
    public List<persona> getpersona();
    public void crearpersona (persona pers);
    public void borrarpersona (Long id);
    public persona findpersona (Long id);
    
     
    
}

package com.backend.springportfolio.service;

import com.backend.springportfolio.model.persona;
import java.util.List;


public interface ipersonaservice {
    
    public List<persona>  verpersonas();
    public void crearpersona (persona per);
    public void borrarpersona (Long id);
    public persona buscarpersona (Long id);
    
     
    
}
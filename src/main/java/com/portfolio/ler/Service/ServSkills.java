package com.portfolio.ler.Service;

import com.portfolio.ler.Entity.Skills;
import com.portfolio.ler.Repository.RSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class ServSkills {
    @Autowired
    RSkills rskills;
    
    public List<Skills> list(){
        return rskills.findAll();
    }
    
    public Optional<Skills> getOne(int id){
        return rskills.findById(id);
    }
    
    public Optional<Skills> getByNombre(String nombre){
        return rskills.findByNombre(nombre);
    }
    
    public void save(Skills skills){
        rskills.save(skills);
    }
    
    public void delete(int id){
        rskills.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rskills.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rskills.existsByNombre(nombre);
    }
    
}

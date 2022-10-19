package com.portfolio.ler.Service;

import com.portfolio.ler.Entity.Banner;
import com.portfolio.ler.Repository.RBanner;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SBanner {
    @Autowired
    RBanner rBanner;
    
    public List<Banner> list(){
        return rBanner.findAll();
    }
    
    public Optional<Banner> getOne(int id){
        return rBanner.findById(id);
    }
    
    public Optional<Banner> getByUrlimg(String urlimg){
        return rBanner.findByUrlimg(urlimg);
    }
    
    public void save(Banner banner){
        rBanner.save(banner);
    }
    
    public void delete(int id){
        rBanner.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rBanner.existsById(id);
    }
    
    public boolean existsByUrlimg(String urlimg){
        return rBanner.existsByUrlimg(urlimg);
    }
    
}

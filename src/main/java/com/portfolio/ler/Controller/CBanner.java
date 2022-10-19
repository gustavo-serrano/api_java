package com.portfolio.ler.Controller;

import com.portfolio.ler.Dto.dtoBanner;
import com.portfolio.ler.Entity.Banner;
import com.portfolio.ler.Security.Controller.Mensaje;
import com.portfolio.ler.Service.SBanner;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banner")
@CrossOrigin(origins = "http://localhost:4200")
public class CBanner {
    @Autowired
    SBanner sBanner;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Banner>> list(){
        List<Banner> list = sBanner.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Banner> getById(@PathVariable("id")int id){
        if(!sBanner.existsById(id)){
            return new ResponseEntity(new Mensaje("Este ID no existe."), HttpStatus.BAD_REQUEST);
        }
        
        Banner banner = sBanner.getOne(id).get();
        return new ResponseEntity(banner, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoBanner dtobanner){
        if(!sBanner.existsById(id)){
            return new ResponseEntity(new Mensaje("Este ID no existe."), HttpStatus.NOT_FOUND);
        }
        if(sBanner.existsByUrlimg(dtobanner.getUrlimg()) && sBanner.getByUrlimg(dtobanner.getUrlimg()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Este nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtobanner.getUrlimg())){
            return new ResponseEntity(new Mensaje("Este campo no puede estar vacío."), HttpStatus.BAD_REQUEST);
        }
        
        Banner banner = sBanner.getOne(id).get();
        
        banner.setUrlimg(dtobanner.getUrlimg());
        
        sBanner.save(banner);
        
        return new ResponseEntity(new Mensaje("Banner actualizado correctamente."), HttpStatus.OK);
    }
    
}

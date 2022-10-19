package com.portfolio.ler.Repository;

import com.portfolio.ler.Entity.Banner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RBanner extends JpaRepository<Banner, Integer>{
    public Optional<Banner> findByUrlimg(String urlimg);
    public boolean existsByUrlimg(String urlimg);
}
package com.portfolio.ler.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoBanner {
    @NotBlank
    private String urlimg;

    public dtoBanner() {
    }

    public dtoBanner(String urlimg) {
        this.urlimg = urlimg;
    }  
}

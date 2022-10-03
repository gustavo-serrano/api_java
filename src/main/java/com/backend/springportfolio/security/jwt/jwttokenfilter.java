package com.backend.springportfolio.security.jwt;

import com.backend.springportfolio.security.service.userdetailsimpl;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

public class jwttokenfilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(jwtprovider.class);

    @Autowired
    jwtprovider jwtprovider;
    @Autowired
    userdetailsimpl userdetailsserviceimpl;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getToken(request);
            if (token != null && jwtprovider.validateToken(token)) {
                String nombreUsuario = jwtprovider.getNombreUsuarioFromToken(token);
                UserDetails userdetails = userdetailsserviceimpl.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userdetails,
                        null, userdetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);

            }
        }catch (Exception e){
                logger.error("fallo el metodo dofilterinternal");
                }
        filterChain.doFilter(request,response);
    }
    private String getToken(HttpServletRequest request){
    String header = request.getHeader("Authorization");
    if (header != null && header.startsWith("bearer"))
        return header.replace("bearer","");
    return null;
    }
    
}



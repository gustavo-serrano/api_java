package com.backend.springportfolio.security.controller;

import com.backend.springportfolio.security.dto.jwtdto;
import com.backend.springportfolio.security.dto.loginusuario;
import com.backend.springportfolio.security.dto.nuevousuario;
import com.backend.springportfolio.security.entity.rol;
import com.backend.springportfolio.security.entity.usuario;
import com.backend.springportfolio.security.enums.rolnombre;
import com.backend.springportfolio.security.jwt.jwtprovider;
import com.backend.springportfolio.security.service.rolservice;
import com.backend.springportfolio.security.service.usuarioservice;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class authcontroller {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager AuthenticationManager;
    @Autowired
    usuarioservice usuarioservice;
    @Autowired
    rolservice rolService;
    @Autowired
    jwtprovider jwtprovider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody nuevousuario NuevoUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new mensaje("campos mal puestos o mail invalido"), HttpStatus.BAD_REQUEST);
        }

        if (usuarioservice.existsBynombreusuario(NuevoUsuario.getNombreusuario())) {
            return new ResponseEntity(new mensaje("este nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (usuarioservice.existsByemail(NuevoUsuario.getEmail())) {
            return new ResponseEntity(new mensaje("este email ya existe"), HttpStatus.BAD_REQUEST);
        }

        usuario usuario = new usuario(NuevoUsuario.getNombre(), NuevoUsuario.getNombreusuario(),
                NuevoUsuario.getEmail(), passwordEncoder.encode(NuevoUsuario.getPassword()));
        Set<rol> roles = new HashSet<>();
        roles.add(rolService.getByrolnombre(rolnombre.ROLE_USER).get());

        if (NuevoUsuario.getRoles().contains("admin")) {
            roles.add(rolService.getByrolnombre(rolnombre.ROLE_ADMIN).get());
        }

        usuario.setRoles(roles);
        usuarioservice.save(usuario);
        return new ResponseEntity(new mensaje("usuario guardado"), HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<jwtdto> login(@RequestBody loginusuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = AuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUsuario.getNombreusuario(), loginUsuario.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtprovider.generatetoken(authentication);
        UserDetails userdetails = (UserDetails) authentication.getPrincipal();

        jwtdto jwtdto = new jwtdto(jwt, userdetails.getUsername(), userdetails.getAuthorities());

        return new ResponseEntity(jwtdto, HttpStatus.OK);

    }

}

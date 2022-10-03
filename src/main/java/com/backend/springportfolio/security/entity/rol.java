/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.springportfolio.security.entity;

import com.backend.springportfolio.security.enums.rolnombre;
import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class rol {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    
    private rolnombre rolnombre;
    
    //constructor

    public rol() {
    }

    public rol(rolnombre rolnombre) {
        this.rolnombre = rolnombre;
    }
    //getter y setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public rolnombre getRolnombre() {
        return rolnombre;
    }

    public void setRolnombre(rolnombre rolnombre) {
        this.rolnombre = rolnombre;
    }
    
}

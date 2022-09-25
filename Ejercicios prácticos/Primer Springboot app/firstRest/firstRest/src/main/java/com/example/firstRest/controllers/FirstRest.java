/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.firstRest.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Martin
 */
@RestController
public class FirstRest {
    private List<String> mensajes = new ArrayList<>();
    
    /**
     * Permite obtener una lista de mensajes como String
     * @return Lista de mensajes 
     */
    @GetMapping("mensajes")
    public String obtenerMensajes(){
        mensajes.add("Primer app Springboot");
        mensajes.add("Test app Springboot");
        return mensajes.toString();
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.similtp.controllers;

import com.example.similtp.dtos.ReciboDTO;
import com.example.similtp.models.Empleado;
import com.example.similtp.models.Recibo;
import com.example.similtp.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmpleadoController {
    @Autowired
    private EmpleadoRepository repository;
    
    @PostMapping("/recibos/nuevo")
    public ResponseEntity<?> registrarRecibo(@RequestBody ReciboDTO reciboDto){
        Empleado aux = new Empleado();
        aux.setLegajo(reciboDto.getLegajo());
        Recibo recibo = new Recibo(0, 
                reciboDto.getMes(),
                reciboDto.getAnio(),
                reciboDto.getAntiguedad(),
                reciboDto.getJubilacion(),
                reciboDto.getObraSocial(),
                reciboDto.getFondoComplejidad(), 
                aux);
        repository.createRecibo(recibo);
        return ResponseEntity.ok("Recibo registrado");
        
    }
}

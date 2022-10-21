/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.productosCrud.controllers;

import com.example.productosCrud.data.ProductoDao;
import com.example.productosCrud.data.exceptions.DaoException;
import com.example.productosCrud.domains.Producto;
import java.util.List;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Setter
public class ProductoController {
    
    @Autowired
    private ProductoDao dao;
    
    
    @GetMapping("/productos")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.ok(dao.getAll());
        } catch (DaoException  e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }   
}

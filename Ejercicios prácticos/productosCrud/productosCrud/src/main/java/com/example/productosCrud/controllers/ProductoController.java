/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.productosCrud.controllers;

import com.example.productosCrud.data.ProductoDao;
import com.example.productosCrud.data.exceptions.DaoException;
import com.example.productosCrud.domains.Producto;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Setter
public class ProductoController {

    @Autowired
    private ProductoDao dao;

    @GetMapping("/productos")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(dao.getAll());
        } catch (DaoException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

     @GetMapping("/producto/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        if (id == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id producto no puede ser 0");
        }
        try {
            return ResponseEntity.ok(dao.getbyId(id));
        } catch (DaoException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error de datos!");
        }
    }
    
    
    @PostMapping("/producto/{id}")
    public ResponseEntity<?> create(@PathVariable int id) {
        if (id == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos de producto incorrectos!");
        }
        try {
            return ResponseEntity.ok(dao.getbyId(id));
        } catch (DaoException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error de datos!");
        }
    }

    @PutMapping("/producto")
    public ResponseEntity<?> update(@RequestBody Producto producto) {
        if (producto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos de producto incorrectos!");
        }
        try {
            return ResponseEntity.ok(dao.save(producto));
        } catch (DaoException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error de datos!");
        }
    }

    @DeleteMapping("/producto/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (id == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id producto no puede ser 0");
        }
        try {
            return ResponseEntity.ok(dao.delete(id));
        } catch (DaoException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error de datos!");
        }
    }
}
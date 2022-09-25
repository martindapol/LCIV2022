/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.clase02.controllers;

import com.example.clase02.models.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Clase2Controller {
    private List numeros;

    public Clase2Controller() {
        numeros = new ArrayList();
        numeros.add(new Random().nextInt());
        numeros.add(new Random().nextInt());
        numeros.add(new Random().nextInt());
    }
    
    
    
    @GetMapping("/hola")
    public String saludar(){
        return "Hola, es la clase DOS";
    }
    
    @GetMapping("/num")
    public String obtenerNum(){
        int nro = new Random().nextInt();
        return String.valueOf(nro) ;
    }
    
    @PutMapping("/numeros/{x}")
    public void agregarNro(@PathVariable int x){
        numeros.add(x);
    }    
    
    @GetMapping("/numeros/{x}")
    public boolean buscarNro(@PathVariable int x){
        return numeros.contains(x);
    }    
    
    
    @GetMapping("/numeros")
    public List obtenerTodos(){    
        return numeros;
    }
    
    @DeleteMapping("/numeros/{x}")
    public boolean borrarNro(@PathVariable int x){
        return numeros.remove((Object)x);
    }    

    
    @GetMapping("/cliente")
    public Cliente obtenerCliente(){
        return new Cliente(1, "TEST", 1000, 1);
    }
    
    @PostMapping("/clienteAll")
    public List  obtenerTodosClientes(){
        List<Cliente> lst = new ArrayList();
        lst.add(new Cliente(1, "TEST", 1000, 1));
        lst.add(new Cliente(2, "TEST2", 9999,  2));
        
        return lst;
    }
}

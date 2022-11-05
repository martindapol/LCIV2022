package com.example.demo;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutoresController {

    @Autowired
    private RepositorioAutores gestor;

    //@JsonView(Vistas.Autores.class)
    @GetMapping("/")
    public Iterable<Autor> consultarAutores() {

        return gestor.findAll();
    }

    @GetMapping("/buscar")
    public Iterable<Autor> consultarAutores(@RequestParam String filtro) {
        return gestor.getAutorByNombreContains(filtro);
    }



    //@JsonView(Vistas.AutoresLibros.class)
    @GetMapping("/{id}")
    public Autor consultarUno(@PathVariable int id) {
        return gestor.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Autor no encontrado"));
    }

    @PutMapping("/{id}")
    public void agregar(@RequestBody Autor nuevo)
    {
        // Validación
        if (nuevo.getNombre().length() < 4)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Falta el nombre");
        gestor.save(nuevo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        if (gestor.existsById(id))
            gestor.deleteById(id);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}

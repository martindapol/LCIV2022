package tup.lc4.abmpersonas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tup.lc4.abmpersonas.models.Persona;
import tup.lc4.abmpersonas.repositories.RepositorioPersonas;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tup.lc4.abmpersonas.exceptions.BackendException;


@RestController
public class ControladorPersonas {
    
    @Autowired
    private RepositorioPersonas repo;
    
    @GetMapping("/persona")
    public ResponseEntity<List<Persona>> obtenerTodas() {
        try {
            return ResponseEntity.ok(repo.obtenerTodas());
        } catch (BackendException ex) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    
    @GetMapping("/persona/{doc}")
    public ResponseEntity<Persona> obtenerUna(@PathVariable int doc) {
        try {
            Persona encontrada = repo.obtenerUna(doc);
            if (encontrada != null) {
                return ResponseEntity.ok(encontrada);
            }
            return ResponseEntity.notFound().build();            
        } catch (BackendException e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
    
    @PutMapping("/persona/{doc}")
    public ResponseEntity guardar(@PathVariable int doc, @RequestBody Persona p) {
        p.setDocumento(doc);
        try {
            repo.guardar(p);
            return ResponseEntity.ok(null);
        } catch (BackendException e) {
            return ResponseEntity.internalServerError().body(null);
        }
        
    }
    
    
}

package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Autores")
public class Autor {

    //@JsonView(Vistas.Autores.class)
    @Id
    private int id;

    //@JsonView(Vistas.Autores.class)
    @Column
    private String nombre;

    //@JsonView(Vistas.AutoresLibros.class)
    
    @OneToMany(targetEntity = Libro.class, mappedBy = "autor") // mappedBy es el nombre del atributo, NO de la columna!
    @JsonManagedReference
    private List<Libro> libros;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public Autor() {
    }

    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

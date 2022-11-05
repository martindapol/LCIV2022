package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


// https://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation

public interface RepositorioAutores extends JpaRepository<Autor, Integer> {

    Iterable<Autor> getAutorByNombreContains(String filtro);

}

package tup.lc4.abmpersonas.repositories;


import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tup.lc4.abmpersonas.exceptions.BackendException;
import tup.lc4.abmpersonas.models.Persona;


@Repository
public class RepositorioPersonasJPA {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Persona> obtenerTodas() throws BackendException {
        try {
            return em.createQuery("select p from Persona p", Persona.class).getResultList();
        } catch (Exception ex) {
            throw new BackendException();
        }
    }

    public List<Persona> obtenerPorApellido(String ape) throws BackendException {
        try {
            return em.createQuery("select p from Persona p where p.apellido = '" + ape + "'", Persona.class).getResultList();
        } catch (Exception ex) {
            throw new BackendException();
        }
    }
    
    public Persona obtenerUna(int documento) throws BackendException  {
        try {
            return em.find(Persona.class, documento);
        } catch (Exception ex) {
            throw new BackendException();
        }
    }
    
    public void eliminar(int documento) throws BackendException  {
        try {
            Persona encontrada = em.find(Persona.class, documento);
            if (encontrada != null)
                em.remove(encontrada);
        } catch (Exception ex) {
            throw new BackendException();
        }
    }

    
    public void guardar(Persona p) throws BackendException {
        try {
            em.persist(p);
        } catch (Exception ex) {
            throw new BackendException();
        }
          
    }
}

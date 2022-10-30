package tup.lc4.abmpersonas.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import tup.lc4.abmpersonas.models.Persona;


public interface RepositorioPersonasJpaData extends JpaRepository<Persona, Integer> {

    List<Persona> findPersonaByApellido (String apellido);
    
    List<Persona> findPersonaByNombreOrderByEdad (String nombre);
}

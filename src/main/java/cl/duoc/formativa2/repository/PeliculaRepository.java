package cl.duoc.formativa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// Se importó el modelo Pelicula para poder usarlo en el repositorio
import cl.duoc.formativa2.model.Pelicula;


// Se extiende de JpaRepository para poder usar los métodos de JPA y poder hacer consultas a la base de datos
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    
}

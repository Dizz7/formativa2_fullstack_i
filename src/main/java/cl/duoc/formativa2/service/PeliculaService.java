package cl.duoc.formativa2.service;

import org.springframework.stereotype.Service;
import cl.duoc.formativa2.model.Pelicula;
import java.util.List;
import java.util.Optional;


// Lógica del negocio relacionada con las películas, como obtener la lista de películas, buscar por ID, etc.

@Service
public interface PeliculaService {
    // Métodos para acceder a las películas
        List<Pelicula> getAllPeliculas();

    // Método para obtener una película por su ID
        Optional<Pelicula> getPeliculaById(Long id);

    // Métodos para Crear, Actualizar y Eliminar películas
        Pelicula createPelicula(Pelicula pelicula);
        Pelicula updatePelicula(Long id, Pelicula pelicula);
        void deletePelicula(Long id);

}



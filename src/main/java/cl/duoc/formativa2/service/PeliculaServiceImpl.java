package cl.duoc.formativa2.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import cl.duoc.formativa2.model.Pelicula;
import cl.duoc.formativa2.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    
        private final PeliculaRepository peliculaRepository;

        PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
                this.peliculaRepository = peliculaRepository;
        }

        @Override
        public List<Pelicula> getAllPeliculas() {
            return peliculaRepository.findAll();
        }
   
        @Override
        public Optional<Pelicula> getPeliculaById(Long id) {
            return peliculaRepository.findById(id);
        }
   

        // Lógica del CRUD para crear, actualizar y eliminar películas
        @Override
        public Pelicula createPelicula(Pelicula pelicula) {
            return peliculaRepository.save(pelicula);
        }

        @Override
        public Pelicula updatePelicula(Long id, Pelicula pelicula) {
            Optional<Pelicula> existingPelicula = peliculaRepository.findById(id);
            if (existingPelicula.isPresent()) {
                Pelicula updatedPelicula = existingPelicula.get();
                updatedPelicula.setTitulo(pelicula.getTitulo());
                updatedPelicula.setAño(pelicula.getAño());
                updatedPelicula.setDirector(pelicula.getDirector());
                updatedPelicula.setGenero(pelicula.getGenero());
                updatedPelicula.setSinopsis(pelicula.getSinopsis());
                
                return peliculaRepository.save(updatedPelicula);
            } else {
                throw new RuntimeException("ID de Pelicula no encontrado: " + id);
            }


        }

        @Override
        public void deletePelicula(Long id) {
             peliculaRepository.deleteById(id);
            }
}








package cl.duoc.formativa2.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import cl.duoc.formativa2.model.Pelicula;
import cl.duoc.formativa2.repository.PeliculaRepository;

@Service
public class PeliculaServieImpl implements PeliculaService {
    
        private final PeliculaRepository peliculaRepository;

        PeliculaServieImpl(PeliculaRepository peliculaRepository) {
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
   


}





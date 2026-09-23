package cl.duoc.formativa2.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.duoc.formativa2.model.Pelicula;
import cl.duoc.formativa2.repository.PeliculaRepository;


@ExtendWith (MockitoExtension.class)

class PeliculaServiceImplTest {
    @Mock 
    private PeliculaRepository peliculaRepository;

    @InjectMocks 
    private PeliculaServiceImpl service;

    private Pelicula pelicula1;
    private Pelicula pelicula2;
    

    @BeforeEach 
    void setUp() {
        pelicula1 = new Pelicula();
        pelicula1.setId(1L);
        pelicula1.setTitulo("Pelicula 1");
        pelicula1.setAño(2020);
        pelicula1.setDirector("Director 1");
        pelicula1.setGenero("Accion");
        pelicula1.setSinopsis("Sinopsis 1");

        pelicula2 = new Pelicula();
        pelicula2.setId(2L);
        pelicula2.setTitulo("Pelicula 2");
        pelicula2.setAño(2021);
        pelicula2.setDirector("Director 2");
        pelicula2.setGenero("Comedia");
        pelicula2.setSinopsis("Sinopsis 2");
    }

    @Test 
    void testGetAllPeliculas() {
        when(peliculaRepository.findAll()).thenReturn(Arrays.asList(pelicula1, pelicula2));

        List<Pelicula> peliculas = service.getAllPeliculas();

        assertEquals(2, peliculas.size());
        verify(peliculaRepository, times(1)).findAll();
    }

    @Test 
    void testGetPeliculaById() {
        when(peliculaRepository.findById(1L)).thenReturn(Optional.of(pelicula1));

        Optional<Pelicula> pelicula = service.getPeliculaById(1L);

        assertTrue(pelicula.isPresent());
        assertEquals("Pelicula 1", pelicula.get().getTitulo());
        verify(peliculaRepository, times(1)).findById(1L);
    }

    @Test 
    void testCreatePelicula() {
        when(peliculaRepository.save(pelicula1)).thenReturn(pelicula1);

        Pelicula createdPelicula = service.createPelicula(pelicula1);

        assertEquals("Pelicula 1", createdPelicula.getTitulo());
        verify(peliculaRepository, times(1)).save(pelicula1);
    }

    @Test 
    void testUpdatePeliculaExists() {
        when(peliculaRepository.findById(1L)).thenReturn(Optional.of(pelicula1));   
        when(peliculaRepository.save(any(Pelicula.class))).thenReturn(pelicula1);

        Pelicula updatedPelicula = new Pelicula();
        updatedPelicula.setTitulo("Pelicula Actualizada");
        updatedPelicula.setAño(2022);
        updatedPelicula.setDirector("Director Actualizado");
        updatedPelicula.setGenero("Drama");
        updatedPelicula.setSinopsis("Sinopsis Actualizada");

        Pelicula result = service.updatePelicula(1L, updatedPelicula);

        assertEquals("Pelicula Actualizada", result.getTitulo());
        assertEquals(2022, result.getAño());
        assertEquals("Director Actualizado", result.getDirector());
        assertEquals("Drama", result.getGenero());
        assertEquals("Sinopsis Actualizada", result.getSinopsis());
        verify(peliculaRepository, times(1)).findById(1L);
        verify(peliculaRepository, times(1)).save(any(Pelicula.class));
    }

    
    @Test
    void testUpdatePeliculaNotExists() {
        Long id = 1L;
        Pelicula pelicula = new Pelicula();

        when(peliculaRepository.findById(id))
            .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> service.updatePelicula(id, pelicula)
        );

        assertEquals("ID de Pelicula no encontrado: 1", exception.getMessage());

        verify(peliculaRepository).findById(id);
        verify(peliculaRepository, never()).save(any(Pelicula.class));
    }


    @Test 
    void testDeletePelicula() {
        doNothing().when(peliculaRepository).deleteById(1L);

        service.deletePelicula(1L);

        verify(peliculaRepository, times(1)).deleteById(1L);
    }


    @AfterEach
    void tearDown() {
        pelicula1 = null;
        pelicula2 = null;
    }


}

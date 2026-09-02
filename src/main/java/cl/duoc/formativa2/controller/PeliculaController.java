package cl.duoc.formativa2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.formativa2.model.Pelicula;
import cl.duoc.formativa2.service.PeliculaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/peliculas")
public class PeliculaController {



    @Autowired
    // Inyección de dependencias del servicio de películas
    private PeliculaService peliculaService;
 
    // Constructor para la inyección de dependencias
    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }
    // Endpoint GET para obtener todas las películas
    @GetMapping({"", "/"})
    public List<Pelicula> getPeliculas() {
        return peliculaService.getAllPeliculas();
    }

    // Endpoint GET para buscar una película por su ID
    @GetMapping("/{id}")
    public Optional<Pelicula> getPeliculaById(@PathVariable Long id) {
        return peliculaService.getPeliculaById(id);
    }
}
    

    

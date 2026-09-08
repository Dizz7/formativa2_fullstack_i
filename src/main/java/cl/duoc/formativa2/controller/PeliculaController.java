package cl.duoc.formativa2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.formativa2.model.Pelicula;
import cl.duoc.formativa2.service.PeliculaService;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



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

    // Controlador para crear, actualizar y eliminar películas
    @PostMapping
    public Pelicula createPelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.createPelicula(pelicula);
    }
    
    @PutMapping("/{id}")
    public Pelicula updatePelicula(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        return peliculaService.updatePelicula(id, pelicula);
    }

    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable Long id) {
        peliculaService.deletePelicula(id);
    }

}
    

    

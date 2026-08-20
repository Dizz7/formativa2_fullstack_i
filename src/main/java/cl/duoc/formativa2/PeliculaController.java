package cl.duoc.formativa2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PeliculaController {
    
    private List<Pelicula> peliculas = new ArrayList<>();

    public PeliculaController() {
        
        peliculas.add(new Pelicula(1, "Crepúsculo", 2008, "Catherine Hardwicke", "Romance / Fantasía", "Bella se muda a un pueblo y se enamora de un vampiro."));
        peliculas.add(new Pelicula(2, "Hotel Budapest", 2014, "Wes Anderson", "Comedia / Drama", "Aventuras de un conserje de hotel en la Europa de entreguerras."));
        peliculas.add(new Pelicula(3, "Terminator", 1984, "James Cameron", "Ciencia Ficción / Acción", "Un ciborg llega del futuro para matar a la madre del líder rebelde."));
        peliculas.add(new Pelicula(4, "Inception", 2010, "Christopher Nolan", "Ciencia Ficción / Acción", "Un experto en robar secretos mediante sueños recibe una misión inversa."));
        peliculas.add(new Pelicula(5, "Misión Imposible", 1996, "Brian De Palma", "Suspenso / Espionaje", "Un agente es culpado de la muerte de su equipo y busca al verdadero traidor."));
        peliculas.add(new Pelicula(6, "Los Juegos del Hambre", 2012, "Gary Ross", "Ciencia Ficción / Acción", "En un futuro post-apocalíptico, jóvenes son forzados a participar en un combate mortal televisado."));
        peliculas.add(new Pelicula(7, "El Exorcista", 1973, "William Friedkin", "Terror", "Una niña es poseída por una entidad demoníaca y dos sacerdotes intentan salvarla."));
        peliculas.add(new Pelicula(8, "Constantine", 2005, "Francis Lawrence", "Fantasía / Acción", "Un detective especializado en lo sobrenatural investiga fuerzas demoníacas y angelicales."));
        peliculas.add(new Pelicula(9, "La Gran Estafa", 2001, "Steven Soderbergh", "Crimen / Suspenso", "Danny Ocean planea el robo más ambicioso de la historia a tres casinos de Las Vegas."));
        peliculas.add(new Pelicula(10, "Hombres de Negro", 1997, "Barry Sonnenfeld", "Ciencia Ficción / Comedia", "Una organización secreta vigila la actividad extraterrestre en la Tierra."));
    }
    

    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula getPeliculaById(@PathVariable int id) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId() == id) {
                return pelicula;
            }
        }
        return null;
    }
}
    

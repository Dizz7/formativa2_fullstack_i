package cl.duoc.formativa2.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PeliculaModelTest {
    @Test
    void testGettersAndSetters() {
        Pelicula pelicula = new Pelicula();
        pelicula.setId(1L);
        pelicula.setTitulo("Inception");
        pelicula.setAño(2010);
        pelicula.setDirector("Christopher Nolan");
        pelicula.setGenero("Sci-Fi");
        pelicula.setSinopsis("A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.");

        assertEquals(1L, pelicula.getId());
        assertEquals("Inception", pelicula.getTitulo());
        assertEquals(2010, pelicula.getAño());
        assertEquals("Christopher Nolan", pelicula.getDirector());
        assertEquals("Sci-Fi", pelicula.getGenero());
        assertEquals("A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.", pelicula.getSinopsis());
    }
    

}

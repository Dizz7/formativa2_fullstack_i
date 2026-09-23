package cl.duoc.formativa2.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.test.web.servlet.ResultHandler;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import tools.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import cl.duoc.formativa2.model.Pelicula;
import cl.duoc.formativa2.service.PeliculaService;



@WebMvcTest(PeliculaController.class)
class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private PeliculaService service;

    private Pelicula pelicula1;

    @BeforeEach 
    void setUp() {
        pelicula1 = new Pelicula();
        pelicula1.setId(1L);
        pelicula1.setTitulo("Inception");
        pelicula1.setAño(2010);
        pelicula1.setDirector("Christopher Nolan");
        pelicula1.setGenero("Sci-Fi");
        pelicula1.setSinopsis("A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.");   
    }

    @Test 
    void testGetAllPeliculas() throws Exception {
        when(service.getAllPeliculas()).thenReturn(Arrays.asList(pelicula1));

        mockMvc.perform(get("/peliculas"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(pelicula1))));
    }

    @Test
    void testGetPeliculaById() throws Exception {
        when(service.getPeliculaById(1L)).thenReturn(Optional.of(pelicula1));
        mockMvc.perform(get("/peliculas/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(pelicula1)));
    }

  @Test
    void testCreatePelicula() throws Exception {
        when(service.createPelicula(any(Pelicula.class)))
                .thenReturn(pelicula1);

        mockMvc.perform(post("/peliculas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pelicula1)))
                .andDo(print())
                .andDo(mostrarCausaDelError())
                .andExpect(status().isCreated())
                .andExpect(content().json(
                        objectMapper.writeValueAsString(pelicula1)));

        verify(service).createPelicula(any(Pelicula.class));
    }

    @Test
    void testUpdatePelicula() throws Exception {
        when(service.updatePelicula(eq(1L), any(Pelicula.class)))
                .thenReturn(pelicula1);

        mockMvc.perform(put("/peliculas/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pelicula1)))
                .andDo(print())
                .andDo(mostrarCausaDelError())
                .andExpect(status().isOk())
                .andExpect(content().json(
                        objectMapper.writeValueAsString(pelicula1)));

        verify(service).updatePelicula(eq(1L), any(Pelicula.class));
    }

    @Test 
    void testDeletePelicula() throws Exception {
        doNothing().when(service).deletePelicula(1L);

        mockMvc.perform(delete("/peliculas/1"))
                .andExpect(status().isOk());
                verify(service).deletePelicula(1L);
    }


    private ResultHandler mostrarCausaDelError() {
            return result -> {
                Exception exception = result.getResolvedException();

                if (exception != null) {
                    throw new AssertionError(
                            "La petición falló: " + exception.getMessage(),
                            exception
                    );
                }
            };
        }

}


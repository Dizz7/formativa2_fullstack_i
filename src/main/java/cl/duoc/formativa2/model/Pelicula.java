package cl.duoc.formativa2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

import jakarta.persistence.Id;



@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id

    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;
    @Column(name = "anio")
    private int anio;
    @Column(name = "director")
    private String director;
    @Column(name = "genero")
    private String genero;
    @Column(name = "sinopsis")
    private String sinopsis;


  public Pelicula () {
    }


    public Pelicula (Long id, String titulo, int anio, String director, String genero, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }
 
    //Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getAño() { return anio; }
    public void setAño(int anio) { this.anio = anio; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
}

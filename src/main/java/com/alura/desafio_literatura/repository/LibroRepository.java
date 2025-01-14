package com.alura.desafio_literatura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.alura.desafio_literatura.model.entity.Libro;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {


    @Query(value = "SELECT * FROM libros JOIN libro_idiomas " +
            "ON libros.id = libro_idiomas.libro_id WHERE libro_idiomas.idioma = :idiomaBuscado;",
            nativeQuery = true)
    List<Libro> librosPorIdioma(String language);
}


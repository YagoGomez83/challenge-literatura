package com.alura.desafio_literatura.repository;

import com.alura.desafio_literatura.model.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {


    @Query(value = "SELECT * FROM autores WHERE fecha_fallecimiento_autor > :anoBuscado", nativeQuery = true)
    List<Autor> autoresPorAno(String yearSearch);
}

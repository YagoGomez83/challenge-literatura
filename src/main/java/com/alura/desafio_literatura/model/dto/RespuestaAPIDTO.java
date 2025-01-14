package com.alura.desafio_literatura.model.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public record RespuestaAPIDTO(

        @SerializedName("count")
        String totalLibrosEncontrados,

        @SerializedName("results")
        List<LibroDTO> resultadosEncontrados
) {
    @Override
    public String toString() {
        return "\nRespuesta de la API de Gutendex: " +
                "\nTotal de libros encontrados: " + totalLibrosEncontrados +
                "\nTitulos que coinciden con tu busqueda: " + resultadosEncontrados;
    }
}

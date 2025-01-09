package com.proyecto.desafio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Implementación de la interfaz IConvierteDatos
public class ConvierteDatos implements IConvierteDatos {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            // Convierte el JSON recibido en un objeto del tipo especificado
            return mapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            // Lanza una excepción con información útil para depurar
            throw new RuntimeException("Error al procesar JSON: " + e.getMessage(), e);
        }
    }
}

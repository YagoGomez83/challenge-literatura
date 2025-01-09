package com.proyecto.desafio.service;

public interface IConvierteDatos {
    // Método genérico para convertir un JSON en una clase específica
    <T> T obtenerDatos(String json, Class<T> clase);
}

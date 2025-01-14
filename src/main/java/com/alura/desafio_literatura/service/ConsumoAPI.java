package com.alura.desafio_literatura.service;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConsumoAPI {

    private final HttpClient client;
    private final ObjectMapper objectMapper;

    public ConsumoAPI() {
        this.client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public String obtenerDatos(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return response.body();
            } else {
                throw new RuntimeException("Error en la solicitud: Código de estado " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error al obtener datos de la API: " + e.getMessage(), e);
        }
    }

    public <T> T obtenerDatosComoObjeto(String url, Class<T> responseType) {
        String json = obtenerDatos(url);
        try {
            return objectMapper.readValue(json, responseType);
        } catch (IOException e) {
            throw new RuntimeException("Error al deserializar el JSON: " + e.getMessage(), e);
        }
    }
}

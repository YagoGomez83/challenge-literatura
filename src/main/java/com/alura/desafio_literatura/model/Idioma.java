package com.alura.desafio_literatura.model;

public enum Idioma {
    EN("English", "Inglés"),
    ES("Spanish", "Español"),
    FR("French", "Francés"),
    DE("German", "Alemán"),
    IT("Italian", "Italiano");

    private String nombreAPI;
    private String nombreEspanol;

    Idioma(String nombreAPI, String nombreEspanol) {
        this.nombreAPI = nombreAPI;
        this.nombreEspanol = nombreEspanol;
    }

    public static Idioma fromString(String text) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.nombreAPI.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Idioma no encontrado: " + text);
    }

    public static Idioma fromEspanol(String text) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.nombreEspanol.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Idioma no encontrado: " + text);
    }
}

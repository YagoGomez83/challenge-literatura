package com.proyecto.desafio.principal;

import com.proyecto.desafio.model.Datos;
import com.proyecto.desafio.model.DatosLibros;
import com.proyecto.desafio.service.ConsumoAPI;
import com.proyecto.desafio.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);
    public void muestraElMenu(){
        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        //Top 10 libros mas descargados
        System.out.println("Top 10 de libros mas descargados");

        datos.libros().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDeDescargas).reversed())
                .limit(10)
                .map(l->l.titulo().toUpperCase())
                .forEach(System.out::println);

        //Busqueda de libros por nombre
        System.out.println("Ingrese el nombre del libro que desea buscar");
        var tituloLibro = teclado.nextLine();
        json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ","+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class );
        Optional<DatosLibros> libroBuscado = datosBusqueda.libros().stream()
                .filter(l->l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if(libroBuscado.isPresent()){
            System.out.println(libroBuscado.get());
        }else{
            System.out.println("Libro no encontrado");
        }

        //trabajando con estadisticas

        DoubleSummaryStatistics est = datos.libros().stream()
                .filter(d->d.numeroDeDescargas()>0)
                .collect(Collectors.summarizingDouble(DatosLibros::numeroDeDescargas));
        System.out.println("Cantidad media de descargas: " + est.getAverage());
        System.out.println("cantidad maxima de descargas: " + est.getMax());
        System.out.println("cantidad minima de descargas: " + est.getMin());
        System.out.println("cantidad de registros evaluados para calcular las estadisiticas: " + est.getCount());


    }
}

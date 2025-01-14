package com.alura.desafio_literatura;

import com.alura.desafio_literatura.principal.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class DesafioLiteraturaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DesafioLiteraturaApplication.class, args);


		Principal menuPrincipal = context.getBean(Principal.class);


		menuPrincipal.mostrarMenu();
	}
}

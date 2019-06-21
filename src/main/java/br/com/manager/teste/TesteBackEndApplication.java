package br.com.manager.teste;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.manager.teste.controller.Controller;

@SpringBootApplication
@Configuration
@ComponentScan("br.com.manager.teste")
public class TesteBackEndApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TesteBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Controller.getInstance();
	}

}

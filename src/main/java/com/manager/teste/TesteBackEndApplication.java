package com.manager.teste;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteBackEndApplication implements CommandLineRunner {

//	@Autowired
//	PaisService paisService;
	
	public static void main(String[] args) {
		SpringApplication.run(TesteBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Fuck");
		
//        List<Pais> paisList = paisService.getAll();
//        for(Pais pais : paisList)
//        {
//            System.out.println(pais.getNome());
//        }
		
	}

}

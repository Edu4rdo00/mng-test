package br.com.manager.teste;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.manager.teste.bean.Token;
import br.com.manager.teste.bean.UsuarioAutenticado;
import br.com.manager.teste.controller.Controller;
import br.com.manager.teste.repository.TokenRepository;

@SpringBootApplication
@Configuration
@ComponentScan("br.com.manager.teste")
public class TesteBackEndApplication implements CommandLineRunner {

	@Autowired 
	private TokenRepository tokenRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TesteBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Token> tokenList = tokenRepository.findAll();
		for (Token tk : tokenList) {
			UsuarioAutenticado usuarioAutenticado = new UsuarioAutenticado();
			usuarioAutenticado.setAdministrador(tk.getUsuario().isAdministrador());
			usuarioAutenticado.setAutenticado(tk.getExpiracao().after(new Date()));
			usuarioAutenticado.setExpiracao(tk.getExpiracao());
			usuarioAutenticado.setLogin(tk.getUsuario().getLogin());
			usuarioAutenticado.setToken(tk.getToken());
			Controller.getInstance().getUsuarioAutenticadoMap().put(tk.getToken(), usuarioAutenticado);
		}
	}

}
